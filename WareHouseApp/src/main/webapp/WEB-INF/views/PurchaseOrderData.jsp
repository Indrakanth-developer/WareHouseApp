<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					Purchase Orders</h3>
			</div>

			<div class="row">
				<a class="btn btn-primary"
					href="http://localhost:2024/WareHouseApp/purchase/reg"
					role="button"> <i class="fa fa-view"></i> Go Back To Register
					Page
				</a>
			</div>
			<!-- Card Body Starts here -->

			<div class="card-body bg bg-light">

				<table
					class="table table-bordered font-weight-bolder font-italic text-center table-hover">
					<tr class="bg bg-dark text-white">
						<th>ID</th>
						<th>Order Code</th>
						<th>Shipment Code</th>
						<th>Status</th>
						<th>Ref Num</th>
						<th>QC</th>
						<th>Vendor</th>
						<th colspan="5">Operations</th>
					</tr>

					<c:forEach items="${list}" var="obj">
						<tr>
							<td><c:out value="${obj.id }"></c:out></td>
							<td><c:out value="${obj.orderCode }"></c:out></td>
							<td><c:out value="${obj.shipmentType.shipmentCode}"></c:out></td>
							<td><c:out value="${obj.status }"></c:out></td>
							<td><c:out value="${obj.referenceNumber}"></c:out></td>
							<td><c:out value="${obj.qualityCheck}"></c:out></td>
							<td><c:out value="${obj.whVendor.userEmail}"></c:out></td>
							<td><a class="btn btn-warning" href="item?id=${obj.id}"
								role="button"> Add Items!! </a> <a class="btn btn-primary"
								href="view?id=${obj.id}" role="button"> <i
									class="fa fa-view"></i> View Me!!
							</a> <a class="btn btn-primary" href="edit?id=${obj.id}"
								role="button"> <i class="fa fa-view"></i> Edit Me!!
							</a><a class="btn btn-danger" href="delete?id=${obj.id}"
								role="button"><i class="fa fa-trash"></i> Trash</a></td>
						</tr>
					</c:forEach>

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