function outerFunction(outerVar) {
    return function innerFunction(innerVar) {
        console.log('outerVar: ', outerVar)
        console.log('innerVar: ', innerVar)
    }
}

const newFunction = outerFunction('outSide') // return 한 함수 할당 
// outval 에 변수를 할당하고 리턴

// 이미 위에서 outvar에대해 함수는 끝났지만 접근 가능
newFunction('inside')

console.log('newFunction: ', newFunction)

//--------------------------------------------------------
// 이런경우 b는 다른 함수에 들어있는 부분이라 애러가 난다
// 내부함수로 바꾸면 가능하다
// let a = 'a'

// function functionB() {
//     let c = 'c'
//     console.log(a,b,c)
// }

// function functionA() {
//     let b = 'b'
//     functionB()
//     console.log(a,b)
// }

// functionA()

//----------------------------------------------

let a = 'a'

function functionA() {
    let b = 'b'
    function functionB() {
        let c = 'c'
        console.log(a,b,c)
    }
    functionB()
    console.log(a,b)
}

functionA()
