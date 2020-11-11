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
    <%@include file="../../comm/comm.jsp" %>
    <title>Dnyw系统</title>
    <style type="text/css">
        a {
            text-decoration: none;
        }

        #main_body_menu {
            width: 380px;
            position: absolute;
            top: 200px;
            min-height: 300px;
        }

        #main_foor_div {
            width: 100%;
        }

        #main_body_concent {
            margin-left: 380px;
        }

        #user_main_div {
            min-height: 320px;
            height: auto;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $(function () {
                $("#logout").click(function () {
                    var ip = returnCitySN.cip;
                    var str64 = window.btoa(ip);
                    if (confirm("是否确认退出登陆？")) {
                        // location.href = "logout?ipAddress=" + str64;
                        $.ajax({
                            url: "logout",
                            type: "post",
                            dataType: "json",
                            data: {
                                "ipAddress": str64
                            },
                            success: function (data) {
                                console.log(data);
                                if(data){
                                    $(window).attr("location","page/login.jsp")
                                }

                            },
                            error: function () {
                                console.log("传输失败");
                            }
                        })
                    }
                })

            })

        })
    </script>
</head>
<body>
<%@include file="../../manager/pop-up.jsp" %>
<div>
    ${messg}
</div>
<div>
    <%@include file="../../comm/com_user_menu.jsp" %>
</div>
<div id="user_main_div">
    <iframe name="iframe_main" width="80%" height="100%" frameborder="0" noResize="yes">
        <div id="main_body_menu" class="main_body_div">
            <ul>
                <li>2020年1月</li>
                <li>2020年1月</li>
                <li>2020年1月</li>
                <li>2020年1月</li>
            </ul>
        </div>
        <div class="main_body_div" id="main_body_concent">

        </div>
    </iframe>
</div>
<div id="main_foor_div">
    <%@include file="../../comm/footer.jsp" %>
</div>
</body>
</html>
