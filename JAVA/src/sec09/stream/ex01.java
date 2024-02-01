package sec09.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ex01 {
    public static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
        );
        // 홀수만 골라낸 다음 정렬하여 "1, 3, 5.." 와 같은 문자열로 만들어 보기

        //  기존의 방식
        List<Integer> odds = new ArrayList<>();
        for (Integer i : int0To9) {
            if (i % 2 == 1) odds.add(i);
        }
        odds.sort(Integer::compare);

        List<String> oddsStrs = new ArrayList<>();
        for (Integer i : odds) {
            oddsStrs.add(String.valueOf(i));
        }
        String oddsStr = String.join(", ", oddsStrs);

        var oddsStrStreamed = int0To9                           // 아까만든 배열
                .stream()                                       // 스트림 수도꼭지 물의 흐름 같음
                .filter(i -> i % 2 == 1)                        // 홀수 필터링 (람다식)
                .sorted(Integer::compare)                       // 정렬 시키기
                .map(String::valueOf)                           // String 으로 바꾸기
                .collect(Collectors.joining(", "));    // 문자열로 바꾸기
    }
}
