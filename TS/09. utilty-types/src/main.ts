// partial
// 부분집합같은 개념
interface Address {
    email: string;
    address: string;
}
// 빈것도 가능
const me: Partial<Address> = {}
// 부분만 가능
const you: Partial<Address> = { email: 'dsanj97@gmail.com'};
const all: Address = { email: 'dsanj97@gmail.com', address: '서울'};



// Pick
// 특정 타입에서 몇개의 속성을 골라서 타입을 새롭게 정의해줌
interface Todo {
    title: string;
    description: string;
    completed: boolean;
}

type TodoPreview = Pick<Todo, 'title' | 'completed'>;

const todo: TodoPreview ={
    title: 'clean code',
    completed: false
}


// omit
// 특정 속성만 제거하여 나타내는것
interface Todo2 {
    title: string;
    description: string;
    completed: boolean;
    createdAt: number;
}
// description만 제거
type TodoPreview2 = Omit<Todo2, 'description'>
 
const todo2: TodoPreview2 = {
    title: 'clean code2',
    completed: false,
    createdAt: 123
}



// Required
type User ={
    firstName: string;
    lastName?: string;
}

// 속성이 ? 가있으면 없어도 괜찮음
let firstUse: User = {
    firstName: 'John',
}

// Required 속성이 있다면 ? 가 있어도 모든 속성이 필수가됨
// let secondUser: Required<User> = {
//     firstName: 'John',
// }



// Recording
interface CatInfo {
    age: number;
    breed: string;
}

type CatName = 'mifft' | 'boris' | 'mordred'

// 타입을 정해줌 key 값과 key값에 해당하는 타입의 속정값을 적용시킨다
const cats: Record<CatName, CatInfo> = {
    mifft: { age: 10, breed: 'persian' },
    boris: { age: 10, breed: 'main coon' },
    mordred: { age: 10, breed: 'british shorthair' }
};



// Return Type
type T0 = ReturnType<() => string>;
type T1 = ReturnType<(s: string) => void>;


function fn(str: string) {
    return str;
}
// typeof fn 리턴 타입은 string a의 타입도 string
const a: ReturnType<typeof fn> = 'hello';
// typeof fn 리턴 타입은 string 인데 b는 boolean 타입을 가지고 있으므로 오류
// const b: ReturnType<typeof fn> = false