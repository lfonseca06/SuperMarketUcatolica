package co.edu.ucatolica.vista;

import javax.swing.*;

import co.edu.ucatolica.controlador.Controlador;

import java.awt.*;

public class VentanaClientes extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCedula, txtNombre, txtDireccion, txtTelefono, txtCorreo;
    private JButton btnGuardar, btnModificar, btnEliminar, btnBuscar;

    public VentanaClientes() {
        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        add(new JLabel("Cédula:"));
        add(txtCedula);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Correo Electrónico:"));
        add(txtCorreo);
        add(btnGuardar);
        add(btnModificar);
        add(btnEliminar);
        add(btnBuscar);
    }

    public void setControlador(Controlador controlador) {
        btnGuardar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnEliminar.addActionListener(controlador);
        btnBuscar.addActionListener(controlador);
    }
}

