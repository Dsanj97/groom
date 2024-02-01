package sec09.java_util_fun;

public class Button {
    private String text;
    public Button(String text) {this.text = text;}
    public  String getText(){return text;}

    // 3. onClickListener 라는 runnerble 필드로 들어감
    private Runnable onClickListener;

    public void setOnClickListener(Runnable onClickListener){
        this.onClickListener = onClickListener;
    }

    public void onClick () {
        onClickListener.run();
    }
}
