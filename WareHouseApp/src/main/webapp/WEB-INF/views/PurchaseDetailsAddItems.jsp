<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
							int serialNo = 0;
								Double lineTotal = 0.0;
						%>
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
				<h3 class="font-weight-bolder font-italic text-center">Purchase
					Details Cart</h3>
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



				<form:form action="add" method="POST"
					modelAttribute="purchaseDetails">

					<!-- ROW 1: ORDER CODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode"
								class="label-control font-weight-bolder font-italic">Order
								Code</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode"
								cssClass="form-control font-weight-bold font-italic"
								readonly="true" />
						</div>
					</div>
					<br />


					<!-- ROW 2: STATUS starts here -->
					<div class="row">
						<div class="col-4">
							<label for="status"
								class="label-control font-weight-bolder font-italic">Status</label>
						</div>
						<div class="col-6">
							<form:input path="status"
								cssClass="form-control font-weight-bold font-italic"
								readonly="true" />
						</div>
					</div>
					<br />
					<!-- ROW 3: STATUS starts here -->
					<div class="row">
						<div class="col-6">
							<label for="item.id"
								class="label-control font-weight-bolder font-italic">Items</label>
						</div>
						<div class="col-2">
							<label for="quantity"
								class="label-control font-weight-bolder font-italic">Quantity</label>
						</div>
						<div class="col-4">
							<label for="Operations"
								class="label-control font-weight-bolder font-italic">Operations</label>
						</div>
					</div>

					<!-- ROW 4: FIELDS AND DROP DOWN starts here -->
					<div class="row">
						<div class="col-4">
							<form:select path="item.id"
								cssClass="form-control font-weight-bold font-italic">
								<form:option value="--SELECT--"
									cssClass="form-control font-weight-bold font-italic"></form:option>
								<form:options items="${items}" itemLabel="itemCode"
									itemValue="id"
									cssClass="form-control font-weight-bold font-italic" />
							</form:select>
						</div>
						<div class="col-4">
							<form:input path="quantity"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
						<div class="col-4">
							<button class="btn btn-primary">
								<span class="spinner-grow spinner-grow-sm"></span>Add!!<span
									class="spinner-grow spinner-grow-sm"></span>
							</button>
						</div>
					</div>
					<br />
					<br />

					<!-- Table Data starts here -->

					<table
						class="table table-bordered font-weight-bolder font-italic text-center table-hover">
						<tr class="bg bg-dark text-white">
							<th>S. No</th>
							<th>Item</th>
							<th>Base Cost</th>
							<th>Quantity</th>
							<th>Line Total</th>
							<th>Remove</th>
						</tr>
						
						<c:forEach items="${list}" var="obj">
							<tr>
							<c:set var="serialNo" value="${serialNo + 1}" scope="page" />
								<td><c:out value="${serialNo}"></c:out></td>
								<td><c:out value="${obj.item.itemCode }"></c:out></td>
								<td><c:out value="${obj.item.baseCost}"></c:out></td>
								<td><c:out value="${obj.quantity}"></c:out></td>
								<td><c:out value="${(obj.item.baseCost) * (obj.quantity)}"></c:out></td>
								<td><a class="btn btn-danger"
									href="deleteitem?id=${obj.id}" role="button"><i
										class="fa fa-trash"></i> Trash</a></td>
							</tr>
							
						</c:forEach>

					</table>

				</form:form>



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