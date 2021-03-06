<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/1
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../comm/comm.jsp" %>
    <title>用户信息</title>
    <link rel="stylesheet" href="source/css/com_user_menu.css">
    <style type="text/css">
        .input_width {
            width: 130px;
        }

    </style>
    <script type="text/javascript">
        $(function () {
            var userProvince = "${userInfo.province}";
            //console.log(userProvince);
            var usercity = "${userInfo.city}";
            //console.log(usercity);
            var usercCounties = "${userInfo.counties}";
            //console.log(usercCounties);
            if (userProvince.length != 0) {
                $.ajax({
                    url: "getCity",
                    type: "get",
                    dataType: "json",
                    data: {"code": userProvince},
                    async: false,
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("#city").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
                    },
                    error: function (data) {
                        console.log("传输失败");
                    }
                });
                $.ajax({
                    url: "getCounties",
                    type: "get",
                    dataType: "json",
                    data: {"code": usercity},
                    async: false,
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("#counties").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
                    },
                    error: function (data) {
                        console.log("传输失败");
                    }
                })
                //调用下拉框默认值
                selectValue("city", usercity);
                selectValue("counties", usercCounties);
            } else {
                $.ajax({
                    url: "getCity",
                    type: "get",
                    dataType: "json",
                    data: {"code": 11},
                    async: false,
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("#city").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
                    },
                    error: function (data) {
                        console.log("传输失败");
                    }
                })
                $.ajax({
                    url: "getCounties",
                    type: "get",
                    dataType: "json",
                    data: {"code": 1101},
                    async: false,
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("#counties").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
                    },
                    error: function (data) {
                        console.log("传输失败");
                    }
                })
            }


            //遍历下拉框设置默认选项
            function selectValue(sId, value) {
                var s = document.getElementById(sId);
                var ops = s.options;
                for (var i = 0; i < ops.length; i++) {
                    var tempValue = ops[i].value;
                    if (tempValue == value) {
                        ops[i].selected = true;
                    }
                }
            }

            $("#yname").on("blur", function () {
                var objname = $("#yname").val();
                if (objname.length >= 120 && objname.length <= 0) {
                    alert("用户名长度在1-120之间")
                }
            })
            $("#sub_input").click(function () {
                var ObjphoneNumber = $("#phoneNumber").val();
                var Objname = $("#yname").val();
                if (Objname.length >= 120 && Objname.length == 0) {
                    alert("用户名不能为空，长度不能超过120个字符！！！");
                } else if (ObjphoneNumber.length != 11 && ObjphoneNumber.length != 0) {
                    alert("手机号码可以为空或或者11位手机号码！！！");
                } else if (confirm("是否确认修改个人信息？")) {
                    if (Objname.length <= 120 && Objname.length != 0 && (ObjphoneNumber.length == 11 || ObjphoneNumber.length == 0)) {

                        $.ajax({
                            url: "updateInfo",
                            type: "post",
                            dataType: "json",
                            data: $("#userinfo_form").serialize(),
                            async: false,
                            success: function (data) {
                                alert("修改成功");
                            },
                            error: function () {
                                alert("修改失败");
                                console.log("传输失败");
                            }
                        })
                    }
                }
            })
        })
    </script>
</head>
<body>
<span class="message"></span>
<div class="user_div">
    <form id="userinfo_form">
        <input id="userid" name="userid" value="${sessionScope.userid}" hidden/>
        <input id="yh_id" name="yh_id" value="${userInfo.yh_id}" hidden/>
        <label>用户编号:</label>
        <input type="text" value="${userInfo.yhbh}" id="yhbh" name="yhbh" disabled="true"/><br><br>
        <label>用户名:&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" value="${userInfo.yname}" id="yname" name="yname" placeholder="用户名在1——120之间"/><br><br>
        <label>性别:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <select value="${userInfo.gender}" id="gender" name="gender">
            <option value='1' <c:if test="${userInfo.gender ==1}">selected</c:if>>男</option>
            <option value='0' <c:if test="${userInfo.gender ==0}">selected</c:if>>女</option>
        </select><br><br>
        <label>出生日期:</label>
        <input type="datetime-local" name="brithday"
               value="<fmt:formatDate  value='${userInfo.brithday}' pattern='yyyy-MM-dd' />"
               id="brithday" placeholder="yyyy-MM-dd"/>
        <br><br>
        <label>省份:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <select id="pro" name="province" class="input_width">
            <c:forEach items="${provinceList}" var="pro">
                <option value="${pro.codeid}" <c:if test="${userInfo.province == pro.codeid}">selected</c:if>>
                        ${pro.cityName}
                </option>
            </c:forEach>
        </select><br><br>
        <label>地市:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <select id="city" name="city" class="input_width">
        </select><br><br>

        <label>县区:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <select id="counties" name="counties" class="input_width">
        </select><br><br>
        <label>手机号:&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" value="${userInfo.phoneNumber}" id="phoneNumber" name="phoneNumber" placeholder="11位数字"/>
        <br><br>
        <label>邮箱地址:</label>
        <input type="email" value="${userInfo.email}" id="email" readonly="true" name="email"
               placeholder="xxx@XXX.com"/> <br><br>
        <label>家庭住址:</label>
        <input type="text" value="${userInfo.homeAddres}" id="homeAddres" name="homeAddres" placeholder="大同胡同"/>
        <br><br>
        <label>爱好:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" value="${userInfo.hobby}" name="hobby" id="hobby" placeholder="多个爱好中间中;分隔"/> <br><br>
        <label><input type="submit" value="确认修改" id="sub_input"/> </label>
    </form>
</div>
</body>
<script type="text/javascript">
    $("#pro").on("blur", function () {
        var code = $("#pro").val();
        if (code != null) {
            $("#city").empty();
            $.ajax({
                url: "getCity",
                type: "get",
                dataType: "json",
                data: {"code": code},
                async: false,
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("#city").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>")
                    }
                },
                error: function (data) {
                    console.log("传输失败");
                }
            })
        }
    })
    $("#city").on("blur", function () {
        var code = $("#city").val();
        if (code != null) {
            $("#counties").empty();
            $.ajax({
                url: "getCounties",
                type: "get",
                dataType: "json",
                data: {"code": code},
                async: false,
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("#counties").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>")
                    }
                },
                error: function (data) {
                    console.log("传输失败");
                }
            })
        }
    })
</script>
</html>
