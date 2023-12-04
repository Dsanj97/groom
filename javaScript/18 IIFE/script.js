// IIFE 정의를 하자마자 실행이 되는 함수
// 전역의 선언을 막고 다른변수가 함수내로 영향을 주는것을 방지
(
    function(){
        var aName = 'Barry'
    }
)()

// IIFE 내부에서 정의된 변수는 외부 범위에서 접근 불가
// console.log('aName', aName);

var result = (function(){
    var bName = 'Barry'
    return bName
})()

console.log('result', result);

// === 함수의 이름이 없으려면 변수에 할당하거나 즉시 호출을 해야한다 ===
// === IIFE 앞에 연산자를 붙여 사용이 가능하다 ===


// 심화 예제

const score = () => {
    let count = 0
    return {
        current: () => {return count},
        increment: () => {count++},
        reset: () => {count = 0}
    }
}

console.log(typeof score)
console.log(score())
console.log(score().current())
// 1증가
score().increment()
// 선언 될때마다 0으로 초기화
console.log(score().current())
// 그럼 어떻게 하는가? => 즉시실행함수로 실행

const score2 = (() => {
    let count = 0
    return {
        current: () => {return count},
        increment: () => {count++},
        reset: () => {count = 0}
    }
})()

console.log(typeof score2)
// 이미 실행이 되었기 때문에 () 없음
console.log(score2)
console.log(score2.current())
score2.increment()
score2.increment()
score2.increment()
score2.increment()
console.log(score2.current())

score2.reset()
console.log(score2.current())

console.log('--------------------------------------------------------')
const increment = () => {
    let counter = 0
    console.log(counter)
    const number = (num) => {
        console.log(`it is ${num} number`)
    }
    return () => {
        counter++
        number(counter)
    }
}

increment()
increment()
increment()
// return () => {
//     counter++
//     number(counter)
// }
// 이부분떄문에 +1되는것 같지만 실행될떄마다 초기화 시켜서 항상 0 이다
console.log('--------------------------------------------------------')
//즉시 실행 함수로 변경했을때
const increment2 = (() => {
    let counter = 0
    console.log(counter)
    const number = (num) => {
        console.log(`it is ${num} number`)
    }
    return () => {
        counter++
        number(counter)
    }
})()

console.log(increment2) // return () => {counter++ number(counter)} 출력
increment2()

// increment2() 을 출하면 return () => {counter++ number(counter)} 가 호출이 되고
// 여기서는 
// const number = (num) => {
//     console.log(`it is ${num} number`)
// }
// 가 호출이 된다

increment2()