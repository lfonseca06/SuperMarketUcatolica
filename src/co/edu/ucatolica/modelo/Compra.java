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
    private List<Producto> productosComprados = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();
    private double valorTotalGeneral = 0;
    
    
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
}