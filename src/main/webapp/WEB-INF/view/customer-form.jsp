<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Save user</title>
	<link rel="stylesheet" href="/resources/css/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<img src="https://seeklogo.com/images/M/minsk-logo-9E6258EEF8-seeklogo.com.gif" width="70" height="70">
	<h1>Minsk tour</h1>
</div>
	
	<div id="wrapper">
		<div id="header">
			<h2>Users</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save User</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
						<form:errors path="firstName" cssClass="error" />
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Role:</label></td>
						<td>
							<form:select path="role">
								<form:option value="NONE" label="--- Select ---"/>
								<form:options items="${rolesOptions}" itemValue="id" itemLabel="role"/>
							</form:select>
						</td>
						<%--<td><form:select path="role" items="${rolesOptions}" itemValue="id" itemLabel="role" /></td>--%>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










