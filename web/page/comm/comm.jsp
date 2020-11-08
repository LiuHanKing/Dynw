<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/9/25
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    request.setAttribute("basePath", basePath);
%>
<link rel="shortcut icon" href="#"/>
<base href=<%=basePath%>>
<script type="text/javascript" src="source/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="source/css/notesys.css">
<script src="http://pv.sohu.com/cityjson?ie=utf-8" type="text/javascript"></script>
