<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/11
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../comm/comm.jsp" %>
    <title>未审批通知审批</title>
    <style type="text/css">
        .button_approval{
            background-color:deepskyblue;
        }
        #inf_content {
            width: 300px;
            height: 200px;
            border: 1px solid black;
        }
        div{
            margin-left: 32%;
            width: 500px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#passApproval").on("click",function () {
                $.ajax({
                    url: "informApproval",
                    type: "post",
                    dataType: "json",
                    data: {
                        "id":$("#inf_id").val(),
                        "status":1,
                        "remark":$("#inf_remark").val()
                    },
                    success: function (data) {
                        if(data){
                            if(confirm("审批完成!")){
                                // location.href = "page/manager/approvalInform.jsp";
                                window.close();
                            }
                        }
                    },
                    error: function () {
                        console.log("传输失败");
                    }
                })
            });
            $("#failApproval").on("click",function () {
                var Objremark=$("#inf_remark").val();
                console.log(Objremark);
                $.ajax({
                    url: "informApproval",
                    type: "post",
                    dataType: "json",
                    data: {
                        "id":$("#inf_id").val(),
                        "status":2,
                        "remark":$("#inf_remark").val()
                    },
                    success: function (data) {
                        if(data){
                            if(confirm("审批完成!")){
                                 location.href = "page/manager/approvalInform.jsp";
                            }
                        }
                    },
                    error: function () {
                        console.log("传输失败");
                    }
                })
            });
        })
    </script>
</head>
<body>

<div>
    <form >
        <input type="hidden" value="${infor.inf_id}" name="inf_id" id="inf_id">
        <label>标题:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" value="${infor.inf_title}" id="inf_title" name="inf_title" disabled="disabled"/>
        <br><br>
        <label>作者:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <input type="text" value="${infor.inf_author}" id="inf_author" name="inf_author" disabled="disabled"/>
        <br><br>
        <label>内容:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
        <div id="inf_content" name="inf_content">${infor.inf_content}</div>
        <br><br>
        <label>编辑时间:</label>
        <input type="text" value="<fmt:formatDate value="${infor.inf_approvalTime}" pattern="yyyy-MM-dd HH:mm:ss" />" id="inf_createTime" name="inf_createTime" disabled="disabled"/>
        <br><br>
<%--        <input type="hidden" name="inf_approvalStatus" id="inf_approvalStatus"/>--%>
        <label>审批意见:</label>
        <input type="text" value="${infor.inf_remark}" id="inf_remark" name="inf_remark"/>
        <br><br>
        <input type="button" value="审批通过" class="button_approval" id="passApproval"/>
        <input type="button" value="审批不通过" class="button_approval" id="failApproval"/>
    </form>
</div>
</body>
</html>
