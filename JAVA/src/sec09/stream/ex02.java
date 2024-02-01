package sec09.stream;

import sec07Game.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;


public class ex02 {
    public static void main(String[] args) {
        // 💡배열로부터 생성
        Integer[] integerAry = {1, 2, 3, 4, 5};
        // 배열을 스트림으로 만듦
        Stream<Integer> fromArray = Arrays.stream(integerAry);
        // 스트림은 외부에 노출이 없어서 확인할땐 toArray() 로 다시 배열로 만들어서 확인
        var formArray_arr = fromArray.toArray();


        // 원시값의 배열로부터는 스트림의 클래스가 달라짐
        int[] intAry = {1, 2, 3, 4, 5};
        IntStream fromIntAry = Arrays.stream(intAry);
        var fromIntAry_Arr = fromIntAry.toArray();

        double[] dblAry = {1.1, 2.2, 3.3};
        DoubleStream fromDblAry = Arrays.stream(dblAry);
        double[] fromDblAry_Arr = fromDblAry.toArray();


        // 💡값들로 직접 생성
        IntStream withInts = IntStream.of(1, 2, 3, 4, 5);
        Stream<Integer> withInteger = Stream.of(1, 2, 3, 4, 5);
        Stream<Unit> withUnits = Stream.of(
                new Swordman(Side.RED),
                new Knight(Side.RED),
                new MagicKnight(Side.BLUE)
        );
        var withUnits_Arr = withUnits.toArray();



        // 💡컬랙션으로 부터 생성
        List<Integer> intAryList = new ArrayList<>(Arrays.asList(integerAry));
        Stream fromColl1 = intAryList.stream();
        var fromColl1_Arr = fromColl1.toArray();

        //  맵의 경우 엔트리의 스트림으로 생성
        Map<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');

        Object[] fromHashMap_Arr = subjectGradeHM.entrySet().stream().toArray();

        //  💡 빌더로 생성
        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        builder.accept('빌');
        builder.accept('더');
        Stream<Character> withBuilder = builder.build();
        Object[] withBuilder_Arr = withBuilder.toArray();

        //  💡 concat 메소드로 생성
        // 두개의 스트림을 하나로 만들기
        Stream<Integer> toConcat1 = Stream.of(11, 22, 33);
        Stream<Integer> toConcat2 = Stream.of(44, 55, 66);
        Stream<Integer> withConcatMethod = Stream.concat(toConcat1, toConcat2);
        Object[] withConcatMethod_Arr = withConcatMethod.toArray();



        //  💡 이터레이터로 생성
        //  - 인자: 초기값, 다음 값을 구하는 람다 함수
        //  - limit으로 횟수를 지정해야 함
        Stream<Integer> withIter1 = Stream
                .iterate(0, i -> i + 2)
                .limit(10);
        Object[] withIter1_Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream
                .iterate("홀", s -> s + (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);
        Object[] withIter2_Arr = withIter2.toArray();



        //  💡 원시자료형 스트림의 기능들로 생성
        IntStream fromRange1 = IntStream.range(10, 20); // 20 미포함
        IntStream fromRange2 = IntStream.rangeClosed(10, 20); // 20 포함

        // 래퍼클래스의 스트림으로 만드려면 원시자료형의 boxed() 사용
        Stream<Integer> fromRangeBox = fromRange1.boxed();
        Object[] fromRangeBox_Arr = fromRangeBox.toArray();


        //  💡 Random 클래스의 스트림 생성 메소드들
        IntStream randomInts = new Random().ints(5, 0, 100);
        int[] randomInts_Arr = randomInts.toArray();

        DoubleStream randomDbls = new Random().doubles(5, 2, 3);
        double[] randomDbls_Arr = randomDbls.toArray();


        //  문자열을 각 문자에 해당하는 정수의 스트림으로
        IntStream fromString = "Hello World".chars();
        int[] fromString_Arr = fromString.toArray();




        //  💡 파일로부터 생성
        //  - File I/O : 이후 배울 것
        Stream<String> fromFile;
        Path path = Paths.get("./src/sec09/stream/tut.txt");
        try {
            fromFile = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[] fromFile_Arr = fromFile.toArray();
    }
}
