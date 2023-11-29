// Methods => Object

const audio = {
    title: 'a',
    play() {
        console.log('play this', this)
    }
}

audio.play()

audio.stop = function () {
    console.log('stop this', this)
}

audio.stop()

// Functions => window

function playAudio() {
    console.log(this)
}

playAudio()

// 생성자 함수에서는 빈객체를 가르킨다
// 참고로 생성자 함수는 대문자로 시작한다
function Audio (title) {
    this.title = title
    console.log(this)
}

const audio2 = new Audio('a');

const audio3 = {
    title : 'audio',
    categories : ['rock', 'pop'],
    displayCategories() {
        this.categories.forEach(function(category) {
            // 제목의 경우 함수안에 있는 this 이기 때문에 윈도우 객체를 가지고온다
            console.log(`title: ${this.title}, category: ${category}`);
        }, this)// 그래서 두번쨰 인자 값으로 참조할 값을 전달할수 있다
    }
}

audio3.displayCategories();

// 화살표 함수에서는 this 는 항상 상위스코픙릐 this를 가리키게 된다
// 타고타고 올라가는듯한 느낌 ==> Lexical this
const audio4 = {
    title : 'audio',
    categories : ['rock', 'pop'],
    displayCategories() {
        this.categories.forEach((category) => {
            console.log(this)
        })
    }
}

audio4.displayCategories();