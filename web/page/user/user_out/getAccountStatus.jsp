<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/8
  Time: 6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../comm/comm.jsp" %>
    <title>Title</title>
    <link rel="stylesheet" href="source/css/head_sigin.css">
    <style>
        #user_div_table {
            border-collapse: collapse;
            vert-align: middle;
            text-align: center;
        }

        #user_div_table tr td {
            width: 150px;
        }

        .table_tr_td_a {
            color: blue;
        }

        #sigin_menu_main {
            text-align: center;
        }


        #user_getUserStatus_div {
            margin-top: 30px;
            margin-left: 410px;
            text-align: center;
        }

    </style>
    <script type="text/javascript">
        $(function () {

            $("#sub_get_acount").click(function () {
                var objcz;
                var ObjAccount = $("#acount").val();
                if (ObjAccount.length == 0) {
                    alert("账号不能为空！！！")
                } else {
                    $.ajax({
                        url: "getUserStatus",
                        type: "post",
                        dataType: "json",
                        data: {"account": ObjAccount},
                        success: function (data) {
                            $("#user_div_table").empty();
                            console.log(data);
                            //console.log(data.account);
                            objcz = data.cz;
                            console.log(objcz);
                            $("#user_div_table").append(
                                "<tr id=\"user_div_table_tr\">\n" +
                                "<td>\n" + "账号" + "</td>\n" +
                                "<td>\n" + "用户状态" + "</td>\n" +
                                "<td>\n" + "操作" +
                                "</td>" +
                                "</tr>" +
                                "<tr >\n" +
                                "<td>\n" + data.account + "</td>\n" +
                                "<td>\n" + data.status + "</td>\n" +
                                "<td>\n" + "<p id=\"user_div_table_tr_td_p\"><\/p>"
                                +
                                "</td>" +
                                "</tr>");
                            if (objcz == '1') {
                                $("#user_div_table_tr_td_p").append(" <a  class=\"table_tr_td_a\">正常有效</a>")
                            } else if (objcz == '2') {
                                $("#user_div_table_tr_td_p").append("<a href=\"page/user/unfreeze.jsp\"  class=\"table_tr_td_a\">解除冻结</a>")
                            } else if (objcz == '3') {
                                $("#user_div_table_tr_td_p").append("<a class=\"table_tr_td_a\">账号申诉</a>")
                            } else if (objcz == '4') {
                                $("#user_div_table_tr_td_p").append("<a href=\"page/register.jsp\" class=\"table_tr_td_a\">重新注册</a>")
                            } else if (objcz == '5') {
                                $("#user_div_table_tr_td_p").append("<a href=\"page/register.jsp\" class=\"table_tr_td_a\">重新注册</a>")
                            } else if (objcz == '6') {
                                $("#user_div_table_tr_td_p").append("<a href=\"page/register.jsp\" class=\"table_tr_td_a\">注册账号</a>")
                            } else if (objcz == '7') {
                                $("#user_div_table_tr_td_p").append("<a href=\"getAccountStatus.jsp\" class=\"table_tr_td_a\">重新输入</a>")
                            }


                        },
                        error: function () {
                            console.log("传输失败");
                        }
                    });

                }
            })
        })
    </script>
</head>
<body>
<div>
    <div id="login_head">
        <h1>查询账号状态</h1>
        <%@include file="../../comm/comm_sigin_head_div.jsp" %>
    </div>
    <hr>
</div>
<div id="sigin_menu_main">
    <div>
        <form>
            <label>账号:</label>
            <input type="text" placeholder="用户编号或者邮箱地址" id="acount" name="acount">
            <input type="button" value="查询" id="sub_get_acount">
        </form>
    </div>
    <div id="user_getUserStatus_div">
        <table id="user_div_table" border="1">
            <tr id="user_div_table_tr">
                <td>账号</td>
                <td>用户状态</td>
                <td>操作</td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
