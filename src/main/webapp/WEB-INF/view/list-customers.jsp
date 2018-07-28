<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Minsk tour</title>
	<link rel="stylesheet" href="/resources/css/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<img src="https://seeklogo.com/images/M/minsk-logo-9E6258EEF8-seeklogo.com.gif" width="70" height="70">
	<h1>Minsk tour</h1>
</div>
<button class="w3-button w3-cyan w3-hover-light-blue w3-round-large" onclick="location.href='/main/news'">Back to List</button>
<button class="w3-button w3-green w3-hover-light-green w3-round-large" onclick="location.href='/main/customer/showFormForAdd'"/>Add User</button>

	<div id="wrapper">
		<div id="header">
			<h2>Users</h2>
		</div>
	</div>
<!-- put new button: Add Customer -->


	<div id="container">

		<div id="content">

			<%--<!-- put new button: Add Customer -->

			<input class="w3-button w3-green w3-hover-light-green w3-round-large" style="width:120%" type="button" value="Add Customer" onclick="window.location.href='/main/customer/showFormForAdd'; return false;"
				class="add-button" />--%>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/main/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/main/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.role.getRole()}</td>

						<td>
							<!-- display the update link --> 
							<a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

		<div style="clear; both;"></div>

	</div>


</body>

</html>









