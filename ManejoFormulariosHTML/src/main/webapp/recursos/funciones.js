
// Selectores
const usuarioInput = document.querySelector(".usuario");
const passwordInput = document.querySelector(".password");
const formulario = document.querySelector(".formulario");
const enviarBtn = document.querySelector(".enviar");



// Funciones
const validarForma = e => {
    // prevenir submit del formulario
    e.preventDefault();
    
    const usuario = formulario.usuario;
    const password = formulario.password;
    const tecnologias = formulario.tecnologia;
    const checkSeleccionado = false;
    const generos = formulario.genero;
    const radioSeleccionado = false;
    const ocupacion = formulario.ocupacion;
    
    // validar usuario
    if(usuario.value == "") {
        alert("Debe proporcionar un nombre de usuario");
        usuarioInput.focus();
        usuarioInput.select();
        return false;
    }
    
    // validar password
    if(password.value == "" || password.value.length < 3){
        alert("Debe proporcionar una contraseña válida");
        passwordInput.focus();
        passwordInput.select();
        return false;
    }
    
    // validar seleccion tecnologias usadas
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnología");
        return false;
    }
    
    // Validar seleccion de genero musical
    for(var i = 0; i < generos.length; i++){
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    
    
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    //Formulario es valido
    alert("Formulario valido, enviado datos al servidor");
    return true;

}

// Eventos

// Submit del formulario
formulario.addEventListener("submit", validarForma);