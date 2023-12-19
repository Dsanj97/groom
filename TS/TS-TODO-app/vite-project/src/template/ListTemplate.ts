import List from "../models/List"

interface DOMList {
    ul: HTMLUListElement;
    clear(): void;
    rander(fullList: List): void;
}

export default class ListTemplate implements DOMList {

    ul: HTMLUListElement;

    static instance: ListTemplate = new ListTemplate();

    private constructor(){
        this.ul = document.getElementById("lists") as HTMLUListElement;
    }

    // ul 안에 없애버리기 
    clear(): void {
        this.ul.innerHTML = '';
    }

    //
    rander(fullList: List): void {
        this.clear();

        // 각각의 해당하는 요소를 생성합니다
        fullList.list.forEach(item =>{
            const liEl = document.createElement("li") as HTMLLIElement;
            liEl.className = 'item';

            const checkEl = document.createElement("input") as HTMLInputElement;
            checkEl.type = 'checkbox';
            checkEl.id = item.id;
            checkEl.checked = item.checked;
            // check요소는 liEl 안에있음
            liEl.append(checkEl);
            // 눌렀을때마다 요소 값 바꾸기
            checkEl.addEventListener('change', () =>{
                item.checked = !item.checked;
                // fullilst => List
                // List에서 쓰는 메소드는 가져와 쓸수 있음
                fullList.save()
            })

            const labelEl = document.createElement('label') as HTMLLabelElement;
            // 이건뭔지모르겠다 라벨의 아이디를 넣는거같은데
            labelEl.htmlFor = item.id;
            // 택스트 넣어주기
            labelEl.textContent = item.item;
            // liEl 에 labelEl 넣어주기
            liEl.append(labelEl);


            const buttonEl = document.createElement('button') as HTMLButtonElement;
            buttonEl.className = 'button';
            buttonEl.textContent = 'x';
            liEl.append(buttonEl);

            buttonEl.addEventListener('click', () =>{
                fullList.removeItem(item.id)
                this.rander(fullList)
            })

            // 요소 넣기
            this.ul.append(liEl)
        })
    } 
}