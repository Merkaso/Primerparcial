package org.escuela.programacionIII2024.casosdeuso;

import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgregarClienteCasoUso {

    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public AgregarClienteCasoUso(BibliotecaServicio bibliotecaServicio) {
        this.bibliotecaServicio = bibliotecaServicio;
    }

    public void ejecutar(Persona cliente) {
        bibliotecaServicio.agregarCliente(cliente);
    }
}
