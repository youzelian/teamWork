<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/11/14 0014
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
<h3>添加游戏信息</h3>
<form action="gameSaveServlet" method="post" enctype="multipart/form-data">
    <%--<p>图书ID: <input type="text" name="gameId"></p>--%>
    <p>游戏名称: <input type="text" name="gameName"></p>
    <p>游戏介绍: <input type="text" name="gameDetail"></p>
    <p>游戏类型: <input type="text" name="gameType"></p>
    <p>游戏封面: <input type="file" name="gameImg"></p>
    <p>游戏价格: <input type="text" name="gamePrice"></p>
    <p>游戏链接: <input type="text" name="gameLink"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>

</html>
