// body 값이 null일수도 있기때문에 애러가발생하지만
// 확실히 null값이 아니라는걸 말하기 위해 ! 사용
const bodyElement = document.querySelector('body')
bodyElement!.innerText = 'Hello World!'

// as HTMLBodyElement 사용
const bodyElement2 = document.querySelector('body') as HTMLBodyElement
bodyElement2.innerText = 'Hello World!'


// type-guard
const bodyElement3 = document.querySelector('body')
if (bodyElement3){
    bodyElement3.innerText = 'Hello World!'
}

// null 값일경우 타입가드 사용해야함
function func(arg: string | null) {
    if(arg){
    return (arg as string).toLowerCase() // string의 경우만 실행
    }
}

func('hello')
func(null)