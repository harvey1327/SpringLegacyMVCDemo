<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<style>
		.error{
			color: red;
			font-size: 15px;
		}
	</style>
	<title>Create Account</title>
</head>
<body>

<h1>Enter Account Details</h1>
<form:form commandName="newAccount" action="accountCreated" method="post" >
	<table>
		<tr><td>
			First Name: <form:input path="firstName" type="text" name="firstName"/>
			<form:errors path="firstName" cssClass="error"/>
		</td></tr>
		<tr><td>
			Last Name: <form:input path="lastName" type="text" name="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
		</td></tr>
		<tr><td>
			Age: <form:input path="age" type="text" name="age"/>
			<form:errors path="age" cssClass="error"/>
		</td></tr>
		<tr><td>
			Address: <form:input path="address" type="text" name="address"/>
			<form:errors path="address" cssClass="error"/>
		</td></tr>
		<tr><td>
			Email: <form:input path="email" type="text" name="email"/>
			<form:errors path="email" cssClass="error"/>
		</td></tr>
		<tr><td>
			<input type="submit" value="Submit"/>
		</td></tr>
	</table>
</form:form>

</body>
</html>
