<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Wallet - Deposito</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link href="/favicon.ico" type="image/x-icon" rel="icon" />

<link rel="stylesheet" href="../assets/css/menu.css">
<link rel="stylesheet" href="../assets/css/style.css">
</head>

<body class="fondo">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" title="HOME"
				href="../home">
				<div class="home" alt="Volver al Menú Principal"
					style="background-image: url('../assets/img/home2.png') !important;"></div>
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" aria-current="page" href="../FormRealizarDeposito">Depositar saldo</a> 
					<a class="nav-link" aria-current="page" href="../FormRealizarRetiro">Retirar saldo</a> 
					<a class="nav-link" aria-current="page" href="../viewAllCuentas">Listar Cuentas</a>
					<a class="nav-link active" aria-current="page" href="/alkewallet_mvc/cuentas/nuevaCuentas.jsp">Crear Cuenta</a>
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
    
			<div class="card m-auto tamanoCardPrincipal">
				<div class="card-header">
					<h2 class="text-center">Crear Cuenta</h2>
				</div>

				<div class="card-body">
				
					<form id="Form_sendmoney" action="../NuevaCuenta" method="post">
				
						<h4 class="card-title">Datos Cliente</h4><hr><br>
						<div class="form-group row">
							<label for="run"
								class="col-sm-2 col-form-label fw-bold">Run:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="run"
									name="run" placeholder="11111111-1" required="required">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="nombre1"
								class="col-sm-2 col-form-label fw-bold">Nombre1:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="nombre1"
									name="nombre1" placeholder="Ingrese nombre1" required="required">
							</div>

							<label for="Nombre2"
								class="col-sm-2 col-form-label fw-bold">Nombre2:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="nombre2"
									name="nombre2" placeholder="Ingrese Nombre2" required="required">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="appaterno"
								class="col-sm-2 col-form-label fw-bold">Apellido Paterno:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="appaterno"
									name="appaterno" placeholder="Ingrese Apellido Paterno" required="required">
							</div>

							<label for="apmaterno"
								class="col-sm-2 col-form-label fw-bold">Apellido Materno:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="apmaterno"
									name="apmaterno" placeholder="Ingrese Apellido Paterno" required="required">
							</div>
						</div>	
																												
						<br>
						<hr><h4 class="card-title">Datos bancarios</h4><hr>
						
						<div class="form-group row">
							<label for="nrocuenta"
								class="col-sm-2 col-form-label fw-bold">Numero Cuenta:</label>
							<div class="col-sm-4">
								<input type="number" class="form-control" id="nrocuenta"
									name="nrocuenta" placeholder="Ingrese nrocuenta" min="1" required="required">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="alias"
								class="col-sm-2 col-form-label fw-bold">Alias:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="alias"
									name="alias" placeholder="Ingrese alias" required="required">
							</div>

							<label for="banco"
								class="col-sm-2 col-form-label fw-bold">Banco:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="banco"
									name="banco" placeholder="Ingrese banco" required="required">
							</div>
						</div>	

						<br>
						<hr><h4 class="card-title">Datos usuario</h4><hr>
						
						<div class="form-group row">
							<label for="nombreUsuario"
								class="col-sm-2 col-form-label fw-bold">nombre:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="nombreUsuario"
									name="nombreUsuario" placeholder="Ingrese nombreUsuario" required="required">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="email"
								class="col-sm-2 col-form-label fw-bold">Correo:</label>
							<div class="col-sm-4">
								<input type="email" class="form-control" id="email"
									name="email" placeholder="Ingrese email" required="required">
							</div>

							<label for="contrasena"
								class="col-sm-2 col-form-label fw-bold">Contraseña:</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" id="contrasena"
									name="contrasena" placeholder="Ingrese Contraseña" required="required" autocomplete="off">
							</div>
						</div>	
						
						
						<div class="card-footer">
							<button type="submit" class="btn btn-primary" id="Enviar">Enviar</button>
						</div>
				</form>

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
	<script src="../assets/js/menu.js"></script>
</body>

</html>
