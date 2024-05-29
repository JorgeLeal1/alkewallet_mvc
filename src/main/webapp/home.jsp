<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Wallet - Men� Principal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="/favicon.ico" type="image/x-icon" rel="icon" />

	<link rel="stylesheet" href="assets/css/menu.css">
	<link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" title="HOME"
				href="home">
				<div class="home" alt="Volver al Men� Principal"
					style="background-image: url('assets/img/home2.png') !important;"></div>
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" aria-current="page" href="FormRealizarDeposito">Depositar saldo</a> 
					<a class="nav-link" aria-current="page" href="FormRealizarRetiro">Retirar saldo</a> 
					<a class="nav-link" aria-current="page" href="viewAllCuentas">Listar Cuentas</a>
					<a class="nav-link" aria-current="page" href="/alkewallet_mvc/cuentas/nuevaCuentas.jsp">Crear Cuenta</a>					
				</div>
			</div>
			<span class="navbar-text"> <a style="float: right;"
				title="Logout" href="../../alkewallet_mvc/index.jsp"> <span
					style="float: left; margin-right: 10px;"> cerrar sesion </span>
					<div class="login" style="float: left;"></div>
			</a>
			</span>
		</div>
	</nav>
	<!-- nav-->

	<div class="container-fluid fondo">
		<div class="container">
			<br>

			<div class="card text-center m-auto tamanoCardPrincipal">
				<div class="card-header">
					<h2 style="padding-top: 10px;" class="text-center">Men�
						Principal</h2>
				</div>
				<div class="card-body">
					<label for="balance" style="float: left; padding-right: 20px;"
						class=" fw-bold">Dinero en cuenta: <%out.print(request.getAttribute("saldo"));%> ( CLP )</label>
					<h4 style="float: left;" id="saldo" class=" fw-bold"></h4>
				</div>

				<!-- card-footer-->
				<div class="card-footer">

					<div class="row row-cols-1 row-cols-md-4 g-4">
						<div class="col">
							<div class="card h-100">
								<a class="nav-link" aria-current="page"
									href="javascript:void(0)" id="linkDepositar"> <img
									src="assets/img/depositar.jpg" width="150px" height="150px"
									class="card-img-top" alt="...">
									<div class="card-body">
										<h6>Depositar</h6>
									</div>
								</a>
							</div>
						</div>
						<div class="col">
							<div class="card h-100">
								<a class="nav-link" href="javascript:void(0)" id="linkRetirar">
									<img src="assets/img/EnviarDinero.png" width="150px"
									height="150px" class="card-img-top" alt="...">
									<div class="card-body">
										<h6>Retirar</h6>
									</div>
								</a>
							</div>
						</div>
						<div class="col">
							<div class="card h-100">
								<a class="nav-link" href="javascript:void(0)"
									id="linkListarCuentas"> <img
									src="assets/img/ultimosMovimientos.jpg" width="150px"
									height="150px" class="card-img-top" alt="...">
									<div class="card-body">
										<h6>Listar Cuentas</h6>
									</div>
								</a>
							</div>
						</div>
						
						<div class="col">
							<div class="card h-100">
								<a class="nav-link" href="javascript:void(0)"
									id="linkCrearCuenta"> <img
									src="assets/img/ultimosMovimientos.jpg" width="150px"
									height="150px" class="card-img-top" alt="...">
									<div class="card-body">
										<h6>Crear Cuenta</h6>
									</div>
								</a>
							</div>
						</div>						
					</div>

					<br>
					<div id="mensaje_menu" style="height: 60px;"></div>

				</div>
				<!-- End card-footer-->

			</div>


			<!-- 
			<form action="cuentas/nuevaCuentas.jsp" method="post">
				Crear Cuenta<br> <input type="submit" value="nuevo">
			</form>
  			-->


		</div>
		<!-- container-->
	</div>
	<!-- container-fluid-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="assets/js/menu.js"></script>
</body>

</html>




