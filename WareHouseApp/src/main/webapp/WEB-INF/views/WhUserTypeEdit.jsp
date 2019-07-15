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
				<h3 class="font-weight-bolder font-italic text-center">WhUserType
					Logistics Refurbishing</h3>
			</div>



			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<form:form action="update" method="post"
					modelAttribute="whUserType">

					<!-- ROW 0: PRIMARY KEY ID ROW STARTS HERE -->
					<div class="row">
						<div class="col-4">
							<label for="id"
								class="control-label font-weight-bolder font-italic">WhUser ID:</label>
						</div>
						<div class="col-6">
							<form:input path="id"
								cssClass="form-control font-weight-bolder font-italic"
								readonly="true" />
						</div>

					</div>
					<br />


						<!-- ROW 1: USER TYPE starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userType" class="label-control font-weight-bolder font-italic">User Type</label>
							</div>
							<div class="col-6 font-weight-bold font-italic">						
								<form:radiobutton path="userType" cssClass="radio-inline" value="Vendor"/>Vendor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="userType" cssClass="radio-inline" value="Customer"/>Customer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</div>						
						
						<!-- ROW 2: USER CODE starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userCode" class="label-control font-weight-bolder font-italic">User Code</label>
							</div>
							<div class="col-6">
								<form:input path="userCode" cssClass="form-control font-weight-bold font-italic"></form:input>								
							</div>
						</div>
						<br/>
						
						
						<br/>

						
						<!-- ROW 3: USER FOR starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userFor" class="control-label font-weight-bolder font-italic">User For:</label>
							</div>
							<div class="col-6">
								<form:select path="userFor" cssClass="form-control font-weight-bolder font-italic">
									<form:option value="">--SELECT--</form:option>
									<form:option value="Purchase">Purchase</form:option>
									<form:option value="Sale">Sale</form:option>
								</form:select>
							</div>							
						</div>
						<br/>
						<br/>
						
						
						
						<!-- ROW 4: USER EMAIL starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userEmail" class="label-control font-weight-bolder font-italic">User Email</label>
							</div>
							<div class="col-6">
								<form:input path="userEmail" cssClass="form-control font-weight-bold font-italic"></form:input>								
							</div>
						</div>
						<br/>						
						
						
						<!-- ROW 5: USER CONTACT starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userContact" class="label-control font-weight-bolder font-italic">User Contact</label>
							</div>
							<div class="col-6">
								<form:input path="userContact" cssClass="form-control font-weight-bold font-italic"></form:input>								
							</div>
						</div>
						<br/>						
						
						
						<!-- ROW 6: USER ID TYPE starts here -->
						<div class="row">
							<div class="col-4">
						<label for="userIdType" class="control-label font-weight-bolder font-italic">User ID Type:</label>
							</div>
							<div class="col-6">
								<form:select path="userIdType" cssClass="form-control font-weight-bolder font-italic">
									<form:option value="">--SELECT--</form:option>
									<form:option value="Pancard">PAN Card</form:option>
									<form:option value="Aadhar">Aadhar</form:option>
									<form:option value="Aadhar">Voter ID</form:option>
									<form:option value="Other">Other</form:option>
								</form:select>
							</div>							
						</div>
						<br/>
						<br/>
												
						
						<!-- ROW 7: ID NUMBER TYPE starts here -->
						<div class="row">
							<div class="col-4">
						<label for="idNumber" class="control-label font-weight-bolder font-italic">ID Number:</label>
							</div>
							<div class="col-6">
								<form:input path="idNumber" cssClass="form-control font-weight-bold font-italic"></form:input>								
							</div>							
						</div>
						<br/>


					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Update My
							WhUserType!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>
					<!-- FORM ENDS HERE -->
				</form:form>
			</div>



			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Action Result: ${message } <br /> <a href="viewall">Show All
					WhUserTypes</a>
			</div>



		</div>



	</div>







</BODY>
</HTML>