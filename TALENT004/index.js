// Función principal que inicia toda la aplicación
export function inicializarApp(peliculas) {
    // Cargamos los géneros en el menú desplegable
    cargarGeneros(peliculas);

    // Configuramos los eventos (como los clics en botones)
    configurarEventos(peliculas);

    // Mostramos todas las películas al cargar la página
    mostrarPeliculas(peliculas);
}

// Carga los géneros en el menú desplegable y crea botones para cada género
function cargarGeneros(peliculas) {
    // Obtenemos todos los géneros únicos de las películas
    const generos = [...new Set(peliculas.map(p => p.genero))];
    const select = document.getElementById('listaDesplegableGenero');

    // Añadimos una opción "Todos" para resetear el filtro
    select.appendChild(new Option('Todos', ''));

    // Añadimos cada género al menú desplegable
    generos.forEach(genero => {
        select.appendChild(new Option(genero, genero));
    });
}

// Configura los eventos (como clics en botones y cambios en el menú desplegable)
function configurarEventos(peliculas) {
    // Evento para el menú desplegable de géneros
    document.getElementById('listaDesplegableGenero').addEventListener('change', e => {
        const generoSeleccionado = e.target.value;
        filtrarPorGenero(peliculas, generoSeleccionado);
    });

    // Evento para los botones de género (como "Animación", "Acción", etc.)
    document.querySelectorAll('.btnGenero').forEach(boton => {
        boton.addEventListener('click', () => {
            const generoSeleccionado = boton.textContent;
            filtrarPorGenero(peliculas, generoSeleccionado);
        });
    });

    // Evento para el botón de búsqueda por título
    document.getElementById('btnBuscar').addEventListener('click', () => {
        buscarPorTitulo(peliculas);
    });

    // Evento para ordenar las películas por año (ascendente o descendente)
    let ordenAscendente = true; // Empezamos ordenando de forma ascendente
    document.getElementById('btnAnio').addEventListener('click', () => {
        ordenAscendente = !ordenAscendente; // Cambiamos el orden
        ordenarPorAnio(peliculas, ordenAscendente);
    });
}

// Muestra las películas en la página
function mostrarPeliculas(peliculas) {
    const container = document.getElementById('listaPeliculas');
    const mensajeError = document.getElementById('mensajeNoResultados');

    // Si no hay películas que mostrar
    if (peliculas.length === 0) {
        container.innerHTML = ''; // Limpiamos el contenedor
        mensajeError.style.display = 'block'; // Mostramos un mensaje de error
        return;
    }

    // Si hay películas, las mostramos
    mensajeError.style.display = 'none'; // Ocultamos el mensaje de error
    container.innerHTML = peliculas.map(p => `
        <div class="pelicula">
            <img src="${p.imagen}" alt="${p.titulo}" class="pelicula-imagen">
            <div class="pelicula-info">
                <h3>${p.titulo}</h3>
                <p>${p.genero}</p>
                <p>Año: ${p.año}</p>
            </div>
        </div>
    `).join(''); // Convertimos el array de películas en un string HTML
}

// Filtra las películas por género
function filtrarPorGenero(peliculas, genero) {
    // Si hay un género seleccionado, filtramos las películas
    const filtradas = genero ? peliculas.filter(p => p.genero === genero) : peliculas;

    // Si no hay películas del género seleccionado, mostramos un mensaje
    if (genero && filtradas.length === 0) {
        alert(`No hay películas del género ${genero}`);
    }

    // Mostramos las películas filtradas
    mostrarPeliculas(filtradas);
}

// Busca películas por título
function buscarPorTitulo(peliculas) {
    const titulo = document.getElementById('campoBusquedaTitulo').value.toLowerCase();

    // Si no se escribió nada en la búsqueda, mostramos un mensaje
    if (!titulo) {
        alert('Escribe un título para buscar');
        return;
    }

    // Filtramos las películas que coincidan con el título
    const filtradas = peliculas.filter(p => p.titulo.toLowerCase().includes(titulo));

    // Si no se encontró ninguna película, mostramos un mensaje
    if (filtradas.length === 0) {
        alert(`No se encontró ninguna película con el título "${titulo}"`);
    }

    // Mostramos las películas filtradas
    mostrarPeliculas(filtradas);
}

// Ordena las películas por año (ascendente o descendente)
function ordenarPorAnio(peliculas, ascendente) {
    // Ordenamos las películas por año
    const ordenadas = [...peliculas].sort((a, b) => ascendente ? a.año - b.año : b.año - a.año);

    // Mostramos las películas ordenadas
    mostrarPeliculas(ordenadas);

    // Cambiamos el texto del botón para indicar el orden actual
    document.getElementById('btnAnio').textContent = `Ordenar por año ${ascendente ? '↑' : '↓'}`;
}