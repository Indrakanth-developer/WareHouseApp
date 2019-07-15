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
				<h3 class="font-weight-bolder font-italic text-center">Shipment
					Logistics Updation</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<%-- HTML way <form action="save" method="post"> --%>
				<form:form action="update" method="post"
					modelAttribute="shipmentType">

					<!-- ROW 0: PRIMARY KEY ID ROW STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="id"
								class="control-label font-weight-bolder font-italic">ShipmentType
								ID:</label>
						</div>
						<div class="col-6">
							<form:input path="id"
								cssClass="form-control font-weight-bolder font-italic"
								readonly="true" />
						</div>

					</div>
					<br />


					<!-- ROW 1: SHIPMENT MODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode"
								class="control-label font-weight-bolder font-italic">Shipment
								Mode:</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentMode"
								cssClass="form-control font-weight-bolder font-italic">
								<form:option value="">--SELECT--</form:option>
								<form:option value="Air">Air</form:option>
								<form:option value="Truck">Truck</form:option>
								<form:option value="Ship">Ship</form:option>
								<form:option value="Train">Train</form:option>
							</form:select>
						</div>

					</div>
					<br />


					<!-- ROW 2: SHIPMENT CODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentCode"
								class="label-control font-weight-bolder font-italic">Shipment
								Code</label>
						</div>
						<div class="col-6">
							<form:input path="shipmentCode"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />



					<!-- ROW 3: ENABLE SHIPMENT starts here -->
					<div class="row">
						<div class="col-4">
							<label for="enableShipment"
								class="control-label font-weight-bolder font-italic">Enable
								Shipment:</label>
						</div>
						<div class="col-6">
							<form:select path="enableShipment"
								cssClass="form-control font-weight-bolder font-italic">
								<form:option value="">--SELECT--</form:option>
								<form:option value="YES">YEAH</form:option>
								<form:option value="NO">NOPE</form:option>
							</form:select>
						</div>
					</div>
					<br />
					<br />


					<!-- ROW 4: SHIPMENT GRADE STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentGrade"
								class="label-control font-weight-bolder font-italic">Shipment
								Grade</label>
						</div>
						<div class="col-6 font-weight-bold font-italic">
							<form:radiobutton path="shipmentGrade" cssClass="radio-inline"
								value="A" />
							A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="shipmentGrade" cssClass="radio-inline"
								value="B" />
							B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="shipmentGrade" cssClass="radio-inline"
								value="C" />
							C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>


					<!-- ROW 5: DESCRIPTION STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="description"
								class="label-control font-weight-bolder font-italic">Description</label>
						</div>
						<div class="col-6">
							<textarea name="description" id="description"
								class="form-control font-weight-bold font-italic" rows="6"
								col="50"></textarea>
						</div>
					</div>
					<br />
					<br />


					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Update My
							Shipment!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
					<!-- FORM ENDS HERE -->
				</form:form>
			</div>



			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Updation Result: ${message } <br /> <a href="viewall">Show All
					Shipments</a>
			</div>



		</div>



	</div>







</BODY>
</HTML>