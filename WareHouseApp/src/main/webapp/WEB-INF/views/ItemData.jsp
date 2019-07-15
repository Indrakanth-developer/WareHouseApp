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
					Items</h3>
			</div>
			
			<div class="row">
			<a class="btn btn-primary"
				href="http://localhost:2024/WareHouseApp/item/reg" role="button">
				<i class="fa fa-view"></i> Go Back To Register Page
			</a>
			<a class="btn btn-primary"
				href="excel" role="button">
				<i class="fa fa-view"></i> Excel Export
			</a>
			<a class="btn btn-primary"
				href="pdf" role="button">
				<i class="fa fa-view"></i> PDF Export
			</a>
			<a class="btn btn-primary"
				href="charts" role="button">
				<i class="fa fa-view"></i> Charts
			</a>
</div>
			
			
			<div class="card-body bg bg-light">

				<table
					class="table table-bordered font-weight-bolder font-italic text-center table-hover">
					<tr class="bg bg-dark text-white">
						<th>ID</th>
						<th>Item Code</th>
						<th>Base Cost</th>
						<th>Base Currency</th>
						<th>Available Actions</th>
					</tr>

					<indra:forEach items="${list}" var="obj">
						<tr>
							<td><indra:out value="${obj.id }"></indra:out></td>
							<td><indra:out value="${obj.itemCode}"></indra:out></td>
							<td><indra:out value="${obj.baseCost }"></indra:out></td>
							<td><indra:out value="${obj.baseCurrency}"></indra:out></td>
							<td><a class="btn btn-danger" href="delete?id=${obj.id}"
								role="button"><i class="fa fa-trash"></i> Trash Me</a> <a
								class="btn btn-warning" href="edit?id=${obj.id}" role="button">
									<i class="fa fa-edit"></i> Edit Me!!
							</a> <a class="btn btn-primary" href="view?id=${obj.id}"
								role="button"> <i class="fa fa-view"></i> View Me!!
							</a></td>
						</tr>
					</indra:forEach>

				</table>
			</div>
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Updation Result: ${message} <br /> <a href="reg">Back To Item
					Registration</a>
			</div>



		</div>



	</div>






</body>
</html>