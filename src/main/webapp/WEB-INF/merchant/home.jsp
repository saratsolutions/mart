<%@include file="merchantHeader.jsp"%>

<div class="col-md-7" style="min-height: 500px;">
<div style="border-radius: 8px;">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">
<center><strong class="boldcapitalize">${command.merchantName} Profile </strong></center>
</h3>
</div>

<div align="center" style="height:22em"><br />
<div class="col-md-6" align="right">Merchant Name :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.merchantName}</div>

<div class="col-md-6" align="right">Email Id :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.mailid}</div>

<div class="col-md-6" align="right">Mobile :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.mobile}</div>

<div class="col-md-6" align="right">Address :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.address}</div>

<div class="col-md-6" align="right">Mobile :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.mobile}</div>

<div class="col-md-12" style="height:1em"></div>

<div class="col-md-6" align="right">Shop Id :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.shopId}</div>

<div class="col-md-6" align="right">Shop Name :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.shopName}</div>

<div class="col-md-6" align="right">Shop Address :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.shopAddress}</div>

<div class="col-md-6" align="right">Delevery Type :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.deliveryType}</div>

<div class="col-md-6" align="right">Timings :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.openingTime}-${command.closingTime}</div>

<div class="col-md-6" align="right">Shop Type :</div>
<div class="col-md-6 boldcapitalize" align="left">${command.shopType}</div>

<button class="btn btn-default">Edit Profile</button>

</div>

</div>
</div>
</div>
</div>

<%@include file="merchantFooter.jsp"%>