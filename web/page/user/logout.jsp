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
    <script type="text/javascript" src="source/js/logout.js"></script>
</head>
<body>
${messg}
<a href="getInfo?userid=${sessionScope.userid}">个人信息</a>
<a id="logout">注销</a>
</body>
</html>
