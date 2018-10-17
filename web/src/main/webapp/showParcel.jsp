<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Parcel info</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="home">home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="createParcel.html">create parcel</a>
			</li>
		</ul>
	</div>
</nav>
<div class="container">

<h1>Parcel info</h1>



<table class="table">
	<thead class="thead-dark">
	<tr>
	<th>id</th>
	<th>weight</th>
	<th>from</th>
	<th>destination</th>
		<th>delivered</th>
	</tr>
	</thead>
	<tr>
		<td>${parcel.id}</td>
		<td>${parcel.weight}</td>
		<td>${parcel.source}</td>
		<td>${parcel.destination}</td>
		<c:choose>
			<c:when test="${parcel.delivered == true}">
				<td class="p-3 mb-2 bg-success text-white">${parcel.delivered}</td>
			</c:when>
			<c:otherwise>
				<td>${parcel.delivered}</td>
			</c:otherwise>


		</c:choose>
	</tr>
</table>



	<c:if test = "${parcel.delivered == false}">
		<hr/>
		<h3>Add tracking</h3>
		<form action="postTrack" method="post" class="form-group">
			location: <input type="text" name="location" class="form-control">
			<input name="id" type="hidden" value="${parcel.id}">

			<select name="status" class="form-control">
				<c:forEach items="${states}" var="status">
					<option>${status}</option>
				</c:forEach>
			</select>
			<input class="btn btn-primary" type="submit" value="Change location">
		</form>

		<hr/>
		<h3>Delivering now</h3>
		<form action="delivering" method="post" class="form-group">
			<input name="id" type="hidden" value="${parcel.id}">
			<input class="btn btn-success" type="submit" value="deliver" class="form-control">
		</form>
	</c:if>

	<hr/>
<h3>Tracking story</h3>
<table class="table">
	<thead class="thead-dark">
	<tr>
		<th>date</th>
		<th>location</th>
		<th>status</th>
	</tr>
	</thead>
	<c:forEach items="${parcel.tracks}" var="track">
		<tr>
			<td>${track.date}</td>
			<td>${track.location}</td>
			<td>${track.status}</td>
		</tr>

	</c:forEach>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>