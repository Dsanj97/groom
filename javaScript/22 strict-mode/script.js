//'use strict'
// 파일 전체에 적용하는것

// 함수 내에서 전언 하는법
function sum(a, b){
    return a + b;
}

// class 를 사용하면 자동으로 strict가 된다
class Cat {

}
// ===== =====

let greeting = 'hello';

// 오타가 나더라고 출력을 할수 있다
greating = 'goodbye';

console.log(greeting);