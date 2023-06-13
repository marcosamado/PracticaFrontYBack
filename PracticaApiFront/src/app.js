/* -------------------------------------------------------------------------- */
/*                        // LOGICA DE MENU DESPLEGABLE                       */
/* -------------------------------------------------------------------------- */

const formAgregar = document.getElementById("formAgregar");
const spanAgregar = document.getElementById("spanAgregar");
const buttonAgregar = document.getElementById("buttonAgregar");

const formActualizar = document.getElementById("formActualizar");
const spanActualizar = document.getElementById("spanActualizar");
const buttonActualizar = document.getElementById("buttonActualizar");


buttonAgregar.addEventListener("click", (e)=> {
    spanAgregar.classList.toggle("transition-transform");
    spanAgregar.classList.toggle("rotate-90");
    formAgregar.classList.toggle("transition-transform");
    formAgregar.classList.toggle("hidden");
    formAgregar.classList.toggle("top-0"); 
})


// buttonActualizar.addEventListener("click", (e)=> {
//     console.log(e);
//     spanActualizar.classList.toggle("transition-transform");
//     spanActualizar.classList.toggle("rotate-90");
//     formActualizar.classList.toggle("transition-transform")
//     formActualizar.classList.toggle("hidden");
//     formActualizar.classList.toggle("top-0");
// })


/* -------------------------------------------------------------------------- */
/*                           CREAR UN NUEVO USUARIO                           */
/* -------------------------------------------------------------------------- */

const usuario = document.getElementById("usuario");
const apellido = document.getElementById("apellido");


formAgregar.addEventListener("submit", (event) => {
    event.preventDefault();

    let payLoad = {
        nombre: usuario.value,
        apellido: apellido.value
    };

    let settings = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(payLoad)
    };

    fetch("http://localhost:8080/usuarios/crearUsuario", settings)
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        return error;
    })

    Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Usuario agregado',
        showConfirmButton: false,
        timer: 1500
    })

    formAgregar.reset();
});


/* -------------------------------------------------------------------------- */
/*                              MOSTRAR USUARIOS                              */
/* -------------------------------------------------------------------------- */

const contenedor = document.getElementById("contenedor-items");
const templateItems = document.getElementById("items").content;
const buttonMostrarUsuario = document.getElementById("botonMostrarUsuario");
const fragment = document.createDocumentFragment();

buttonMostrarUsuario.addEventListener("click", (e)=> {
    
    let settings = {
        method: "GET",
        headers: {
            "Content-type": "application/json"
        }
    };

    fetch("http://localhost:8080/usuarios", settings)
    .then(response => {
        return response.json();
    })
    .then(data => {
        imprimirUsuarios(data);
    })
    .catch(error => {
        return error;
    })


})


function imprimirUsuarios(data){
    contenedor.innerHTML = "";
    
    let timerInterval
    Swal.fire({
        title: 'Cargando Usuarios',
        html: 'tiempo restante <b></b>',
        timer: 2000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading()
            const b = Swal.getHtmlContainer().querySelector('b')
            timerInterval = setInterval(() => {
            b.textContent = Swal.getTimerLeft()
            }, 100)
        },
        willClose: () => {
            clearInterval(timerInterval)
        }
        }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {
            console.log('I was closed by the timer')
        }
    })

    setTimeout(()=> {
        data.forEach(user => {
            templateItems.getElementById("id").innerHTML = `<p id="id" class="text-center text-yellow-400"><span class="text-start text-pink-100">ID </span>${user.id}</p>`
            templateItems.getElementById("nombreUsuario").innerHTML = `<p id="nombreUsuario" class="text-center text-yellow-400"><span class="text-pink-100">NOMBRE </span>${user.nombre}</p>`
            templateItems.getElementById("apellidoUsuario").innerHTML = `<p id="apellidoUsuario" class="text-center text-yellow-400"><span class="text-pink-100">APELLIDO </span>${user.apellido}</p>`
            let clone = templateItems.cloneNode(true);
            fragment.appendChild(clone);
        });
        contenedor.appendChild(fragment);
    },2000);

}











