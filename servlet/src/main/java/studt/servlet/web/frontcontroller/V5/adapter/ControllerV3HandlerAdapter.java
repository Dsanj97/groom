package studt.servlet.web.frontcontroller.V5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.V3.ControllerV3;
import studt.servlet.web.frontcontroller.V5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    // handle 넘어온게 ControllerV3 라면 true반환
    @Override
    public boolean supports(Object handle) {
        return (handle instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);

        return mv;
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
