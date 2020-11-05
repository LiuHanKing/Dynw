<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/9/25
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../comm/comm.jsp" %>
    <title>Title</title>
    <style type="text/css">
        a{
            text-decoration:none;
        }
    </style>
    <script type="text/javascript" src="source/js/logout.js"></script>
</head>
<body>

<div>
    ${messg}
</div>
<div>
    <a href="getInfo?userid=${sessionScope.userid}">个人信息</a>
    <a href="page/user/change_pss.jsp">修改密码</a>
    <a href="page/user/forgotpass.jsp">忘记密码</a>
    <a id="logout">注销</a>
</div>

</body>
</html>
