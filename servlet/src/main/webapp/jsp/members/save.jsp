<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // jsp도 결국 서블릿으로 바뀌기 때문에 response, request 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    // 요청값 가져오기
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); // 무조건 getParameter로 들어올 때 문자열로 들어오기 때문에 형변환을 해줘야 된다.

    // 비지니스 로직 실행
    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
