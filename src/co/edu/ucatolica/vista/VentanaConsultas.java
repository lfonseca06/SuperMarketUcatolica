package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.ucatolica.modelo.Cliente;
import co.edu.ucatolica.modelo.Reporte;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaConsultas extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JButton btnListadoClientes;
    private JButton btnTotalVentasPorCliente;
    private JButton btnDetalleVentasPorCliente;
    private JButton btnTotalComprasPorProveedor;
    private JButton btnDetalleChequesExpedidos;
    //private JButton btnGenerarReportePDF;
    //private JButton btnGenerarReporteExcel;
    
    private SuperMarketFachada fachada;
    private VistaReporte vistaReporte;
    
    public VentanaConsultas(Reporte reporte) {
    	
        this.setFachada(fachada);
        this.vistaReporte = new VistaReporte();
        
        setTitle("Consultas y Reportes");
        setSize(400, 300);
        setLayout(new GridLayout(7, 1));
        
        //Mostrar consulta de listado clientes
        btnListadoClientes = new JButton("Listado de Clientes");
        btnListadoClientes.addActionListener(e -> {
        	vistaReporte.mostrarPanelClientes();
        	vistaReporte.setVisible(true);

        });
        add(btnListadoClientes);
        
        //Mostrar consulta detotal de ventas por cliente
        btnTotalVentasPorCliente = new JButton("Total de Ventas por Cliente");
        btnTotalVentasPorCliente.addActionListener(e -> {
        	vistaReporte.mostrarPanelTotalVentasCliente();
        	vistaReporte.setVisible(true);
        });
        add(btnTotalVentasPorCliente);    
        
        //Mostrar consulta del detalle de ventas por cliente
        btnDetalleVentasPorCliente = new JButton("Detalle de Venta por Cliente");
        btnDetalleVentasPorCliente.addActionListener(e -> {
        	vistaReporte.mostrarDetalleVentasCliente();
        	vistaReporte.setVisible(true);  	
        });
        add(btnDetalleVentasPorCliente); 
        
        //Mostrar consulta del total compras por proveedor
        btnTotalComprasPorProveedor = new JButton("Total Compras por Proveedor");
        btnTotalComprasPorProveedor.addActionListener(e -> {
        	vistaReporte.mostrarTotalComprasProveedor();
        	vistaReporte.setVisible(true);
        });
        add(btnTotalComprasPorProveedor); 
        
        //Mostrar consulta del detalle cheques expedidos
        btnDetalleChequesExpedidos = new JButton("Detalle Cheques Expedidos");
        btnDetalleChequesExpedidos.addActionListener(e -> {
        	vistaReporte.mostrarDetalleChequesExpedidos();
        	vistaReporte.setVisible(true);
        });
        add(btnDetalleChequesExpedidos); 
        
    }
    

    // Getters and Setters

	public JButton getBtnListadoClientes() {
		return btnListadoClientes;
	}
	
	public void setBtnListadoClientes(JButton btnListadoClientes) {
		this.btnListadoClientes = btnListadoClientes;
	}
	
	
	public JButton getBtnTotalVentasPorCliente() {
		return btnTotalVentasPorCliente;
	}

	public void setBtnTotalVentasPorCliente(JButton btnTotalVentasPorCliente) {
		this.btnTotalVentasPorCliente = btnTotalVentasPorCliente;
	}
	
	
	public JButton getBtnDetalleVentasPorCliente() {
		return btnDetalleVentasPorCliente;
	}

	public void setBtnDetalleVentasPorCliente(JButton btnDetalleVentasPorCliente) {
		this.btnDetalleVentasPorCliente = btnDetalleVentasPorCliente;
	}
    
	
	public JButton getBtnTotalComprasPorProveedor() {
		return btnTotalComprasPorProveedor;
	}

	public void setBtnTotalComprasPorProveedor(JButton btnTotalComprasPorProveedor) {
		this.btnTotalComprasPorProveedor = btnTotalComprasPorProveedor;
	}
	
	
	public JButton getBtnDetalleChequesExpedidos() {
		return btnDetalleChequesExpedidos;
	}

	public void setBtnDetalleChequesExpedidos(JButton btnDetalleChequesExpedidos) {
		this.btnDetalleChequesExpedidos = btnDetalleChequesExpedidos;
	}


	public SuperMarketFachada getFachada() {
		return fachada;
	}


	public void setFachada(SuperMarketFachada fachada) {
		this.fachada = fachada;
	}

}


