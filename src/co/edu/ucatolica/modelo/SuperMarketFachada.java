package co.edu.ucatolica.modelo;

import java.io.IOException;

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
			this.proveedorServicio=new Proveedor();
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
	            System.out.println("No se pudo guardar la configuración: " + e.getMessage());
	        }
	    }
	    
		public Cliente getClienteServicio() {
			return clienteServicio;
		}
	
		public void setClienteServicio(Cliente clienteServicio) {
			this.clienteServicio = clienteServicio;
		}
	
		// Getter y Setter para proveedorServicio
		public Proveedor getProveedorServicio() {
			return proveedorServicio;
		}
	
		public void setProveedorServicio(Proveedor proveedorServicio) {
			this.proveedorServicio = proveedorServicio;
		}
	
		// Getter y Setter para productoServicio
		public Producto getProductoServicio() {
			return productoServicio;
		}
	
		public void setProductoServicio(Producto productoServicio) {
			this.productoServicio = productoServicio;
		}
	
		// Getter y Setter para ventaServicio
		public Venta getVentaServicio() {
			return ventaServicio;
		}
	
		public void setVentaServicio(Venta ventaServicio) {
			this.ventaServicio = ventaServicio;
		}
	
		// Getter y Setter para compraServicio
		public Compra getCompraServicio() {
			return compraServicio;
		}
	
		public void setCompraServicio(Compra compraServicio) {
			this.compraServicio = compraServicio;
		}
	
		// Getter y Setter para reporteServicio
		public Reporte getReporteServicio() {
			return reporteServicio;
		}
	
		public void setReporteServicio(Reporte reporteServicio) {
			this.reporteServicio = reporteServicio;
		}
		
}

        

        

		   
	
