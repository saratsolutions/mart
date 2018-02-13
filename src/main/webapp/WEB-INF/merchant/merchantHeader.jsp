<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Bag</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<script>
	function openSubmenu(divClass) {
		var x = document.getElementsByClassName(divClass);
		var i;
		for (i = 0; i < x.length; i++) {
			if(x[i].style.display == '' || x[i].style.display==null || x[i].style.display==undefined || x[i].style.display=='none')
		    x[i].style.display = 'block';
			else x[i].style.display = 'none';
		} 		
	}

	
</script>
	
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.modal-footer {
	margin-top: 0px;
}

.footer-bottom {
	text-align: center;
	margin: 4em 0 0;
}

.footer-bottom h2 {
	font-family: 'Montserrat', sans-serif;
	font-size: 3.5em;
	display: inline-block;
	position: relative;
}

.footer-bottom h2 a {
	text-decoration: none;
	color: #fff;
}

.footer-bottom h2 span {
	font-size: 12px;
	display: block;
	letter-spacing: 5px;
	text-transform: uppercase;
	font-family: 'Noto Sans', sans-serif;
	padding-top: 6px;
}

.footer-bottom h2 b {
	font-size: 10px;
	background: #CC2127;
	font-weight: normal;
	padding: 3px;
	display: inline-block;
	line-height: 10px;
	position: absolute;
	top: 9px;
	left: -7px;
}

/*-- //footer-top --*/
.footer {
	background: #353535;
	padding: 5em 0;
}

.footer-grid h3 {
	color: #fff;
	font-size: 1.7em;
	margin-bottom: 1em;
}

.footer-grid p {
	color: #ABABAB;
	line-height: 2.2em;
	font-size: 14px;
}

.footer-grid ul li {
	list-style-type: none;
	font-size: 14px;
	line-height: 2.2em;
	color: #ABABAB;
}

.footer-grid ul li a {
	color: #ABABAB;
}

.footer-grid ul li a:hover {
	color: #FAB005;
}

.footer-grid h3 {
	font-size: 1.5em;
}

.footer-grid {
	float: left;
	width: 50%;
	margin-bottom: 2em;
}

.footer-bottom {
	text-align: center;
	margin: 0em 0 0;
}

.footer {
	padding: 3em 0;
}

.footer-grid {
	width: 100%;
	margin-bottom: 1em;
}

.footer-bottom h2 b {
	font-size: 8px;
	padding: 2px;
	line-height: 9px;
	top: 8px;
	left: -6px;
}

.footer-bottom h2 span {
	letter-spacing: 3px;
}

.footer-bottom h2 {
	font-size: 2.5em;
}

.footer-bottom h2 span {
	letter-spacing: 2px;
	font-size: 11px;
}

.footer-bottom h2 b {
	font-size: 7px;
	padding: 2px;
	line-height: 7px;
	top: 7px;
	left: -7px;
}

.footer-grid h3 {
	font-size: 1.5em;
	margin-bottom: 0.5em;
}

p.fo-para {
	font-size: 1em;
	line-height: 2em;
	color: #fff;
	padding: 1em 0 3em;
	width: 70%;
	margin: 0 auto;
}

p.fo-para {
	padding: 1em 0 2em;
}

p.fo-para {
	width: 95%;
}

.address {
	margin-top: 2em;
}

.fo-grid1 p {
	font-size: 1em;
	line-height: 2em;
	color: #fff;
}

.fo-grid1 p a {
	text-decoration: none;
	color: #fff;
}

.fo-grid1 p a:hover {
	color: #FAB005;
}

.fo-grid1 p  i {
	margin-right: 7px;
}

.copy-right p {
	margin-top: 2em;
}

.copy-right p {
	color: #fff;
	font-size: 14px;
	text-align: center;
	margin-top: 4em;
}

.copy-right p a {
	color: #fff;
}

.copy-right p a:hover {
	color: #E21737;
}

.container {
	padding-right: 5px;
	padding-left: 5px;
}

<
style>* {
	box-sizing: border-box;
}

body {
	margin: 0;
}

