package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnClientes;
    private JButton btnProveedores;
    private JButton btnProductos;
    private JButton btnVentas;
    private JButton btnCompras;
    private JButton btnConsultas;
    private JButton btnParametros;

    public VentanaPrincipal() {
        setTitle("UCatolica Market");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        btnClientes = new JButton("Gestión de Clientes");
        btnProveedores = new JButton("Gestión de Proveedores");
        btnProductos = new JButton("Gestión de Productos");
        btnVentas = new JButton("Gestión de Ventas");
        btnCompras = new JButton("Gestión de Compras");
        btnConsultas = new JButton("Consultas y Reportes");
        btnParametros = new JButton("Parámetros de la Tienda");

        panel.add(btnClientes);
        panel.add(btnProveedores);
        panel.add(btnProductos);
        panel.add(btnVentas);
        panel.add(btnCompras);
        panel.add(btnConsultas);
        panel.add(btnParametros);

        add(panel);
    }

    public void setControlador(ActionListener controlador) {
        btnClientes.addActionListener(controlador);
        btnProveedores.addActionListener(controlador);
        btnProductos.addActionListener(controlador);
        btnVentas.addActionListener(controlador);
        btnCompras.addActionListener(controlador);
        btnConsultas.addActionListener(controlador);
        btnParametros.addActionListener(controlador);
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JButton getBtnVentas() {
        return btnVentas;
    }

    public JButton getBtnCompras() {
        return btnCompras;
    }

    public JButton getBtnConsultas() {
        return btnConsultas;
    }

    public JButton getBtnParametros() {
        return btnParametros;
    }
}
