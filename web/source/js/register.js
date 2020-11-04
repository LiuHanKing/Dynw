$(function () {

        $("#yhbh").on("blur", function () {
            var result_yhbh;
            var yhbh = $("#yhbh").val();
            //yhbh的校验规则
            var yhbh_patt = /\w{5,16}$/;
            //创建password校验的函数
            if (yhbh.length == 0) {
                $("#errorMsg").text("用户编号不能为空");
            } else {
                if (yhbh_patt.test(yhbh)) {
                    $("#errorMsg").text(" ");
                    $.ajax({
                        url: "selectyhbh",
                        type: "post",
                        dataType: "json",
                        data: {"yhbh": yhbh},
                        async: false,
                        success: function (data) {
                            //console.log(data)
                            result_yhbh =data
                        },
                        error: function (data) {
                            console.log("传输失败");
                        }
                    })

                } else {
                    $("#errorMsg").text("用户编号不符合要求");

                };
                if (result_yhbh == 0) {
                    $("#errorMsg").text("此用户编号可用");
                } else{
                    $("#errorMsg").text("此用户编号不可用");
                }
            }
        });

        //创建校验email的函数
        $("#email").on("blur",function () {
            var result_email;
            //获取email输入框的值
            var emailObj = $("#email").val();
            //email的校验规则
            var email_patt = /^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
            if (emailObj.length == 0) {
                //$("#errorMsg").remove();
                $("#errorMsg").text("邮箱不能为空");
            } else {
                if (email_patt.test(emailObj)) {
                    //$("#errorMsg").remove();
                    //$("#errorMsg").hide();
                    $("#errorMsg").text(" ");
                    //验证邮箱是否被占用
                    $.ajax({
                        url: "selectemail",
                        type: "post",
                        dataType: "json",
                        data: {"email": emailObj},
                        async: false,
                        success: function (data) {
                            result_email =data;
                            //console.log(data);
                        },
                        error: function () {
                            console.log("传输失败");
                        }
                    })
                } else {
                    $("#errorMsg").text("邮箱不符合要求");

                };
                if (result_email==0) {
                    $("#errorMsg").text("此邮箱地址可用");
                } else {
                    $("#errorMsg").text("此邮箱地址不可用");
                }
            }
        })

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
        $("#sendEmailCode").on("click",function () {

            //获取email输入框的值
            var email = $("#email").val();
            //email的校验规则
            var email_patt = /^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
            console.log(email);
            //判断非空
            if (email.length == 0) {
                $("#errorMsg").text("邮箱不能为空");
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
                            $("#errorMsg").html(data);
                            //console.log(data);
                        },
                        error: function () {
                            console.log("传输失败");
                        }
                    })

                } else {
                    $("#errorMsg").text("邮箱不符合要求");

                }
            }

        })


        //创建密码校验规则函数
        var password_fun = function () {
            //获取password输入框的值
            var passObj = $("#password").val();
            //password的校验规则
            var pass_patt = /\w{6,18}$/;
            //创建password校验的函数
            if (passObj.length == 0) {
                $("#errorMsg").text("密码不能为空");
            } else {
                if (pass_patt.test(passObj)) {

                    $("#errorMsg").text(" ");
                } else {
                    $("#errorMsg").text("密码不符合要求");

                }
                ;
            }
        }
        //创建确认密码的校验规则函数
        var repassword_fun = function () {
            //获取password输入框的值
            var passObj = $("#password").val();
            //获取再次输入密码框的值
            var repassObj = $("#repassword").val();
            console.log(passObj+"-------------"+repassObj);
            if (repassObj.length == 0) {
                $("#errorMsg").text("确认密码不能为空");
            } else {
                if (repassObj != passObj ) {
                    $("#errorMsg").text("两个密码不一致");
                    //console.log("两个密码不一致");
                } else {
                    $("#errorMsg").text(" ");
                    //console.log("两个密码一致");
                }
                ;
            }
            ;
        }
        //创建验证码校验规则函数
        var code_function = function () {
            var codeObj = $("#code").val();
            if (codeObj.length == 0) {
                $("#errorMsg").text("验证码不能为空");
            } else {
                $("#errorMsg").text(" ");
            }
        }
        //调用yhbh的函数，全都是失去焦点事件
        $("#password").on("blur",password_fun);
        $("#repassword").on("blur",repassword_fun);
        $("#code").on("blur",code_function);

        //注册提交
        $("#register_submit").on("click",function () {
            var emailObj = $("#email").val();
            var yhbhObj = $("#yhbh").val();
            var passwordObj = $("#password").val();
            var repasswordObj = $("#repassword").val();
            var codeObj = $("#code").val();
            if (emailObj.length == 0 || yhbhObj.length == 0 || passwordObj.length == 0 || repasswordObj.length == 0 || codeObj.length == 0) {
                $("#errorMsg").text("邮箱地址，用户编号，密码，确认密码，验证码不能为空");
            } else {
                return true;
            }
            return false;
        })
    }
)