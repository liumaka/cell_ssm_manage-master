<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>系统登录</title>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">

<div class="login">
    <div class="message">系统登录</div>
    <div id="darkbannerwrap"></div>
    <div style="color: red"><h3>${error}</h3></div>
    <div style="color: #27C24C"><h3>${ok}</h3></div>
    <form class="layui-form" id="login" method="post" action="./dologin">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <div style="color: red"><h3>${errorCode}</h3></div>
        <input class="input-text size-L" name="vcode" type="text" placeholder="请输入验证码" style="width: 200px;">
        <img title="点击图片切换验证码" id="vcodeImg" src="./vcode">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
    <div class="layui-input-inline" style="width:80px">
        <a href="./register">我要注册</a>
    </div>

    <div class="layui-input-inline" style="width:80px">
        <button type="button" onclick="buyItem('meizi','1000','绿茶')">购买</button>
        <a href="./buy">我要支付</a>
    </div>

</div>

<script>
    function buyItem(bookName,price,desc) {
        var list={"bookName": bookName, "price": price, "desc": desc};
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "/alipay_ajax_buy",
            //数据，json字符串
            data: list,
            success: function (result) {
                $("#app").append(result)
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        });
    }
</script>

<script>

    // $(function() {
    //     //点击图片切换验证码
    //     $("#vcodeImg").click(function() {
    //         this.src = "./vcode&t=" + new Date().getTime();
    //     });
    layui.use(['form'],
        function () {
            $ = layui.jquery;
            var form = layui.form(),
                layer = layui.layer;

            //点击图片切换验证码
            $("#vcodeImg").click(function () {
                this.src = "./vcode";
            });

            // $(function () {
            //     $.ajax({
            //         type: "POST",
            //         url: "./dologin",
            //         data: $('#login').val(),
            //         dataType : "json",
            //         success: function(data){
            //             if (data.status==200){
            //                 alert("登录成功")
            //                 window.location.href("index.html");
            //             }else {
            //                 alert("登录失败，用户名或密码错误")
            //             }
            //         }
            //     });
            // })


            /*//监听提交
            form.on('submit(login)',
                function(data) {
                    //alert(1);
                    /!*console.log(data);*!/
                    layer.alert(JSON.stringify(data.field), {
                        title: '点击确定进入后台'
                    },function  () {
                        location.href = "/index.html";
                    })
                    return false;


                });*/
        });

</script>


<!-- 底部结束 -->

</body>
</html>