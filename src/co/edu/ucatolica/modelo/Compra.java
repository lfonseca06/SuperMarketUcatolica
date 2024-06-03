package co.edu.ucatolica.modelo;



import co.edu.ucatolica.modelo.persistencia.ArchivosBinariosProveedor;
import co.edu.ucatolica.modelo.persistencia.GestorArchivos;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Compra{
    private static final long serialVersionUID = 1L;
	private String codigo;
    private String NITProveedor;
    private double valorTotal;
    private double valorIVA;
    private double valorTotalConIVA;
    private List<DetalleCompra> detalles;

    public static String[] comboboX(List<Producto> nitsFiltados){
        String[] nitProductos= new String[nitsFiltados.size()];
        int indice=0;
        for (Producto producto:nitsFiltados){
            nitProductos[indice]=producto.getNITProveedor();
            indice++;
        }
        return nitProductos;
    }
	public static Proveedor[] leerProveedores() {
        Proveedor[] proveedores = ArchivosBinariosProveedor.leerArchivoBinarioProveedores();
        if (proveedores == null) {
            System.out.println("No se pudieron leer proveedores o el archivo está vacío.");
        }
        return proveedores;
    }

    public static List<Producto> leerProductos() {
        List<Producto> productos = null;
        try {
            productos = GestorArchivos.cargarProductos();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los productos: " + e.getMessage());
        }
        System.err.println(productos);
        return productos;
    } 
    
    
    public static List<Producto> quiarNitsNoIguales() {
        Proveedor[] prov = leerProveedores();
        List<Producto> produc = leerProductos();
        List<String> productosNit=new ArrayList<>();
        List<Producto> productosValidos = new ArrayList<>();

        for (Producto producto :produc){
            productosNit.add(producto.getNITProveedor());
        }
        for (Proveedor proveedor : prov) {
            if (productosNit.contains(proveedor.getNIT())){
                for (Producto producto :produc){
                    if (producto.getNITProveedor().equals(proveedor.getNIT())){
                        productosValidos.add(producto);
                    }
                } 
            }
        }

        return productosValidos;
    }
    public static void main(String[] args){
        leerProductos();
        
    }
}