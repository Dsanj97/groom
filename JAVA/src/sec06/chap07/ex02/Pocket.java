package sec06.chap07.ex01;

// 원하는 자료형ㅇ들로 세개의 필드를 갖는 클래스
public class Pocket<T1, T2, T3> {
    private T1 fieldA;
    private T2 fieldB;
    private T3 fieldC;
    public Pocket(T1 fieldA, T2 fieldB, T3 fieldC) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        this.fieldC = fieldC;
    }
    public T1 getFieldA() {
        return fieldA;
    }
    public T2 getFieldB() {
        return fieldB;
    }
}
