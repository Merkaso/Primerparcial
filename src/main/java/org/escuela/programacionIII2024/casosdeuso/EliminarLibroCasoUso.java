package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EliminarLibroCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public EliminarLibroCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public void ejecutar(String nombre) {
        bibliotecaServicio.eliminarLibro(nombre);
    }
}
