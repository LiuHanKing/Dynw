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
    <%@include file="../comm/com_user_menu.jsp" %>
</div>
<div class="user_div">

</div>
<div>
    <%@include file="../comm/footer.jsp" %>
</div>
</body>
</html>
