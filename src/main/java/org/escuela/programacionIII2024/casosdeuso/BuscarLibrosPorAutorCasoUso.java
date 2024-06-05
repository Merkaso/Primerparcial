package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarLibrosPorAutorCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public BuscarLibrosPorAutorCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public List<Libro> ejecutar(String nombreAutor) {
        return bibliotecaServicio.buscarLibrosPorAutor(nombreAutor);
    }
}
