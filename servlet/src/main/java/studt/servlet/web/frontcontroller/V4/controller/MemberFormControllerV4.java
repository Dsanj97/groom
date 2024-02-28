package studt.servlet.web.frontcontroller.V4.controller;

import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.V3.ControllerV3;
import studt.servlet.web.frontcontroller.V4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
