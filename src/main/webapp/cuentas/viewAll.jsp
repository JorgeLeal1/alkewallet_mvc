<%@page import="model.Cuenta"%>
<%@page import="java.util.List"%>

<%  
	List<Cuenta> lista=(List)request.getAttribute("cuentas");  
	out.print("Hay un total de "+lista.size()+" cuentas");  
%>
<br><hr>
<br><br>
<style>
table, th, td {
  border: 1px solid black;
}
</style>

<table>
  <tr>
    <th>ID</th>
    <th>RUN</th>
    <th>N° Cuenta </th>
    <th>Alias </th>
    <th>Banco </th>    
    <th>Saldo </th>

  </tr>
<%  
	
	for(int i=0;i<lista.size();i++){
		out.print(
				"<tr>"+""+
				  "<td>"+lista.get(i).getId()+"</td>"+""+
				  "<td>"+lista.get(i).getRun()+"</td>"+""+
				  "<td>"+lista.get(i).getNroCuenta()+"</td>"+""+
				  "<td>"+lista.get(i).getAlias()+"</td>"+""+
				  "<td>"+lista.get(i).getBanco()+"</td>"+""+
				  "<td>"+lista.get(i).getSaldo()+"</td></tr>"
				  );  
	}
	
%>  

</table>

<br><hr>


<form action="../alkewallet_mvc/home.jsp" method="post">
<br><br>
<input type="submit" value='<< volver'>
</form>