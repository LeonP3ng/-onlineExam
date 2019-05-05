$("#login").click(function(){
    var username=$("#username").val();
    var password=$("#password").val();
    console.log(username);
    $.ajax({
    	type: "POST",
        url: "http://localhost:8080/user/login",
        data: {
            username: username,
            password: password
        },
        success:function(data){
            if(data.status===true) {
                alert("登录成功！");
            }else{
                alert("登录失败！");
            }

        },
        error:function(){
        	alert("error!");
        }
    })
})