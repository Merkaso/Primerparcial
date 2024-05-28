package org.escuela.programacionIII2024.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Biblioteca {
    private List<Libro> libros;

    @PostConstruct
    public void init() {
        if (libros == null) {
            libros = new ArrayList<>();
        }
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String nombre) {
        libros.removeIf(libro -> libro.getNombre().equals(nombre));
    }

    public List<Libro> listarLibros() {
        return libros;
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre) {
        return libros.stream()
                .filter(libro -> libro.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
