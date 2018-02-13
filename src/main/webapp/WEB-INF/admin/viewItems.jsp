<%@include file="adminHeader.jsp" %>
<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<strong>Items </strong></h3>
    			</div>
<c:if test="${not empty command}">
			<c:forEach var="item" items="${command}">
		
		<script>
		$(document).ready( function() {
			$('#divimg${item.itemId}').hover(
			    function() {
			        $(this).css({ 'border': "1px solid red" }, 400);
			        //$(this).animate({ 'zoom': "1.2" }, 400);
			    },
			    function() {
			    	$(this).css({ 'border': "1px solid grey" }, 400);
			    	//$(this).animate({ 'zoom': "1" }, 400);
			    });
			});
		</script>
  <div class="w3-card-4" id="divimg${item.itemId}" style="width:45%;float:left;margin-left:11px;border:1px solid grey">
    <div class="w3-container">
      <hr>
      <div style="float:left">
      <img src='${pageContext.request.contextPath}/${item.itemImage}' alt="Avatar" class="w3-left w3-rectangle w3-margin-right" style="width:120px;border:1px solid grey">
      </div>
      <div style="float:left;padding-left:10px;word-break:break-all;">
      <br>
      <span style="color:blue">Id :</span> ${item.itemId}<br>
      <span style="color:blue">Name :</span> ${item.itemName}<br>
      <span style="color:blue">Brand :</span> ${item.itemBrand}<br><br>
      <a href="editItem.htm?id=${item.itemId}"><button class="btn btn-default">Edit Item</button></a> 
      </p><br>
      </div>
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