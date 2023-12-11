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