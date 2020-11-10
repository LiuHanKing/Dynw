<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/8
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../comm/comm.jsp" %>
    <title>解除账号冻结</title>
    <style type="text/css">
        #user_getUserStatus_div {
            margin-top: 30px;
            margin-left: 410px;
        }
    </style>
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

            /*发送邮件*/
            $("#sendEmailCode").on("click", function () {

                //获取email输入框的值
                var email = $("#email").val();
                //email的校验规则
                var email_patt = /^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
                //console.log(email);
                //判断非空
                if (email.length == 0) {
                    alert("邮箱不能为空");
                } else {
                    if (email_patt.test(email)) {
                        startTimer();
                        $("#errorMsg").hide();
                        $.ajax({
                            url: "sendemail",
                            type: "post",
                            dataType: "json",
                            data: {"email": email},
                            success: function (data) {
                                //$("#errorMsg").html(data);
                                console.log(data);
                            },
                            error: function () {
                                console.log("传输失败");
                            }
                        })

                    } else {
                        alert("邮箱不符合要求");

                    }
                }
            })
            var timer=10;
            function startTimerPage() {//页面跳转计时器
                setInterval(handel, 1000);//刷新定时器
            }

            function handel() {
                timer-=1;
                if (timer==0) {
                    timer=10;
                    location.href = "../../login.jsp"
                }

            }

            $("#button_un").on("click", function () {
                var email = $("#email").val();
                var yzm = $("#yzm").val();
                if (email.length != 0 && yzm.length != 0) {
                    $.ajax({
                        url: "updateAccountFreeze",
                        type: "post",
                        dataType: "json",
                        data: {
                            "email": email,
                            "yzm": yzm
                        },
                        success: function (data) {
                            if (data) {
                                startTimerPage();
                                alert("解除冻结成功!!!10秒之后自动跳转登陆页面");
                            } else {
                                alert("解除冻结失败!!!");
                            }
                            //console.log(data);
                        },
                        error: function () {
                            console.log("传输失败");
                        }
                    })
                } else {
                    alert("验证码/邮箱地址不能为空");
                }
            });
        });
    </script>
</head>
<body>
<div>
    <div id="login_head">
        <h1>帮助</h1>
        <%@include file="../../comm/comm_sigin_head_div.jsp" %>
    </div>
    <hr>
</div>
<div id="sigin_menu_main">
    <div id="user_getUserStatus_div">
        <form>
            <label>邮箱地址:</label>
            <input type="email" placeholder="邮箱地址" id="email" name="email">
            <input type="button" value="发送验证码" id="sendEmailCode"><br><br>
            <label>验证码:&nbsp&nbsp&nbsp</label>
            <input type="text" id="yzm" name="yzm"><br><br>
            <input type="button" value="解除冻结" id="button_un"><br><br>
        </form>
    </div>

</div>
<div>
    <%@include file="../../comm/footer.jsp" %>
</div>

</body>
</html>
