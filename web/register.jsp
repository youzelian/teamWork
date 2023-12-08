<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="JS/jquery-3.7.1.js"></script>
</head>
<body>
<h3>用户注册</h3>
<form action="UserSaveServlet" method="post">
    <p>
        用户名:<input type="text" id="userName" name="userName">
        <label id="nameTips"></label>
        <input type="button" value="检测" id="checkBtn"></p>
    <p>密码:<input type="password" id="Pwd1"></p>
    确认密码:<input type="password" id="Pwd2" name="userPwd">
    <label id="pwdTips"></label>
    <p>姓名:<input type="text" name="realName"></p>
    <p>性别:<input type="text" name="userGender"></p>
    <p>电话:<input type="text" name="userTel"></p>
    <p><input type="submit" value="提交注册"></p>
</form>
</body>
<script type="text/javascript">
    $("#checkBtn").click(function () {
        // 发送ajax请求，判断用户名是否可用
        var name = $("#userName").val();
        var pwd1 = $("#Pwd1").val();
        var pwd2 = $("#Pwd2").val();
        // 参数1:请求的urL
        // 参数2:传递的参数
        // 参数3:回调函数
        // 参数4,服务器返回的数据的格式(json,html,text,xml)
        $.get("CheckUserServlet", {userName: name, Pwd1: pwd1, Pwd2: pwd2}, function (res) {
            if (res.nameCode == 1) {
                $("#nameTips").replaceWith("<label id='nameTips' style='color:green'>用户名可用!</label>");
            } else {
                $("#nameTips").replaceWith("<label id='nameTips' style='color:red'>用户名被占用!</label>");
            }
            console.log(res.pwdCode);
            if (res.pwdCode == 1) {
                $("#pwdTips").replaceWith("<label id='pwdTips' style='color:green'>√</label>");
            } else {
                $("#pwdTips").replaceWith("<label id='pwdTips' style='color:red'>密码不一致</label>");
            }
        }, "json");
    });
</script>
</html>
