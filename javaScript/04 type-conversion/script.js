let val

// Number to String
console.log('-----Number to String-----')
val = String(111)

console.log(val)
console.log(typeof val)
 
val = String(8+2)
console.log(val)
console.log(typeof val)
console.log(val.length)

//Boolean to String
console.log('-----Boolean to String-----')
val = false

console.log(val)
console.log(typeof val)
console.log(val.length) // string 형식이 아니기 때문에 undefiond 나옴

val = String(false)

console.log(val)
console.log(typeof val)
console.log(val.length)

// Date to String
console.log('-----Date to String-----')
val = new Date()

console.log(val)
console.log(typeof val)
console.log(val.length)

val = String(new Date())

console.log(val)
console.log(typeof val)
console.log(val.length)

// Array to String
console.log('-----Array to String-----')
val = [1, 2, 3, 4, 5]

console.log(val)
console.log(typeof val)
console.log(val.length)

val = String([1, 2, 3, 4, 5])

console.log(val)
console.log(typeof val)
console.log(val.length)

// toString() => 숫자로 리턴 한다는것
console.log('-----toString()-----')
val = (5).toString()

console.log(val)
console.log(typeof val)
console.log(val.length)

// String to number