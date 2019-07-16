<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h3 class="font-weight-bolder font-italic text-center">Purchase
					Order Registration</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->

				<form:form action="save" method="post"
					modelAttribute="purchaseOrder">
					<!-- ROW 1: ITEM CODE starts here -->
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

					<!-- ROW 2: SHIPMENT INTEGRATION starts here -->
					<div class="row">
						<div class="col-4">
							<label for="shipmentType.id"
								class="label-control font-weight-bolder font-italic">Shipment Code</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentType.id"
								cssClass="form-control font-weight-bolder font-italic">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${shipments}" itemLabel="shipmentCode"
									itemValue="id" />
							</form:select>
						</div>
					</div>
					<br />
					<!-- ROW 3: VENDOR  INTEGRATION starts here -->
					<div class="row">
						<div class="col-4">
							<label for="whVendor.id"
								class="label-control font-weight-bolder font-italic">Vendor</label>
						</div>
						<div class="col-6">
							<form:select path="whVendor.id"
								cssClass="form-control font-weight-bolder font-italic">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${vendors}" itemLabel="userEmail"
									itemValue="id" />
							</form:select>
						</div>
					</div>
					<br />

					<!-- ROW 4: REFERENCE NUMBER starts here -->
					<div class="row">
						<div class="col-4">
							<label for="referenceNumber"
								class="control-label font-weight-bolder font-italic">Reference
								Number</label>
						</div>
						<div class="col-6">
							<form:input path="referenceNumber"
								cssClass="form-control font-weight-bolder font-italic" />
						</div>
					</div>
					<br />

					<!-- ROW 5: QUALITY CHECK starts here -->
					<div class="row">
						<div class="col-4">
							<label for="qualityCheck"
								class="label-control font-weight-bolder font-italic">Shipment
								Grade</label>
						</div>
						<div class="col-6 font-weight-bold font-italic">
							<form:radiobutton path="qualityCheck" cssClass="radio-inline"
								value="REQUIRED" />
							REQUIRED&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="qualityCheck" cssClass="radio-inline"
								value="NOT REQUIRED" />
							NOT REQUIRED
						</div>
					</div>
					<br />


					<!-- ROW 6: MODULE ORDERMETHOD Integration starts here -->
					<div class="row">
						<div class="col-4">
							<label for="status"
								class="control-label font-weight-bolder font-italic">Status</label>
						</div>
						<div class="col-6">
							<form:input path="status" readonly="true"
								cssClass="form-control font-weight-bolder font-italic" />
						</div>
					</div>
					<br />


					<!-- ROW 7: Description starts here -->
					<div class="row">
						<div class="col-4">
							<label for="description"
								class="control-label font-weight-bolder font-italic">Description</label>
						</div>
						<div class="col-6">
							<form:textarea path="description"
								cssClass="form-control font-weight-bolder font-italic"
								itemValue="id" />
						</div>
					</div>
					<br />



					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span>Place Order!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
					<!-- FORM ENDS HERE -->
				</form:form>
			</div>



			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				<c:if test="${not empty message}">Registration Result: ${message } <br />
				</c:if>
				<a href="viewall">Show All Purchase Orders</a>
			</div>

		</div>

	</div>

</BODY>
</HTML>