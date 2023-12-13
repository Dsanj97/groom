interface Person {
    name: string
    age: number
    address: string
}

const person = {
    name: 'John',
    age: 30,
    address: 'New York'
}

const age = getProperty(person, 'age') // 30
const names = getProperty(person, 'name') // 'John'
// const invaild = getProperty(person, 'invaild') // undefined

function getProperty<T, K extends keyof T>(obj: T, key: K) {
    return obj[key]
}