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
    <title>未登录时的菜单</title>
    <style type="text/css">
        /*设置文本的字体颜色为蓝色*/
        li a {
            color: blue;
        }

        /*鼠标停留时二级菜单显示*/
        .ul_menu > li:hover .ul_div_menu_help_c {
            display: block;
        }

        /*鼠标停留时三级菜单显示*/
        .ul_div_menu_help_c > li:hover .ul_div_menu_help_c_ul {
            display: block;
        }

        /*让二级菜单隐藏起来*/
        .ul_div_menu_help_c {
            display: none;
        }

        /*二级菜单以竖直形式展示背景颜色以及定位，不显示样式*/
        .ul_div_menu_help_c {
            list-style-type: none;
            position: relative;
            position: fixed;
            background-color: chartreuse;
            width: auto;
            float: right;
        }

        /*让二级菜单以竖直形式展示*/
        .ul_div_menu_help_c li {
            font-size: 16px;
            display: list-item;
        }

        /*让三级菜单隐藏起来*/
        .ul_div_menu_help_c_ul {
            display: none;
        }

        /*三级菜单以竖直形式展示背景颜色以及定位，不显示样式*/
        .ul_div_menu_help_c_ul {
            list-style-type: none;
            position: relative;
            position: fixed;
            background-color: chartreuse;
            width: auto;
        }

        /*让三级菜单以竖直形式展示*/
        .ul_div_menu_help_c_ul li {
            font-size: 16px;
            display: list-item;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            /*设置鼠标移入时背景颜色*/
            $(".menu_li").on("mouseover", function () {
                $(this).css("backgroundColor", "chartreuse");
            })
            /*设置鼠标移出时背景颜色恢复*/
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
            <a href="page/user/user_out/forgotpass.jsp" class="login_head_sigin">忘记密码</a>
        </li>
        <li class="menu_li">
            <a class="login_head_sigin" id="li_help_menu">帮助</a>
            <ul class="ul_div_menu_help_c">
                <li>
                    <a  class="login_head_sigin">账号无法登录</a>
                    <ul class="ul_div_menu_help_c_ul">
                        <li>
                            <a href="page/user/user_out/getAccountStatus.jsp" class="login_head_sigin">查询账号状态</a>
                        </li>
                        <li>
                            <a href="page/user/user_out/unfreeze.jsp" class="login_head_sigin">解除账号冻结</a>
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
