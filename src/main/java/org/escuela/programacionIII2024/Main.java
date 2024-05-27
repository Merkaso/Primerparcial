package org.escuela.programacionIII2024;

import org.escuela.programacionIII2024.casosdeuso.AgregarLibroCasoUso;
import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProgramacionIII20242 {

    @Autowired
    private AgregarLibroCasoUso agregarLibroCasoUso;

    public static void main(String[] args) {
        SpringApplication.run(ProgramacionIII20242.class, args);
    }

    @Bean
    public CommandLineRunner run(AgregarLibroCasoUso agregarLibroCasoUso) {
        return args -> {
            List<Libro> libros = new ArrayList<>();
            libros.add(new Libro("Libro1", new Persona("12123123", "Autor 1"), "Ficción"));

            List<Persona> personas = new ArrayList<>();
            personas.add(new Persona("33345678", "Cliente Uno"));

            Biblioteca biblioteca = new Biblioteca(libros, personas);

            // Agregamos un libro nuevo a la biblioteca
            Persona autor = new Persona("22334455", "Nuevo Autor");
            Libro nuevoLibro = new Libro("Nuevo Libro", autor, "Aventura");
            agregarLibroCasoUso.ejecutar(nuevoLibro);
            System.out.println("Libro agregado: " + nuevoLibro.getNombre());

            // Puedes continuar agregando los otros casos de uso aquí
            // ...
        };
    }
}
