<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>@@cReAtE oRDeR mEThOd@@</title>
</head>
<body>

	<!-- Container Starts here -->
	<div class="container">
		<div class="card">
			<!-- Card header Starts here -->
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">Welcome
					To OrderMethod Register Page</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<form:form action="save" method="post" modelAttribute="orderMethod">
					<!-- ROW 4: SHIPMENT GRADE STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="orderMode"
								class="label-control font-weight-bolder font-italic">Order
								Mode</label>
						</div>
						<div class="col-6 font-weight-bold font-italic">
							<form:radiobutton path="orderMode" cssClass="radio-inline"
								value="Sale" />
							Sale&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="orderMode" cssClass="radio-inline"
								value="Purchase" />
							Purchase&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>


					<!-- ROW 2: ORDER CODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode"
								class="label-control font-weight-bolder font-italic">Order
								Code</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />


					<!-- ROW 3: ORDER EXECUTION TYPE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="executionType"
								class="label-control font-weight-bolder font-italic">Execution
								Type</label>
						</div>
						<div class="col-6">
							<form:select path="executionType" cssClass="form-control font-weight-bolder font-italic">>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO (First Created First Out)</form:option>
								<form:option value="FEFO">FEFO (First Executed First Out)</form:option>
							</form:select>
						</div>
					</div>
					<br />

					<!-- ROW 4: ORDER ACCEPT starts here -->
					<div class="row">
						<div class="col-4">
							<label for="orderAccept"
								class="label-control font-weight-bolder font-italic">Order
								Accept</label>
						</div>
						<div class="col-6">
							<form:checkbox path="orderAccept" value="MULTI MODEL" />
							Multi Model
							<form:checkbox path="orderAccept" value="ACCEPT RETURN" />
							Accept Return
							<form:checkbox path="orderAccept" value="SERVICE EXTEND" />
							Service Extend

						</div>
					</div>
					<br />

					<!-- ROW 4: ORDER ACCEPT starts here -->
					<div class="row">
						<div class="col-4">
							<label for="description"
								class="label-control font-weight-bolder font-italic">Description</label>
						</div>
						<div class="col-6">
							<form:textarea path="description" />
						</div>
					</div>
					<br />
	<div class="row">
		<button class="btn btn-primary">
			<span class="spinner-grow spinner-grow-sm"></span> Create My
			Order Method!! <span class="spinner-grow spinner-grow-sm"></span>
		</button>
	</div>

	</form:form>

					<!-- DIV BODY ENDS HERE -->
			</div>
							<!-- CARD FOOTER STARTS HERE -->
					<div class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
							Registration Result:	${message }
					<br/>
					<a href="viewall">Show All My Order Methods</a>
					</div>

			
			<!-- DIV CARD ENDS HERE -->
		</div>
		<!-- DIV CONTAINER ENDS HERE -->
	</div>


</body>
</html>