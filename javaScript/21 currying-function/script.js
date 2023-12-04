const sum = (x, y) => x + y
console.log(sum(1, 2))

const curriedSum = x => y => x + y
console.log(curriedSum(1)(2))

//================================================================
const makeFood = (ingredient1) => {
    return (ingredient2) => {
        return (ingredient3) => {
            return `${ingredient1} ${ingredient2} ${ingredient3}`
        }
    }
}

const hamburger = makeFood('Bread')('tomatoes')('ham')
console.log(hamburger)

// 간단하게 만들기
const makeFood2 = ingredient1 => ingredient2 => ingredient3 =>
    `${ingredient1} ${ingredient2} ${ingredient3}`

const newHamburger = makeFood2('Bread')('ham')('tomatoes')
console.log(newHamburger)
//================================================================

function log(date, importance, message) {
    alert(`${date.getHours()} ${date.getMinutes()} ${importance}: ${message}`)
}

log(new Date(), "Debug", "some debug message")

// 간단하게 바꾸기
function curry(f){
    return(function(a){
        return(function(b){
            return(function(c){
                return f(a, b, c)
            })
        })
    })
}

const curriedLog = curry(log)
curriedLog(new Date()("Debug")("some debug message"))
// 항목이 들어나면 코드도 늘어난다는 문제점이 있음 그래서 동적으로ㅓ 바꾸는게 필요함

function curry(func) {
    return function curried(...args) {
        if(args.length >= func.length) {
            return func.apply(this, args)
        }else {
            return function(...args2) {
                return curried.apply(this, args.concat(args2))
            }
        }
    }
}

const sum2 = (x, y, z, j) => x + y + z + j

const curriedSum2 = curry(sum2)
console.log(curriedSum2(1)(2)(3)(4))