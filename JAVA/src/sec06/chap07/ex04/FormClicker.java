package sec06.chap07.ex04;

public class FormClicker <T extends FormElement & Clickable> {
    private T formElem;

    // 생성자
    public FormClicker(T forElem){
        this.formElem = forElem;
    }

    public void printElemmode() {
        formElem.printMode();
    }

    public void clickElem() {
        formElem.onClick();
    }
}
