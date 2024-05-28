package org.escuela.programacionIII2024.servicio;

import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BibliotecaServicio {

    private final Biblioteca biblioteca;

    @Autowired
    public BibliotecaServicio(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void agregarLibro(Libro libro) {
        biblioteca.agregarLibro(libro);
    }

    public void eliminarLibro(String nombre) {
        biblioteca.eliminarLibro(nombre);
    }

    public void listarLibros() {
        for (Libro libro : biblioteca.listarLibros()) {
            System.out.println("Nombre: " + libro.getNombre() + ", Autor: " + libro.getAutor().getNombre() + ", Género: " + libro.getGenero());
        }
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre) {
        return biblioteca.buscarLibroPorNombre(nombre);
    }
}
