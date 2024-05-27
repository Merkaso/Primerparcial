package org.escuela.programacionIII2024.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
    private String nombre;
    private Persona autor;
    private String genero;
}
