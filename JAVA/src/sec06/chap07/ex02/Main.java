package sec06.chap07.ex02;

import sec06.chap03.ex01.Outer;

public class Main {
    public static void main(String[] args) {

        // 선언시 아래와 같은 자료형에 따라 각 타입변수의 자료형을 명시
        // - 제네릭에는 원시값이 아닌 클래스만 사용 가능
        // - (래퍼클래스의 또다른 존재 이유)

        // 모든 자료형이 Double인 인스턴스들을 만듬
        Pocket<Double, Double, Double> size3d1 =
                new Pocket<>(123.45, 234.56, 345.67);

        // var을 사용하여 타입 추론도 가능함
        var size3d2 =
                new Pocket<>(123.45, 234.56, 345.67);

        // getter들을 사용하여 double형 숫자들을 반환
        double width = size3d1.getFieldA();
        double height = size3d1.getFieldB();
        double depth = size3d1.getFieldC();


        // 타입들을 다르게 해서 인스턴스 만들기
        Pocket<String, Integer, Boolean> person =
                new Pocket<>("허동석", 20, false);

        // 제네릭 클래스로 배열 생성시 ⚠️new 로 초기화 필수⚠️   ⤵️
        Pocket<String, Integer, Boolean>[] people = new Pocket[]{
                new Pocket<>("가나다", 29, false),
                new Pocket<>("kim", 21, true),
                new Pocket<>("choi", 25, false),
        };
    }
}
