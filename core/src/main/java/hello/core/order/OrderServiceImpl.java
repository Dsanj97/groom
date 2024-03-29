package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // 롬복에서 만들어 주는 생성지
public class OrderServiceImpl implements OrderService {

    // 두가지 기능이 필요함
    // 1. 맴버 저장소에서 회원 정보 가져오기
    //private  final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


    // 2. 할인정책 가져오기 (고정 할인 정책)
    // 2. 할인정책 가져오기 (비율 할인 정책)
    // 할인 정책이 바뀌면 코드도 바뀌어야하는 문제가 발생함

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final DiscountPolicy discountPolicy;

    // setter 로 의존관계 주입 하기 private final MemberRepository memberRepository; ==> private MemberRepository memberRepository;
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1 = " + 1);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 잘 구성된 설계의 에
    // 할인에대해서 잘 모르겠고 너가 알아서 해줘 라는뜻
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 최종적으로 할인된 금액

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
