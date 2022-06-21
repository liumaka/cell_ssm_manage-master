<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        人元添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/main.css" media="all">
    <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-2.1.4.min.js"></script>

    <style>
        .imgs {
            display: none;
        }

        input[type="file"] {
            width: 50px;
            height: 50px;
            border-radius: 100%;
            opacity: 0;
            cursor: pointer;
            border: 1px solid red;
            position: absolute;
        }
    </style>

</head>
<body>

<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <blockquote class="layui-elem-quote">
            <input type="hidden" name="id" value="8">
            <div>
                <input class="layui-upload " type="file" accept="undefined" id="previewImg" name="images"
                       onchange="upload(this,8)">
                <img src="${pageContext.request.contextPath}/images/${user.img}" class="layui-circle"
                     style="width:50px;height:50px;float:left" id="pimages"
                     name="pimages" alt="个人头像">
                <input id="avatar" name="image" required="" type="hidden" value="">
                <dl style="margin-left:80px; color:#019688">
                    <dt><span>${user.realname}</span> <span></span></dt>
                    <dd style="margin-left:0">这家伙很懒，什么也没有留下</dd>
                </dl>
            </div>
        </blockquote>

        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">

                    <div class="layui-form-item" hidden>
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>id
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="userId" autocomplete="off" placeholder="" class="layui-input" value="${user.id}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>用户名
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="username" autocomplete="off" placeholder="" class="layui-input"
                                   value="${user.username}">
                        </div>
                    </div>

<%--                    <div class="layui-form-item">--%>
<%--                        <label class="layui-form-label">--%>
<%--                            <span class='x-red'>*</span>原密码--%>
<%--                        </label>--%>
<%--                        <div class="layui-input-block">--%>
<%--                            <input type="password" name="oldPassword" value="" autocomplete="off" placeholder="请输入原密码"--%>
<%--                                   class="layui-input">--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>新密码
                        </label>
                        <div class="layui-input-block">
                            <input type="password" id="newPassword" name="newPassword" value="" autocomplete="off" placeholder="密码为空则不修改" onchange="check()" class="layui-input">
                        </div>
                    </div>
                    <div style="color: #ff0114" id="confirminfo"></div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" >
                            <span class='x-red'>*</span>确认密码
                        </label>
                        <div class="layui-input-block">
                            <input type="password" id="newPassword1" name="newPassword1" value="" autocomplete="off" placeholder="密码为空则不修改" onchange="check()" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>电话号码
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="phone" autocomplete="off" placeholder=""
                                   class="layui-input" value="${user.phone}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>邮箱
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="email" autocomplete="off" placeholder=""
                                   class="layui-input" value="${user.email}">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="">
                            保存
                        </button>
                    </div>
                    <!--</form>-->
                    <div style="height:100px;"></div>
                </div>


            </div>

        </div>
    </form>
</div>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="js/x-layui.js" charset="utf-8"></script>


<script>
    function check() {
        var newPassword = document.getElementById('newPassword');
        var newPassword1 = document.getElementById('newPassword1');
        var confirminfo = document.getElementById('confirminfo');
        if (newPassword.value != newPassword1.value) {
            confirminfo.innerHTML = '两次输入密码不一致';
        }else{
            confirminfo.innerHTML = '';
        }
    }
    layui.use(['element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form()


        //图片上传接口
        /*layui.upload({
          url: './upload.json' //上传接口
          ,success: function(res){ //上传成功后的回调
              console.log(res);
            $('#LAY_demo_upload').attr('src',res.url);
          }
        });*/


        //监听提交
        form.on('submit(add)', function (data) {
            var userId = $("input[name='userId']").val();
            var username = $("input[name='username']").val();
            var newPassword = $("input[name='newPassword']").val();
            var newPassword1 = $("input[name='newPassword1']").val();
            var phone = $("input[name='phone']").val();
            var email = $("input[name='email']").val();

            if (username == "") {
                layer.msg('用户名不能为空', {icon: 5, time: 2000});
                return false;
            }

            var data = {
                "id":userId,
                "username":username,
                "password":newPassword1,
                "phone":phone,
                "email":email
            }
            $.ajax({
                type: "post",
                url: "./userUpdate",
                data: data,
                dataType: "json",
                success: function (data) {
                    if (data.status == 200) {
                        layer.msg(data.info, {icon: 6, time: 2000}, function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                        return false;

                    } else {
                        layer.msg(data.info, {icon: 5, time: 2000});
                        return false;
                    }
                }

            });

        });

    })
</script>


<!--栏目缩略图上传-->
<script>
    function upload(obj, id) {
        var formData = new FormData();
        formData.append('images', $('#previewImg')[0].files[0]);
        formData.append('id', id);
        layer.msg('图片上传中', {icon: 16});
        $.ajax({
            type: "post",
            processData: false,
            contentType: false,
            url: "./userImgInsert",
            data: formData,
            success: function (data) {
                if (data.status == 200) {
                    console.log(data.image_name);
                    layer.closeAll('loading');
                    //layer.msg(data.info,{icon:1,time:1000});
                    let src = data.url;
                    $("#pimages").attr('src', src);
                    $("#avatar").val(data.image_name);
                    $(".imgs").show();
                    return false;
                } else {
                    layer.msg(data.info, {icon: 2, time: 1000});
                }
            }
        });
    }
</script>

</body>
</html>