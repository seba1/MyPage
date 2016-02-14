<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Calculations</title>

<!-- Bootstrap -->
<link href="../lib/bootstrap.min.css" rel="stylesheet">

<link href="../css/myStylesheet.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">My Page</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<!-- TODO -->
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
							<!-- End TODO -->
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h2>Fuel Cost</h2>
			<p>Here you can calculate your fuel expenses</p>
			<form id="calc">
				<table class="table">
					<tr>
						<td>Petrol cost per Liter</td>
						<td colspan="2"><input placeholder="0.00" type="text" id="costPerL" name="costPerL" required onfocus="this.select();" onmouseup="return false;"></td>
					</tr>
					<tr>
						<td>Average fuel consumption (L/100km)</td>
						<td colspan="2"><input placeholder="0" type="text" id="avgFuelCost"  name="avgFuelCost" required onfocus="this.select();" onmouseup="return false;"></td>
					</tr>
					<tr>
						<td colspan="2"><font size="4">Enter Only ONE of the below</font></td>
						<td><font size="4">Total Cost</font></td>
					</tr>
					<tr>
						<td>Daily amount of km driven</td>
						<td><input placeholder="0" type="text" id="kmPerDay"  name="kmPerDay"></td>
						<td><input placeholder="0" type="text" id="kmPerDayCost" name="kmPerDayCost" disabled></td>
					</tr>
					<tr>
						<td>Weekly amount of km driven</td>
						<td><input placeholder="0" type="text" id="kmPerWeek" name="kmPerWeek"></td>
						<td><input placeholder="0" type="text" id="kmPerWeekCost" name="kmPerWeekCost" disabled></td>
					</tr>
					<tr>
						<td>Monthly amount of km driven</td>
						<td><input placeholder="0" type="text" id="kmPerMnyh" name="kmPerMnyh"></td>
						<td><input placeholder="0" type="text" id="kmPerMnyhCost" name="kmPerMnyhCost" disabled></td>

					</tr>
					<tr>
						<td>Yearly amount of km driven</td>
						<td><input placeholder="0" type="text" id="kmPerYr" name="kmPerYr"></td>
						<td><input placeholder="0" type="text" id="kmPerYrCost" name="kmPerYrCost" disabled></td>
					</tr>
					<tr>
						<td>Trip Distance</td>
						<td><input placeholder="0" type="text" id="tripDist"  name="tripDist"></td>
						<td><input placeholder="0" type="text" id="tripDistCost"  name="tripDistCost" disabled></td>
					</tr>
					<tr>
						<td colspan="3" align="right">
						<input type="submit" class="btn btn-lg btn-success" value="Calculate">
						<input type="button" class="btn btn-lg btn-danger"  value="Clear" id="clear" name="clear" >
						</td>
					</tr>
				</table>
			</form>

			<!-- jumbotron div end -->
		</div>

		<!-- main div end -->
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../lib/bootstrap.min.js"></script>
	<!-- my javascript -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="../js/myJs.js"></script>

</body>
</html>