/* Create four equal columns that floats next to each other */
.column {
	float: left;
	width: 25%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.btn {
  display: inline-block;
  margin-bottom: 0;
  font-weight: normal;
  text-align: center;
  vertical-align: middle;
  touch-action: manipulation;
  cursor: pointer;
  background-image: none;
  border: 1px solid transparent;
  white-space: nowrap;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  border-radius: 4px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  font-weight:bold;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.btn-default {
  color: #333;
  //background-color: #fff;
  background-color: #e6e6e6;
  border-color: #ccc;
}
.btn-default:focus,
.btn-default.focus {
  color: #333;
  background-color: #e6e6e6;
  border-color: #8c8c8c;
}
.btn-default:hover {
  color: #333;
  background-color: #e6e6e6;
  border-color: #adadad;
  
}


.headerMenu{
height:100%;
color:#ffffff;
}

.headerMenu >a:hover{
background-color:#4CAF49 !important;
color:white;
}

.left-menu .navbar-nav > .items {
	display:none;
	border-left:5px solid green;
	transition: height 5s, visibility 1s, opacity 0.5s ease-out;
}
.left-menu .navbar-nav > .shops {
	display:none;
	border-left:5px solid green;
	transition: height 5s, visibility 1s, opacity 0.5s ease-out;
}

.left-menu .navbar-nav > li {
    float: none;
    background-color: #eee;
    border-bottom:1px dotted #CECECE;
}

.left-menu .nav > li > a:hover, .nav > li > a:focus {
    background-color: #4CAF49;
    color: #fff;
}
.left-menu .navbar-nav {
    float: none;
    margin: 0;
	border-top: 1px solid #B58F62;
}

.left-menu .navbar-nav > li > a {
    color: #212121;
    padding:10px 0px 10px 40px;
    border-bottom: 1px dotted #CDCDCD;
}
.left-menu .nav .open > a, .nav .open > a:hover, .nav .open > a:focus {
    background-color: #84C639;
    border: none;
}
.col-md-7{
width:70% !important;
}

.boldcapitalize{
 text-transform: capitalize;
 font-weight:bold;
}
.darkRow{
height:4em;
background-color:lightgrey;
}

.darkRow:hover{
border:1px solid orange;
}

.lightRow{
height:4em;
background-color:whitesmoke;
}

.lightRow:hover{
border:1px solid orange;
}

</style>
</head>
<body>

<div style="background-color: #5f5f5f; height: 3em;width:100%;position:fixed;z-index:1">
<div
	style="background-color:#4CAF49; width: 25%; height: 100%; float: left; display: block">
<span
	style="color: yellow; font-size: 2em; font-weight: bold; padding-left: 1em">
<span style="color: white">O</span>ne <span style="color: white">B</span>ag</span>
</div>

<div style="height: 90%; float: left; display: block;padding-left:9em">
	<input type="text" style="margin-left:8em;height:100%;width:20em;border:1px solid red;" placeholder=" Enter Search Here..."/>
	<span class="glyphicon glyphicon-search" style="color:white;background-color:red;padding:13px;left:-5px"></span>
</div>

<div style="float: right;padding-right:1em"><a
	href="${pageContext.request.contextPath}/logout.htm" type="button"
	class="btn btn-primary">Logout</a>
</li>
</div>

</div>

<div style="background-color: #5f5f5f; height: 3em;width:100%;"></div>
<div class="container-fluid"
	style="background-color: white; height: 10em">
<div
	style="font-size: 45px; float: left; padding-left: 1em; color: green">
<img src="/mart/resources/logo2.jpg" width="360"></div>
<div style="font-size: 20px;font-family:calibri;font-weight:italic; float: left; padding-left: 2em;margin-top:60px">
 <span class="glyphicon glyphicon-earphone"></span>+91 9492250094 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <span class="glyphicon glyphicon-envelope"></span> </span>info.onebag@gmail.com
 </div>
</div>

<nav class="navbar">
<div class="container" style="background-color: #5f5f5f; width: 100%">
<div class="navbar-header">
<h3 style="color: white; padding-left: 3em">Welcome <span style="font-weight:bold;text-transform: capitalize;"><c:out value="${sessionScope.LoggedInUser.merchantName}" /></span></h3>
</div> 
<!--<ul class="nav navbar-nav" style="float: right">-->
<!--	<li class="headerMenu"><a href="addShops.htm" type="button" >Add Shops</a></li>-->
<!--	<li class="headerMenu"><a href="viewShops.htm" type="button">View Shops</a></li>-->
<!--	<li class="headerMenu"><a href="addItems.htm" type="button" >Add Items</a></li>-->
<!--	<li class="headerMenu"><a href="viewItems.htm" type="button">View Items</a></li>-->
<!--</ul>-->
</div>
</nav>

<div class="row">
<div class="col-md-3 left-menu" style="padding-left:0px">
<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="home.htm">Home</a></li>
						<li>
							<a class="" style="cursor:pointer" onclick="openSubmenu('shops');">Orders<span class="caret"></span></a>				
							<li class="shops"><a href="newOrders.htm">&nbsp;&nbsp;Pending Orders</a></li>
							<li class="shops"><a href="dispatchedOrders.htm">&nbsp;&nbsp;Dispatched Orders</a></li>
							<li class="shops"><a href="cancelOrders.htm">&nbsp;&nbsp;Canceled Orders</a></li>
							<li class="shops"><a href="rejectedOrders.htm">&nbsp;&nbsp;Rejected Orders</a></li>
							<li class="shops"><a href="orderHistory.htm">&nbsp;&nbsp;All Orders History</a></li>
						</li>
						
						<li>
							<a class="" style="cursor:pointer" onclick="openSubmenu('items');">Items<span class="caret"></span></a>				
							<li class="items"><a href="viewItems.htm">&nbsp;&nbsp;View Items</a></li>
							<li class="items"><a href="addItems.htm">&nbsp;&nbsp;Add New Items</a></li>
						</li>
						<li><a href="reviews.htm">Ratings & Reviews</a></li>
						<li><a href="viewCustomers.htm">View Customers</a></li>
						<li><a href="${pageContext.request.contextPath}/logout.htm">Logout</a></li>
					</ul>
				 </div>
</div>