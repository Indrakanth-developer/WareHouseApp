<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>@@sOlO vIEw@@</title>

<!-- CSS LINK -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<BODY>
	<!-- Container Starts here -->
	<div class="container">
		<div class="card">
			<!-- Card header Starts here -->
			<div class="card-header bg bg-dark text-white">
				<h3 class="font-weight-bolder font-italic text-center">Document
					Upload Page</h3>
			</div>


			<!-- Card Body starts here -->
			<div class="card-body bg bg-light">


				<!-- Form head starts here -->
				<form action="upload" method="post" enctype="multipart/form-data">


					<!-- ROW 1: FILE NAME starts here -->
					<div class="row">
						<div class="col-4">
							<label for="fileData"
								class="control-label font-weight-bolder font-italic">File
								Document:</label>
						</div>
						<div class="col-6">
							<input type="file" name="fileData" />
						</div>
					</div>

					<div class="row">
						<button class="btn btn-primary">
							<span class="spinner-grow spinner-grow-sm"></span> Upload My
							Document!! <span class="spinner-grow spinner-grow-sm"></span>
						</button>
					</div>


				</form>
				<!-- FORM ENDS HERE -->

				<table
					class="table table-striped table-hover table-bordered text-center font-italic font-weight-bolder">
					<thead class="thead-dark">
						<th>FILE NAME</th>
						<th>OPERATIONS</th>
					</thead>
					<tbody class="tbody-striped">
						<c:forEach items="${list }" var="obj">
							<tr>
								<td><c:out value="${obj[1]}"></c:out></td>
								<td><a href="download?id=${obj[0] }">DOWNLOAD</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>

			</div>
			<!-- CARD FOOTER STARTS HERE -->
			<div
				class="card-footer bg bg-dark text-white text-center font-italic font-weight-bolder">
				Upload Status: ${message } <br /> <br />
			</div>




		</div>
		<br />
	</div>
</body>
</html>