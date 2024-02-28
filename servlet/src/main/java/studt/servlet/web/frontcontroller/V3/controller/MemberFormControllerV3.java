package studt.servlet.web.frontcontroller.V3.controller;

import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.V3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form"); // 기존의 전체 이름을 넣는게 아니라 논리적 이름만 넣는다
    }
}
