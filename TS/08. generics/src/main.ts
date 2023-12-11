function getArrayLength(arr: number[] | string[] | boolean[]): number {
    return arr.length
}

const arr = [1, 2, 3]
const arr2 = ['a', 'b', 'c', 'd', 'e']
const arr3 = [true, false, true]

console.log(getArrayLength(arr)) // 3
console.log(getArrayLength(arr2)) // 5
console.log(getArrayLength(arr3)) // 3

// 깔끔하게 만들기
function getArrayLength2<T>(arr: T[]): number {
    return arr.length
}

const arr4 = [1, 2, 3]
const arr5 = ['a', 'b', 'c', 'd', 'e']
const arr6 = [true, false, true]

console.log(getArrayLength2<number>(arr4)) // 3
console.log(getArrayLength2<string>(arr5)) // 5
console.log(getArrayLength2<boolean>(arr6)) // 3






interface Vehicle<T> {
    name: string,
    color: string,
    options: T
}

const car: Vehicle<{price: number}> = {
    name: 'Car',
    color: 'Blue',
    options: {
        price: 1000
    }
}

const bike: Vehicle<boolean> = {
    name: 'Bike',
    color: 'White',
    options: true
}




// 변수가 두개라면??
// T와 Y를 받고 그거대로 타입 리턴
const makeArr = <T, Y>(x: T, y: Y): [T, Y] => {
    return [x, y]
}

const array = makeArr<number, number>(1, 2)
const array1 = makeArr<string, string>('a', 'b')

// 디폴트로 지정 가능
const makeArr1 = <T, Y = string>(x: T, y: Y): [T, Y] => {
    return [x, y]
}

const array2 = makeArr1<number>(1, 'a')

// 확장
// 항상 firstName, lastName은 들어오는거고 새로운것들도 추가할수있게끔 만듦
const makeFullName =<T extends {firstName: string, lastName:string} > (obj:T) => {
    return{
        ...obj,
        fullName: obj.firstName +'' + obj.lastName
    }
}

makeFullName({firstName: 'John', lastName: 'Doe', location: 'USA'})
// 항상 있어야할 속성이 없다면 
// makeFullName({lastName: 'Doe', location: 'USA', age: 20}) // firstName가 없으면 에러 발생
