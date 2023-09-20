<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-18
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<<h2>수정</h2>
<form action="/update" method="post" name="updateForm">
  <input type="hidden" name="id" value="${member.id}">
  <input class="form-control" type="text" name="memberEmail" value="${member.memberEmail}" placeholder="이메일"
         readonly> <br>
  <input type="text" name="memberPassword" id="member-password" placeholder="비밀번호"> <br>
  <input type="text" name="memberName" value="${member.memberName}" placeholder="이름"> <br>
  <input type="text" name="memberMobile" value="${member.memberMobile}" placeholder="전화번호"> <br>
  <input type="button" value="수정" onclick="update_fn()">
  <%--        <button onclick="fun1()">함수호출</button>--%>
</form>
<script>
  const update_fn = () => {
    const passInput = document.getElementById("member-password").value;
    const passDB = '${member.memberPassword}';
    if (passInput == passDB) {
      document.updateForm.submit();
    } else {
      alert("비밀번호가 일치하지 않습니다!");
    }
  }
</script>
</body>
</html>
