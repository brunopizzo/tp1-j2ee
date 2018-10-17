<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manipulation des comptes bancaires</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#">home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="createParcel.html">create parcel</a>
			</li>
		</ul>
	</div>
</nav>
<div class="container">
<h1>TP Parcel</h1>

	<br/>
	<h3>All parcels</h3>
	<table class="table">
		<thead class="thead-dark">
		<tr>

			<th>id</th>
			<th>weight</th>
			<th>source</th>
			<th>destination</th>
			<th></th>
		</tr>
		</thead>
		<c:forEach items="${parcels}" var="parcel">
		<tr>
			<td>${parcel.id}</td>
			<td>${parcel.weight}</td>
			<td>${parcel.source}</td>
			<td>${parcel.destination}</td>
			<td>
				<form action="getParcel" method="get">
					<input name="id" type="hidden" value="${parcel.id}">
					<button class="btn btn-primary">info</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>

</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>