<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="indra" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>@@dAtA pAgE@@</title>
<!-- CSS LINK -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Font Awesome Icon Library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- STYLING SETUP -->
<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	border-radius: 2px;
}

.button2 {
	border-radius: 4px;
}

.button3 {
	border-radius: 8px;
}

.button4 {
	border-radius: 12px;
}

.button5 {
	border-radius: 50%;
}
</style>

</head>
<body>

	<div class="container">

		<div class="card">
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">Aggregrate
					WhUsers</h3>
			</div>

			<div class="row">
				<a>    </a><a class="btn btn-primary"
					href="http://localhost:2024/WareHouseApp/whuser/reg" role="button">
					<i class="fa fa-view"></i> Go Back To Register Page
				</a> <a class="btn btn-primary" href="excel" role="button"> <i
					class="fa fa-view"></i> Excel Export
				</a> <a class="btn btn-primary" href="pdf" role="button"> <i
					class="fa fa-view"></i> PDF Export
				</a> <a class="btn btn-primary" href="charts" role="button"> <i
					class="fa fa-view"></i> Charts
				</a>
			</div>
			<div class="row"><br/></div>
			<br/>
			<!-- Card Body Starts here -->

			<div class="card-body bg bg-light">

				<table
					class="table table-bordered font-weight-bolder font-italic text-center table-hover">
					<tr class="bg bg-dark text-white">
						<th>ID</th>
						<th>User Type</th>
						<th>User Code</th>
						<th>User For</th>
						<!-- <th>User Email</th> -->
						<!-- <th>User Contact</th> -->
						<th>User ID Type</th>
						<th>ID Number</th>
						<th colspan=3>Available Actions</th>
					</tr>

					<indra:forEach items="${list}" var="obj">
						<tr>
							<td><indra:out value="${obj.id }"></indra:out></td>
							<td><indra:out value="${obj.userType }"></indra:out></td>
							<td><indra:out value="${obj.userCode }"></indra:out></td>
							<td><indra:out value="${obj.userFor }"></indra:out></td>
							<%-- <td><indra:out value="${obj.userEmail}"></indra:out></td> --%>
							<%-- <td><indra:out value="${obj.userContact}"></indra:out></td> --%>
							<td><indra:out value="${obj.userIdType}"></indra:out></td>
							<td><indra:out value="${obj.idNumber}"></indra:out></td>

							<td><a class="btn btn-danger" href="delete?id=${obj.id}"
								role="button"><i class="fa fa-trash"></i> Trash</a> <a
								class="btn btn-warning" href="edit?id=${obj.id}" role="button">
									<i class="fa fa-edit"></i> Edit Me!!
							</a> <a class="btn btn-primary" href="view?id=${obj.id}"
								role="button"> <i class="fa fa-view"></i> View Me!!
							</a></td>
						</tr>
					</indra:forEach>

				</table>
			</div>

			<!-- Card Footer Starts here -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				<h3>Notification: ${message}</h3>
			</div>



		</div>



	</div>



</body>
</html>