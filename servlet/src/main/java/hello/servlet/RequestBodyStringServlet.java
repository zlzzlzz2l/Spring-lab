package hello.servlet;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // 메세지 body의 내용을 바이트 코드로 바로 얻을 수 있다.
        // 바이트 코드를 String으로 바꾸기 위해서
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 스프링에서 바이트 코드를 String으로 바꾸기 위한 유틸리티를 제공한다.
        // 바꿔서 꺼낼 때 인코딩 정보를 알려줘야 된다. 바이트 -> String 어떤 인코딩인지, 반대로 String -> 바이트로 바꿀 때도 어떤 인코딩인지 알려줘야 된다.
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
