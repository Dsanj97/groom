let val

const list = document.querySelector('ul.list-group')
const listItem = document.querySelector('li.list-group-item:first-child')

console.log('list', list)
console.log('listItem', listItem)

val = list.childNodes // NodeList 반환, line break도 포함

console.log('val', val)

val = list.childNodes[1] // 띄고 다음칸
console.log(val)
val = list.childNodes[1].nodeName // 노드의 이름
console.log(val)

// 1번의 경우 요소 
// 2번의경우 속성 
// 3번은 택스트 노드 
// 8번은 주석 
// 9번은 document
// 10번은 doctype
val = list.childNodes[3].nodeType 
console.log('val', val)

// children element node 반환
val = list.children // HTML Collection 반환 (line break 포함 안함)
console.log(val)
val = list.children[1]
console.log(val)
list.children[1].textContent = "hello"

val = list.firstChild
console.log(val) // firstChild 시 위에꺼랑 똑같음 text 노드 포함
// list.firstChild === list.childNodes[0]

// 요소들만 다루는것 
val = list.firstElementChild

console.log('val', val)

// Last child
val = list.lastChild
// list.lastChild === list.childNodes[list.childNodes.lenght -1]
console.log(val)

val = list.lastElementChild
console.log(val)

// child 요소 카운트 하는법
val = list.childElementCount
console.log(val)

// paretn node 반환
val = listItem.parentNode
console.log(val)

val = listItem.parentElement
console.log(val)
val = listItem.parentElement.parentElement
console.log(val)

// next sibling 변환
val = listItem.nextSibling // => text 노드 포함
console.log(val)
val = listItem.nextElementSibling // => 바로 요소 접근
console.log(val)
val = listItem.nextElementSibling.nextElementSibling // => 다다음 요소
console.log(val)
val = listItem.nextElementSibling.nextElementSibling.previousElementSibling
console.log(val)

// previous sibling 반환
val = listItem.previousSibling
console.log(val)
val = listItem.previousElementSibling
console.log(val)

// 이건 리스트의 형식(배열) 이아님
// 배열에서 사용하는것들을 일부 사용 할수 없음
// 순회는 for문 가능함
for (let node of list.childNodes){
    console.log(node)
}

console.log(Array.from(list.childNodes).filter)