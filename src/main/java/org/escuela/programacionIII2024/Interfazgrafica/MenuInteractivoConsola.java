package org.escuela.programacionIII2024.Interfazgrafica;

import org.escuela.programacionIII2024.casosdeuso.*;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicio.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuInteractivoConsola {

    private final AgregarLibroCasoUso agregarLibroCasoUso;
    private final EliminarLibroCasoUso eliminarLibroCasoUso;
    private final BuscarLibroPorNombreCasoUso buscarLibroPorNombreCasoUso;
    private final BuscarLibrosPorAutorCasoUso buscarLibrosPorAutorCasoUso;
    private final AgregarClienteCasoUso agregarClienteCasoUso;
    private final EliminarClienteCasoUso eliminarClienteCasoUso;
    private final MostrarClientesCasoUso mostrarClientesCasoUso;
    private final BibliotecaServicio bibliotecaServicio;

    @Autowired
    public MenuInteractivoConsola(AgregarLibroCasoUso agregarLibroCasoUso,
                                  EliminarLibroCasoUso eliminarLibroCasoUso,
                                  BuscarLibroPorNombreCasoUso buscarLibroPorNombreCasoUso,
                                  BuscarLibrosPorAutorCasoUso buscarLibrosPorAutorCasoUso,
                                  AgregarClienteCasoUso agregarClienteCasoUso,
                                  EliminarClienteCasoUso eliminarClienteCasoUso,
                                  MostrarClientesCasoUso mostrarClientesCasoUso,
                                  BibliotecaServicio bibliotecaServicio) {
        this.agregarLibroCasoUso = agregarLibroCasoUso;
        this.eliminarLibroCasoUso = eliminarLibroCasoUso;
        this.buscarLibroPorNombreCasoUso = buscarLibroPorNombreCasoUso;
        this.buscarLibrosPorAutorCasoUso = buscarLibrosPorAutorCasoUso;
        this.agregarClienteCasoUso = agregarClienteCasoUso;
        this.eliminarClienteCasoUso = eliminarClienteCasoUso;
        this.mostrarClientesCasoUso = mostrarClientesCasoUso;
        this.bibliotecaServicio = bibliotecaServicio;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @Bean
    public CommandLineRunner run() {
        return args -> {
            cargarDatosIniciales();
            mostrarMenu();
        };
    }

    private void cargarDatosIniciales() {
        // Cargar 10 libros de ejemplo
        bibliotecaServicio.agregarLibro(new Libro("Rayuela", new Persona("00000001", "Julio Cortázar"), "Novela"));
        bibliotecaServicio.agregarLibro(new Libro("Bestiario", new Persona("00000002", "Julio Cortázar"), "Cuento"));
        bibliotecaServicio.agregarLibro(new Libro("Final del juego", new Persona("00000003", "Julio Cortázar"), "Cuento"));
        bibliotecaServicio.agregarLibro(new Libro("Las armas secretas", new Persona("00000004", "Julio Cortázar"), "Cuento"));
        bibliotecaServicio.agregarLibro(new Libro("Cien años de soledad", new Persona("00000005", "Gabriel García Márquez"), "Novela"));
        bibliotecaServicio.agregarLibro(new Libro("El amor en los tiempos del cólera", new Persona("00000006", "Gabriel García Márquez"), "Novela"));
        bibliotecaServicio.agregarLibro(new Libro("Don Quijote de la Mancha", new Persona("00000007", "Miguel de Cervantes"), "Novela"));
        bibliotecaServicio.agregarLibro(new Libro("Matar a un ruiseñor", new Persona("00000008", "Harper Lee"), "Novela"));
        bibliotecaServicio.agregarLibro(new Libro("1984", new Persona("00000009", "George Orwell"), "Distopía"));
        bibliotecaServicio.agregarLibro(new Libro("Orgullo y prejuicio", new Persona("00000010", "Jane Austen"), "Novela"));

        // Cargar clientes de ejemplo
        bibliotecaServicio.agregarCliente(new Persona("001", "Juan Pérez"));
        bibliotecaServicio.agregarCliente(new Persona("002", "Ana García"));
        bibliotecaServicio.agregarCliente(new Persona("003", "Luis Martínez"));
    }

    private void mostrarMenu() {
        int opcion = 0;
        while (opcion != 9) { // 9 es la opción para salir
            try {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Mostrar todos los libros");
                System.out.println("4. Buscar libro por nombre");
                System.out.println("5. Buscar libro por autor");
                System.out.println("6. Agregar cliente");
                System.out.println("7. Eliminar cliente");
                System.out.println("8. Mostrar clientes");
                System.out.println("9. Salir");
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
                        buscarLibrosPorAutor();
                        break;
                    case 6:
                        agregarCliente();
                        break;
                    case 7:
                        eliminarCliente();
                        break;
                    case 8:
                        mostrarClientes();
                        break;
                    case 9:
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

    private void buscarLibrosPorAutor() {
        System.out.println("\n--- Buscar libros por autor ---");
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        List<Libro> libros = buscarLibrosPorAutorCasoUso.ejecutar(nombreAutor);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros del autor " + nombreAutor);
        } else {
            System.out.println("Libros del autor " + nombreAutor + ":");
            for (Libro libro : libros) {
                System.out.println("Nombre: " + libro.getNombre() + ", Género: " + libro.getGenero());
            }
        }
    }

    private void agregarCliente() {
        System.out.println("\n--- Agregar cliente ---");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();

        Persona cliente = new Persona(idCliente, nombreCliente);
        agregarClienteCasoUso.ejecutar(cliente);
        System.out.println("Cliente agregado: " + nombreCliente);
    }

    private void eliminarCliente() {
        System.out.println("\n--- Eliminar cliente ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String idCliente = scanner.nextLine();

        eliminarClienteCasoUso.ejecutar(idCliente);
        System.out.println("Cliente eliminado: " + idCliente);
    }

    private void mostrarClientes() {
        System.out.println("\n--- Lista de clientes ---");
        List<Persona> clientes = mostrarClientesCasoUso.ejecutar();
        for (Persona cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
        }
    }

}
