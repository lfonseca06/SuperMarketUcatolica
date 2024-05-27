package co.edu.ucatolica.vista;
import co.edu.ucatolica.controlador.Controlador;
import javax.swing.*;
import java.awt.*;

public class VentanaProveedores extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNIT, txtNombre, txtDireccion, txtTelefono, txtCiudad;
    private JButton btnGuardar, btnModificar, btnEliminar, btnBuscar;

    public VentanaProveedores() {
        setTitle("Gestión de Proveedores");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtNIT = new JTextField();
        txtNombre = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCiudad = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        add(new JLabel("NIT:"));
        add(txtNIT);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Ciudad:"));
        add(txtCiudad);
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
