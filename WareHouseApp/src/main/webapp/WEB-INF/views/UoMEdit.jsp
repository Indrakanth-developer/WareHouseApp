<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<HTML>
<HEAD>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</HEAD>



<BODY>
	<!-- Container Starts here -->
	<div class="container">
		<div class="card">
			<!-- Card header Starts here -->
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">UoM Edit</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<%-- HTML way <form action="save" method="post"> --%>
				<form:form action="update" method="post" modelAttribute="uoM">

					<!-- ROW 0: PRIMARY KEY ID ROW STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="id"
								class="control-label font-weight-bolder font-italic">UoM:</label>
						</div>
						<div class="col-6">
							<form:input path="id"
								cssClass="form-control font-weight-bolder font-italic"
								readonly="true" />
						</div>

					</div>
					<br />
					<!-- ROW 1: UOM TYPE  starts here -->
					<div class="row">
						<div class="col-4">
							<label for="uomType"
								class="control-label font-weight-bolder font-italic">UoM
								Model:</label>
						</div>
						<div class="col-6">
							<form:input path="uomType"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />

					<!-- ROW 2: UOM MODEL starts here -->
					<div class="row">
						<div class="col-4">
							<label for="uomModel"
								class="control-label font-weight-bolder font-italic">UoM
								Model:</label>
						</div>
						<div class="col-6">
							<form:input path="uomModel"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />

					<!-- ROW 3: DESCRIPTION STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="description"
								class="label-control font-weight-bolder font-italic">Description</label>
						</div>
						<div class="col-6">
							<form:textarea path="uomDescription"
								cssClass="form-control font-weight-bold font-italic" rows="6"
								col="50" />
						</div>
					</div>
					<br />
					<br />

					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Update My
							UoM!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
				</form:form>
				<!-- FORM ENDS HERE -->
			</div>
			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Updation Result: ${message } <br /> <a href="viewall">Show All
					UoMs</a>
			</div>
		</div>
	</div>
</BODY>
</HTML>