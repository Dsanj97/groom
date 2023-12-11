// overloading
function add(a: number, b: number): number
function add(a: string, b: string): string
function add(a: any, b: any): any {
    return a + b
}

add(1, 2)
add('1', '2')
// add(1, '2')




function saySomething(arg: string | string[]): string{
    if(typeof arg === 'string'){
        return arg
    } else if(Array.isArray(arg)){
        return arg.join(' ')
    } 
    throw new Error("unable to say somthing")
}

console.log(saySomething(['hello', 'world'])) // 'hello'

// 함수 오버로당으로 만들기
// 1. 타입 선언
// 2. 함수 구현
function saySomething2(arg: string): string
function saySomething2(arg: string[]): string
function saySomething2(arg: any): any {
    if(typeof arg ==='string'){
        return arg
    } else if(Array.isArray(arg)){
        return arg.join(' ')
    }
    throw new Error("unable to say somthing")
}