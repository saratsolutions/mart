<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
  	position:relative;
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
  .footer-grid ul li{
  	list-style-type:none;
  	font-size:14px;
  	line-height:2.2em;
      color: #ABABAB;

  }
  .footer-grid ul li a{

      color: #ABABAB;
  }
  .footer-grid ul li a:hover{
      color:#FAB005;
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
  .fo-grid1 p{
  	 font-size:1em;
  	line-height:2em;
  	color:#fff;
  }
  .fo-grid1 p a{
  	text-decoration:none;
  	color:#fff;
  }
  .fo-grid1 p a:hover {
      color: #FAB005;
  }
  .fo-grid1 p  i{
  	margin-right:7px;
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

  <style>
  * {
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
  </style>
  </style>
</head>
<body>

<nav class="navbar">
  <div class="container-fluid" style="background-color:orange">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>

  </div>
</nav>

<nav class="navbar">
  <div class="container" style="background-color:grey">
    <div class="navbar-header">
      <h3>Hello: Jagadeesh</h3>
    </div>
  </div>
</nav>



<div class="container">
 <div class="form-group">
           <div class="col-md-3">
            <label>Enter Shop ID</label>
            <input type="email" class="form-control" id="email" placeholder="shopID">
           </div>
         </div>
         <br>
<a id="add_row" class="btn btn-default pull-right">Get Details</a>


</div>

<div class="container">
  <h2>Shop Details</h2>
  <form action="/action_page.php">
    <div class="form-group">
      <label for="email">Shop Name</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Shop Name" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Shop Address</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter Shop Address" name="pwd">
    </div>
    <div class="form-group">
      <label for="email">Merchant Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Merchant Name" name="email">
    </div>
    <div class="form-group">
    <label for="exampleInputFile">Shop Image</label>
    <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">

  </div>
    <div class="checkbox">

    </div>

  </form>
</div>

<br>


<!--
<div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Invoice</h2><h3 class="pull-right">Order # 12345</h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					John Smith<br>
    					1234 Main<br>
    					Apt. 4B<br>
    					Springfield, ST 54321
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Shipped To:</strong><br>
    					Jane Smith<br>
    					1234 Main<br>
    					Apt. 4B<br>
    					Springfield, ST 54321
    				</address>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<strong>Payment Method:</strong><br>
    					Visa ending **** 4242<br>
    					jsmith@email.com
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
    					<strong>Order Date:</strong><br>
    					March 7, 2014<br><br>
    				</address>
    			</div>
    		</div>
    	</div>
    </div>

  -->
<div class="container">
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order summary</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Item Name</strong></td>
        							<td class="text-center"><strong>Item Price</strong></td>
        							<td class="text-center"><strong>Item Picture</strong></td>
        							<td class="text-right"><strong>Quantity</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							 <tr>
    								<td>BS-200</td>
    								<td class="text-center">$10.99</td>
    								<td class="text-center">1</td>
    								<td class="text-right">$10.99</td>
                    <td><button type="btn-sm" class="btn-primary">Edit Details</button></td>
    							</tr>
                                <tr>
        							<td>BS-400</td>
    								<td class="text-center">$20.00</td>
    								<td class="text-center">3</td>
    								<td class="text-right">$60.00</td>
                    <td><button type="btn-sm" class="btn-primary">Edit Details</button></td>
    							</tr>
                                <tr>
            						<td>BS-1000</td>
    								<td class="text-center">$600.00</td>
    								<td class="text-center">1</td>
    								<td class="text-right">$600.00</td>
                    <td><button type="btn-sm" class="btn-primary">Edit Details</button></td>
    							</tr>
    							<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    								<td class="thick-line text-center"><strong>Subtotal</strong></td>
    								<td class="thick-line text-right">$670.99</td>

    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Shipping</strong></td>
    								<td class="no-line text-right">$15</td>
    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right">$685.99</td>
    							</tr> -->
    						</tbody>
    					</table>

    				</div>

    			</div>

    		</div>
                <div class="container">
 <div class="form-group">
           <div class="col-md-3">
            <label>Discounts/Offers</label>
            <input type="email" class="form-control" id="email" placeholder="offers">
           </div>
         </div>
         <br>
<a id="add_row" class="btn btn-default pull-right">Save</a>


</div>
    	</div>
    </div>
</div>
  <hr>




  <div class="footer">
    <div class="container-fluid" style="background-color:grey">

      <div class="row">
        <div class="col-sm-6" >
          <h3 style="padding-left:80px;padding-top:30px;color:white">About Us</h3>
          <p align="justify" style="color:white;padding-left:70px;padding-top:40px">Jagadeesh super market is very big and it is lanched very long back. we take care of our customers and we value there needs. we have a very big p
            lace with many workers inside. their are well trained to support our customers. </p>
          </div>
          <div class="col-sm-6" >
            <h3 style="padding-left:60px;padding-top:30px;color:white">Services</h3>
            <p align="justify" style="color:white;padding-left:70px;padding-top:40px">Contacts </p>
            </div>
          </div>


  <div class="clearfix"></div>
    <div class="footer-bottom" style="background-color:grey;padding-top:30px">
      <h2 ><a href="home.html"><b>T<br>H<br>E</b>Big Store<span>The Best Supermarket</span></a></h2>
      <p class="fo-para">Since 2012</p>
      <div class=" address">
        <div class="col-md-4 fo-grid1">
            <p><i class="fa fa-home" aria-hidden="true"></i>Kukatpally,Hyderabad.</p>
        </div>
        <div class="col-md-4 fo-grid1">
            <p><i class="fa fa-phone" aria-hidden="true"></i>+91999999999</p>
        </div>
        <div class="col-md-4 fo-grid1">
          <p><a href="mailto:info@example.com"><i class="fa fa-envelope-o" aria-hidden="true"></i>mechbronco@gmail.com</a></p>
        </div>
        <div class="clearfix"></div>

        </div>
    </div>
  <div class="copy-right">
    <p> &copy; 2012- <?php echo date("Y"); ?> Big Jagadeesh. All Rights Reserved | Design by  <a href="">Big Jagadeesh</a></p>
  </div>

	</div>
</div>


</body>
</html>
