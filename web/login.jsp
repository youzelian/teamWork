<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/11/17 0017
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="JS/jquery-3.7.1.js"></script>
</head>
<body>
<form action="loginServlet" method="post">
    ${tipsHeader}<br>
    账号:<input type="text" name="userName"/><br>
    密码:<input type="text" name="userPwd"/><br>
    验证码:<input type="text" name="inputVcode">
    <img src="createCode" id="codeImg"/><br/>
    <input type="submit" value="登录">
    &nbsp; &nbsp;
    <a href="register.jsp">注册</a>
    ${tips}
</form>
</body>
<script>
    // var img = document.getElementById("codeImg");
    // img.onclick = function () {
    //     img.src = "createCode?m=" + Math.random();
    // };
    $("#codeImg").click(function () {
        $(this).attr('src', "createCode?m=" + Math.random());
    });
</script>
</html>
