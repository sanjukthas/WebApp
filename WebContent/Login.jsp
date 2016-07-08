<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body style="background-image: url('http://vignette2.wikia.nocookie.net/despicableme/images/3/30/Despicable-me-2-laughing-minions.jpg')">
<form action="Login" method="post">
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<input type="text" name="email" id="email" value""></input>
<input type="password" name="password" id="password" value""></input>
<input type="hidden" name="secretvalue" id="secretvalue" value="loginform"></input>
<input type="submit" name="submit" id="submit" value="Log in"></input>
</form>
 <div class="btn-group">
  <button type="button" class="btn btn-primary"><a href="AddUser.jsp">Click Here</a></button>
  
</div>

</body>
</html>