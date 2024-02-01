package sec06.chap07.ex03;

public class Main {
    public static void main(String[] args) {

        var sum1 = add2Num(12, 34.56);

    }

    // 제한된 제네릭
    // 제네릭에서 특정한 조건을 붙여서 해당 타입만 쓸수있게 하는법
    public static <T extends Number> double add2Num(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }
}
