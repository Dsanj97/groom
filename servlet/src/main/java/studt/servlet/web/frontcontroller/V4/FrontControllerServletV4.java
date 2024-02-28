package studt.servlet.web.frontcontroller.V4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.MyView;
import studt.servlet.web.frontcontroller.V3.ControllerV3;
import studt.servlet.web.frontcontroller.V4.controller.MemberFormControllerV4;
import studt.servlet.web.frontcontroller.V4.controller.MemberListControllerV4;
import studt.servlet.web.frontcontroller.V4.controller.MemberSaveControllerV4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    //매핑정보
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        String requestURI = request.getRequestURI(); // 요청한 URI 확인 가능

        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // v3 와 다른점 모델을 같이 넘김
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>(); // 추

        String viewName = controller.process(paramMap, model);// 각각의 인터페이스에서 오버라이딩한 메서드 호출
        // 뷰이름을 리턴받음

        MyView view = viewResolver(viewName);
 
        view.rander(model, request, response);
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
