$(function(){
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

})