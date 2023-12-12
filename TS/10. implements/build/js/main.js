"use strict";
class Car {
    constructor() {
        this.mileage = 0;
        this.price = 100;
        this.color = 'black';
    }
    drive() {
        return 'drive!';
    }
    break() {
        return 'break!';
    }
}
// interface 추가
// 
class Ford {
    drive() {
        return 'drive!';
    }
    break() {
        return 'break!';
    }
}
const myCar = new Ford();
