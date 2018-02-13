<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="adminHeader.jsp" />

<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<center><strong>Add Shops </strong></center>
</h3>
</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 

<form:form
	class="login100-form validate-form" action="/mart/admin/addShops.htm"
	enctype="multipart/form-data" style="height:55em">
	<div>
	<span style="color: red"><form:errors path="*" /></span>
	<div class="col-md-12" style="height: 25px; color: darkgrey;"
		align="center">Merchant Details</div>
		
	<div class="col-md-offset-2 col-md-4"><label>Merchant Name</label> <form:input
		path="merchantName" type="text" required="true" class="form-control"
		placeholder="Merchant Name..." /></div>

	<div class="col-md-4"><label>Password</label> <form:input
		path="password" type="password" required="true" class="form-control"
		placeholder="Password..." /></div>
	
	<div class="col-md-12" style="height:1em"></div>

	<div class="col-md-offset-2 col-md-4"><label>Mail-Id</label> <form:input
		path="mailid" type="text" required="true" class="form-control"
		placeholder="Email id..." /></div>

	<div class="col-md-4"><label>Mobile </label> <form:input
		path="mobile" type="text" required="true" class="form-control"
		placeholder="Mobile..." /></div>

	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-offset-2 col-md-4"><label>Address </label> <form:input
		path="address" type="text" required="true" class="form-control"
		placeholder="Mobile..." /></div>

	<div class="col-md-4"><label>Merchant Image </label> <form:input
		path="merchantImage" type="file" onchange="ValidateSize(this)"/></div>
</div>
<div>
	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height: 25px; color: darkgrey;"
		align="center">Shop Details</div>

	<div class="col-md-offset-2 col-md-4"><label>Shop Name </label> <form:input
		path="shopName" type="text" required="true" class="form-control"
		placeholder="Shop Name..." /></div>

	<div class="col-md-4"><label>Shop Location </label> <form:input
		path="shopLocation" type="text" required="true" class="form-control"
		placeholder="longitude,latitude..." /></div>

	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height:1em"></div>

	<div class="col-md-offset-2 col-md-4"><label>Shop Address </label> <form:input
		path="shopAddress" type="text" required="true" class="form-control"
		placeholder="Shop Address..." /></div>

	<div class="col-md-4"><label>Delevery Charges </label> <form:input
		path="deleveryCharges" type="text" required="true" class="form-control"
		placeholder="Delevery Charges..." /></div>
		
	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height:1em"></div>
	
	<div class="col-md-offset-2 col-md-4"><label>Delevery Type </label> <form:input
		path="deliveryType" type="text" required="true" class="form-control"
		placeholder="Delevery Type..." /></div>

	<div class="col-md-4"><label>Opening Time </label> <form:input
		path="openingTime" type="text" required="true" class="form-control"
		placeholder="Opening Time..." /></div>

	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height:1em"></div>

	<div class="col-md-offset-2 col-md-4"><label>Closing Time</label> <form:input
		path="closingTime" type="text" required="true" class="form-control"
		placeholder="Closing Time..." /></div>
	
	
	<div class="col-md-4"><label>Shop Type </label> <form:input
		path="shopType" type="text" required="true" class="form-control"
		placeholder="Shop Type..." /></div>
	
	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height:1em"></div>
		
	<div class="col-md-offset-2 col-md-4"><label>Minimum Order Price </label> <form:input
		path="minOrderPrice" type="text" required="true" class="form-control"
		placeholder="Minimum Order Price..." /></div>

		
	<div class="col-md-4"><label>Shop Image </label> <form:input
		path="shopImage" type="file" required="true" onchange="ValidateSize(this)"/></div>
	</div>
	
	<div class="col-md-12" style="height:1em"></div>
	<div class="col-md-12" style="height:1em"></div>

	<div class="col-md-12" align="center"><input type="submit"
		value="Add Shop" class="btn btn-default"></input>
	</div>
	
</form:form></div>
</div>
</div>
</div>
</div>
</div>
<hr>
<%@include file="adminFooter.jsp"%>