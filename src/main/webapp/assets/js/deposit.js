$(document).ready(function () {
    var balance = Number(localStorage.balances);
    //console.log(balance);

    $('#balance').text(balance);

    function updateBalance() {
        $('#balance').text(balance);
    }

    function alert(mensaje, flag) {
        let alert = "", class_alert = "";

        if (flag == 0) { class_alert = "alert-success"; } else { class_alert = "alert-danger"; }

        alert = "<div class='alert " + class_alert + " alert-dismissible fade show text-center' role='alert'>"
            + mensaje
            + "</div>";

        $("#alert-container").html(alert);

        if (flag == 0) {
            setTimeout(() => { window.location.href = "./../menu.html"; }, 2000);
        }
    }

    $('#btnAgregarDeposito').click(function () {

        let mensaje = "", flag = 0;
        var inputMonto = parseFloat($('#inputMonto').val());

        if ((!isNaN(inputMonto)) && (inputMonto > 0)) {
            balance += inputMonto;
            localStorage.balances = balance;
            updateBalance();
            $('#inputMonto').val('');
            mensaje = 'Deposit realizado!, redirigiendo';
        } else {
            mensaje = 'Monto invalido. Por favor ingrese un número positivo.';
            flag = 1;
        }

        alert(mensaje, flag);

    });

    $('#btnRetirarDeposito').click(function () {

        let mensaje = "", flag = 0;
        var inputMonto = parseFloat($('#inputMonto').val());

        if ((!isNaN(inputMonto)) && (inputMonto > 0) && (inputMonto <= balance)) {
            balance -= inputMonto;
            localStorage.balances = balance;
            updateBalance();
            $('#inputMonto').val('');
            mensaje = 'Retiro exitoso!, redirigiendo';
        } else {
            mensaje = 'Monto invalido. Ingrese un número válido dentro de su saldo.';
            flag = 1;
        }

        console.log(flag);
        
        alert(mensaje, flag);
    });




})