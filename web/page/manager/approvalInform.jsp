<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/10
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../comm/comm.jsp" %>
    <title>审批通知消息</title>
    <link rel="stylesheet" href="source/css/com_user_menu.css">
    <style type="text/css">
        .approvalInfrom_div{
            float: left;
        }
        #approvalInfrom_iframe{
            margin-left: 50px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "getInformsUnApproval",
                type: "post",
                dataType: "json",
                data: {},
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var Url="getInformsById_un?id="+data[i].inf_id;
                        $("#unApprovalAll").append("<li ><a href="+Url+" target='iframe_main'>" + data[i].inf_title + "</a></li>");
                    }
                    ;
                },
                error: function () {
                    console.log("传输失败");
                }
            })
        })
    </script>
</head>
<body>
<div class="user_div">
    <div class="approvalInfrom_div">
        待审批的数据
        <ul id="unApprovalAll">

        </ul>
        审批不通过的数据
        <ul id="failApproval">

        </ul>
    </div>
</div>
</div>
</body>
</html>
