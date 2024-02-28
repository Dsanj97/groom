package studt.servlet.web.frontcontroller.V5;

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
import studt.servlet.web.frontcontroller.V4.controller.MemberFormControllerV4;
import studt.servlet.web.frontcontroller.V4.controller.MemberListControllerV4;
import studt.servlet.web.frontcontroller.V4.controller.MemberSaveControllerV4;
import studt.servlet.web.frontcontroller.V5.adapter.ControllerV3HandlerAdapter;
import studt.servlet.web.frontcontroller.V5.adapter.ControllerV4HandlerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {


    // 어떤 핸들러가 들어올지 모르니 최상위 Obj로 선언
    // 각각의 컨트롤러안에서 캐스팅하여 사용할것인듯?
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        inintHandlerMappingMap();

        inintHandlerAdapters();
    }

    private void inintHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //V4 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4() );
    }

    //어댑터 등록
    private void inintHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV5.service");

        // 핸들러 찾아오는 로직
        Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 어댑터의 목록을 조회해서 맞는지 보고 선택
        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        // 어댑터도 찾았으니 핸들러(컨트롤러)를 찾아 모델뷰를 반환
        ModelView mv = adapter.handle(request, response, handler);

        // 뷰네임 호출해주고
        String viewName = mv.getViewName(); // 논리이름

        // 뷰리졸버 호출해주고
        MyView view = viewResolver(viewName);

        // 뷰랜더로 실질적인 뷰리턴
        view.rander(mv.getModel(), request, response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) { //handlerAdapters 안에서 조회한후
            if (adapter.supports(handler)) { // 어댑터가 지원을 한다면
                return adapter; // 어댑터 리턴
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을수 없습니 handler = " + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); // 요청한 URI 확인 가능
        return  handlerMappingMap.get(requestURI);// 매핑된 핸들러를 찾아옴
    }

    private static MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }
}
