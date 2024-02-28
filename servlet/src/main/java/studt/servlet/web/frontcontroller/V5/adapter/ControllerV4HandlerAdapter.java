package studt.servlet.web.frontcontroller.V5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studt.servlet.web.frontcontroller.ModelView;
import studt.servlet.web.frontcontroller.V4.ControllerV4;
import studt.servlet.web.frontcontroller.V5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handle) {
        return (handle instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV4 controller = (ControllerV4) handler;

        // 이전과 비슷
        Map<String, String> paramMap = createParamMap(request);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        // 모델뷰 이름이 스트링으로 온다 --> 모델뷰에 넣어서 다시 세팅해준다
        // 모델 값도 세팅
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

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
