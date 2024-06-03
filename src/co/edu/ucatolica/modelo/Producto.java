package co.edu.ucatolica.modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.ucatolica.modelo.persistencia.GestorArchivos;

public class Producto implements Serializable {
    private String codigo;
    private String nombre;
    private String NITProveedor;
    private double precioCompra;
    private double precioVenta;
    private static List<Producto> productos = new ArrayList<>();

    // Getters y Setters
    public static Producto crarProducto(){
        return new Producto();

    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNITProveedor() {
        return NITProveedor;
    }

    public void setNITProveedor(String NITProveedor) {
        this.NITProveedor = NITProveedor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public static List<Producto> obtenerProductos() {
        return new ArrayList<>(productos);
    }

    public static Producto buscarProducto(String codigo) {
        return productos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    public static void GestorArchivosguardarProductos(List<Producto> productos) throws IOException{
          GestorArchivos.guardarProductos(productos);

    }
    public static void actualizarProducto(Producto producto) {
        Producto prod = buscarProducto(producto.getCodigo());
        if (prod != null) {
            prod.setNombre(producto.getNombre());
            prod.setNITProveedor(producto.getNITProveedor());
            prod.setPrecioCompra(producto.getPrecioCompra());
            prod.setPrecioVenta(producto.getPrecioVenta());
        }
    }

    public static void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public static  List<Producto> gestorArchivosCargarProductos() throws ClassNotFoundException, IOException{
        return (GestorArchivos.cargarProductos());
    }
    
    public static boolean existeProducto(String codigo) {
        return productos.stream().anyMatch(p -> p.getCodigo().equals(codigo));
    }
  
    public String toString(){
        return (codigo+" " +nombre+" "+ NITProveedor+" "+
        Double.toString(precioCompra)+" "+Double.toString(precioVenta));

    }
}