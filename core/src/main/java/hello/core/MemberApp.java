package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // 기존 자바 코드로만 작성했을때
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

        // 스프링 활용
        // ApplicationContext ==> 스프링 컨테이너
        // @Bean 등 컨테이너들을 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // config 에서 memberService 라는이름의 객체를 찾음 MemberService.class 는 반환타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member m = new Member(1L, "dsa", Grade.BASIC);
        memberService.join(m);

        Member findMember = memberService.findMember(1L);
        System.out.println("new m = " + m.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
