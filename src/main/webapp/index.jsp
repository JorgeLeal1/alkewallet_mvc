<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Wallet - Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="/favicon.ico" type="image/x-icon" rel="icon" />
</head>

<body>
	<div class="container">

		<div class="card m-auto shadow-lg p-3 mb-5 bg-white rounded" style="width: 25rem; ">
			<h2 class="text-center">Inicio de sesi�n</h2>

			<div class="card-body">
				<form action="ValidarLogin" method="post">
					<div class="form-group has-validation">
						<label for="inputEmail" class="form-label">Ingresa tu Run:</label>
						<input type="text" class="form-control form-control-lg " id="run" name="run"
							placeholder="" required="required">
					</div>
					<br>
					<div class="form-group has-validation">
						<label for="inputPassword" class="form-label">Ingresa tu Contrase�a:</label>
						<input type="password" class="form-control form-control-lg" id="contrasena" name="contrasena"
							placeholder="Ingrese su contrase�a" required="required" autocomplete="off">
					</div>
					<br>
					<button type="submit" class="btn btn-primary w-100 py-2" value="submit">Iniciar sesi�n</button>
				</form>
			</div>
			<div class="card-footer  text-center">
				<div id="mensaje" >
				
				 	<% if(request.getAttribute("mensaje") != null){ %>
						<div class='alert alert-danger alert-dismissible fade show  text-center' role='alert'>
                        	<p><% out.print(request.getAttribute("mensaje")); %></p>
                        </div>
                     <% } %>
				
					<br>
					<!--   <a href="CambioClave.html" class="alert-link">�Problemas con tu clave?</a>-->
				</div>
			</div>
		</div><!-- Card -->
	</div><!-- Container -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

</html>