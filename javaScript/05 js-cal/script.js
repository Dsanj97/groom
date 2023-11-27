const num1 = 20
const num2 = 10

let val
val = num1 + num2
console.log(val)

val = num1 - num2
console.log(val)

val = num1 * num2
console.log(val)

val = num1 / num2
console.log(val)

val = num1 % num2
console.log(val)

// Math Object
val = Math.E
console.log(val)

val = Math.PI
console.log(val)

val = Math.round(2.4) // 가장 가까운수 (반올림)
console.log(val)

val = Math.ceil(2.4) // (올림)
console.log(val)

val = Math.floor(2.5) // (내림)
console.log(val)

val = Math.abs(-2) // (절댓값)
console.log(val)

val = Math.min(2, 3, 4, 5, 6, 7, 8, -1) // (가장 작은값)
console.log(val)

val = Math.max(2, 3, 4, 5, 6, 7, 8, -1) // (가장 큰값)
console.log(val)

val = Math.random() // (0과 1사이의 값중에 랜덤하게 출력)
console.log(val)

// 1 ~ 20 사이의 값중에 랜덤으로 출력
val = Math.floor(Math.random() * 20 + 1)
console.log(val) 