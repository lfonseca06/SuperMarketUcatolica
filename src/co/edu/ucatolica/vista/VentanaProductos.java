package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.controlador.Controlador;

public class VentanaProductos extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoProducto, txtNombreProducto, txtNITProveedor, txtPrecioCompra, txtPrecioVenta;
    private JButton btnAgregarProducto, btnActualizarProducto, btnEliminarProducto, btnBuscarProducto;

    public VentanaProductos() {
        setTitle("Gestión de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCodigoProducto = new JLabel("Código del Producto:");
        JLabel lblNombreProducto = new JLabel("Nombre del Producto:");
        JLabel lblNITProveedor = new JLabel("NIT del Proveedor:");
        JLabel lblPrecioCompra = new JLabel("Precio de Compra:");
        JLabel lblPrecioVenta = new JLabel("Precio de Venta:");

        txtCodigoProducto = new JTextField(20);
        txtNombreProducto = new JTextField(20);
        txtNITProveedor = new JTextField(20);
        txtPrecioCompra = new JTextField(20);
        txtPrecioVenta = new JTextField(20);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnActualizarProducto = new JButton("Actualizar Producto");
        btnEliminarProducto = new JButton("Eliminar Producto");
        btnBuscarProducto = new JButton("Buscar Producto");

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblCodigoProducto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtCodigoProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNombreProducto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtNombreProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblNITProveedor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtNITProveedor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblPrecioCompra, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtPrecioCompra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblPrecioVenta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(txtPrecioVenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnAgregarProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnActualizarProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(btnEliminarProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(btnBuscarProducto, gbc);
    }

    public void setControlador(Controlador controlador) {
        btnAgregarProducto.addActionListener(controlador);
        btnActualizarProducto.addActionListener(controlador);
        btnEliminarProducto.addActionListener(controlador);
        btnBuscarProducto.addActionListener(controlador);
    }
}
