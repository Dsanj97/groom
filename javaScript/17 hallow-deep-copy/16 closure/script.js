// hallow deep copy
const aArray = [1, 2, 3];

// shallow copy with sperad poeraror
const bArray = [...aArray, 4];

console.log('aArray', aArray);
console.log('bArray', bArray);
console.log('aArray === bArray', aArray === bArray);

// shallow copy with Object.assign()
// b배열을 얕은복사를 통해 c배열에 저장
const cArray = Object.assign([], bArray);

console.log('cArray', cArray);
console.log('bArray === cArray', bArray === cArray);

// Nested Arrays and Objects
cArray.push([5, 6, 7]);

console.log('cArray', cArray);

const dArray = [...cArray, 10];

console.log('dArray', dArray);

dArray[4].push(8)

console.log('cArray', cArray);
console.log('dArray', dArray);
// 중첩된 배열이나 객체가 있다면 cArray를 shallow copy 해서 dArray를 만들고
// dArray를 shallow copy 해서 dArray를 만들고 dArray를 변경했을때 cArray에 있는
// 중첩된 부분은 따라서 변경이 되는걸 볼수 있다


// 얕은 동결
const aObject = {
    a: 'a',
    b: 'b',
    cObject: {a: '1', b: '2', c: '3'}
}

Object.freeze(aObject)
aObject.a = 'c'

console.log('aObject', aObject);

// 얕은 복사의 경우 동력을 하더라도 안에있는 것까지는 동결하지 못한다
aObject.cObject.a = '4'

// == beep copy with jason.parse(jason.stringify()) ===
const bObject = {
    a: 'a',
    b: 'b',
    cObject: {a: '1', b: '2', c: '3'}
}

const newAObject = JSON.parse(JSON.stringify(bObject))

console.log('bObject', bObject);
console.log('newAObject', newAObject);

bObject.cObject.a = '4'

console.log('newAObject', newAObject);
// 깊은 복사의 경우 안의 모든걸 복사하기 때문에 값이 변해도 복사한값은 변하지 않는다.

// 깊은 복사의 다른방법
// deep copy with nested sptead operator
// 전체 bObject에서 얕은 복사를 진행하고 cObject 까지 들어가서 얕은복사를 진행
const newBObject ={...bObject, cObject: {...bObject.cObject}}

console.log('newBObject', newBObject);