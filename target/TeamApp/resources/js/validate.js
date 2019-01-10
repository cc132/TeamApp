$(function (){
    $("form input[name='login']").click(function (){
        var account=$("#account").val();
        var password=$("#password").val();
        var json = {
        		"account":account,
        		"password":password
        };
        $.ajax({
            type:'POST',
            data: json,
            url:'hello',
            dataType:'json',//返回数据格式
            success:function (data){
                console.log(data);//值为success
            }
        });
    });
});