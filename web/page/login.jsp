<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/9/26
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="comm/comm.jsp" %>
    <title>登陆页面</title>
    <script type="text/javascript" src="source/js/login.js"></script>
    <link rel="stylesheet" href="source/css/head_sigin.css">
    <script type="text/javascript">
        $(function () {
            $("#GoogleCode").click(function () {
                this.src = "${basePath}kaptcha.jpg?d" + new Date();
            });
        })

    </script>
</head>
<body>
<div>
    <div id="login_head">
        <h1>欢迎登陆</h1>
        <a href="page/register.jsp" id="login_head_sigin">注册</a>
    </div>
    <hr>
</div>

<div class="user_div">
    <form action="login" method="POST">
        <table>
            <%--            <tr class="user_tr">
                            <td colspan="2" id="user_title">
                                欢迎登陆
                            </td>
                        </tr>--%>
            <tr>
                <td class="user_cont">
                    账号
                </td>
                <td>
                    <input type="text" class="login_text" name="username" id="username"
                           placeholder="请输入用户编号或者邮箱地址"/><br>
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    密码
                </td>
                <td>
                    <input type="password" class="login_text" id="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    验证码
                </td>
                <td>
                    <input type="text" style="width: 80px;" name="GoogleCode">
                    <img src="kaptcha.jpg" id="GoogleCode" style="width: 100px; height: 28px;">
                </td>
            </tr>
            <input type="hidden" name="ipAddress" id="ipAddress"/>
            <tr class="user_tr">
                <td colspan="2">
                    <input type="submit" id="login_sub" value="登陆"/>
                </td>
            </tr>
        </table>

    </form>
</div>
<div id="msg_div">
    <span id="errorMsg">${messg}</span>
</div>
<%@include file="comm/footer.jsp" %>
</body>
</html>
