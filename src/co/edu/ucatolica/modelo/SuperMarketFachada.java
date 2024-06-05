package co.edu.ucatolica.modelo;

import co.edu.ucatolica.modelo.persistencia.GestorArchivos;
import java.io.IOException;
import java.util.List;

public class SuperMarketFachada {

    private Cliente clienteServicio;
    private Proveedor proveedorServicio;
    private Producto productoServicio;
    private Venta ventaServicio;
    private Compra compraServicio;
    private Reporte reporteServicio;
    private Tienda tienda;

    public SuperMarketFachada() {
        this.clienteServicio = new Cliente();
        this.proveedorServicio = new Proveedor();
        this.productoServicio = new Producto();
        this.ventaServicio = new Venta();
        this.compraServicio = new Compra();
        this.reporteServicio = new Reporte();

        tienda = new Tienda();
        try {
            tienda.cargarConfiguracion();
        } catch (IOException e) {
            System.out.println("No se pudo cargar la configuración: " + e.getMessage());
        }
    }

    public boolean existeEmpresa() {
        return Tienda.existeEmpresa();
    }

    public void crearParametros(String nombre, String tipoComercio, String NIT, String ciudad, double valorIVA, double tasaInteres, String nombreBanco, String numeroCuenta, String nombreGerente) {
        tienda.setNombre(nombre);
        tienda.setTipoComercio(tipoComercio);
        tienda.setNIT(NIT);
        tienda.setCiudad(ciudad);
        tienda.setValorIVA(valorIVA);
        tienda.setTasaInteres(tasaInteres);
        tienda.setNombreBanco(nombreBanco);
        tienda.setNumeroCuenta(numeroCuenta);
        tienda.setNombreGerente(nombreGerente);

        try {
            tienda.guardarConfiguracion();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar la configuración: " + e.getMessage());
        }
    }

    public void modificarParametros(String nombre, String tipoComercio, String NIT, String ciudad, double valorIVA, double tasaInteres, String nombreBanco, String numeroCuenta, String nombreGerente) {
        tienda.setNombre(nombre);
        tienda.setTipoComercio(tipoComercio);
        tienda.setNIT(NIT);
        tienda.setCiudad(ciudad);
        tienda.setValorIVA(valorIVA);
        tienda.setTasaInteres(tasaInteres);
        tienda.setNombreBanco(nombreBanco);
        tienda.setNumeroCuenta(numeroCuenta);
        tienda.setNombreGerente(nombreGerente);

        try {
            tienda.guardarConfiguracion();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar la configuración: " + e.getMessage());
        }
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        try {
            List<Producto> productos = GestorArchivos.cargarProductos();
            for (Producto producto : productos) {
                if (producto.getCodigo().equals(codigo)) {
                    return producto;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int leerIVA() {
        return (int) tienda.getValorIVA();
    }

    public double leerTasaInteres() {
        return tienda.getTasaInteres();
    }

    public void registrarVenta(String cedulaCliente, double valorTotal, double valorIVA, double valorTotalConIVA, List<Producto> productos, List<Integer> cantidades) throws IOException {
        ventaServicio.registrarVenta(cedulaCliente, valorTotal, valorIVA, valorTotalConIVA, productos, cantidades);
    }

    public void registrarCredito(Credito credito) throws IOException {
        GestorArchivos.guardarCredito(credito);
    }

    // Getters y Setters para los servicios
    public Cliente getClienteServicio() {
        return clienteServicio;
    }

    public void setClienteServicio(Cliente clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public Proveedor getProveedorServicio() {
        return proveedorServicio;
    }

    public void setProveedorServicio(Proveedor proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    public Producto getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(Producto productoServicio) {
        this.productoServicio = productoServicio;
    }

    public Venta getVentaServicio() {
        return ventaServicio;
    }

    public void setVentaServicio(Venta ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    public Compra getCompraServicio() {
        return compraServicio;
    }

    public void setCompraServicio(Compra compraServicio) {
        this.compraServicio = compraServicio;
    }

    public Reporte getReporteServicio() {
        return reporteServicio;
    }

    public void setReporteServicio(Reporte reporteServicio) {
        this.reporteServicio = reporteServicio;
    }

    public Tienda getTienda() {
        return tienda;
    }
}
   
	
