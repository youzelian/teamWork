<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/11/14 0014
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String type = (String) request.getAttribute("type");
    String url = null;
    if (type.equals("gameSave")) {
        url = basePath + "gameSaveServlet"; //设置跳转的地址
    }
    else if (type.equals("userSave")) {
        url = basePath + "login.jsp"; //设置跳转的地址
    }
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv=refresh content=5;url=<%=url %>>
    <title>Document</title>
</head>

<body>
<div style="text-align: center;margin-top:150px;">
    ${tips}
    <b style=color:blue><span id=jump>5</span> 秒钟后页面将自动返回${address}...</b>
</div>
</body>
<script>
    function countDown(secs) {
        jump.innerText = secs;
        if (--secs > 0)
            setTimeout("countDown(" + secs + " )", 1000);
    }

    countDown(5);
</script>
</html>
