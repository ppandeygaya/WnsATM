<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <title>WELCOME To WNS ATM</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div class="container" style="margin: 50px">
    <div style="color:#FF0000"><h3>${error}</h3></div>
        <div>
            <form action="/refill" method="post">
                       <div class="form-group">
                <label for="withdraw">Enter The Amount For Refill </label> 
                
				<input type="text" class="form-control" id="refillMoney" name="refillMoney">
				<label for="withdraw">Enter The Note of $20 For Refill </label> 
				<input type="text" class="form-control" id="refill$20" name="refill$20">
				<label for="withdraw">Enter The Note of $50 For Refill </label> 
				<input type="text" class="form-control" id="refill$50" name="refill$50">
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
        
</div>
</body>
</html>