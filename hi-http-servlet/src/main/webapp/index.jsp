<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hi Http</title>
</head>
<body>
<h1>Hi Http</h1>
<br/>
<h3>URL参数</h3>
<ul>
    <li><a href="/url/parameter?param1=盘古开天&param2=女娲造人">查询参数 : /url/parameter?param1=盘古开天&amp;param2=女娲造人</a></li>
    <li><a href="/url/array?param1=盘古开天&param1=女娲造人">查询参数-数组-1 : /url/array?param1=盘古开天&amp;param1=女娲造人</a></li>
    <li><a href="/url/array?param1=盘古开天,女娲造人">查询参数-数组-2 : /url/array?param1=盘古开天,女娲造人</a></li>
    <li><a href="/url/path/盘古开天/女娲造人">URL Path Parameter : /url/path/盘古开天/女娲造人</a></li>
</ul>
</body>
</html>