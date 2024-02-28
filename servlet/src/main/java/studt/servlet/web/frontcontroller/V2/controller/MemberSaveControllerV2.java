package studt.servlet.web.frontcontroller.V2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.domain.member.Member;
import studt.servlet.domain.member.MemberRepository;
import studt.servlet.web.frontcontroller.MyView;
import studt.servlet.web.frontcontroller.V2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("MemberSaveControllerV2.process");

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //Model 에 데이터를 보관
        request.setAttribute("member", member); // request 안에 member 보관

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
