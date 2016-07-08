<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<form action="AddUser" method="post">
    <input type="hidden" name="action" value="addUser">
	
	 <input type="text" name="userName" id="userName" value=""/>
	 <input type="text" name="userEmail" id="userEmail" value=""/>
	 <input type="text" name="userMotto" id="userMotto" value=""/>
	 <input type="password" name="userPassword" id="userPassword" value=""/>
	 <input type="submit" value="Enter"/>
</form>
</body>
</html>