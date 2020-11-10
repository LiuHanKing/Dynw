<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/10
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../comm/comm.jsp" %>
    <title>添加通知</title>
    <style type="text/css">
        #informsTitle {
            width: 300px;
            height: 28px;
            border: 1px solid black;
        }

        #informsContent {
            width: 300px;
            height: 200px;
            border: 1px solid black;
        }
        addInform_div{
            margin-top: 5px;
            margin-left: 5px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#informsTitle").attr("contentEditable", true);
            $("#informsContent").attr("contentEditable", true);
            $("#informs_button").on("click", function () {
                var ObjTitle = $("#informsTitle").text();
                var ObjContext = $("#informsContent").text();
                if (ObjTitle.length == 0) {
                    alert("标题不能为空");
                } else if (ObjContext == 0) {
                    alert("内容不能为空");
                } else if (ObjTitle.length != 0 && ObjContext.length != 0) {
                    if (confirm("您确定要提交吗？")) {
                        $.ajax({
                            url: "addInforms",
                            type: "post",
                            dataType: "json",
                            data: {
                                "title": ObjTitle,
                                "content": ObjContext
                            },
                            success: function (data) {
                               if(data){
                                   alert("通知已经提交成功！！！，请等待审批通过！");
                               }else{
                                   alert("通知已经提交失败！！！，请重新审核内容之后再次提交！")
                               }
                            },
                            error: function () {
                                console.log("传输失败");
                            }
                        })
                    }
                }
            })
        });
    </script>
</head>
<body>
<div id="addInform_div">
    <form>
        <label>通知标题</label>
        <br>
        <div id="informsTitle"></div>
        <label>通知内容</label>
        <br>
        <div id="informsContent"></div>
        <input type="button" value="提交" id="informs_button"/>
    </form>
</div>
</body>
</html>
