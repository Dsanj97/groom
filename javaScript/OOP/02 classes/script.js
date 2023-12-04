class Person {
    constructor(name, email, birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = new Date(birthDate);
    }

    // 바로 프로토타입에 들어감
    introduce() {
        return `Hello, my name is ${this.name}`
    }

    // 들어가는곳이 다름 프로토타입은 아님
    // 사용하려면 클래스 이름으로 사용해야함
    static multipleNumbers(a, b) {
        return a * b;
    }
}

const john = new Person('John', 'envkt@example.com', '7-10-91');
console.log(john);
// introduce 사용법
console.log(john.introduce())
// static 사용법
console.log(Person.multipleNumbers(2, 3));
