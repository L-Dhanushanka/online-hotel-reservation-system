<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Management Form</title>
<img src  = "file:///C:/New%20folder/paymentmanagement/WebContent/img/logo-removebg-preview.png"width="200" height="200" style="display: block; margin-left: auto; margin-right: auto;">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
	
body{
		
		background:rgba(0,0,0,0.7) url("file:///C:/New%20folder/paymentmanagement/WebContent/img/blur.jpg");
		background-blend-mode:darken;
		height: 100%; 
		background-position: center;
}
  h3{
 		 font-weight: bold;
	 font-style: italic;
	 font-size: 38px;
	 color:SaddleBrown;
 }
 
 th{
 	 color:white;
 	 font-weight: bold;
 	  font-size: 20px;
 }
 
  td{
 	 color:white;
 	  font-size: 20px;
 }
	</style>
</head>
<body>
<header>
<
	<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: BurlyWood">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand">Payment Management Form </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">payments</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of payments</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Payment Forms</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Telephone number</th>
						<th>Payment Method</th>
						<th>Package</th>
						<th>Date</th>
						<th>paid Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="Payment" items="${listPay}">

						<tr>
							<td><c:out value="${payment.id}" /></td>
							<td><c:out value="${payment.name}" /></td>
							<td><c:out value="${payment.Tel_No}" /></td>
							<td><c:out value="${payment.Payment_Method}" /></td>
							<td><c:out value="${payment.Package}" /></td>
							<td><c:out value="${payment.date}" /></td>
							<td><c:out value="${payment.paid_amount}" /></td>
						<td><a href="edit?id=<c:out value='${payment.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${payment.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>