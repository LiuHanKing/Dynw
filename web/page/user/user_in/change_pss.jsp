<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/4
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../comm/comm.jsp" %>
    <title>changepass</title>
    <style type="text/css">
        .form_sigin{
            margin-top:30px;
            margin-left: 480px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#oldpassword").on("blur", function () {
                var ObjOldPass = $("#oldpassword").val();
                if (ObjOldPass.length != 0) {
                    $.ajax({
                        url: "checkoldpass",
                        type: "post",
                        dataType: "json",
                        data: {"username": "${sessionScope.username}", "password": $("#oldpassword").val()},
                        async: false,
                        success: function (data) {
                            //console.log(data);
                            if (data) {
                                alert("旧密码正确")
                            } else {
                                alert("旧密码错误")
                            }
                        },
                        error: function (data) {
                            console.log("传输失败");
                        }
                    })
                } else {
                    alert("旧密码不能为空！！！");
                }
            });
            $("#renewpassword").on("blur", function () {
                var ObjOldPass = $("#oldpassword").val();
                var pass_patt = /\w{6,18}$/;
                var ObjNewPass = $("#newpassword").val();
                var ObjreNewPass = $("#renewpassword").val();
                if (ObjreNewPass.length == 0) {
                    alert("确认新密码不能为空！！！");
                }else if (ObjNewPass != ObjreNewPass) {
                    alert("确认新密码和新密码不一致！！！");
                }else if (!pass_patt.test(ObjNewPass)) {
                    alert("密码格式不符合要求！！！");
                }else if (ObjOldPass == ObjNewPass) {
                    alert("新密码和久密码不能相同！！！");
                }
            });
            $("#change_sub").click(function () {
                var ObjOldPass = $("#oldpassword").val();
                var ObjNewPass = $("#newpassword").val();
                var ObjreNewPass = $("#renewpassword").val();
                var pass_patt = /\w{6,18}$/;
                if (ObjOldPass.length == 0) {
                    alert("旧密码不能为空！！！");
                }else if (ObjNewPass.length == 0) {
                    alert("新密码不能为空！！！");
                }else
                if (ObjreNewPass.length == 0) {
                    alert("确认新密码不能为空！！！");
                }else if (ObjNewPass != ObjreNewPass) {
                    alert("确认新密码和新密码不一致！！！");
                }else if (ObjOldPass.length != 0 && ObjreNewPass.length != 0 && ObjreNewPass.length != 0 && ObjNewPass == ObjreNewPass && ObjOldPass != ObjNewPass) {
                    if (pass_patt.test(ObjNewPass)) {
                        if (confirm("是否确认修改密码？")) {
                            $.ajax({
                                url: "changepass",
                                type: "post",
                                dataType: "json",
                                data: {"username": "${sessionScope.username}", "password": $("#newpassword").val()},
                                async: false,
                                success: function (data) {
                                    console.log(data)
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
                        alert("密码格式不符合要求！！！");
                    }

                }
            })
        })
    </script>
</head>
<body>

<div >
    <form id="change_pass_form">
        <label>旧密码:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="password" id="oldpassword" name="oldpassword"/><br><br>
        <label>新密码:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="password" id="newpassword" name="newpassword" placeholder="6-18位任意字符"/><br><br>
        <label>确认新密码:</label>
        <input type="password" id="renewpassword" name="renewpassword"/><br><br>
        <input type="submit" id="change_sub" value="确认修改"/>
    </form>

</div>

</body>
</html>
