window.onload = function() {
    // 문서가 load될떄 이 함수를 실행
    let text = document.getElementById('text')
    //아이디가 'text' 인 요소를 return

    text.innerText = 'HTML 문서 load'
}

const aElement = document.querySelector('a')

aElement.addEventListener('click', () => {
    alert('a element clicked')
})

const buttonElement = document.querySelector('.btn2')

buttonElement.addEventListener('click', (event) => {
    let val 
    val = event.target
    console.log(val)

})

// 이벤트 종류
// const submit = document.querySelector('.submit-btn')
// const form = document.querySelector('.form')
// const title = document.querySelector('h2')

// submit.addEventListener('click', handleEvent)
// submit.addEventListener('dblclick', handleEvent)
// submit.addEventListener('mousedown', handleEvent)
// submit.addEventListener('mouseup', handleEvent)

// form 이벤트
const form = document.querySelector('form')
const emailInput = document.getElementById('email')
const title = document.querySelector('h2')

form.addEventListener('submit', handleEvent)
emailInput.addEventListener('keydown', handleEvent)

function handleEvent(e) {
    if (e.type ==='submit') {
        e.preventDefault()
    }
    console.log(`Event type: ${e.type}`)
    //title.textContent = `MouseX: ${e.clientX}, MouseY: ${e.clientY}`
    title.textContent = e.target.value
}