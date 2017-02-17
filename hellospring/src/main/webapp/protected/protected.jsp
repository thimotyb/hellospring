<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hello <%= request.getUserPrincipal().getName().toString() %>
You are able to view this page because you are authenticated user.

<sf:form method="POST" commandName="message">
	<sf:errors path="*" element="div" cssClass="errors" />
	First Name: <sf:input path="firstName" /><br/><sf:errors path="firstName" cssClass="error" /><br/>
	Last Name: <sf:input path="lastName" /><br/>
	Email: <sf:input path="email" /><br/>
	Username: <sf:input path="username" /><br/>
	Password: <sf:password path="password" /><br/>
	<input type="submit" value="Register" />
</sf:form>


</body>
</html>