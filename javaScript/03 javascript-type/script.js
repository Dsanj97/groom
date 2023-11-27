// javascript 같은경우 동적타입이 가능하다
let foo = 42
foo = 'bar'
foo = true

console.log(typeof foo)

// 원시타입
// 문자열 String
const name = 'han'
// Number
const age = 26
// Boolean
const hasJob = false
// null
const cat = null
// undefined
let anything
// Symbol
const sym = Symbol()

// 참조타입
// Array 배열
const hobbies = ['walking', 'books', 'coding']
// Object => 파이썬의 딕션어리 생각하면 좋을듯
const adress = {
    province: '서울',
    city: '구로구'
}

console.log(adress)
console.log(typeof hobbies)
console.log(typeof adress)
// Array의 경우 타입을 찍어도 오브잭트로 아오기 떄문에 다른 타입 체크를 해야한다
console.log(Array.isArray(hobbies))