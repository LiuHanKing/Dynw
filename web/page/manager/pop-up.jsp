<%@ taglib prefix="c" uri="http://java.sun.com/jstl/xml_rt" %>
<%--
  Created by IntelliJ IDEA 2019.3.4.
  User: liuzhiwen
  Date: 2020/11/4
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<base href=<%=basePath%>>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="source/js/jquery-3.5.1.min.js"></script>
    <style type="text/css">
        /* 弹窗 */
        .modal {
            display: none; /* 默认隐藏 */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.4);
            -webkit-animation-name: fadeIn;
            -webkit-animation-duration: 0.4s;
            animation-name: fadeIn;
            animation-duration: 0.4s
        }

        /* 弹窗内容 */
        .modal-content {
            position: fixed;
            left: 20%;
            top: 10%;
            bottom: 0;
            background-color: #fefefe;
            width: 50%;
            height: 80%;
            -webkit-animation-name: slideIn;
            -webkit-animation-duration: 0.4s;
            animation-name: slideIn;
            animation-duration: 0.4s
        }

        /* 关闭按钮 */
        .close {
            color: white;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }

        .modal-header {
            padding: 2px 10px;
            background-color: #5cb85c;
            color: white;
        }

        .modal-body {
            padding: 2px 16px;
        }

        .modal-footer {
            padding: 2px 10px;
            background-color: #5cb85c;
            color: white;
        }

        /* 添加动画 */
        @-webkit-keyframes slideIn {
            from {
                bottom: -300px;
                opacity: 0
            }
            to {
                bottom: 0;
                opacity: 1
            }
        }

        @keyframes slideIn {
            from {
                bottom: -300px;
                opacity: 0
            }
            to {
                bottom: 0;
                opacity: 1
            }
        }

        @-webkit-keyframes fadeIn {
            from {
                opacity: 0
            }
            to {
                opacity: 1
            }
        }

        @keyframes fadeIn {
            from {
                opacity: 0
            }
            to {
                opacity: 1
            }
        }

        /*设置弹窗标题的大小*/
        .modal-header h2 {
            text-align: center;
        }

        /*设置弹窗主体的样式*/
        .modal-body_sonBody {
            float: left;
            text-align: center;
        }

        /*设置弹窗菜单的大小*/
        #modal-body_menu {
            border-right:1px solid black;
            width: 34%;
            height: 78%;
        }

        /*设置弹窗内容的大小*/
        #modal-body_context {
            width: 65%;
            height: 78%;
        }

        #modal-body_context h1 {
            text-align: center;
        }
       a {
            text-decoration:none;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                url: "getInformsPass",
                type: "get",
                dataType: "json",
                data: {},
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var Url="getInformsById?id="+data[i].inf_id;
                        $("#modal_body_menu_ul").append("<li ><a href="+Url+" target='informs_toshow'>" + data[i].inf_title + "</a></li>");
                    }
                    ;
                },
                error: function () {
                    console.log("传输失败");
                }
            })
        })


    </script>
    <script type="text/javascript">
        window.onload = function () {
            // 获取弹窗
            var modal = document.getElementById('myModal');
            //页面加载之后显示弹窗
            modal.style.display = "block";
            // 获取 <span> 元素，用于关闭弹窗 that closes the modal
            var span = document.getElementsByClassName("close")[0];

            // 点击 <span> (x), 关闭弹窗
            span.onclick = function () {
                modal.style.display = "none";
            }

            // 在用户点击其他地方时，关闭弹窗
            /*window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }*/

        };
    </script>

</head>
<body>
<div>
    <!-- 弹窗 -->
    <div id="myModal" class="modal">
        <!-- 弹窗内容 -->
        <div class="modal-content">
            <div class="modal-header">
                <span class="close">&times;</span>
                <h2>系统通知</h2>
            </div>
            <div class="modal-body">
                <div class="modal-body_sonBody" id="modal-body_menu">
                    <p class="inf_title">通知列表</p>
                    <hr>
                    <ul id="modal_body_menu_ul">
                        <%--                    <c:forEach items="${list}" var="inf">
                                                    <li>
                                                            ${inf.inf_title}
                                                    </li>
                                                </c:forEach>--%>
                    </ul>
                </div>
                <div class="modal-body_sonBody" id="modal-body_context">
                    <p class="inf_title">通知内容</p>
                    <hr>
                    <iframe name="informs_toshow"  frameborder="0" noResize="yes" width="100%" height="100%">

                    <span id="inf_author"></span>
                    <span id="inf_context"></span>
                    </iframe>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
