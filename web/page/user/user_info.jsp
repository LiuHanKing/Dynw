<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    <title>user_info</title>
    <script type="text/javascript" src="source/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#pro").on("blur", function () {
                $.ajax({
                    url: "getCity",
                    type: "get",
                    dataType: "json",
                    data: {"code": $("#pro").val()},
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
            });
            $("#city").on("blur", function () {
                $.ajax({
                    url: "getCounties",
                    type: "get",
                    dataType: "json",
                    data: {"code": $("#city").val()},
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
            });
        })
    </script>
</head>
<body>
<div>
    <form>
        省份
        <select id="pro">
            <option>
                -----------------
            </option>
            <c:forEach items="${provinceList}" var="pro">
                <option value="${pro.codeid}">
                        ${pro.cityName}
                </option>
            </c:forEach>
        </select>
        地市
        <select id="city">
            <option>
                -----------------
            </option>
        </select>
        县区
        <select id="counties">
            <option>
                -----------------
            </option>
        </select>
    </form>
</div>
</body>
</html>
