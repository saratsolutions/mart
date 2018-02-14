<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="adminHeader.jsp" />
<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title"><center><strong>Edit Item </strong></center>
</h3>
</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form class="login100-form validate-form"
	action="/mart/admin/editItem.htm" enctype="multipart/form-data">
	<div class="col-md-12" style="height: 10px"></div>
	<div class="col-md-4"><label>Item Name</label> <form:input
		path="itemName" type="text" required="true" class="form-control"
		placeholder="Item Name..." /></div>

	<div class="col-md-4"><label>Item Brand</label> <form:input
		path="itemBrand" type="text" required="true" class="form-control"
		placeholder="Item Brand..." /></div>

	<div class="col-md-4"><label>Units</label> <form:input
		path="units" type="text" class="form-control"
		placeholder="Item Units..." /></div>

	<div class="col-md-12" style="height: 10px"></div>

	<div class="col-md-12"><label>Description</label> <form:textarea
		path="description" class="form-control" placeholder="Description"
		style="height:150px" /></div>

	<div class="col-md-12" style="height: 10px"></div>

	<div class="col-md-12"><label>Image</label> <form:input
		path="itemImage" type="file" required="true"/>
		<img src="${pageContext.request.contextPath}/${command.itemImage}" style="width:150px"/>
		</div>

	<div class="col-md-12" style="height: 1em; color: red;"></div>

	<div class="container-login100-form-btn" align="center"><input
		type="submit" value="Update Item" class="btn btn-default"></input>
	</div>
	<br>
</form:form></div>
</div>
</div>
</div>
</div>
</div>
<hr>
<jsp:include page="adminFooter.jsp" />