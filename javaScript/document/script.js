let val

val = document
 
console.log(val) 

val = document.baseURI // 웝페이지의 절대 URL을 반환

console.log(val)

val = document.head // head 태그를 반환 
console.log(val)

val = document.body // body 태그를 반환 
console.log(val)

val = document.forms // forms 태그를 반환 
console.log(val)
val = document.forms[0].id // id 를 가져옴
console.log(val)
val = document.forms[0].classList // forms 태그를 반환 
console.log(val)
val = document.forms[0].className // forms 태그를 반환 
console.log(val)

val = document.scripts // forms 태그를 반환 
console.log(val)
val = document.scripts[0].getAttribute('src') // 속성이 src인것을 반환
console.log(val)

// --------요소 접근 하기--------
console.log("-----------요소 접근 하기----------")

const headerContainer = document.getElementById('header-container')
console.log(headerContainer)
// header display 값 변경
// headerContainer.style.display = 'none'

// header 의 요소들의 값 변경
headerContainer.textContent = 'Text Content'
headerContainer.innerText = 'Inner Text'
headerContainer.innerHTML = '<span>Inner HTML</span>'

// -----여러개의 요소에 접근
const items = document.getElementsByClassName('list-group-item')
console.log(items)

items[0].style.color = 'blue'
items[3].textContent = 'python'

let lists = document.getElementsByTagName('li')
console.log(lists)
// 배열이 아니기에 쓸수 없음
// lists.forEach(element => {
//     console.log(element)
// });

//-- 이 친구들을 배열로 저장
lists = Array.from(lists)
console.log(lists)

// 배열이기에 쓸수있는 것들
// 리스트 각 요소에 접근
lists.forEach(element => {
    console.log(element)
});

// 리스트의 각 요소의 인덱스 값 + 'List' 라고 바꿈
lists.forEach((list, index) => {
    list.textContent = `${index}. List`
})


// 배열의 홀수 값만 골라서 색 바꿈
const liOdd = document.querySelectorAll('li:nth-child(odd)')

liOdd.forEach((li) =>{
    li.style.background = 'gray'
})