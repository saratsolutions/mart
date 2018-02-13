<%@include file="adminHeader.jsp" %>
<div class="col-md-7" style="min-height: 500px;">
<div>
<div>
<div style="border-radius:8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<script>
	function openDetailsPopup(itemId, itemName, shopId) {
		document.getElementById("exampleModalLabel").innerHTML= "&nbsp;&nbsp;&nbsp;Item Name : "+itemName;
		document.getElementById("shopId").value= shopId;
		document.getElementById("itemId").value= itemId;
		$('#exampleModal').modal('show');
	}
</script>
<strong>Items</strong></h3>
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
      <a type="button" class="" data-toggle="modal" data-whatever="@getbootstrap" onclick="openDetailsPopup('${item.itemId}', '${item.itemName}', '${shopId}');"><button class="btn btn-default">Add Item to Shop</button></a>
      
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

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="">
        <form action="addItemToShop.htm" method="post">
          <input type="hidden" name="shopId" id="shopId"/>
          <input type="hidden" name="itemId" id="itemId"/>
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Quantity:</label>
            <input type="text" class="form-control" id="recipient-name" name="quantity" required="true">
          </div>
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Item Price:</label>
            <input type="text" class="form-control" id="recipient-name" name="price" required="true">
          </div>
          
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Regular Units:</label>
            <input type="text" class="form-control" id="recipient-name" name="regularUnits" required="true">
          </div>
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Regular Units Price:</label>
            <input type="text" class="form-control" id="recipient-name"name="regularUnitsPrice" required="true">
          </div>
          
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Medium Units:</label>
            <input type="text" class="form-control" id="recipient-name" name="mediumUnits" required="true">
          </div>
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Medium Units Price:</label>
            <input type="text" class="form-control" id="recipient-name" name="mediumUnitsPrice" required="true">
          </div>
          
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Large Units:</label>
            <input type="text" class="form-control" id="recipient-name" name="largeUnits" required="true">
          </div>
          <div class="col-md-6" style="height:5em">
            <label for="recipient-name" class="form-control-label">Large Units Price:</label>
            <input type="text" class="form-control" id="recipient-name" name="largeUnitsPrice" required="true">
          </div>
        	
       	<div class="modal-footer">
        	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        	<input type="submit" class="btn btn-primary" value="Add Item to Shop"/>
     	 </div>  
		          
        </form>
      </div>
    </div>
  </div>
</div>