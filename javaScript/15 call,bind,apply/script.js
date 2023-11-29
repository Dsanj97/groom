// call()
const fullName = function (city, country) {
    console.log(this.firstName + ' ' + this.lastName, city, country)
}

const person1 = {
    firstName : 'John',
    lastName : 'Doe'
}

fullName.call(person1, "서울", "한국")

// apply() ==> call() 이랑 다른점은 배열로 넣는다는것
const fullName2 = function (city, country) {
    console.log(this.firstName + ' ' + this.lastName, city, country)
}

const person2 = {
    firstName : 'John',
    lastName : 'Doe'
}

fullName2.apply(person2, ["서울", "한국"])

// bind()
function func(language) {
    if (language === 'kor') {
        console.log(`language: ${this.korGreeting}`)
    } else {
        console.log(`language: ${this.engGreeting}`)
    }
}

const greeting = {
    korGreeting : '안녕하세요',
    engGreeting : 'Hello'
}

// bind() 의 경우 바인딩을 해주고 
// 변수를 설정하여 실행 시켜준다
const boundFunc = func.bind(greeting)

boundFunc('kor')