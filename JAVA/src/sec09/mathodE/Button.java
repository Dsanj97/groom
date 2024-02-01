package sec09.mathodE;

public class Button {
    private String text;
    //인자를 하나 받음
    public Button(String text) { this.text = text; }
    //인자를 두개 받음
    public Button(String text, String sound){
        this(text);
        onClickListener = () -> System.out.println(sound + " " + sound);
    }
    public String getText() { return text; }

    private Runnable onClickListener;
    public void setOnClickListener(Runnable onClickListener) {
        this.onClickListener = onClickListener;
    }
    public void onClick(){
        onClickListener.run();
    }
}
