<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión TINAG</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="Principal">Gestión TINAG</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Accidentes">Accidentes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="CrearAccidente">Registrar accidente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Logout">Cerrar sesión</a>
                </li>
            </ul>
        </nav>
	<div class="container text-center border mb-5 mt-5">
	<h1>Gestión This Is Not A Gameland</h1>
	<p>Debes iniciar sesión para poder usar esta aplicación</p>
	<form action="Principal" method="POST">
		<div class="form-group">
             <label for="placa">Placa de identificación:</label>
             <input id="placa" class="form-control text-center" type="text" name="placa" value="">
         </div>
         <div class="form-group">
             <label for="clave">Contraseña:</label>
             <input id="clave" class="form-control text-center" type="password" name="clave" value="">
         </div>
		<button type="submit" class="btn btn-primary mb-2 mt-2 btn-block">Login</button>
	</form>
	</div>
	<%
		String error = (String) request.getAttribute("error");
	//Muestra el mensaje de error
		if(error != null){
			out.print("<p class='text-error'>"+error+"</p>");
		}
	%>
	<footer class="page-footer font-small blue text-center">
            <p>Gestión de accidentes del ayuntamiento de Madrid.</p>
            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Copyright: Dach SL
            </div>
            <!-- Copyright -->
        </footer>
</body>
</html>