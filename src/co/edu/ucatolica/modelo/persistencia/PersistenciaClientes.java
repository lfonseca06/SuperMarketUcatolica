package co.edu.ucatolica.modelo.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import co.edu.ucatolica.modelo.Cliente;

public class PersistenciaClientes {
    private static final String RUTA_ARCHIVO = "./data/clientes.out";
    private List<Cliente> listaClientes;

    public PersistenciaClientes() {
        listaClientes = new ArrayList<>();
        cargarListaClientes(); // Cargar clientes al iniciar
    }

    public String guardarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        return guardarListaClientes();
    }

    public String guardarListaClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(listaClientes);
            return "Guardado Exitosamente";
        } catch (IOException ex) {
            return "Error al guardar la lista de clientes: " + ex.getMessage();
        }
    }

    public void cargarListaClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            listaClientes = (List<Cliente>) ois.readObject();
        } catch (EOFException ex) {
            listaClientes = new ArrayList<>(); // Retorna una lista vacía si el archivo está vacío
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al cargar la lista de clientes: " + ex.getMessage());
            listaClientes = new ArrayList<>(); // Retorna una lista vacía en caso de error
        }
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
