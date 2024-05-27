package org.escuela.programacionIII2024.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Biblioteca {
    private List<Libro> libros;
    private List<Persona> personas;

    public void agregarLibro(Libro libro) {
    }
}
