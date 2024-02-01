package sec06.chap07.ex01;

public class Main {
    public static void main(String[] args) {

        // 제네릭에서는 타입이 일관되어야 한다
        int ranNum = pickRandom( 123, 456);
        boolean ranBool = pickRandom(true, false);
        String ranStr = pickRandom("동", "석");

        var array1 = new Double[] {
                1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8
        };

        var array2 = new Character[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
        };
        arraySwap(array1, 3, 5);
        arraySwap(array2, 2, 7);

    }

    // 제네릭 메소드
    // 여러번 오버라이딩 할 필요가 없어짐
    // T : 타입 변수. 원하는 어떤 이름으로든 가능
    public static <T> T pickRandom (T a, T b) {
        return Math.random() > 0.5 ? a : b;
    }

    public static <T> void arraySwap (T[] array, int a, int b){
        if (array.length <= Math.max(a,b)) return;
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
