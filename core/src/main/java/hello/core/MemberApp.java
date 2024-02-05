package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member m = new Member(1L, "dsa", Grade.BASIC);
        memberService.join(m);

        Member findMember = memberService.findMember(1L);
        System.out.println("new m = " + m.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}