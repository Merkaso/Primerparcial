package org.escuela.programacionIII2024.modelo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Biblioteca {

    private List<Libro> libros;
    private List<Persona> clientes;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String nombre) {
        libros.removeIf(libro -> libro.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre) {
        return libros.stream().filter(libro -> libro.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // Métodos para manejar clientes
    public void agregarCliente(Persona cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(String idCliente) {
        clientes.removeIf(cliente -> cliente.getId().equalsIgnoreCase(idCliente));
    }

    public List<Persona> listarClientes() {
        return clientes;
    }
}
