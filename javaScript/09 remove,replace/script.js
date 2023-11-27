const listParent = document.querySelector('ul')
const list = document.querySelectorAll('li')

//요소 지우기
// 부모노드.removeChild(지울노드)
// listParent.removeChild(list[1])

// 요소 교체
const oldElement = document.getElementById('A')
const newElement = document.createElement('span')

newElement.textContent = 'HI'

// 부모노드 찾기
oldElement.parentNode.replaceChild(newElement, oldElement)