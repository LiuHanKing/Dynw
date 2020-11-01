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
</head>
<body>
<script>
    $(function(){
        $("#logout").click(function(){
            var ip= returnCitySN.cip;
            var str64 = window.btoa(ip);
            console.log(str64);
            if(confirm("是否确认退出登陆？")){
                location.href="logout/"+str64;
            }
        })

    })
</script>
${messg}
<a id="logout">注销</a>
</body>
</html>
