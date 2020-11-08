<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/8
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="source/css/com_user_menu.css">
    <script type="text/javascript" src="source/js/comm_user_menu.js"></script>
</head>
<body>
<div>
    <h1>
        Dynw信息管理系统
    </h1>

    <div class="div_menu">
        <ul class="ul_menu">
            <%-- <li class="menu_li">
                 <a href="getInfo?userid=${sessionScope.userid}">个人信息</a>
             </li>
             <li class="menu_li">
                 <a href="page/user/forgotpass.jsp" class="login_head_sigin">忘记密码</a>
             </li>--%>
            <li class="menu_li">
                <a class="login_head_sigin" id="li_help_menu">用户管理</a>
                <ul class="ul_div_menu_help_c">
                    <li>
                        <a href="page/user/getUser.jsp" class="login_head_sigin">账号无法登录</a>
                    </li>
                    <li>
                        <a href="getInfo?userid=${sessionScope.userid}">个人信息</a>
                    </li>
                    <li>
                        <a href="page/user/change_pss.jsp">修改密码</a>
                    </li>
                    <li>
                        <a href="page/user/forgotpass.jsp">忘记密码</a>
                    </li>
                </ul>
            </li>
            <li class="menu_li">
                <a id="logout">注销登陆</a>
            </li>
            <li>
                <a id="user_yname">
                    当前登陆的账号:${sessionScope.username}
                </a>
            </li>
            <c:if test="${sessionScope.yhcaste !='0'}">
                <li>
                    <a>后台管理</a>
                </li>
            </c:if>

        </ul>
        <hr>
    </div>
</div>
</body>
</html>
