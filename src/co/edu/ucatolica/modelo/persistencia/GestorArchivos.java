package co.edu.ucatolica.modelo.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.ucatolica.modelo.Producto;

public class GestorArchivos {

    // Método para guardar datos en un archivo de texto
    public static void guardarTexto(String rutaArchivo, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(contenido);
        }
    }

    // Método para leer datos desde un archivo de texto
    public static String leerTexto(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
        }
        return contenido.toString();
    }

    // Método para guardar un objeto en un archivo serializado
    public static void guardarSerializado(String rutaArchivo, Serializable objeto) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
        }
    }

    // Método para leer un objeto desde un archivo serializado
    public static Object leerSerializado(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        }
    }

    // Método para guardar una lista de objetos en un archivo de texto
    public static void guardarListaTexto(String rutaArchivo, List<String> lista) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String item : lista) {
                writer.write(item);
                writer.newLine();
            }
        }
    }

    // Método para leer una lista de objetos desde un archivo de texto
    public static List<String> leerListaTexto(String rutaArchivo) throws IOException {
        List<String> lista;
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            lista = reader.lines().toList();
        }
        return lista;
    }


    private static final String FILE_PATH = "./data/productos.dat";

    public static void eliminarProductoCodigo(String productoBorrar) throws IOException {
        try {
            List<Producto> productosExis = cargarProductos();
            productosExis.removeIf(prod -> prod.getCodigo().equals(productoBorrar));
            guardarListaProductos(productosExis);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    public static void actualizarProducto(Producto productosNew) throws IOException {
        try {
            List<Producto> productosExis = cargarProductos();
            boolean productoEncontrado = false;
            for (Producto produExis : productosExis) {
                if (produExis.getCodigo().equals(productosNew.getCodigo())) {
                    produExis.setCodigo(productosNew.getCodigo());
                    produExis.setNITProveedor(productosNew.getNITProveedor());
                    produExis.setNombre(productosNew.getNombre());
                    produExis.setPrecioCompra(productosNew.getPrecioCompra());
                    produExis.setPrecioVenta(productosNew.getPrecioVenta());
                    productoEncontrado = true;
                    break;
                }
            }
            if (!productoEncontrado) {
                productosExis.add(productosNew);
            }
            guardarListaProductos(productosExis);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public static void guardarProducto(Producto productosNew) throws IOException {
        try {
            List<Producto> productosExis = cargarProductos();
            productosExis.add(productosNew);
            guardarListaProductos(productosExis);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }

    public static List<Producto> cargarProductos() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Producto>) ois.readObject();
        }
    }

    private static void guardarListaProductos(List<Producto> productos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(productos);
        }
    }

    public static boolean existeProducto(String codigo) throws IOException {
        try {
            List<Producto> productos = cargarProductos();
            return productos.stream().anyMatch(prod -> prod.getCodigo().equals(codigo));
        } catch (ClassNotFoundException e) {
            System.out.println("Error al verificar existencia del producto: " + e.getMessage());
            return false;
        }
    }
}

