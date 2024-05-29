package co.edu.ucatolica.modelo;

public class SuperMarketFachada {
	
	    
	    
	    private Cliente clienteServicio;
	    private Proveedor proveedorServicio;
	    private Producto productoServicio;
	    private Venta ventaServicio;
	    private Compra compraServicio;
	    private Reporte reporteServicio;

	    public SuperMarketFachada() {
	        this.clienteServicio = new Cliente();
			this.proveedorServicio=new Proveedor();
	        this.productoServicio = new Producto();
	        this.ventaServicio = new Venta();
	        this.compraServicio = new Compra();
	        this.reporteServicio = new Reporte();
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

        

        

		   
	
