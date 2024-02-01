package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    // return --> 할인 대상 금액
    // 이걸 호출하면 얼마를 할인했는지 리턴해줌
    int discount(Member member, int price);

}
