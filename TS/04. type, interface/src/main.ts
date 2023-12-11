// interface 의 경우
// interface Animal {
//     name: string
// }

// interface Bear extends Animal {
//      honey: boolean
// }

// const bear1: Bear = {
//     name: 'honey bear',
//     honey: true
// }

// type의 경우
type Animal = {
    name: string
}

type Bear = Animal & {
    honey: boolean
}

const bear1: Bear = {
    name: 'honey bear',
    honey: true
}

// 같은게 두개면 병합이 되어버린다
interface Animal2 {
    name: string
}

interface Animal2 {
    honey: boolean
}

const animal2: Animal2 = {
    name: 'honey bear',
    honey: true
}

// type의 경우 중복 불가
// type Animal3 {
//     name: string
// }

// type Animal3{
//     honey: boolean
// }

