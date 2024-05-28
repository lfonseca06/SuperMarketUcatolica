package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaProveedores extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNIT, txtNombre, txtDireccion, txtTelefono, txtCiudad;
    private JButton btnGuardar, btnModificar, btnEliminar, btnBuscar;

    public VentanaProveedores(SuperMarketFachada fachada) {
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

        // Asignar acciones a los botones utilizando la fachada
        btnGuardar.addActionListener(e -> {
            //fachada.guardarProveedor(/* pasar los parámetros necesarios */);
        });

        btnModificar.addActionListener(e -> {
            //fachada.modificarProveedor(/* pasar los parámetros necesarios */);
        });

        btnEliminar.addActionListener(e -> {
            //fachada.eliminarProveedor(/* pasar los parámetros necesarios */);
        });

        btnBuscar.addActionListener(e -> {
            //fachada.buscarProveedor(/* pasar los parámetros necesarios */);
        });
    }
}
