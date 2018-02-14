<%@include file="adminHeader.jsp" %>
<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<strong>Shops </strong></h3>
    			</div>

 <c:if test="${not empty command}">
			<c:forEach var="shop" items="${command}"> 
    			
<div class="w3-card-4" style="width:100%;float:left;margin-right:30px">
    <div class="w3-container" style="float:left;width:70%">
      <hr>
      <img src='${pageContext.request.contextPath}/${shop.shopImage}' alt="Avatar" class="w3-left w3-rectangle w3-margin-right" style="width:200px">
      <p><h2>${shop.shopName}</h2>
      <b>Rating :</b> 
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star checked"></span>
			<span class="fa fa-star"></span>
			<span class="fa fa-star"></span>
		<b style="padding:0px 0px 0px 20px">Comments (123)</b>	<br>
     <b>Address :</b><br>
      	${shop.shopAddress}
      	</p><br><br> 
    </div>
    
    <div style="float:left">
    <hr>
     <b>Merchant Address</b><br>
      	${shop.address}<br>
      	<b>Mobile : </b>
      	${shop.mobile}<br>
      	<b>email : </b>
      	${shop.mailid}<br>
      	<button href="#" class="btn btn-default">&nbsp;&nbsp;Edit Details&nbsp;&nbsp;</button></p>
      	<button href="#" class="btn btn-default">Manage Items</button></p>
	</div>
  </div>
  
  </c:forEach>
  </c:if>
 
    		</div>
    	</div>
    </div>
</div>
</div>
</div>

  <hr>




  <%@include file="adminFooter.jsp" %>