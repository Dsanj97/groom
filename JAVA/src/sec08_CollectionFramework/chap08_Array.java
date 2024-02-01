package sec08_CollectionFramework;

import sec07Game.*;

import javax.print.attribute.standard.JobKOctets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class chap08_Array {
    public static void main(String[] args) {
        // ⭐️ 제네릭을 사용하여 타입지정
        // - 붙이지 않을시 <Object>와 동일
        ArrayList<Integer> ints1 = new ArrayList<>();
        //ArrayList<int> ints1 = new ArrayList<>();
        // 제네릭에 원시타입은 넣을수 없다
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Knight> knights = new ArrayList<>();

        // add 메소드로 요소 추가
        ints1.add(11);
        ints1.add(22);
        ints1.add(33);
        ints1.add(44);
        ints1.add(55);

        // 요소 중복 허용
        for (var str : "바니 바니 바니 바니 당근 당근".split(" ")){
            strings.add(str);
        }


        // for-each 문 사용
        for (int i : ints1){
            System.out.println(i);
        }


        int ints1Size = ints1.size(); // 요소 개수
        boolean ints1IsEmpty = ints1.isEmpty();
        int ints12nd = ints1.get(1);
        boolean ints1Con3 = ints1.contains(33);
        boolean ints1Coin6 = ints1.contains(66);

        // 리스트 안의 요소를 바꿀떄 set 요소 사용
        ints1.set(2, 444);
        // 특정부분에 요소 더하기
        ints1.add(0, 111);


        // ⭐️간략한 생성 킻 초기화 방법들
        // 선언과 동시에 리스트에 할당하기
        ArrayList<Integer> ints2A = new ArrayList<>(
                Arrays.asList(1,2,3,4,5) // 💡Arrays 클래스 : 배열 관련 각종 기능 제공
        );
        ArrayList<Integer> ints2B = new ArrayList<>(
                List.of(1,2,3,4,5) // 💡List => 인터페이스   정적메소드를 가질수 있음 of
        );
        // 먼저 리스트를 만들어주고 Collections 믈래스를 사용하여 요소를 넣어주기
        ArrayList<Integer> ints2C = new ArrayList<>();
        Collections.addAll(ints2C, 1,2,3,4,5);



        // 다른 Array를 가지고 같은 값을 가지는 arry 생성하기
        ArrayList<Integer> ints3 = new ArrayList<>(ints1);
        // 스스로 복제하여 반환(⚠️얕은 복사)
        ArrayList<Integer> ints4 = (ArrayList<Integer>) ints3.clone(); // clone 오브젝트를 반환하기 때문에 형변환 필요

        // 요소 지우기
        ints3.remove(4); // int : 인덱스로 지우기
        // 배열안에있는 요소중에 저것과 일치하는 첫번째 것을 없애줌
        ints3.remove((Integer) 55); // 클래스 자료형 : 요소로 지우기


        // Array 안에서 다른 Array값들을 다 뺴주기
        ints1.removeAll(ints3);

        // 다른 Array이어 붙이기
        ints1.addAll(ints3);  // 콜랙션 이어붙이기

        // Array 리스트를 Object 로 반환하는법
        // 💡toArray - Object 배열 반환
        Object[] intsAry2_Obj = ints1.toArray();
        // ⭐️특정 타입을 배열로 반환하려면??
        //Integer[] ints1Ary1 = (Integer[]) ints1.toArray();// ⚠️ 이렇게는 불가
        // 💡인자로 해당 타입 배열의 생성자를 넣어줌
        // - 다음 섹션에 배울 메소드 참조 사용 (9-3강 수강후 다시 볼것)
        Integer[] intsAry2 = ints1.toArray(Integer[]::new);

        // 리스트 비우기
        ints1.clear();

        // 제네릭 적용
        numbers.add(Integer.valueOf(123));
        numbers.add(3.14);
        // numbers.add("Hello");  ⚠️불가

        // knights.add(new Swordman(Side.BLUE));  ⚠️불가
        knights.add(new Knight(Side.BLUE));
        knights.add(new MagicKnight(Side.RED));

        // 와일드 카드 적용
        // 기사 이상의 그룹으로만 편성될수 있는 정예 분대
        ArrayList<? extends Knight> eliteSquad;

        // eliteSquad = new ArrayList<Swordman>(); ⚠️불가
        eliteSquad = new ArrayList<Knight>();
        eliteSquad = new ArrayList<MagicKnight>();


        // ⭐️인스턴스 요소를 지울때는 참조를 기준으로
        // - 내용이 같다고 같은 인스턴스가 아님
        // Knight를 이용하여 knight1을 만들어주고
        Knight knight1 = new Knight(Side.RED);
        // knights 배열에 저장
        knights.add(knight1);

        // 요소를 지워졌는지 반환
        // 지워지지 않음 => 내용으로 지우려함 ㄷ
        boolean remove1 = knights.remove(new Knight(Side.RED));
        // 참조값 (주소값) 으로 지워야함
        boolean remove2 = knights.remove(knight1);
    }


}
