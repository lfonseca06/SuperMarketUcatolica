package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaConsultas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnListadoClientes;
    private JButton btnTotalVentasPorCliente;
    private JButton btnDetalleVentasPorCliente;
    private JButton btnTotalComprasPorProveedor;
    private JButton btnDetalleChequesExpedidos;
    private JButton btnGenerarReportePDF;
    private JButton btnGenerarReporteExcel;

    private SuperMarketFachada fachada;

    public VentanaConsultas(SuperMarketFachada fachada) {
        this.fachada = fachada;
        setTitle("Consultas y Reportes");
        setSize(400, 300);
        setLayout(new GridLayout(7, 1));

        btnListadoClientes = new JButton("Listado de Clientes");
        btnListadoClientes.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.mostrarListadoClientes();
        });
        add(btnListadoClientes);

        btnTotalVentasPorCliente = new JButton("Total de Ventas por Cliente");
        btnTotalVentasPorCliente.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.mostrarTotalVentasPorCliente();
        });
        add(btnTotalVentasPorCliente);

        btnDetalleVentasPorCliente = new JButton("Detalle de Ventas por Cliente");
        btnDetalleVentasPorCliente.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.mostrarDetalleVentasPorCliente();
        });
        add(btnDetalleVentasPorCliente);

        btnTotalComprasPorProveedor = new JButton("Total de Compras por Proveedor");
        btnTotalComprasPorProveedor.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.mostrarTotalComprasPorProveedor();
        });
        add(btnTotalComprasPorProveedor);

        btnDetalleChequesExpedidos = new JButton("Detalle de Cheques Expedidos");
        btnDetalleChequesExpedidos.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.mostrarDetalleChequesExpedidos();
        });
        add(btnDetalleChequesExpedidos);

        btnGenerarReportePDF = new JButton("Generar Reporte PDF");
        btnGenerarReportePDF.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.generarReportePDF();
        });
        add(btnGenerarReportePDF);

        btnGenerarReporteExcel = new JButton("Generar Reporte Excel");
        btnGenerarReporteExcel.addActionListener(e -> {
            // Llamar al método correspondiente en la fachada
            //fachada.generarReporteExcel();
        });
        add(btnGenerarReporteExcel);
    }
}
