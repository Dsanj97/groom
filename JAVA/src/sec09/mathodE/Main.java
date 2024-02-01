package sec09.mathodE;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    // 메소드 참조
    public static void main(String[] args) {

        // 람다식이 어떤 메소드 하나만 호출할때 코드를 간편화
        // 해당 메소드가 인터페이스와 인자, 리턴값 구성이 동일할때
        Function<Integer,String> intToStrLD = i -> String.valueOf(i);
        Function<Integer,String> intToStrMR = String::valueOf;
        var intToStr = intToStrMR.apply(123);

        // 입력값과 출력값의 타입이 일치한 형태
        UnaryOperator<String> toLCaseLD = s -> s.toLowerCase();
        UnaryOperator<String> toLCaseMR = String::toLowerCase;
        var toLCase = toLCaseMR.apply("HELLO");

        // 버튼 만들어 보기 클래스 생성자
        // 이전 방식
        Function<String, Button> strToButtonLD = s -> new Button(s);
        // 버튼만 만들어서 반환하는거라면
        Function<String, Button> strToButtonMR = Button::new;
        Button button1 = strToButtonMR.apply("DOG");


        // 인자를 두개받고 만들기
        BiFunction<String, String, Button> twoStrToButtonLD = (s1, s2) -> new Button(s1, s2);
        BiFunction<String, String, Button> twoStrToButtonMR = Button::new;
        Button button2 = twoStrToButtonMR.apply("고양이", "야옹");
        button2.onClick();

        // 현존하는 인스턴스의 메소드 실행
        // 위에는 클래스로 접근하여 클래스이름인 Button으로 만들었다면
        // 여기서는 만들어진 버튼에 접근하여 안에 존재하는 인스턴스를 실행
        Runnable catCryLD = () -> button2.onClick();
        Runnable catCryMD = button2::onClick;
        catCryMD.run();
    }
}
