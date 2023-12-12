"use strict";
// "name" | "age" | "address" 반환
// 객체로 생성되어있을경우 먼저 타입으로 변경후 진행
const user = {
    name: 'John',
    age: 20,
    address: 'Seoul'
};
// enum으로 해보기
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
