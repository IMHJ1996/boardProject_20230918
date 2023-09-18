<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-18
  Time: 오전 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>
    <table>
         <tr>
            <td>회원아이디</td>
            <td>이메일</td>
            <td>비밀번호</td>
            <td>이름</td>
            <td>전화번호</td>
            <td>수정</td>
            <td>삭제</td>
          </tr>
        <c:forEach items="${memberList}" var="member">
         <tr>
             <td>
                 <a href="/detail?id=${member.id}">${member.id}</a>
             </td>
             <td>${member.memberEmail}</td>
             <td>${member.memberPassword}</td>
             <td>${member.memberName}</td>
             <td>${member.memberMobile}</td>
         </tr>

        </c:forEach>
    </table>
</body>
</html>
