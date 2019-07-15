<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<HTML>
	<HEAD>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<title>@@UoM Registration@@</title>
		</HEAD>



		<BODY>
				<!-- Container Starts here -->
			<div class="container">
				<div class="card">
				<!-- Card header Starts here -->
					<div class="card-header bg bg-dark text-white">
						<h3 class="font-weight-bolder font-italic text-center">UoM Logistics</h3>
					</div>
					
					
					
					<!-- Card Body starts here -->
					<div class="card-body bg bg-light">
					
					
					<!-- Form head starts here -->
					
						<form:form action="save" method="post" modelAttribute="uoM">




						<!-- ROW 1: UOM MODE starts here -->
						<div class="row">
							<div class="col-4">
						<label for="uomType" class="control-label font-weight-bolder font-italic">UoM Type:</label>
							</div>
							<div class="col-6">
								<form:select path="uomType" cssClass="form-control font-weight-bolder font-italic">
									<form:option value="">--SELECT--</form:option>
									<form:option value="Packing">Packing</form:option>
									<form:option value="No Packing">No Packing</form:option>									
									<form:option value="NA">N/A</form:option>
								</form:select>
							</div>							
						</div>
						<br/>


						<!-- ROW 2: UOM MODEL starts here -->
						<div class="row">
							<div class="col-4">
						<label for="uomModel" class="label-control font-weight-bolder font-italic">UoM Model</label>
							</div>
							<div class="col-6">
								<form:input path="uomModel" cssClass="form-control font-weight-bold font-italic"></form:input>								
							</div>
						</div>
						<br/>



					

							<!-- ROW 3: DESCRIPTION STARTS HERE -->
						<div class="row">
							<div class="col-4">
					<label for="uomDescription" class="label-control font-weight-bolder font-italic">Description</label>
							</div>
							<div class="col-6">
								<textarea name="uomDescription" id="description" class="form-control font-weight-bold font-italic" rows="6" col="50"></textarea>
							</div>
						</div>
						<br/><br/>
						
						
						<div class="row">
						<button class="btn btn-primary">
						<span class="spinner-grow spinner-grow-sm"></span>
						Create My UoM!!
						<span class="spinner-grow spinner-grow-sm"></span>
						</button>
						</div>
						<!-- FORM ENDS HERE -->
						</form:form>
					</div>
					
					
					
					<!-- CARD FOOTER STARTS HERE -->
					<div class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
								Register Result: ${message}
								<br/>
					<a href="viewall">Show All UoMs</a>
					
					</div>



				</div>



			</div>







		</BODY>
	</HTML>