package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgregarLibroCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public AgregarLibroCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public void ejecutar(Libro libro) {
        bibliotecaServicio.agregarLibro(libro);
    }
}
