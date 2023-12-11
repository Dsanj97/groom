class Post {
    // this 를 위한 속성값을 넣어줘야함
    // 접근제어자를 사용
    // pubilc -> 어디서든 접근 가능
    // protected -> 클래스내, 상속받은 클래스에서 접근가능
    // private -> 클래스 내에서만 접근 가능
    constructor(
        public id: number = 0, 
        protected title: string) {
    }

    // 메소드 생성
    getPost(){
        return `postId ${this.id} title ${this.title}`
    }
}

const post: Post = new Post(1, 'title1')
console.log(post.id) // 1
// console.log(post.title) // 접근불가

// 하위 클래스 만들어서 사용해보기
class SubPost extends Post {
    getPost2() {
        // 여기서는 사용 가능 
        return this.title
    }
}
