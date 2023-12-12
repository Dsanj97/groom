"use strict";
// 빈것도 가능
const me = {};
// 부분만 가능
const you = { email: 'dsanj97@gmail.com' };
const all = { email: 'dsanj97@gmail.com', address: '서울' };
const todo = {
    title: 'clean code',
    completed: false
};
const todo2 = {
    title: 'clean code2',
    completed: false,
    createdAt: 123
};
// 속성이 ? 가있으면 없어도 괜찮음
let firstUse = {
    firstName: 'John',
};
// 타입을 정해줌 key 값과 key값에 해당하는 타입의 속정값을 적용시킨다
const cats = {
    mifft: { age: 10, breed: 'persian' },
    boris: { age: 10, breed: 'main coon' },
    mordred: { age: 10, breed: 'british shorthair' }
};
function fn(str) {
    return str;
}
// typeof fn 리턴 타입은 string a의 타입도 string
const a = 'hello';
// typeof fn 리턴 타입은 string 인데 b는 boolean 타입을 가지고 있으므로 오류
// const b: ReturnType<typeof fn> = false
