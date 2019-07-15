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
				<h3 class="font-weight-bolder font-italic text-center">Item
					Registration</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->

				<form:form action="save" method="post" modelAttribute="item">
					<!-- ROW 1: ITEM CODE starts here -->
					<div class="row">
						<div class="col-4">
							<label for="itemCode"
								class="label-control font-weight-bolder font-italic">Item
								Code</label>
						</div>
						<div class="col-6">
							<form:input path="itemCode"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />

					<!-- ROW 2: ITEM DIMENSIONS starts here -->
					<div class="row">
						<div class="col-4">
							<label for="itemWidth"
								class="label-control font-weight-bolder font-italic">Item
								Dimensions</label>
						</div>
						<div class="col-2">
							[W]
							<form:input path="itemWidth"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
						<div class="col-2">
							[L]
							<form:input path="itemLength"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
						<div class="col-2">
							[H]
							<form:input path="itemHeight"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />
					<!-- ROW 3: BASE COST starts here -->
					<div class="row">
						<div class="col-4">
							<label for="baseCost"
								class="label-control font-weight-bolder font-italic">Base
								Cost</label>
						</div>
						<div class="col-6">
							<form:input path="baseCost"
								cssClass="form-control font-weight-bold font-italic"></form:input>
						</div>
					</div>
					<br />

					<!-- ROW 4: BASE CURRENCY starts here -->
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency"
								class="control-label font-weight-bolder font-italic">Base
								Currency</label>
						</div>
						<div class="col-6">
							<form:select path="baseCurrency"
								cssClass="form-control font-weight-bolder font-italic">
								<form:option value="">--SELECT--</form:option>
								<form:option value="INDIAN RUPEE">INR</form:option>
								<form:option value="U.S. DOLLARS">USD</form:option>
								<form:option value="AUSTRALLIAN DOLLARS">AUS</form:option>
								<form:option value="EURO">EUR</form:option>
							</form:select>
						</div>
					</div>
					<br />
					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Create My
							Item!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
					<!-- FORM ENDS HERE -->
				</form:form>
			</div>



			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Registration Result: ${message } <br /> <a href="viewall">Show
					All Items</a>
			</div>


		</div>

	</div>


</BODY>
</HTML>