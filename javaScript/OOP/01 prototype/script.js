let user = {
    name : 'dong',
    age: 26
}

console.log(user.name);
console.log(user.hasOwnProperty('email'));
// prototype 자바스크립트 객체가 다른 객체로부토 메서드와 속성을 상속받는 매커니즘

// ===== ===== ===== ===== =====
function Person(name, email, birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = new Date(birthDate);
    // 밑의 함수의 경우 어디에나 똑같이 쓰이는 함수이므로 프로토 타입에 넣어서 사용해주는것이 편하다.
    this.calculateAge = function() {
        const diff = Date.now() - this.birthDate.getTime();
        const ageDate = new Date(diff);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    };
}

const john = new Person('John', 'envkt@example.com', '7-10-91');
const dong = new Person('Dong', 'envkt@example.com', '3-2-97');

console.log(john);
console.log(dong);


// 프로토타입에 넣는법
function Person2(name, email, birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = new Date(birthDate);
}

Person2.prototype.calculateAge = function() {
    this.calculateAge = function() {
        const diff = Date.now() - this.birthDate.getTime();
        const ageDate = new Date(diff);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    };
}

const john2 = new Person2('heo', 'envkt@example.com', '7-10-91');
const dong2 = new Person2('kim', 'envkt@example.com', '3-2-97');

console.log(john2);
console.log(dong2);

// 프로토타입으로 만드는법 2번째
function Person3(name, email, birthDate) {
    const person = Object.create(personsPrototype);
    person.name = name;
    person.email = email;
    person.birthDate = new Date(birthDate);
    return person;
}

const personsPrototype = {
    calculateAge() {
        this.calculateAge = function() {
            const diff = Date.now() - this.birthDate.getTime();
            const ageDate = new Date(diff);
            return Math.abs(ageDate.getUTCFullYear() - 1970);
        };
    }
}

const john3 = new Person2('heo', 'envkt@example.com', '7-10-91');
const dong3 = new Person2('kim', 'envkt@example.com', '3-2-97');
console.log(john3);
console.log(dong3);
