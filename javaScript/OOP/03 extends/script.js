class Person {
    // constructor(생성자) => 인스턴스화된 객체에서 메서드를 호출하기전에 초기화를 진행
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

// == 상속 ==

class Person2 {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }

    introduce() {
        return `Hello, my name is ${this.name}`
    }
}

class Client extends Person2 {
    constructor(name, email, phone, address) {
        super(name, email);

        this.phone = phone;
        this.address = address;
    }
}

const hee = new Client('hee', 'envkt@example.com', '010-1234-5678', 'Seoul');
console.log(hee.introduce());
console.log(hee);