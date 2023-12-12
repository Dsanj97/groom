// 타입에서 키를 추출할떄 사용
interface IUser {
    name: string;
    age: number;
    address: string;
}

// 타입의 키를 추출해서 새로운 유니온 타입 으로 만들기
type UserKeys = keyof IUser;
// "name" | "age" | "address" 반환


// 객체로 생성되어있을경우 먼저 타입으로 변경후 진행
const user = {
    name: 'John',
    age: 20,
    address: 'Seoul'
}

type UserKeys2 = keyof typeof user;

// enum으로 해보기
enum Color {    
    Red,
    Green,
    Blue
}

type ColorKeys = keyof typeof Color; // "Red" | "Green" | "Blue"