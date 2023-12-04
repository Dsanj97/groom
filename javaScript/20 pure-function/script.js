let x = 0
const numberUp = () => {
    x +=1
}

console.log(numberUp())
console.log(x)

// 함수 밖에있는 변수에 영향을줬음 
// 이걸 바꾸는게 pure function
let y = 0
const puruNumberUp = (num) => num +1
console.log(puruNumberUp(y))
console.log(y)

// ===== =====

const alphabetArray = ['A', 'B']
const addItemToArray = (originalArray, newItem) => {
    originalArray.push(newItem)
    return originalArray
}

console.log(addItemToArray(alphabetArray, 'C'))
console.log(alphabetArray) 

const pureAddToArray = (originalArray, newItem) => {
    return [...originalArray, newItem] // 복사해와서 새로운 배열에 저장 원래배열울 건들이지 않음
}

console.log(pureAddToArray(alphabetArray, 'D'))
console.log(alphabetArray)