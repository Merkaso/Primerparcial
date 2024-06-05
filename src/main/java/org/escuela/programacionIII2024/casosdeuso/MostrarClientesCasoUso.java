package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MostrarClientesCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public MostrarClientesCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public List<Persona> ejecutar() {
        return bibliotecaServicio.listarClientes();
    }
}
