// 리스트의 전반적인것들

import ListItem, { IListItem } from "./ListItem";

interface IList {
    // 배열로 여러개의 객체를 저장
    list: IListItem[]
    //리스트 데이터를 불러오는 함수
    load(): void
    save(): void
    clear(): void
    //작성한 텍스트 값을 가져온다
    // 아이템 요소의 id값 등을 가져옴
    addItem(itemObj: IListItem): void
    // 아이템 요소의 삭제
    // 유니크한 값을 가지고 있어야함
    removeItem(id: string): void
}

// 리스트
export default class List implements IList {

    // 클래스 안에서 요소 생성하기
    static instance = new List();

    // 타입스크립트에서 singleton방식으로 하기
    // private constructor
    private constructor(
        private _list: IListItem[] = [],
    ){}

    get list(): IListItem[] {
        return this._list;
    }

    // 로컬스토리지를 사용해서 저장된 데이터를 불러옴
    load(): void {
        const storedList: string | null = localStorage.getItem("mylist")

        // 가져온데이터가 없으면
        if(typeof storedList !== "string") return;

        // 데이터가 있다면 오브젝트 형식으로 바꿔야함
        // 배열 형식으로 변수에 저장할것이고
        // 각각의 타입도 정의함
        const parsedList: {
            _id: string,
            _item: string,
            _checked: boolean,
        }[] = JSON.parse(storedList);

        // listItem 인스턴스 객체를 생성하고 
        // list 인스턴스 객체에 넣어주기 => 클래스 내에 이미 생성해뒀고 (클래스명).(인스턴스명) 으로 접근
        parsedList.forEach(itemObj => {
            const newListItem = new ListItem(
                itemObj._id,
                itemObj._item,
                itemObj._checked
            )
            // (클래스명).(인스턴스명).(클래스안에 있는 메소드)
                List.instance.addItem(newListItem)
        })

    }
    addItem(itemObj: IListItem): void{
        this._list.push(itemObj)
        // 입력이 있을때마다 list의 변경이 있다
        // 그럴때마다 save()를 자동으로 불러야한다
        this.save();
    }

    save(): void {
        localStorage.setItem('myList', JSON.stringify(this._list))
    }
    
    clear(): void{
        // 배열 초기화 해준다음에
        this._list = []
        // 저장해주면 초기화
        this.save();
    }

    removeItem(id: string): void {
        // list배열의 값들중 지워야하는 id 빼고 나머지를 새로운 배열로 저장함
        this._list = this._list.filter(item => item.id !== id);
        // 리스트가 바뀌었으니 저장
        this.save() 
    }
}

// 지금우리가 만들꺼는 하나의 리스트만 만들꺼니 singleton 방식으로 구현
// 생성자(constructor)가 private로 선언되어 있으면
// class안에서만 객체를 생서할수가 있다
