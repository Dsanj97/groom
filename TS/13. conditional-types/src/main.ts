// tyoe SomeType = T extends U ? X : Y;
// SomeType 이 number 에 할당이 가능한가? 참=> sting 거짓=> null
type SomeType = number
type ConditionalType = SomeType extends string? string : null;


// fn1 부를떄 string 형식임
function fn1<T>(val: T) {
    const fn2 = (
        arg: T extends boolean ? 'A' : 'B'
    ) => {}
    return fn2
    
}

const result = fn1('');

//never => 아무런 값을 사용하지 않을떄 사용
type StringOrNot<T> = T extends string? T : never;
// 유니온 타입에서 never은 사라지게 된다
type AUnion = string | boolean | never;

const A: StringOrNot<string> = '';


// type Exclude<T, U> = T extends U ? never : T;
type ResultType = Exclude<'a' | 'b' | 'c', 'a' | 'b'>;
/*
'a' extends 'a' | 'b' | 'c ? never : 'a' ==> never
'b' extends 'a' | 'b' | 'c ? never : 'b' ==> never
'c' extends 'a' | 'b' | 'c ? never : 'c' ==> 'c'
*/

type AType<T> = T extends string | number ? T : never;

type Myresult = AType<string | number | boolean>;