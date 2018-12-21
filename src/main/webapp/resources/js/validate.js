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
            contentType:'application/json;charset=UTF-8',
            /*
             * 上面这段很重要,如果前台设置改属性，则前台必须返回给后台一个json字符串，且后台必须使用@Request+对象来接受
             * 当然如果不设置传送类型，则可以直接传送json对象，后台中使用相同的变量名来接受
             */
            dataType:'json',//返回数据格式
            data: JSON.stringify(json),
            url:'hello',
            success:function (data){
                console.log(data);//值为success
            }
        });
    });
});