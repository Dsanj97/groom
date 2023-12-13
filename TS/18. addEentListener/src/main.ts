interface MyMouseEvent {
    x: number;
    Y: number;
}

interface MyKeyboardEvent {
    key: string;
}

interface MyEventObjects {
    click: MyMouseEvent;
    keypress: MyKeyboardEvent;
}

function handleEvent<K extends keyof MyEventObjects>(
    event: K, 
    callback: (e: MyEventObjects[K]) => void) {

}

handleEvent('keypress', (e)=> {})