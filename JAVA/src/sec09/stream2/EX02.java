package sec09.stream2;

import java.util.*;
import java.util.stream.*;

public class EX02 {
    public static void main(String[] args) {
        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        // 이름들을 가지고 문자열의 스트림 생성
        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4); // 균일한 결과를 위해 지정된 시드값
        // Person의 인스턴스를 흘려보내는 스트림
        List<Person> people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18, 35),
                        random.nextDouble(160, 190),
                        random.nextBoolean()
                ))
                .sorted()
                //.sorted((p1, p2) -> p1.getHeight() > p2.getHeight() ? 1 : -1)
                //.sorted((p1, p2) -> Boolean.compare(p1.isMarried(), p2.isMarried()))
                .toList();


        //  💡 collect, Collectors의 기능들
        //  - 이미 다룬 joining도 이들 중 하나
        //  어떤 스트림을 원하는 컬랙션으로 바꾸기

        //  메소드에 따라 자료형이 달라지므로 var을 사용했습니다.
        var peopleLastNameSet = people.stream()
                // 각 사럼들의 성을 뽑아옴
                .map(p -> p.getName().charAt(0))

                //  💡 아래 중 원하는 컬렉션으로 택일
        //        .collect(Collectors.toList()); // ArrayLIst로 만들어줌
        .collect(Collectors.toSet()); // Hashset으로 만들어줌
        //.collect(Collectors.toCollection(ArrayList::new));
        //.collect(Collectors.toCollection(LinkedList::new));
        //.collect(Collectors.toCollection(TreeSet::new));


        Map<String, Integer> nameAgeMap = people.stream()
                //  💡 의미 없는 작업(해시맵이 될 스트림의 정렬)은 IDE가 제거 권유
                .sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
                .collect(Collectors.toMap(Person::getName, Person::getAge));


        // 스트림을 특정 기준에 따라서 해쉬 맵므로 바꾸는것

        // 결혼 여부에 따라 그룹핑
        Map<Boolean, List<Person>> peopleHMapByMarried = people.stream()
                .collect(Collectors.groupingBy(Person::isMarried));
        List<Person> marrieds = peopleHMapByMarried.get(true);


        // 각 사람의 키를 가지고 정렬
        Map<Integer, List<Person>> peopleHMapByHeight = people.stream()
                .collect(Collectors.groupingBy(
                        p -> ((int) p.getHeight() / 10) * 10)
                );
        List<Person> over180s = peopleHMapByHeight.get(180);


        // 숫자들의 스트림을 가져다가
        Map<Character, List<Integer>> intHMapByOddEven
                = IntStream.range(0, 10).boxed()
                .collect(Collectors.groupingBy(
                        i -> i % 2 == 1 ? '홀' : '짝'
                ));
        List<Integer> odds = intHMapByOddEven.get('홀');



        //  💡 수의 통계를 인스턴스 형태로 갖는 클래스
        IntSummaryStatistics ageStats = people.stream()
                .map(Person::getAge)
                .collect(Collectors.summarizingInt(Integer::intValue));


        DoubleSummaryStatistics heightStats = people.stream()
                .map(Person::getHeight)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
    }


}
