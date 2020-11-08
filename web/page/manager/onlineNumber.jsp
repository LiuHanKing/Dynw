<%@ page import="com.aaa.listener.OnlineListener" %><%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/8
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../comm/comm.jsp" %>
    <title>Title</title>
    <script type="text/javascript">
        /*        function myrefresh() {
                    window.location.reload();
                }
                setTimeout('myrefresh()', 1000); //指定1秒刷新一次*/
        function startTimer() {//开始计数
            setInterval(timer, 1000);//刷新定时器
        };
        function timer() {//计数器
            $("#onlie_number").text(<%=OnlineListener.getOnlineNumberCount() %>);
        };

        $(function () {
            startTimer();
        })

    </script>
</head>
<body>
<div></div>
<div></div>
<div>
    <span>当前在线人数：<%--<%=OnlineListener.getOnlineNumberCount() %>--%> </span><span id="onlie_number"></span>
    <inpput id="a"/>
</div>
</body>
</html>
