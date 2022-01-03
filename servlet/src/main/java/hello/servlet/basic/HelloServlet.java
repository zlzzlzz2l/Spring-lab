package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // url /hello가 오면 해당 클래스를 실행한다.
public class HelloServlet extends HttpServlet { // HttpServlet을 상속받아야 Servlet을 사용할 수 있다.


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 요청을 위한 request, 응답을 위한 response를 던져준다.

        System.out.println("HelloServlet.service");
        String username = request.getParameter("username");
        System.out.println("request = " + username);

        response.setContentType("text/plain"); // 단순 문자열로 보낸다 (header 정보에 들어간다.)
        response.setCharacterEncoding("utf-8"); // 문자 세팅 인코딩 정보 (header 정보에 들어간다.)
        response.getWriter().write("hello" + username); // HTTP Message Body에 데이터가 들어간다.
        System.out.println("response = " + response);
    }
}
