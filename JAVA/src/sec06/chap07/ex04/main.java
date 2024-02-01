package sec06.chap07.ex04;

public class main {
    public static void main(String[] args) {
        FormClicker<Button> fc1 = new FormClicker<>(new Button());
        FormClicker<Switch> fc2 = new FormClicker<>(new Switch(true));

        fc1.printElemmode();
        fc2.clickElem();
    }
}
