// Selectores
const usuarioInput = document.querySelector(".usuario");
const passwordInput = document.querySelector(".password");
const formulario = document.querySelector(".formulario");
const enviarBtn = document.querySelector(".enviar");


// Funciones
const validarFormulario = e => {
    // prevenir submit del formulario
    e.preventDefault();
    
    const usuario = formulario.usuario;
    const password = formulario.password;
    const tecnologias = formulario.tecnologia;
    let checkSeleccionado = false;
    const generos = formulario.genero;
    let radioSeleccionado = false;
    const ocupacion = formulario.ocupacion;
    

    // validar usuario
    if(usuario.value == "") {
        Swal.fire({
            title: "Campo obligatorio",
            text: "Debe proporcionar un nombre de usuario",
            icon: "warning",
            confirmButtonText: "Aceptar",
      });
      
      
        
        return false;
    }
    
    
    // validar password
    if(password.value == "" || password.value.length < 3){
        Swal.fire({
            title: "Campo obligatorio",
            text: "Debe proporcionar una contraseña válida",
            icon: "warning",
            confirmButtonText: "Aceptar",
      });
        return false;
    }
    
    // validar seleccion tecnologias usadas
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    
    if(!checkSeleccionado){
        Swal.fire({
            title: "Campo obligatorio",
            text: "Debe seleccionar una tecnología",
            icon: "warning",
            confirmButtonText: "Aceptar",
      });
        return false;
    }
    
    // Validar seleccion de genero musical
    for(var i = 0; i < generos.length; i++){
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        Swal.fire({
            title: "Campo obligatorio",
            text: "Debe seleccionar un género",
            icon: "warning",
            confirmButtonText: "Aceptar",
      });
        return false;
    }
    
    
    if(ocupacion.value == ""){
        Swal.fire({
            title: "Campo obligatorio",
            text: "Debe seleccioanr una ocupación",
            icon: "warning",
            confirmButtonText: "Aceptar",
      });
        return false;
    }
    
    //Formulario es valido
    Swal.fire({
            title: "Registro completado",
            text: "Formulario enviado exitosamente",
            icon: "success",
            confirmButtonText: "Aceptar",
      });
      
      // limpiar formulario
      formulario.reset();

    return true;

}

// Eventos

// Submit del formulario
formulario.addEventListener("submit", validarFormulario);