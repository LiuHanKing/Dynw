<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/8
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        li a {
            color: blue;
        }

        .ul_menu > li:hover .ul_div_menu_help_c {
            display: block;
        }

        .ul_div_menu_help_c > li:hover .ul_div_menu_help_c_ul {
            display: block;
        }

        .ul_div_menu_help_c {
            display: none;
        }

        .ul_div_menu_help_c {
            list-style-type: none;
            position: relative;
            position: fixed;
            background-color: chartreuse;
            width: auto;
            float: right;
        }

        .ul_div_menu_help_c li {
            font-size: 16px;
            display: list-item;
        }

        .ul_div_menu_help_c_ul {
            display: none;
        }

        .ul_div_menu_help_c_ul {
            list-style-type: none;
            position: relative;
            position: fixed;
            background-color: chartreuse;
            width: auto;
            float: right;
        }

        .ul_div_menu_help_c_ul li {
            font-size: 16px;
            display: list-item;
        }
    </style>
    <script type="text/javascript">
        $(function () {

            $(".menu_li").on("mouseover", function () {
                $(this).css("backgroundColor", "chartreuse");
            })
            $(".menu_li").on("mouseout", function () {
                $(this).css("backgroundColor", "");
            })
        })

    </script>
</head>
<body>
<div class="div_menu">
    <ul class="ul_menu">
        <li class="menu_li">
            <a href="page/register.jsp" class="login_head_sigin">注册</a>
        </li>
        <li class="menu_li">
            <a href="page/login.jsp" id="login_head_sigin">登陆</a>
        </li>
        <li class="menu_li">
            <a href="page/user/forgotpass.jsp" class="login_head_sigin">忘记密码</a>
        </li>
        <li class="menu_li">
            <a class="login_head_sigin" id="li_help_menu">帮助</a>
            <ul class="ul_div_menu_help_c">
                <li>
                    <a href="page/user/getUser.jsp" class="login_head_sigin">账号无法登录</a>
                    <ul class="ul_div_menu_help_c_ul">
                        <li>
                            <a href="page/user/getAccountStatus.jsp" class="login_head_sigin">查询当前账号状态</a>
                        </li>
                        <li>
                            <a href="page/user/unfreeze.jsp" class="login_head_sigin">解除账号冻结</a>
                        </li>
                        <li>
                            <a class="login_head_sigin">账号申诉</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>
