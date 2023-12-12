class Car {
    mileage = 0;
    price = 100;
    color = 'black';

    drive() {
        return 'drive!'
    }

    break() {
        return 'break!'
    }
}
// extends => implements 로 바꿈 
// implements 는 틀을 잡아주는것
// 그래서 속성값들을 다 넣어줘야 한다

// implements 는 class 말고 interface 도 넣을수 있다

interface Part {
    seats: number;
    tire: number;
}
// interface 추가
// 
class Ford implements Car, Part {
    mileage: 1;
    price: 2;
    color: 'black';

    //Part 부분 추가해줘야함
    seats: 4;
    tire: 4;

    drive(): string {
        return 'drive!'
    }

    break(): string {
        return 'break!'
    }
}

const myCar = new Ford();