
<h1>realizar deposito</h1>
<hr>

<form action="RealizarDeposito" method="post">
	Saldo Actual:<input type="number" name="saldo_actual" value ="<% out.print(request.getAttribute("saldo")); %>" readonly><br> 
	Monto a depositar:<input type="number" name="saldo" min="1" required=required><br> 
	<input type="submit" value="Enviar">
</form>


<form action="../../alkewallet_mvc/home.jsp" method="post">
<br><br>
<input type="submit" value='<< volver'>
</form>


