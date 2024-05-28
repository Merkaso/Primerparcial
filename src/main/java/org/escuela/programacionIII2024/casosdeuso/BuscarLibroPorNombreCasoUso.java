package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarLibroPorNombreCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public BuscarLibroPorNombreCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public Optional<Libro> ejecutar(String nombre) {
        return bibliotecaServicio.buscarLibroPorNombre(nombre);
    }
}
