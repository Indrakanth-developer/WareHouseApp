<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>@@sOlO vIEw@@</title>

<!-- CSS LINK -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Font Awesome Icon Library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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
</head>
<BODY>
	<!-- Container Starts here -->
	<div class="container">
		<div class="card">
			<!-- Card header Starts here -->
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">ShipmentType
					Detailed View</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">
				<table
					class="table table-striped table-hover table-bordered text-center font-italic font-weight-bolder">
					<thead class="thead-dark">
						<th>FIELD</th>
						<th>INFO</th>
					</thead>
					<tbody class="tbody-striped">
						<tr>
							<th>UoM ID:</th>
							<td>${obj.id }</td>
						</tr>

						<tr>
							<th>UoM Type</th>
							<td>${obj.uomType }</td>
						</tr>

						<tr>
							<th>UoM Model:</th>
							<td>${obj.uomModel}</td>
						</tr>

						<tr>
							<th>UoM Description:</th>
							<td>${obj.uomDescription}</td>
						</tr>

					</tbody>

				</table>
			</div>



			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				<a class="btn btn-danger" href="delete?id=${obj.id}" role="button"><i
					class="fa fa-trash"></i> Trash</a> <a class="btn btn-warning"
					href="edit?id=${obj.id}" role="button"> <i class="fa fa-edit"></i>
					Edit Me!!
				</a> <a class="btn btn-primary" href="excel?id=${obj.id}" role="button">
					<i class="fa fa-edit"></i> Excel Export
				</a> <a class="btn btn-primary" href="pdf?id=${obj.id}" role="button">
					<i class="fa fa-edit"></i> PDF Export
				</a>

			</div>

		</div>

	</div>


</BODY>
</html>