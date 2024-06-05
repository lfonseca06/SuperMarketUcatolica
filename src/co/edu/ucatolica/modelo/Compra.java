package co.edu.ucatolica.modelo;


import co.edu.ucatolica.modelo.persistencia.ArchivosBinariosProveedor;
import co.edu.ucatolica.modelo.persistencia.GestorArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;



public class Compra{
    private static final long serialVersionUID = 1L;
	private String codigoCompra;
	private String NITProveedor;
    private double valorTotal;
    private double valorIVA;
    private double valorTotalConIVA;
    private List<DetalleCompra> detalles;
    private List<Producto> productosComprados = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();
    private double valorTotalGeneral = 0;
    
    
    // Otros atributos y métodos de la clase Compra

    public int leerIVA() {
        int iva = 0;
        try {
            Tienda tienda = new Tienda();
            tienda.cargarConfiguracion(); // Carga la configuración desde el archivo config.dat
            iva = (int) tienda.getValorIVA();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iva;
    }

    public String leerBanco() {
        String banco = "";
        try {
            Tienda tienda = new Tienda();
            tienda.cargarConfiguracion(); // Carga la configuración desde el archivo config.dat
            banco = tienda.getNombreBanco();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return banco;
    }

    public String leerCuenta() {
        String cuenta = "";
        try {
            Tienda tienda = new Tienda();
            tienda.cargarConfiguracion(); // Carga la configuración desde el archivo config.dat
            cuenta = tienda.getNumeroCuenta();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cuenta;
    }

    public String leerNITTienda() {
        String nitTienda = "";
        try {
            Tienda tienda = new Tienda();
            tienda.cargarConfiguracion(); // Carga la configuración desde el archivo config.dat
            nitTienda = tienda.getNIT();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nitTienda;
    }
    public String leerGerente() {
        String nombreGerente = "";
        try {
            Tienda tienda = new Tienda();
            tienda.cargarConfiguracion(); // Carga la configuración desde el archivo config.dat
            nombreGerente = tienda.getNombreGerente();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombreGerente;
    }
    
    public void generarCodigoCompra() {
        this.codigoCompra = GeneradorCodigo.generarCodigoCompra();
    }

    public String getCodigo() {
        return codigoCompra;
    }
    
    public void generarCheque(int consecutivo, String nombreProveedor, int valorTotalConIVA, String nombreBanco, String numeroCuenta) {
        Cheque cheque = new Cheque(consecutivo, nombreProveedor, valorTotalConIVA, nombreBanco, numeroCuenta);
        try {
            // Generar el cheque
            cheque.guardarChequeArchivo("./data/cheque_" + consecutivo + ".txt");
            System.out.println("Cheque generado correctamente con consecutivo " + consecutivo);
        } catch (IOException e) {
            System.out.println("Error al generar el cheque: " + e.getMessage());
        }
    }

    public String leerCheque(int consecutivo) {
        try {
            // Leer el cheque
            String contenidoCheque = GestorArchivos.leerTexto("./data/cheque_" + consecutivo + ".txt");
            return contenidoCheque;
        } catch (IOException e) {
            System.out.println("Error al leer el cheque: " + e.getMessage());
            return null; // Retornar null en caso de error
        }
    }
 
   

   
        // Otros atributos y métodos de la clase Compra...

    // Método para guardar la compra en archivo sin sobrescribir
    public void guardarCompraEnArchivo(String rutaArchivo) throws IOException {
        String contenido = String.format("%s,%s,%.2f,%.2f,%.2f%n", codigoCompra, NITProveedor, valorTotal, valorIVA, valorTotalConIVA);
        agregarTextoArchivo(rutaArchivo, contenido);
    }

    // Método para guardar el detalle de la compra en archivo sin sobrescribir
    public void guardarDetalleCompraEnArchivo(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < productosComprados.size(); i++) {
            Producto producto = productosComprados.get(i);
            int cantidad = cantidades.get(i);
            double valorTotalItem = producto.getPrecioCompra() * cantidad;
            contenido.append(String.format("%s,%d,%.2f,%s%n", producto.getCodigo(), cantidad, valorTotalItem, codigoCompra));
        }
        agregarTextoArchivo(rutaArchivo, contenido.toString());
    }

    // Método para guardar el cheque en archivo sin sobrescribir
    public void guardarChequeEnArchivo(String rutaArchivo, int consecutivoCheque) throws IOException {
        String contenido = String.format("%d,%s,%s,%.2f%n", consecutivoCheque, codigoCompra, NITProveedor, valorTotalConIVA);
        agregarTextoArchivo(rutaArchivo, contenido);
    }
 // Método auxiliar para agregar texto a un archivo
    private void agregarTextoArchivo(String rutaArchivo, String contenido) throws IOException {
        try (FileWriter fileWriter = new FileWriter(rutaArchivo, true)) {
            fileWriter.write(contenido);
        }
    }
    public void agregarProducto(String codigoProducto, int cantidad) {
        List<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigoProducto)) {
                productosComprados.add(producto);
                cantidades.add(cantidad);
                valorTotalGeneral += cantidad * producto.getPrecioVenta();
                break;
            }
        }
    }

    public double getValorTotalGeneral() {
        return valorTotalGeneral;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    
	public static Proveedor[] leerProveedores() {
        Proveedor[] proveedores = ArchivosBinariosProveedor.leerArchivoBinarioProveedores();
        if (proveedores == null) {
            System.out.println("No se pudieron leer proveedores o el archivo está vacío.");
        }
        System.out.println(proveedores);
        return proveedores;
    }

    public static List<Producto> leerProductos() {
        List<Producto> productos = null;
        try {
            productos = GestorArchivos.cargarProductos();
            System.out.println(productos);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los productos: " + e.getMessage());
        }
        return productos;
    } 
    
    public Proveedor buscarProveedor(String nit) {
        Proveedor[] proveedores = leerProveedores();
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNIT().equals(nit)) {
                return proveedor;
            }
        }
        return null;
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
    
    public List<String> obtenerNombresProductosPorNITProveedor(String nitProveedor) {
        List<String> nombresProductos = new ArrayList<>();
        List<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (producto.getNITProveedor().equals(nitProveedor)) {
                nombresProductos.add(producto.getNombre());
            }
        }
        return nombresProductos;
    }
    
    public List<String> obtenerCodigosProductosPorNITProveedor(String nitProveedor) {
        List<String> codigosProductos = new ArrayList<>();
        List<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (producto.getNITProveedor().equals(nitProveedor)) {
                codigosProductos.add(producto.getCodigo());
            }
        }
        return codigosProductos;
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        productosComprados.add(producto);
        cantidades.add(cantidad);
    }
    
    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : leerProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
    public void setValorTotalConIVA(double val){
        valorTotalConIVA=val;
    }
    public double getValorTotalConIVA(){
        return valorTotalConIVA;
    }
    
    
}