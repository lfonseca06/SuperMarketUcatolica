package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.controlador.Controlador;

public class VentanaConsultas extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnListadoClientes;
    private JButton btnTotalVentasPorCliente;
    private JButton btnDetalleVentasPorCliente;
    private JButton btnTotalComprasPorProveedor;
    private JButton btnDetalleChequesExpedidos;
    private JButton btnGenerarReportePDF;
    private JButton btnGenerarReporteExcel;
	
	private Controlador controlador;
	

    public VentanaConsultas() {
        setTitle("Consultas y Reportes");
        setSize(400, 300);
        setLayout(new GridLayout(7, 1));

        btnListadoClientes = new JButton("Listado de Clientes");
        add(btnListadoClientes);

        btnTotalVentasPorCliente = new JButton("Total de Ventas por Cliente");
        add(btnTotalVentasPorCliente);

        btnDetalleVentasPorCliente = new JButton("Detalle de Ventas por Cliente");
        add(btnDetalleVentasPorCliente);

        btnTotalComprasPorProveedor = new JButton("Total de Compras por Proveedor");
        add(btnTotalComprasPorProveedor);

        btnDetalleChequesExpedidos = new JButton("Detalle de Cheques Expedidos");
        add(btnDetalleChequesExpedidos);

        btnGenerarReportePDF = new JButton("Generar Reporte PDF");
        add(btnGenerarReportePDF);

        btnGenerarReporteExcel = new JButton("Generar Reporte Excel");
        add(btnGenerarReporteExcel);
    }

	
	public void setControlador(Controlador controlador) {
	    this.controlador = controlador;
	}
}
