package sec09.java_util_fun;


import sec07Game.*;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // ⭐️⭐️⭐️Runnerble⭐️⭐️⭐️
        Runnable dogButtonFunc = () -> System.out.println("멍멍");
        Runnable catButtonFunc = () -> System.out.println("야옹");
        Runnable cowButtonFunc = () -> System.out.println("음메");

        dogButtonFunc.run();
        catButtonFunc.run();
        cowButtonFunc.run();


        System.out.println("\n- - - - -\n");

        // 강아지 울음소리
        // 1. 버튼의 인스턴스를 생성
        Button dogButton = new Button("강아지");
        // 2. setter로 멍멍 하는  runnerble을 넣어줌
        dogButton.setOnClickListener(dogButtonFunc);

        Button catButton = new Button("고양이");
        catButton.setOnClickListener(() -> {
            System.out.println("- - - - -");
            System.out.println(catButton.getText() + "울음소리: 야옹야옹");
            System.out.println("- - - - -");
        });

        dogButton.onClick();
        catButton.onClick();

        // ⭐️⭐️⭐Supplier⭐️⭐️⭐️
        // get 메소드를 가지고 있음
        // 입력값과 같은 타입으로 반환해줌
        Supplier<String> appName = () -> "BudDiary";
        Supplier<Double> rand0to10 = () -> Math.random() * 10;
        Supplier<Boolean> randTF = () -> Math.random() > 0.5;

        var supp1 = appName.get();
        var supp2 = rand0to10.get();
        var supp3 = randTF.get();

        System.out.println("\n- - - - -\n");

        // ⭐️⭐️⭐Consumer⭐️⭐️⭐️
        // accept 메소드를 가지고 있음
        // 인자를 받음, 리턴값 없음

        // 인자를 하나만 받기에 i 에 () 를 없애도됨
        // 람다도 한줄만 실행하는것이다 보니 {} 생략 가능
        Consumer<Integer> sayOddEven  = i -> System.out.printf(
                "%d은 %c수 입니다 %n", i, "짝홀".charAt(i % 2)
        );

        // 버튼 클릭해버리
        Consumer<Button> clickButton = b -> b.onClick();

        // BiConsumer -> 서로다른 타입의 인자를 받음
        // Button 과 숫자를 받고 그수만큼 버튼 누르기
        BiConsumer<Button, Integer> clickButtonNTimes = (b, n) -> {
            for (var i = 0; i < n; i++){
                b.onClick();
            }
        };

        sayOddEven.accept(3);
        sayOddEven.accept(2);
        // 아까만든 cat버튼을 인자로 받아서 처리해버림
        clickButton.accept(catButton);

        clickButtonNTimes.accept(dogButton,5);

        System.out.println("\n- - - - -\n");

        // ⭐️⭐️⭐Function⭐️⭐️⭐️
        // accept 메소드를 가지고 있음
        // 하나의 인자와 한개의 리턴 을 가짐

        // 정수 한개를 넣어서 홀수인지 확인
        Function<Integer, Boolean> isOdd = i -> i % 2 == 1;
        // 문자열을 받아서 버튼을 생성
        Function<String, Button> getButton = s -> new Button(s);

        // 두개의 인자를 받아서 한개의 반환값을 가짐
        BiFunction<Unit, Horse, Integer> getFullHP = (u, h) -> {
            h.setRider(u);
            return u.hp;
        };

        BiFunction<String, Runnable, Button> getButtonWFunc = (s, r) -> {
            var b = new Button(s);
            b.setOnClickListener(r);
            return b;
        };

         var isOdd3 = isOdd.apply(3);
         var isOdd4 = isOdd.apply(4);

         var goatButton = getButton.apply("염소");


         var unitFullHP = getFullHP.apply(
                 new MagicKnight(Side.RED), new Horse(80)
         );

        getButtonWFunc.apply("오리", () -> System.out.println("꽥꽥")).onClick();


        System.out.println("\n- - - - -\n");

        // ⭐️⭐️⭐Predicate⭐️⭐️⭐️
        // test 메소드를 가지고 있음
        // 인자를 하나받고 boolean으로 반환
        Predicate<Integer> isOddTester = i -> i % 2 == 1;
        Predicate<String> isAllLowerCase = s -> s.equals(s.toLowerCase());

        BiPredicate<Character, Integer> areSameCharNum = (c, i) -> (int) c == i;
        BiPredicate<Unit, Unit> areSameSide = (u1, u2)  -> u1.getSide() == u2.getSide();

        boolean isOddT3 = isOddTester.test(3);
        boolean isOddT4 = isOddTester.test(4);
        boolean isAL1 = isAllLowerCase.test("Hello");
        boolean isAL2 = isAllLowerCase.test("world");

        boolean areSameCN1 = areSameCharNum.test('A', 64);
        boolean areSameCN2 = areSameCharNum.test('A', 65);

        boolean areSameSide1 = areSameSide.test(
                new Knight(Side.RED), new Knight(Side.BLUE)
        );
        boolean areSameSide2 = areSameSide.test(
                new Swordman(Side.BLUE), new MagicKnight(Side.BLUE)
        );

    }
}
