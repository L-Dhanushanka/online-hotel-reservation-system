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
		
		background:rgba(0,0,0,0.7) url("file:///C:/New%20folder/paymentmanagement/WebContent/img/gg3.jpg")no-repeat;
		background-size:cover;
		background-blend-mode:darken;
}

 div.card{
 background-color:#49CBF4;
 display:flex;
 flex-derection:column;
 align-items:center;
 background:rgba(0,0,0,0.6);
 box-shadow:0 0 10px rgba(0, 0, 0, 1)
 }
 h2{
 	 font-weight: bold;
	 font-style: italic;
	 font-size: 38px;
	 color:white;
 }

label{
	 color:white;
}

	</style>

</head>
<body style="background-color:#49CBF4;">


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: DeepSkyBlue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Payment Management Form </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">payment</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${payment != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${payment == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${payment != null}">
						Edit Pay	
            		</c:if>
						<c:if test="${payment == null}">
            			Add New Pay
            		</c:if>
					</h2>
				</caption>

				<c:if test="${payment != null}">
					<input type="hidden" name="id" value="<c:out value='${payment.id}' />" />
				</c:if>
				
				
				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${payment.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Tel_No</label> <input type="text"
						value="<c:out value='${payment.Tel_No}' />" class="form-control"
						name="Tel_No" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Payment_Method</label> <input type="text"
						value="<c:out value='${payment.Payment_Method}' />" class="form-control"
						name="Payment_Method" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Package</label> <input type="text"
						value="<c:out value='${payment.Package}' />" class="form-control" 
						name="Package" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Date</label> <input type="text"
						value="<c:out value='${payment.date}' />" class="form-control"
						name="date">
				</fieldset>

				<fieldset class="form-group">
					<label>Paid_amount</label> <input type="text"
						value="<c:out value='${payment.paid_amount}' />" class="form-control"
						name="paid_amount">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

