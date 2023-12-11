"use strict";
// Boolean value
let boolean;
let falseBoolean = false;
//Number value
let number;
let integer = 6;
let float = 3.14;
//String value
let string;
let firstName = "Dong";
//Array value
// 한가지 타입만 가지는 경우
let names1 = ["Dong", "John"];
let names2 = ["Dong", "John"];
// 여러 타입을 가지는 배열
let array1 = ['John', 1, 2];
let array2 = ['John', 1, 2];
// 여러타입을 단언 x any
let someArry = ['John', 1, [], {}, false];
// 읽기 전용 배열 생성(readonly, ReadonlyArray)
let stringArray = ['A', 'B', 'C'];
let numberArray = [1, 2, 3];
// stringArray.push('D') // readonly에는 push 메서드를 지원하지 않음
// numberArray[0] = 3 // numberArray의 0번째 인덱스에 3을 할당할 수 없음
//Tuple
let tuple1;
tuple1 = ['a', 1];
// tuple1 = ['a', 1, 2] // 2개 이상의 값이 들어오면 에러 발생
// tuple1 = [1, 'a'] // 순서가 다른  값이 들어오면 에러 발생
// tuple값이라도 push 메서드가 가능함 그리고 추가도 가능함
tuple1.push(3);
console.log(tuple1);
let users;
users = [[1, 'Dong'], [2, 'John']];
let users2;
users2 = ['a', 1];
users2.push(2);
console.log(users2);
// users2.push(false) // [string, number] 만 가능 에러 발생
// any 타입
let anyValue;
anyValue = 1;
anyValue = 'a';
anyValue = true;
anyValue = [1, 2, 3];
anyValue = {};
// undefined, null
// 아무타입 가능
let unknowValue = false;
// Object value
let obj = {};
let arr = [];
let nul = null; // stric 모드에서는 애러를 발생심킴
let date = new Date();
const obj1 = {
    id: 1,
    title: 'title1',
    description: 'description1' // 타입이 없어서 애러 발생
};
// Union type
let union;
union = 'hi',
    union = 1,
    union = true, // 타입이 없으면 에러 발생
    union = [1, 2, 3]; // 타입이 없으면 에러 발생
let func1; // 리턴 타입
func1 = function (x, y) {
    return x + y;
};
let func2; // 리턴 타입 없음
func2 = function () {
    console.log('hi');
};
// null, undefined
let number1 = undefined;
let string1 = null;
