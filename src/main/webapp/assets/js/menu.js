$(document).ready(function () {

    let balance = localStorage.balances;

    $('#saldo').text(balance);

    $('#linkDepositar').click(function(){  alert("Depositar", "alkewallet_mvc/FormRealizarDeposito"); });
    $('#linkRetirar').click(function(){  alert("Retirar", "alkewallet_mvc/FormRealizarRetiro"); });
    $('#linkListarCuentas').click(function(){  alert("Listar Cuentas", "alkewallet_mvc/viewAllCuentas"); });
    $('#linkCrearCuenta').click(function(){  alert("Crear Cuentas", "alkewallet_mvc/cuentas/nuevaCuentas.jsp"); });
    
    function alert(mensaje, link){
        let alert = "<div class='alert alert-success alert-dismissible fade show text-center' role='alert'>"
        + "Redirigiendo a " + mensaje
        + "</div>";
        
        $("#mensaje_menu").html(alert);   
        setTimeout(() => { window.location.href = "./../"+ link; }, 2000);
    }

})