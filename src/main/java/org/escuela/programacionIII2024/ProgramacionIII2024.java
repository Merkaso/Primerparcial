package org.escuela.programacionIII2024;

import org.escuela.programacionIII2024.casosdeuso.AgregarLibroCasoUso;
import org.escuela.programacionIII2024.casosdeuso.EliminarLibroCasoUso;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProgramacionIII2024 {

    @Autowired
    private AgregarLibroCasoUso agregarLibroCasoUso;

    @Autowired
    private EliminarLibroCasoUso eliminarLibroCasoUso;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(ProgramacionIII2024.class, args);
    }

    @Bean
    public CommandLineRunner startApplication() {
        return args -> {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Mostrar todos los libros");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        eliminarLibro();
                        break;
                    case 3:
                        mostrarLibros();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
            System.out.println("¡Hasta luego!");
        };
    }

    private void agregarLibro() {
        System.out.println("\n--- Agregar libro ---");
        System.out.print("Ingrese el nombre del libro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();

        Persona autorPersona = new Persona("00000000", autor); // Asumimos un ID genérico
        Libro libro = new Libro(nombre, autorPersona, genero);
        agregarLibroCasoUso.ejecutar(libro);
        System.out.println("Libro agregado: " + nombre);
    }

    private void eliminarLibro() {
        System.out.println("\n--- Eliminar libro ---");
        System.out.print("Ingrese el nombre del libro a eliminar: ");
        String nombre = scanner.nextLine();

        eliminarLibroCasoUso.ejecutar(nombre);
    }

    private void mostrarLibros() {
        System.out.println("\n--- Lista de libros ---");
        // Implementar la lógica para mostrar libros
        // ...
    }
}
