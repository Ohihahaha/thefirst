<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>input添加小图标</title>
<style>
.div-bor{
position: relative;width: 200px;
}
.icon-user{
position: absolute;left: 0；z-index:5;
background-image: url('img/user_icon.png'); /*引入图片图片*/
background-repeat: no-repeat; /*设置图片不重复*/
background-position: 0px 0px; /*图片显示的位置*/
width: 20px; /*设置图片显示的宽*/
height: 20px; /*图片显示的高*/

}
.user{
padding-left: 22px;
}
</style>
</head>
<body>
<div class="div-bor">
<i class="icon-user"></i>
<input type="text" class="user" />
</div>
</body>
</html>