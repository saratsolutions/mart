<%@include file="merchantHeader.jsp"%>

<div class="col-md-7" style="min-height: 500px;">
<div style="border-radius: 8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<center><strong class="boldcapitalize">Rejected Orders History </strong></center>
</h3>
</div>

<div style="height:22em"><br />

<div class="w3-card-4" >
		<table class="col-md-12" style="width:100%">
			<tr align="center" style="background-color:#5f5f5f;color:white;height:3em">
				<td>Id</td>
				<td>Customer Name</td>
				<td>Order Date</td>
				<td>Amount</td>
				<td>Status</td>
				<td>View</td>
			</tr>
			
			<c:set var="flagCount" value="false" scope="page" />
			<c:if test="${not empty command}">
			<c:forEach var="order" items="${command}">
			<c:if test="${not empty order}">
			<c:set var="flagCount" value="${!flagCount}" scope="page"/>
			<c:if test="${flagCount}">
			<tr class="darkRow" align="center">
			</c:if>
			<c:if test="${!flagCount}">
			<tr class="lightRow" align="center">
			</c:if>
				<td>${order.orderId}</td>
				<td>${order.customer.name}</td>
				<td>${order.orderDate}</td>
				<td>${order.totalAmt}</td>
				<td>${order.status}</td>
				<td class="btn btn-primary"  id="orderx${order.orderId}"> View</td>
			</tr>
			</c:if>
			<script>
			$(document).ready(function(){
			    $('#orderx${order.orderId}').click(function(){
			        $("#ordery${order.orderId}").slideToggle();
			    });
			});
			</script>
			<tr align="center">
				<td colspan="6" style="height:100%">
					<div id="ordery${order.orderId}" style="display:none;background-color:#5f5f5f;height:2em;color:white;width:95%;border:1px solid orange">
						<div class="col-md-6" style="border:1px solid grey">
							<div class="col-md-2">Sl.no</div>
							<div class="col-md-5">Item Name</div>
							<div class="col-md-2">Quantity</div>
							<div class="col-md-3">Price</div>
						</div>
						<div class="col-md-6" style="border:1px solid grey">
							<div class="col-md-2">Sl.no</div>
							<div class="col-md-5">Item Name</div>
							<div class="col-md-2">Quantity</div>
							<div class="col-md-3">Price</div>
						</div>
						
						<c:set var="count" value="0"  scope="page"/>
						<c:forEach var="item" items="${order.items}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div class="col-md-6" style="border:1px solid grey;color:black;">
							<div class="col-md-2">${count}</div>
							<div class="col-md-5">${item.itemName}</div>
							<div class="col-md-2">${item.quantity}</div>
							<div class="col-md-3">${item.price}</div>
						</div>
						</c:forEach>
					</div>
				</td>
			</tr>
			</c:forEach>
			</c:if>
		</table>      
</div>
  
</div>

</div>
</div>
</div>
</div>

<%@include file="merchantFooter.jsp"%>