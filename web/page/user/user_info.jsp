<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/1
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>user_info</title>
    <script type="text/javascript" src="source/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#pro").on("blur", function () {
                var code = $("#pro").val();
                if (code != 0) {
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
            });
            $("#city").on("blur", function () {
                var code = $("#city").val();
                if (code != 0) {
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
            });



            var userProvince=${userInfo.province};
            console.log(userProvince);
            var usercity=${userInfo.city};
            console.log(usercity);
            var usercCounties=${userInfo.counties};
            console.log(usercCounties);
            $.ajax({
                url: "getCity",
                type: "get",
                dataType: "json",
                data: {"code": userProvince},
                async: false,
                success: function (data) {
                    // var data=JSON.parse(data);
                    //console.log(data.length)
                    for (var i = 0; i < data.length; i++) {
                        if (usercity==data[i].codeid){
                            $("#city").append("<option value=" + data[i].codeid +" select='selected'>" + data[i].cityName + "</option>");
                        }else {
                            $("#city").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
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
                data: {"code":usercity},
                async: false,
                success: function (data) {
                    // var data=JSON.parse(data);
                    //console.log(data.length)
                    for (var i = 0; i < data.length; i++) {
                        if (usercCounties==data[i].codeid){
                            $("#city").append("<option value=" + data[i].codeid +" select='selected'>" + data[i].cityName + "</option>");
                        }else {
                            $("#city").append("<option value=" + data[i].codeid + ">" + data[i].cityName + "</option>");
                        }
                    }
                },
                error: function (data) {
                    console.log("传输失败");
                }
            })
        })
    </script>
</head>
<body>
<div>
    <form>

        <label>用户编号</label>
        <input type="text" value="${userInfo.yh_yhbh}" id="yhbh"><br>
        <label>性别</label>
        <select value="${userInfo.gender}" id="gender">
            <option value='1'>男</option>
            <option value='0'>女</option>
        </select><br>
        <label>出生日期</label>
        <input type="datetime-local" value="<fmt:formatDate  value='${userInfo.brithday}' pattern='yyyy/MM/dd' />"
               id="brithday">
        <br>
        <label>爱好</label>
        <input type="text" value="${userInfo.hobby}" id="hobby"> <br>
        <label>省份</label>
        <select id="pro" name="pro">
            <option value="0" >
                ----------------------
            </option>
            <c:forEach items="${provinceList}" var="pro">
                <option value="${pro.codeid}"
                        <c:if test="${userInfo.province == pro.codeid}">selected</c:if> >
                        ${pro.cityName}
                </option>
            </c:forEach>
        </select>
        <label>地市</label>
        <select id="city" name="city">
            <option value="0" >
                ----------------------
            </option>
        </select>

        <label>县区</label>
        <select id="counties" name="counties">
            <option value="0" >
                ----------------------
            </option>
        </select><br>
        <label>手机号</label>
        <input type="text" value="${userInfo.phoneNumber}" id="phoneNumber"> <br>
        <label>邮箱地址</label>
        <input type="text" value="${userInfo.yh_email}" id="email"> <br>
        <label>家庭住址</label>
        <input type="text" value="${userInfo.homeAddres}" id="homeAddres"> <br>
        <label><input type="reset" value="重置" id="re_input"/></label>
        <label><input type="submit" value="确认修改" id="sub_input"/> </label>
    </form>
</div>
</body>
</html>
