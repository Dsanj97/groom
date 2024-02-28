package studt.servlet.web.frontcontroller.V4.controller;

import studt.servlet.domain.member.Member;
import studt.servlet.domain.member.MemberRepository; 
import studt.servlet.web.frontcontroller.V4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";

        //1. 파라미터에서 데이터꺼내고
        //2. 비즈니스 로직 실행시켜주고
        //3. 모델에 넣어서 보내주고
        //4. 리턴을 스트링으로 해주고
    }
}
