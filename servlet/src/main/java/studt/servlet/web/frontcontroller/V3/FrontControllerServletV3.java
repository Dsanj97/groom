package studt.servlet.web.frontcontroller.V3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.MyView;
import studt.servlet.web.frontcontroller.V3.controller.MemberFormControllerV3;
import studt.servlet.web.frontcontroller.V3.controller.MemberListControllerV3;
import studt.servlet.web.frontcontroller.V3.controller.MemberSaveControllerV3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    //매핑정보
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI(); // 요청한 URI 확인 가능

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);// 각각의 인터페이스에서 오버라이딩한 메서드 호출

        String viewName = mv.getViewName(); // 논리이름

        MyView view = viewResolver(viewName);
 
        view.rander(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        // paramMap 을 넘겨줘야함
        // Map 형식으로 넘겨줄것이니 Map 하나 만들어주고
        Map<String, String> paramMap = new HashMap<>();

        //http request에 모든 파라미터의 이름을 다 가져오고 돌리면서 키 변수명 paramName 벨류로 request.getParameter로 다 꺼내오기
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
