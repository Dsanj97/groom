// Boolean value
let boolean: boolean
let falseBoolean: boolean = false

//Number value
let number: number
let integer: number = 6
let float: number = 3.14

//String value
let string: string
let firstName: string = "Dong"

//Array value
// 한가지 타입만 가지는 경우
let names1: string[] = ["Dong", "John"]
let names2: Array<string> = ["Dong", "John"]

// 여러 타입을 가지는 배열
let array1: (string | number)[]= ['John', 1, 2]
let array2: Array<string | number>= ['John', 1, 2]

// 여러타입을 단언 x any
let someArry: any[] = ['John', 1, [], {}, false] 

// 읽기 전용 배열 생성(readonly, ReadonlyArray)
let stringArray : readonly string[] = ['A', 'B', 'C']
let numberArray : ReadonlyArray<number> = [1, 2, 3]

// stringArray.push('D') // readonly에는 push 메서드를 지원하지 않음
// numberArray[0] = 3 // numberArray의 0번째 인덱스에 3을 할당할 수 없음

//Tuple
let tuple1: [string, number]
tuple1 = ['a', 1]
// tuple1 = ['a', 1, 2] // 2개 이상의 값이 들어오면 에러 발생
// tuple1 = [1, 'a'] // 순서가 다른  값이 들어오면 에러 발생

// tuple값이라도 push 메서드가 가능함 그리고 추가도 가능함
tuple1.push(3)
console.log(tuple1)

let users: [number, string][]
users = [[1, 'Dong'], [2, 'John']]

let users2 : [string, number]
users2 = ['a', 1]
users2.push(2)
console.log(users2)
// users2.push(false) // [string, number] 만 가능 에러 발생

// any 타입
let anyValue: any
anyValue = 1
anyValue = 'a'
anyValue = true
anyValue = [1, 2, 3]
anyValue = {}

// undefined, null
// 아무타입 가능
let unknowValue: unknown = false


// Object value
let obj: object = {}
let arr: object = []
let nul: object = null // stric 모드에서는 애러를 발생심킴
let date: object = new Date()

const obj1: {id: number, title: string} = {
    id: 1,
    title: 'title1',
    description: 'description1' // 타입이 없어서 애러 발생
}

// Union type
let union: (string | number)
union = 'hi',
union = 1,
union = true, // 타입이 없으면 에러 발생
union = [1, 2, 3] // 타입이 없으면 에러 발생

let func1: (arg1: number, arg2: number) => number// 리턴 타입
func1 = function (x, y){
    return x + y
}

let func2: () => void // 리턴 타입 없음
func2 = function () {
    console.log('hi')
}

// null, undefined
// "strictNullChecks": false // strict null checks
// 설정하면 잘 할당되는것을 확인할수 있다
let number1: number = undefined
let string1: string = null
let object: {a: 10, b: 20} = undefined
let array: any = undefined
let undefined1: undefined = null
let null1: null = undefined
let void1: void = null

// void 타입
function greeting(): void {
    console.log('hi')
}

const hi: void = greeting()
console.log(hi) // undefined

// never
// 리턴값을 절대 내보내지 않거나 애러를 출력할때(확신)
function throwError(): never {
    throw new Error('error')
}

function keepProcessing(): never {
    while (true) {
        console.log('hi')
    }
}

// never안에는 다른것을 할당할수 없다
const never: [] = []
never.push(1)