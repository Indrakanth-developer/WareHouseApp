<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<title>@@eDiT mE@@</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</HEAD>
<style>

/* The container */
.container {
	display: block;
	position: relative;
	padding-left: 35px;
	margin-bottom: 12px;
	cursor: pointer;
	font-size: 22px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
	height: 0;
	width: 0;
}

/* Create a custom checkbox */
.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 25px;
	width: 25px;
	background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
	background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
	background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
	display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
	left: 9px;
	top: 5px;
	width: 5px;
	height: 10px;
	border: solid white;
	border-width: 0 3px 3px 0;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}
</style>


<body>

	<!-- Container Starts here -->
	<div class="container">
		<div class="card">
			<!-- Card header Starts here -->
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">OrderMethod
					Edit</h3>
			</div>

			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<form:form action="update" method="post"
					modelAttribute="orderMethod">

					<!-- ROW 0: PRIMARY KEY ID ROW STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="id"
								class="control-label font-weight-bolder font-italic">Order
								ID:</label>
						</div>
						<div class="col-6">
							<form:input path="id"
								cssClass="form-control font-weight-bolder font-italic"
								readonly="true" />
						</div>

					</div>
					<br />

					<!-- ROW 1: ORDER MODE STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentGrade"
								class="label-control font-weight-bolder font-italic">Order
								Mode</label>
						</div>
						<div class="col-6 font-weight-bold font-italic">
							<form:radiobutton path="orderMode" cssClass="radio-inline"
								value="SALE" />
							Sale&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="orderMode" cssClass="radio-inline"
								value="PURCHASE" />
							Purchase&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>


					<!-- ROW 2: ORDER CODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode"
								class="label-control font-weight-bolder font-italic">Shipment
								Code</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />


					<!-- ROW 3: EXECUTION TYPE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="executionType"
								class="control-label font-weight-bolder font-italic">Execution
								Type:</label>
						</div>
						<div class="col-6">
							<form:select path="executionType"
								cssClass="form-control font-weight-bolder font-italic">
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
								class="control-label font-weight-bolder font-italic">Order
								Accept:</label>
						</div>
						<div class="col-6">
							<!-- Material unchecked -->
							<div class="form-check">
								<form:checkbox path="orderAccept" cssClass="form-check-input"
									value="ACCEPT RETURN" />
								<label class="form-check-label" for="multiModel">Muliti
									Model</label>
							</div>
							<form:checkbox path="orderAccept"
								cssClass="form-control font-weight-bolder font-italic"
								value="ACCEPT RETURN" />
							Accept Return
							<form:checkbox path="orderAccept"
								cssClass="form-control font-weight-bolder font-italic"
								value="SERVICE EXTEND" />
							Service Extend

						</div>
					</div>

					<!-- ROW 5: DESCRIPTION starts here -->
					<div class="row">
						<div class="col-4">
							<label for="description"
								class="control-label font-weight-bolder font-italic">Description:</label>
						</div>
						<div class="col-6">
							<form:input path="description"
								cssClass="form-control font-weight-bolder 
font-italic" />
						</div>
					</div>

					<!-- Update Button -->
					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Update My
							Shipment!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
					<!-- FORM ENDS HERE -->



				</form:form>
				<!-- CARD FOOTER STARTS HERE -->
				<div
					class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
					Edit Result: ${message} <br /> <a href="viewall">Show All Order
						Methods</a>
				</div>



			</div>


		</div>
	</div>







</BODY>
</HTML>