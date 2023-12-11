// call signature
// 재사용성을 위해 인터페이스로 제작
interface getLikeNuimber {
    (like: number): number // 호출 시그니처
} 

interface Post {
    id: number;
    title: string;
    getLikeNuimber: getLikeNuimber
}

const post1: Post = {
    id: 1,
    title: 'post1',
    getLikeNuimber(like: number) {
        return like
    }
}

post1.getLikeNuimber(10)

// index signature
interface Post2 {
    [key: string]: unknown // 추가할 값들
    id: number,
    title: string,
}

const post2: Post2 = {
    id: 1,
    title: 'post2'
}
// 이 속성들 이외에도 더 필요한경우

post2['description'] = 'post2 description'
post2['pages'] = 200

// 배열 index signature
interface Name {
    [item: number]: string
    // userNames[0] === dong
}

const userNames: Name = ['dong', 'kim', 'choi']