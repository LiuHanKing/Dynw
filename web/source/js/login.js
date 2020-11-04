$(function () {
    var obj = document.getElementById("ipAddress");
    obj.value = returnCitySN.cip;
    //创建用户登陆账号校验
    $("#username").blur(function(){
        var usernameObj=$("#username").val();
        if(usernameObj!=null){
            $("#errorMsg").hide();
        }else{
            $("#errorMsg").text("账号不能为空");
        }
    });
    //创建用户登陆密码校验
    $("#password").blur(function(){
        var password=$("#password").val();
        if(password!=null){
            $("#errorMsg").hide();
        }else{
            $("#errorMsg").text("密码不能为空");
        }
    });
    $("#login_sub").click(function(){
        //获取password输入框的值
        var usernameObj = $("#username").val();
        //获取password输入框的值
        var passObj = $("#password").val();
        if (usernameObj.length == 0||passObj.length == 0) {
            $("#errorMsg").text("用户名，密码不能为空");
        } else {
            $("#errorMsg").hide();
            return true;
        };

        return false;
    });
})