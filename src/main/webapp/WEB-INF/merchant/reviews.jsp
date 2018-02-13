<%@include file="merchantHeader.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-7" style="min-height: 500px;">
<div style="border-radius: 8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<center><strong class="boldcapitalize">Rating : 
<fmt:formatNumber type = "number" 
         maxFractionDigits = "2" value = "${avgRating}" /> / 5 </strong></center>
</h3>
</div>

<div style="height:22em"><br />

<div class="w3-card-4" >
		<table class="col-md-12" style="width:100%">
			<tr align="center" style="background-color:#5f5f5f;color:white;height:3em">
				<td>Id</td>
				<td>Customer Name</td>
				<td>Commented Date</td>
				<td>Rating</td>
				<td>Comment</td>
			</tr>
			
			<c:set var="flagCount" value="false" scope="page" />
			<c:set var="count" value="0" scope="page"/>
			<c:if test="${not empty command}">
			<c:forEach var="comment" items="${command}">
			<c:set var="count" value="${count + 1}" scope="page"/>
			<c:set var="flagCount" value="${!flagCount}" scope="page"/>
			<c:if test="${flagCount}">
			<tr class="darkRow" align="center">
			</c:if>
			<c:if test="${!flagCount}">
			<tr class="lightRow" align="center">
			</c:if>
				<td class="col-md-1">${count}</td>
				<td class="col-md-2">${comment.customer.name}</td>
				<td class="col-md-2">${comment.commentedDate}</td>
				<td class="col-md-1">${comment.rating}</td>
				<td class="col-md-6">${comment.comment}</td>
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