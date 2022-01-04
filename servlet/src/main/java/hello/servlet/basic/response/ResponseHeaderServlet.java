package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 200으로 써도 되지만 magic number로 의미를 확인하도록 쓰는 것을 추천

        // [response-header]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 데이터 (방금 설정은 무효화)
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello"); // 내가 헤더를 만들 수 있음

        // [Header 편의 메서드]
       // content(response);
        //cookie(response);
        redirect(response);

        // [message body] 원하는 값을 바디에 넣어준다.
        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요");
    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        //원래는 setHeader를 이용해서 직접 생성했다면 아래와 같이 사용할 수도 있다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //임의로 지을 수 있는데 생략시 자동 생성
    }

    private void cookie(HttpServletResponse response) {
        // 아래는 주석은 직접 넣은 경우
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
