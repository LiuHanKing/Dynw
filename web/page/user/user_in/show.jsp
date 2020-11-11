<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/3
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <%@include file="../../comm/comm.jsp" %>--%>
    <title>Title</title>
    <style type="text/css">
        div {
            width: 380px;
            text-align: center;
        }

    </style>
</head>
<body>
<div>
    <hl>${infor.inf_title}</hl>
    <p>
        <small>作者：${infor.inf_author}</small>
        <small>发布时间：<fmt:formatDate value="${infor.inf_approvalTime}" pattern="yyyy-MM-dd HH:mm:ss" /></small>
    </p>
    <p>${infor.inf_content}</p>
</div>
</body>
</html>
