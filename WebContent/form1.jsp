<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>中文乱码</title>
</head>
<body>
  <form action="ServletFormDemo" method="post">
  用户名：	<input type="text" name="username">
  <input type="submit" value="提交">
  
  </form>
  
  <form action="ServletFormDemo" method="get">
  用户名：	<input type="text" name="username">
  <input type="submit" value="提交">
  
  </form>
  
  <!-- 超链接提交的中文，服务器想不乱码，也只能手工处理 -->
  <a href="ServletFormDemo?username=中国">点点</a>

</body>
</html>