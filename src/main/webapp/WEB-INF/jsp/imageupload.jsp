<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>upload模块快速使用</title>
    <link rel="stylesheet" th:href="@{/webjars/layui/2.5.7/css/layui.css}">
    <link rel="stylesheet" th:href="@{/index.css}">
    <script th:src="@{/webjars/layui/2.5.7/layui.js}"></script>
</head>
<body>
<header>
    <span>基于LayUI完成图片的上传和预览功能</span>
</header>

<article>
    <div class="layui-container">
        <div class="layui-row">
            <!-- 这里添加一个form表单 -->
            <form class="layui-form" action="">
                <!-- 这里设置一个隐藏域，用来存放我们的图片的地址 -->
                <input type="hidden" id="imagePath" name="imagePath" value="">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">图片描述</label>
                    <div class="layui-input-block">
                        <textarea name="imageDescribe" placeholder="请输入该图片的描述" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">上传按钮</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">图片预览</label>
                    <div class="layui-input-block">
                        <img id="image" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="upload">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</article>
</body>
</html>
<script>
    layui.use('upload', function(){
        let upload = layui.upload;
        let $ = layui.$;
        //执行实例
        let uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/upload/image' //上传接口
            ,done: function(res){
                if (res.code == 0){
                    layer.msg("上传成功");
                    //获得图片的路径
                    let src = res.data.src;
                    //将图片进行回显
                    $("#image").attr("src",src);
                    //将图片的地址赋值给 form的隐藏域
                    $("#imagePath").attr("value",src);
                }
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });


    layui.use('form', function(){
        let form = layui.form;
        let $ = layui.$;
        //监听表单的提交
        form.on('submit(upload)', function(data){
            $.ajax({
                url: "/upload/addImage",
                method: "post",
                data: data.field,
                dataType: "JSON",
                success: function (res){
                    if (res ==1){
                        layer.msg("上传成功");
                    }
                }
            })
            return false;
        });
    });
</script>
