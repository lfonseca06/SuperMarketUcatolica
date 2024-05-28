package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.controlador.Controlador;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaProductos extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCodigoProducto, txtNombreProducto, txtNITProveedor, txtPrecioCompra, txtPrecioVenta;
    private JButton btnAgregarProducto, btnActualizarProducto, btnEliminarProducto, btnBuscarProducto;
    private SuperMarketFachada fachada;

    public VentanaProductos(SuperMarketFachada fachada) {
        this.fachada = fachada;
        setTitle("Gestión de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));
        
        txtCodigoProducto = new JTextField();
        txtNombreProducto = new JTextField();
        txtNITProveedor = new JTextField();
        txtPrecioCompra = new JTextField();
        txtPrecioVenta = new JTextField();
        btnAgregarProducto = new JButton("Agregar Producto");
        btnActualizarProducto = new JButton("Actualizar Producto");
        btnEliminarProducto = new JButton("Eliminar Producto");
        btnBuscarProducto = new JButton("Buscar Producto");

        add(new JLabel("Código del Producto:"));
        add(txtCodigoProducto);
        add(new JLabel("Nombre del Producto:"));
        add(txtNombreProducto);
        add(new JLabel("NIT del Proveedor:"));
        add(txtNITProveedor);
        add(new JLabel("Precio de Compra:"));
        add(txtPrecioCompra);
        add(new JLabel("Precio de Venta:"));
        add(txtPrecioVenta);
        add(btnAgregarProducto);
        add(btnActualizarProducto);
        add(btnEliminarProducto);
        add(btnBuscarProducto);

        // Configurar acciones de los botones
        btnAgregarProducto.addActionListener(e -> agregarProducto());
        btnActualizarProducto.addActionListener(e -> actualizarProducto());
        btnEliminarProducto.addActionListener(e -> eliminarProducto());
        btnBuscarProducto.addActionListener(e -> buscarProducto());
    }

    private void agregarProducto() {
        // Obtener los datos de los campos de texto
        String codigo = txtCodigoProducto.getText();
        String nombre = txtNombreProducto.getText();
        String nitProveedor = txtNITProveedor.getText();
        double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
        double precioVenta = Double.parseDouble(txtPrecioVenta.getText());

        // Llamar al método correspondiente de la fachada
        //fachada.agregarProducto(codigo, nombre, nitProveedor, precioCompra, precioVenta);
    }

    private void actualizarProducto() {
        // Obtener los datos de los campos de texto
        String codigo = txtCodigoProducto.getText();
        String nombre = txtNombreProducto.getText();
        String nitProveedor = txtNITProveedor.getText();
        double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
        double precioVenta = Double.parseDouble(txtPrecioVenta.getText());

        // Llamar al método correspondiente de la fachada
        //fachada.actualizarProducto(codigo, nombre, nitProveedor, precioCompra, precioVenta);
    }

    private void eliminarProducto() {
        // Obtener el código del producto a eliminar
        String codigo = txtCodigoProducto.getText();

        // Llamar al método correspondiente de la fachada
        //fachada.eliminarProducto(codigo);
    }

    private void buscarProducto() {
        // Obtener el código del producto a buscar
        String codigo = txtCodigoProducto.getText();

        // Llamar al método correspondiente de la fachada y mostrar los resultados en los campos de texto
        /*Producto producto = fachada.buscarProducto(codigo);
        if (producto != null) {
            txtNombreProducto.setText(producto.getNombre());
            txtNITProveedor.setText(producto.getNitProveedor());
            txtPrecioCompra.setText(String.valueOf(producto.getPrecioCompra()));
            txtPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
        } else {
            // Limpiar los campos de texto si no se encuentra el producto
            txtNombreProducto.setText("");
            txtNITProveedor.setText("");
            txtPrecioCompra.setText("");
            txtPrecioVenta.setText("");
            JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }
}
