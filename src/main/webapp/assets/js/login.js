$(document).ready(function () {
    localStorage.balances = 20000;
    
    $('#form_login').submit(function(e){
        e.preventDefault();
        let flag = 0;

        const inputEmail       = $("#inputEmail").val();
        const inputPassword    = $("#inputPassword").val();

        //console.log('inputEmail:', inputEmail);
        //console.log('inputPassword:', inputPassword);
    
        if (inputEmail === 'admin@gmail.com') { 
            $("#inputEmail").removeClass('form-control form-control-lg is-invalid');   
            $("#inputEmail").addClass('form-control form-control-lg is-valid');      
        } else {
            flag++;
            $("#inputEmail").removeClass('form-control form-control-lg is-valid');   
            $("#inputEmail").addClass('form-control form-control-lg is-invalid');           
        }
    
        if (inputPassword === '1234') {
            $("#inputPassword").removeClass('form-control form-control-lg is-invalid');   
            $("#inputPassword").addClass('form-control form-control-lg is-valid');     
        } else {
            flag++;
            $("#inputPassword").removeClass('form-control form-control-lg is-valid');   
            $("#inputPassword").addClass('form-control form-control-lg is-invalid');     
        }
    
        //console.log('flag:', flag);
        //-----------------------------------------------------
        if (flag > 0) {
            let alert = "<div class='alert alert-danger alert-dismissible fade show  text-center' role='alert'>"
                        + "<p>Datos Incorrectos!</p>"
                        + "</div>";
            $("#mensaje").html(alert);            
        } else {
            let alert = "<div class='alert alert-success alert-dismissible fade show  text-center' role='alert'>"
                        + "<p>Redireccionando!</p>"
                        + "</div>";
                        
            $("#mensaje").html(alert);   
            setTimeout(() => { window.location.href = "./../menu.html"; }, 2000);
            
        }    

    }); //form_login

})