<%@include file="adminHeader.jsp" %>
<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<strong>Item Categories </strong></h3>
    			</div>
<div style="font-size:18px;">
<c:if test="${not empty command}">
			<c:forEach var="itemCategory" items="${command}">
    <div class="col-md-offset-4 col-md-12">
      <div style="float:left">${itemCategory.id}</div>
      <div style="float:left;padding-left:2em">${itemCategory.categoryName}</div>
    </div>
    <br>
</c:forEach>
	</c:if>
	<div class="col-md-12">
	<form action="addCategory.htm" method="post">
		<br>
		<div>
		<div class="col-md-offset-4 col-md-5">
			<input type="text" name="categoryName" placeholder="Enter Category Name" class="form-control" required="true"/>
		</div>
		<div class="col-md-offset-5 col-md-5">
			<button class="btn btn-default" type="submit">Add Item Category</button>
		</div>
		</div>
		</form>
	</div>
	</div>
	
   	</div>
    	</div>
    </div>
</div>
</div>
</div>
  <hr>

<%@include file="adminFooter.jsp" %>