// var A = 1
// console.log(A)
// // ----- 재선언 재할당 가능 -----
// // 최초 선언 할당
// var greeting = 'hello'
// console.log(greeting)

// // 중복선언
// var greeting = 'hi'
// console.log(greeting)

// // 재할당
// greeting = 'how'
// console.log(greeting)

// // ----- 재선언 불가 재 할당 가능 -----

// let greeting2 = 'greeting2'
// console.log(greeting2)

// greeting2 = 'greeting123'
// console.log(greeting2)

// // ----- 재할당 재선언 불가 -----
// const greeting3 = 'hhheee'
// console.log(greeting3)


// // ----- var 함수레벨 스코프 -----
// // var 은 함수레벨 변수명으로 함수번위내에서는 접근이 가능하다
// function func() {
//     if(true) {
//         var a = 'a'
//         console.log(a)
//     }
//     console.log(a)
// }

// func()

// // ----- Block 레벨 스코프 -----
// // let, const
// function func2() {
//     if(true) {
//         let a = 'b'
//         const b = 'B'
//         console.log(a)
//         console.log(b)
//     }
//     console.log(a)
//     console.log(b)
// }

// func2()

// ---Hoisting---

// console.log(greeting4)
// let greeting4 = 'dsanj' 

func()

function func() {
    console.log('hoisting test')
}