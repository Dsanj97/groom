package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        // 자바 코드로만 사용했을떄
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        // 의존성 이슈발생
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();


        // Spring 코드로 작성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 회원 생성후 저장
        Long memberId = 1L;
        Member member = new Member(memberId, "허동석", Grade.VIP);
        // 객체 저장
        memberService.join(member);


        // 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        // 주문 출력 --> toString() 으로 출력됨
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
