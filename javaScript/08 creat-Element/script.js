// element 생성
const li = document.createElement('li')

// 클래스 추가하기
li.className = 'list-group-item'

// id 추가하기
li.id = 'new-item'

// 새로운 속성 생성
li.setAttribute('name', 'New list item')

// link element 생성하기
const link = document.createElement('a')

// link의 클래스 이름 추가
link.className = 'alarm-item'

link.innerHTML = '<i class = "bi-alarm"></i>'

li.appendChild(link)
 
document.querySelector('ul.list-group').appendChild(li)