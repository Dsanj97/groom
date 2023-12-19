// 리스트아이템 이 가지고 있는 데이터
// id, 체크상태, 택스트 부분

export interface IListItem {
    id: string;
    item: string;
    checked: boolean;
}

// 이 클래스 에서는 위의 interface의 모든 요소를 포함하고 있어야 한다
export default class ListItem implements IListItem{

    constructor(
        // 클래스 내에서만 사용할것이기 때문에 _ 사용
        private _id: string = "",
        private _item: string = "",
        private _checked: boolean = false
    ){}

    get id(): string {
        return this._id;
    }

    set id(id: string) {
        this._id = id;
    }

    get item(): string {
        return this._item;
    }

    set item(item: string) {
        this._item = item;
    }

    get checked(): boolean {
        return this._checked;
    }

    set checked(checked: boolean) {
        this._checked = checked;
    }
}