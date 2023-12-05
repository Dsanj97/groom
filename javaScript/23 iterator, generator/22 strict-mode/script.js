// iterator => 반복자
// 반복자 next() 를 호출해서 
// {value: , done: } 을 반환하는 객체
function makeIterator(numbers) {
    let nextIndex = 0;

    return {
        next: function () {
            return nextIndex < numbers.length ?
                {value: numbers[nextIndex++], done: false} :
                {value: undefined, done: true}
            
        }
    }
}

// 숫자배열 생성
const numbersArray = [1, 2, 3, 4, 5, 6,];

const numbersIterator = makeIterator(numbersArray);

console.log(numbersIterator.next());
console.log(numbersIterator.next());
console.log(numbersIterator.next());
console.log(numbersIterator.next());
console.log(numbersIterator.next());
console.log(numbersIterator.next());
console.log(numbersIterator.next());

// Symbol.iterator로 만들기
// 반복가능한 반복기로 생성 가능
console.log('Symbol.iterator')

const numbersIterator2= numbersArray[Symbol.iterator]();

console.log(numbersIterator2.next());
console.log(numbersIterator2.next());
console.log(numbersIterator2.next());
console.log(numbersIterator2.next());
console.log(numbersIterator2.next());
console.log(numbersIterator2.next());
console.log(numbersIterator2.next());

// 반복가능한 객체인지 확인 하는법
const numbersIterable = [1, 2, 3];

const numbersNotIterable = {a: 1, b: 2, c: 3};

// 둘다 오브잭트
console.log(typeof numbersIterable)
console.log(typeof numbersNotIterable)

// for of 사용가능하면 반복자 가증
for (const number of numbersIterable) {
    console.log(number);
}
// for of 사용불가 반복자 사용 불가
// for (const number of numbersNotIterable) {
//     console.log(number);
// }

// set 으로 만들기
const set = new Set([1, 2, 3, 4, 5, 6]);
console.log('set', set);
// 가능
console.log(set[Symbol.iterator]());

// map 사용
const map = new Map();
map.set('a', 1);
map.set('b', 2);
map.set('c', 3);

console.log('map', map);
console.log(map[Symbol.iterator]());

// ===== generator =====
// 사용자의 요구에 따라 일시적으로 정지될수도 있고 다시시작될수도 있다
function* sayNumbers() {
    // yield 함수는 일시정지를 시킨다
    // return 과 비슷
    yield 1;
    yield 2;
    yield 3;
}

// sayNumbers(generator 함수) 를 호출하여 반환하면 그게 제너래이터가 됨
const number = sayNumbers();

console.log(number.next());
console.log(number.next());
console.log(number.next());
console.log(number.next());

function* generatorFunction() {
    yield 1;
}

const generator = generatorFunction();

// generator 는 generator iterable과 같다
// generator = generator[Symbol.iterator]();

console.log(generator.next());


// lazy Evaluation
// 계산의 결과값이 필요할때까지 계산을 늦춰서 필요한 데이터를 필요한 순간에 생성
// 무한루프를 돌지 않음
function* createIds() {
    let index = 1;

    while (true) {
        yield index++;
    }
}

const ids = createIds();

console.log(ids.next().value);
console.log(ids.next().value);
console.log(ids.next().value);
// 값을 10으로 넣어줄수가 있다
console.log(ids.return(10));

function* generatorFunction2() {
    // yield 1
    // yield 2
    // yield 3
    yield* [1, 2, 3];
}

const generator2 = generatorFunction2();

for (const number of generator2) {
    console.log(number);
}