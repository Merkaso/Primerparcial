package org.escuela.programacionIII2024.Interfazgrafica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuInteractivoConsola {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
        System.out.println("¡Hasta luego!");
    }

    private static void agregarLibro() {
        System.out.println("\n--- Agregar libro ---");
        System.out.print("Ingrese el nombre del libro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();

        libros.add(new Libro(nombre, autor, genero));
        System.out.println("Libro agregado correctamente.");
    }

    private static void mostrarLibros() {
        System.out.println("\n--- Lista de libros ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                System.out.println((i + 1) + ". " + libro.getNombre() + " - " + libro.getAutor() + " - " + libro.getGenero());
            }
        }
    }

    private static class Libro {
        private final String nombre;
        private final String autor;
        private final String genero;

        public Libro(String nombre, String autor, String genero) {
            this.nombre = nombre;
            this.autor = autor;
            this.genero = genero;
        }

        public String getNombre() {
            return nombre;
        }

        public String getAutor() {
            return autor;
        }

        public String getGenero() {
            return genero;
        }
    }
}
