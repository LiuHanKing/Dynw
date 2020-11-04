<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/9/25
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="comm/comm.jsp" %>
    <title>注册页面</title>
    <script type="text/javascript" src="source/js/register.js"></script>
</head>
<body>
<div>
    <a href="page/login.jsp">登陆</a>
</div>
<div class="user_div">
    <form action="checkCode" method="POST">
        <table>

            <tr class="user_tr">
                <td colspan="3" id="user_title">
                    欢迎注册
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    用户编号
                </td>
                <td colspan="2">
                    <input type="text" placeholder="长度5-16,字母,数字" class="login_text" name="yhbh" id="yhbh"/>
                </td>
            </tr>

            <tr>
                <td class="user_cont">
                    邮箱地址
                </td>
                <td colspan="2">
                    <input type="text" class="login_text" name="email" id="email"/>
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    密码
                </td>
                <td colspan="2">
                    <input type="password" class="login_text" name="password" id="password"/>
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    确认密码
                </td>
                <td colspan="2">
                    <input type="password" class="login_text" name="repassword" id="repassword"/>
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    验证码
                </td>
                <td colspan="2">
                    <input type="text" class="login_text" id="code" name="yzm"/>
                </td>
                <td>
                    <input type="button" id="sendEmailCode" value="获取验证码"/>
                </td>
            </tr>
            <tr class="user_tr">
                <td colspan="3">
                    <input type="reset" value="清空"><input type="submit" value="注册" id="register_submit"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="msg_div">
    <span id="errorMsg">
        ${messg}
    </span>

</div>
</body>
</html>
