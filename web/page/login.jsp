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
    <%@include file="comm.jsp" %>
    <title>登陆页面</title>
    <script>
        $(function () {
            var obj = document.getElementById("ipAddress");
            obj.value = returnCitySN.cip;
        })
        //创建用户登陆账号校验
        $("#username").blur(function(){
            var usernameObj=$("#username").val();
            if(usernameObj!=null){
                $("#errorMsg").hide();
            }else{
                $("#errorMsg").text("账号不能为空");
            }
        });
        //创建用户登陆密码校验
        $("#password").blur(function(){
            var password=$("#password").val();
            if(password!=null){
                $("#errorMsg").hide();
            }else{
                $("#errorMsg").text("密码不能为空");
            }
        });
        $("#login_sub").click(function(){
            //获取password输入框的值
            var usernameObj = $("#username").val();
            //获取password输入框的值
            var passObj = $("#password").val();
            if (usernameObj.length == 0||passObj.length == 0) {
                $("#errorMsg").text("用户名，密码不能为空");
            } else {
                $("#errorMsg").hide();
                return true;
            };

            return false;
        });

    </script>

</head>
<body>
<div class="user_div">
    <form action="login" method="POST">
        <table>
            <tr class="user_tr">
                <td colspan="2" id="user_title">
                    欢迎登陆
                </td>
            </tr>
            <tr>
                <td class="user_cont">
                    账号
                </td>
                <td>
                    <input type="text" class="login_text" name="username" id="username" placeholder="请输入用户编号或者邮箱地址"/><br>
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
</body>
</html>
