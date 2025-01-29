// Importamos la función inicializarApp desde index.js
import { inicializarApp } from './index.js';

// Evento que se ejecuta cuando el DOM está completamente cargado
document.addEventListener('DOMContentLoaded', async () => {
    try {
        // Cargamos los datos del archivo JSON
        const response = await fetch('peliculas.json');
        const peliculas = await response.json();

        // Inicializamos la aplicación con los datos cargados
        inicializarApp(peliculas);
    } catch (error) {
        console.error('Error al cargar las películas:', error);
        document.getElementById('mensajeNoResultados').style.display = 'block'; // Mostramos un mensaje de error
    }
});