<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/2
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
        })
    </script>
</head>
<body>
<form>
    <label>省份</label>
    <select id="pro" name="pro">
        <option value="0" selected="selected">
            ----------------------
        </option>
        <c:forEach items="${provinceList}" var="pro">
            <option value="${pro.codeid}">
                    ${pro.cityName}
            </option>
        </c:forEach>
    </select>
    <label>地市</label>
    <select id="city" name="city">
        <option value="0" selected="selected">
            ----------------------
        </option>
    </select>

    <label>县区</label>
    <select id="counties" name="counties">
        <option value="0" selected="selected">
            ----------------------
        </option>
    </select><br>
</form>
</body>
</html>
