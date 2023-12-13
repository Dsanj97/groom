type Properties = 'propA' | 'propB';

type MyMappedType<Properties extends string | number | symbol> = {
    [p in Properties]: boolean | string
}

type MyNewType = MyMappedType2<{a: 'a', b: 'b',}>
// 키값으로 타입 지정
type MyMappedType2<T> = {
    [p in keyof T]: T[p]
}

// pick
// 하나 이상의 프로터티를 선택하여 새로운 타입을 생성하는데 사용
type Pick1<T, Properties extends keyof T> = {
    [P in Properties]: T[P]
}

type MyNewType2 = Pick1<{a: 'a', b: 'b', c: 'c'}, 'a'>

// Record
type NewRecord<K extends keyof any, T> = {
    [P in K]: T
}

const myNewRecord: NewRecord<string, number> = {}
myNewRecord.a = 10
myNewRecord.b = 20
