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
<body class="register-bg">
<div class="register">
    <div class="message">注册页面</div>
    <div id="darkbannerwrap"></div>
    <div style="color: red">${error}</div>
    <form class="layui-form" id="register" method="post" action="./userInsert">
        <input name="username" value="${user.username}" placeholder="用户名" type="text" lay-verify="required"
               class="layui-input">
        <hr class="hr15">
        <input name="realname" value="${user.realname}" placeholder="真实姓名" type="text" lay-verify="required"
               class="layui-input">
        <hr class="hr15">
        <input name="password" id="password" maxlength="20" lay-verify="required" placeholder="密码" type="password" onchange="check()" class="layui-input">
        <hr class="hr15">
        <div style="color: #ff0114" id="confirminfo"></div>
        <input type="password" id="confirm" maxlength="20" lay-verify="required" placeholder="确认密码"  class="layui-input"  onchange="check()"/>
        <hr class="hr15">
        <input name="phone" value="${user.phone}" placeholder="电话号码" type="text" lay-verify="required"
               class="layui-input">
        <hr class="hr15">
        <input name="email" value="${user.email}" placeholder="邮箱" type="text" lay-verify="required"
               class="layui-input">
        <hr class="hr15">
        <input value="注册" lay-submit lay-filter="register" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
    <div class="layui-input-inline" style="width:80px">
        <a href="./login">返回登录界面</a>
    </div>
</div>
<script>
    function check() {
        var password = document.getElementById('password');
        var confirm = document.getElementById('confirm');
        var confirminfo = document.getElementById('confirminfo');
        if (password.value != confirm.value) {
            confirminfo.innerHTML = '两次输入密码不一致';
        }else{
            confirminfo.innerHTML = '';
        }
    }
    layui.use(['element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();





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