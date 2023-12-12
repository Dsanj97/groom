// 타입 스크립트에서 추론을해 할당이 가능한지 본다
type AType<T> = T extends infer R ? R : null;

const a: AType<number> = 1



type BType<T> = T extends { a: infer A, b:number} ? A : any;

type Inferred = BType<{ a: 'sd', b: 1 }>;



type CType<T> = T extends { a: infer A, b:infer B}? A & B : any

type Inferred2 = CType<{ a:{someAProps: 1}, b:{someBProps: 2}}>;

// 리턴타입도 이런식으로 만들어졌다
type T0 = ReturnType<() => string>;
type T1 = ReturnType<(s: string) => void>;

function fn(str: string) {
    return str;
}

type T2 = ReturnType<typeof fn>;