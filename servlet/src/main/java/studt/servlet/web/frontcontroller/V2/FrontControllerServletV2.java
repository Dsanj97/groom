package studt.servlet.web.frontcontroller.V2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.web.frontcontroller.MyView;
import studt.servlet.web.frontcontroller.V2.controller.MemberFormControllerV2;
import studt.servlet.web.frontcontroller.V2.controller.MemberListControllerV2;
import studt.servlet.web.frontcontroller.V2.controller.MemberSaveControllerV2;
import studt.servlet.web.frontcontroller.v1.ControllerV1;
import studt.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import studt.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import studt.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    //매핑정보
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI = request.getRequestURI(); // 요청한 URI 확인 가능

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);// 각각의 인터페이스에서 오버라이딩한 메서드 호출
        view.rander(request, response);
    }
}
