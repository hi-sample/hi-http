<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hi Http</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        .modal {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            border: 1px solid #ccc;
            z-index: 1000;
            padding: 20px;
        }
        #overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }
    </style>
</head>
<body>
<h1>Hi Http</h1>
<br/>
<h3>URL参数</h3>
<ul>
    <li><a href="/url/parameter?param1=盘古开天&param2=女娲造人">查询参数 : /url/parameter?param1=盘古开天&amp;param2=女娲造人</a>
    </li>
    <li><a href="/url/array?params=盘古开天&params=女娲造人">查询参数-数组-1 : /url/array?params=盘古开天&amp;params=女娲造人</a>
    </li>
    <li><a href="/url/array?params=盘古开天,女娲造人">查询参数-数组-2 : /url/array?params=盘古开天,女娲造人</a></li>
    <li><a href="/url/path/盘古开天/女娲造人">URL Path Parameter : /url/path/盘古开天/女娲造人</a></li>
</ul>
<h3>请求体</h3>
<ul>
    <li>
        表单参数：
        <form method="post" action="/body/formParam">
            <label for="formParam-name">姓名</label> <input type="text" id="formParam-name" name="name" value="张三"/>
            <label for="formParam-age">年龄</label> <input type="text" id="formParam-age" name="age" value="20"/>
            <input type="submit" value="添加"/>
        </form>
    </li>
    <li>
        表单对象：
        <form method="post" action="/body/formModel">
            <label for="formModel-name">姓名</label> <input type="text" id="formModel-name" name="name" value="李四"/>
            <label for="formModel-age">年龄</label> <input type="text" id="formModel-age" name="age" value="21"/>
            <input type="submit" value="添加"/>
        </form>
    </li>
    <li>
        JSON对象：<br/>
        <label for="user-name">姓名</label> <input type="text" id="user-name" name="name" value="王五"/>
        <label for="user-age">年龄</label> <input type="text" id="user-age" name="age" value="22"/>
        <input id="user-btn" type="button" value="添加"/>
    </li>
    <li>
        上传文件：
        <form method="post" action="/body/uploadFile" enctype="multipart/form-data">
            <label for="uploadFile-file">选择文件</label> <input type="file" id="uploadFile-file" name="file"/>
            <input type="submit" value="上传文件"/>
        </form>
    </li>
</ul>
<h3>HTTP头部</h3>
<ul>
    <li>
        <label for="headerParam">headerParam</label> <input type="text" id="headerParam" value="上善若水"/>
        <input id="heard-btn" type="button" value="提交头部参数"/>
    </li>
</ul>

<div id="overlay"></div>
<div id="customAlert" class="modal">
    <div id="customAlertContent">
        <p id="alertMessage"></p>
        <button id="closeButton">Close</button>
    </div>
</div>

</body>
<script src="/jquery-2.1.4.js"></script>
<script>
    $(function (){
        $("#user-btn").click(addUser);
        $("#heard-btn").click(addHeader);

        $("#closeButton").click(function(){
            // 隐藏遮罩层和弹窗
            $("#overlay").hide();
            $("#customAlert").hide();
        });
    });

    function addUser() {
        $.ajax({
            url: "/body/user",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                name: $("#user-name").val(),
                age: $("#user-age").val()
            }),
            success: function (result) {
                console.log(result);
                customAlert(result);
            },
            error: function(xhr, status, error) {
                // 当请求失败时执行的操作
                console.error('请求失败！错误信息：', error);
            }
        });
    }

    function addHeader() {
        $.ajax({
            url: "/header",
            type: 'GET',
            headers: {
                'headerParam': encodeURIComponent($('#headerParam').val())
            },
            success: function (result) {
                console.log(result);
                customAlert(result);
            },
            error: function(xhr, status, error) {
                // 当请求失败时执行的操作
                console.error('请求失败！错误信息：', error);
            }
        });
    }

    function customAlert(message) {
        // 设置弹窗中的文本内容
        $("#alertMessage").html(message);
        // 显示遮罩层和弹窗
        $("#overlay").show();
        $("#customAlert").show();
    }
</script>
</html>