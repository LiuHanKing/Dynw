<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/9
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../comm/comm.jsp" %>
    <title>forgotpass</title>
    <script type="text/javascript">
        $(function () {
            //倒计时
            var seconds = 60;//倒计时时间
            var handle;//事件柄
            function startTimer() {//开始计数
                handle = setInterval(timer, 1000);//刷新定时器
                $("#sendEmailCode").attr({"disabled": true});
            }

            function timer() {//计数器
                seconds -= 1;
                $("#sendEmailCode").val(seconds);
                if (seconds == 0) {
                    stopTimer();
                }
            }

            function stopTimer() {//结束定时器
                clearInterval(handle);
                $("#sendEmailCode").attr({"disabled": false});
                $("#sendEmailCode").val("获取验证码");
                seconds = 60;
            }

            $("#sendEmailCode").on("click", function () {

                //获取email输入框的值
                var email = $("#email").val();
                //判断非空
                if (email.length == 0) {
                    alert("邮箱不能为空!!!");
                } else {
                    startTimer();
                    $.ajax({
                        url: "sendemail",
                        type: "post",
                        dataType: "json",
                        data: {"email": email},
                        success: function (data) {
                            alert("发送成功!");
                            //console.log(data);
                        },
                        error: function () {
                            console.log("传输失败");
                        }
                    })

                }
            })
            $("#renewpass").on("blur", function () {
                var ObjNewPass = $("#newpass").val();
                var ObjreNewPass = $("#renewpass").val();
                if (ObjreNewPass.length == 0) {
                    alert("确认密码不能为空");
                } else if (ObjNewPass != ObjreNewPass) {
                    alert("确认密码和密码不一致");
                }
            });

            $("#sub_forget_pass").on("click", function () {
                var Objemail = $("#email").val();
                var Objyzm = $("#yzm").val();
                var ObjNewPass = $("#newpass").val();
                var ObjreNewPass = $("#renewpass").val();
                var pass_patt = /\w{6,18}$/;
                if (Objemail.length != 0 && Objyzm.length != 0 && ObjreNewPass.length != 0 && ObjNewPass == ObjreNewPass) {
                    if (pass_patt.test(ObjNewPass)) {
                        if (confirm("是否确认修改密码？")) {
                            $.ajax({
                                url: "resetpass",
                                type: "post",
                                dataType: "json",
                                data: {
                                    "yzm": Objyzm,
                                    "email": Objemail,
                                    "password": ObjNewPass
                                },
                                async: false,
                                success: function (data) {
                                    console.log(data);
                                    if (data) {
                                        alert("密码修改成功")
                                    } else {
                                        alert("密码修改失败")
                                    }
                                },
                                error: function (data) {
                                    console.log("传输失败");
                                }
                            })
                        }
                    } else {
                        alert("新密码不符合要求");
                    }
                } else {
                    alert("邮箱地址/验证码/新密码/确认密码不能为空");
                }
            })


        })
    </script>
</head>
<body>
<div>
    <form>
        <label>邮箱地址:&nbsp&nbsp&nbsp&nbsp</label>
        <input type="email" id="email" name="email"/>
        <br><br>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="button" id="sendEmailCode" value="发送邮箱验证码"/>
        <br><br>
        <label>验证码:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" id="yzm" name="email"/><br><br>
        <label>新密码:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="password" id="newpass" name="newpass"/><br><br>
        <label>确认新密码:</label>
        <input type="password" id="renewpass" name="renewpass"/><br><br>
        <input type="submit" id="sub_forget_pass" value="提交"/>
    </form>
</div>
</body>
</html>
