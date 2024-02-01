package sec06.chap07.ex04;

public class Switch extends FormElement implements Clickable {

    private boolean isOn;

    public Switch(boolean isOn){
        this.isOn = isOn;
    }

    @Override
    public void onClick() {
        func();
    }

    @Override
    void func() {
        isOn = !isOn;
        System.out.printf("%s(으로) 전환%n", isOn ? "ON" : "OFF");
    }
}
