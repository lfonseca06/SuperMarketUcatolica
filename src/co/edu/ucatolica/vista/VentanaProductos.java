package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import co.edu.ucatolica.modelo.Producto;
import co.edu.ucatolica.modelo.persistencia.GestorArchivos;

public class VentanaProductos extends JFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> txtNITProveedor;
    private JTextField txtCodigoProducto, txtNombreProducto, txtPrecioCompra, txtPrecioVenta;
    private JButton btnAgregarProducto, btnActualizarProducto, btnEliminarProducto, btnBuscarProducto;

    public VentanaProductos() {
        setTitle("Gestión de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        txtCodigoProducto = new JTextField();
        txtNombreProducto = new JTextField();
        txtNITProveedor = new JComboBox<>(GestorArchivos.listaNitProveedores());
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

        btnAgregarProducto.addActionListener(e -> agregarProducto());
        btnActualizarProducto.addActionListener(e -> actualizarProducto());
        btnEliminarProducto.addActionListener(e -> eliminarProducto());
        btnBuscarProducto.addActionListener(e -> buscarProducto());
    }

    private void agregarProducto() {
        try {
            String codigo = txtCodigoProducto.getText();
            if (GestorArchivos.existeProducto(codigo)) {
                JOptionPane.showMessageDialog(this, "Error: El producto con el mismo código ya existe");
                return;
            }
            Producto producto = new Producto();
            producto.setCodigo(txtCodigoProducto.getText());
            producto.setNombre(txtNombreProducto.getText());
            producto.setNITProveedor((String)(txtNITProveedor.getSelectedItem()));
            try {
                Double precioCom = Double.parseDouble(txtPrecioCompra.getText());
                producto.setPrecioCompra(precioCom);
                Double precioVen = Double.parseDouble(txtPrecioVenta.getText());
                producto.setPrecioVenta(precioVen);
                GestorArchivos.guardarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Algunos parámetros deben ser números");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar producto: " + ex.getMessage());
        }
    }

    private void actualizarProducto() {
        try {
            Producto producto = new Producto();
            producto.setCodigo(txtCodigoProducto.getText());
            producto.setNombre(txtNombreProducto.getText());
            producto.setNITProveedor((String)txtNITProveedor.getSelectedItem());
            try {
                Double precioCom = Double.parseDouble(txtPrecioCompra.getText());
                producto.setPrecioCompra(precioCom);
                Double precioVen = Double.parseDouble(txtPrecioVenta.getText());
                producto.setPrecioVenta(precioVen);
                GestorArchivos.actualizarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Algunos parámetros deben ser números");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar producto: " + ex.getMessage());
        }
    }

    private void eliminarProducto() {
        try {
            String codigo = txtCodigoProducto.getText().trim();
            GestorArchivos.eliminarProductoCodigo(codigo);
            JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar producto: " + ex.getMessage());
        }
    }

    private void buscarProducto() {
        try {
            List<Producto> productos = GestorArchivos.cargarProductos();
            String codigo = txtCodigoProducto.getText().trim();
            Producto producto = productos.stream()
                    .filter(p -> p.getCodigo().equals(codigo))
                    .findFirst()
                    .orElse(null);
            if (producto != null) {
                txtNombreProducto.setText(producto.getNombre());
                txtPrecioCompra.setText(String.valueOf(producto.getPrecioCompra()));
                txtPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar producto: " + ex.getMessage());
        }
    }
}
