package org.escuela.programacionIII2024.servicio;

import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
