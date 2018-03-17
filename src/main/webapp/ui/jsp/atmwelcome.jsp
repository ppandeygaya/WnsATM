<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>WELCOME TO WNS ATM</title>
<link href="/bootstrap.min.css" rel="stylesheet">
<script src="/jquery-2.2.1.min.js"></script>
<script src="/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="margin: 50px;border: 1px solid green;">
		<h3>WELCOME To WNS ATM </h3>
		<div style="color:#FF0000"><h3>${error}</h3></div>
		
		<form action="/withdraw" method="get">
			
			<div class="form-group">
				<label for="withdraw">Enter The Amount For Withdraw</label> 
				<input type="text" class="form-control" id="withdraw" name="withdraw">
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
		<form action="/login" method="get">
			<div class="form-group">
				<label for="withdraw">Click Here For Refilling</label> 
			</div>
			<button type="submit" class="btn btn-success">Refill</button>
		</form>
	</div>
	
</body>
</html>