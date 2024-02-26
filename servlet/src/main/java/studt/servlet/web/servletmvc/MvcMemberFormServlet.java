package studt.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; //WEB-INF 경로의 파일은 컨트롤러를 거쳐서 이동해야함
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //컨트롤러에서 뷰로 이동할떄 사용
        dispatcher.forward(request, response); // 간닷!
    }
}
