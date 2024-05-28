package org.escuela.programacionIII2024.Interfazgrafica;

import org.escuela.programacionIII2024.casosdeuso.AgregarLibroCasoUso;
import org.escuela.programacionIII2024.casosdeuso.EliminarLibroCasoUso;
import org.escuela.programacionIII2024.casosdeuso.BuscarLibroPorNombreCasoUso;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuInteractivoConsola {

    private final AgregarLibroCasoUso agregarLibroCasoUso;
    private final EliminarLibroCasoUso eliminarLibroCasoUso;
    private final BuscarLibroPorNombreCasoUso buscarLibroPorNombreCasoUso;
    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public MenuInteractivoConsola(AgregarLibroCasoUso agregarLibroCasoUso, EliminarLibroCasoUso eliminarLibroCasoUso, BuscarLibroPorNombreCasoUso buscarLibroPorNombreCasoUso, BibliotecaServicio bibliotecaServicio) {
        this.agregarLibroCasoUso = agregarLibroCasoUso;
        this.eliminarLibroCasoUso = eliminarLibroCasoUso;
        this.buscarLibroPorNombreCasoUso = buscarLibroPorNombreCasoUso;
        this.bibliotecaServicio = bibliotecaServicio;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @Bean
    public CommandLineRunner run() {
        return args -> {
            mostrarMenu();
        };
    }

    private void mostrarMenu() {
        int opcion = 0;
        while (opcion != 5) {
            try {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Mostrar todos los libros");
                System.out.println("4. Buscar libro por nombre");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(scanner.nextLine().trim());

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
                        buscarLibroPorNombre();
                        break;
                    case 5:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    private void agregarLibro() {
        System.out.println("\n--- Agregar libro ---");
        System.out.print("Ingrese el nombre del libro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();

        Persona autor = new Persona("00000000", nombreAutor); // ID genérico para el autor
        Libro libro = new Libro(nombre, autor, genero);
        agregarLibroCasoUso.ejecutar(libro);
        System.out.println("Libro agregado: " + nombre);
    }

    private void eliminarLibro() {
        System.out.println("\n--- Eliminar libro ---");
        System.out.print("Ingrese el nombre del libro a eliminar: ");
        String nombre = scanner.nextLine();

        eliminarLibroCasoUso.ejecutar(nombre);
        System.out.println("Libro eliminado: " + nombre);
    }

    private void mostrarLibros() {
        System.out.println("\n--- Lista de libros ---");
        bibliotecaServicio.listarLibros();
    }

    private void buscarLibroPorNombre() {
        System.out.println("\n--- Buscar libro por nombre ---");
        System.out.print("Ingrese el nombre del libro a buscar: ");
        String nombre = scanner.nextLine();

        Optional<Libro> libroOpt = buscarLibroPorNombreCasoUso.ejecutar(nombre);
        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            System.out.println("Libro encontrado: ");
            System.out.println("Nombre: " + libro.getNombre());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Género: " + libro.getGenero());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
