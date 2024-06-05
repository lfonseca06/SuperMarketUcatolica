package co.edu.ucatolica.vista;

import javax.swing.*;
import co.edu.ucatolica.modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentanaVentas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCedulaCliente, txtCodigoProducto, txtCantidad, txtNombreProducto, txtValorTotal, txtValorIVA, txtValorTotalConIVA;
    private JButton btnAgregarProducto, btnTotalizar, btnConfirmar;
    private JComboBox<String> comboMetodoPago;
    private SuperMarketFachada fachada;
    private List<Producto> productosVendidos;
    private List<Integer> cantidadesVendidas;

    public VentanaVentas(SuperMarketFachada fachada) {
        this.fachada = fachada;
        productosVendidos = new ArrayList<>();
        cantidadesVendidas = new ArrayList<>();

        setTitle("Gestión de Ventas");
        setSize(400, 500);
        setLayout(new GridLayout(12, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtCedulaCliente = new JTextField();
        txtCodigoProducto = new JTextField();
        txtNombreProducto = new JTextField();
        txtNombreProducto.setEditable(false);
        txtCantidad = new JTextField();
        txtValorTotal = new JTextField();
        txtValorIVA = new JTextField();
        txtValorTotalConIVA = new JTextField();
        comboMetodoPago = new JComboBox<>(new String[] { "Efectivo", "Crédito" });
        btnAgregarProducto = new JButton("Agregar Producto");
        btnTotalizar = new JButton("Totalizar");
        btnConfirmar = new JButton("Confirmar");

        add(new JLabel("Cédula del Cliente:"));
        add(txtCedulaCliente);
        add(new JLabel("Código del Producto:"));
        add(txtCodigoProducto);
        add(new JLabel("Nombre del Producto:"));
        add(txtNombreProducto);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(btnAgregarProducto);
        add(btnTotalizar);
        add(new JLabel("Valor Total:"));
        add(txtValorTotal);
        add(new JLabel("Valor IVA:"));
        add(txtValorIVA);
        add(new JLabel("Valor Total con IVA:"));
        add(txtValorTotalConIVA);
        add(new JLabel("Método de Pago:"));
        add(comboMetodoPago);
        add(btnConfirmar);

        // Configurar acciones de los botones
        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        btnTotalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalizar();
            }
        });
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarVenta();
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                limpiarCampos();
            }
        });
    }

    private void agregarProducto() {
        if (txtCantidad.getText().isEmpty() || Integer.parseInt(txtCantidad.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigoProducto = txtCodigoProducto.getText();
        Producto producto = fachada.buscarProductoPorCodigo(codigoProducto);
        if (producto != null) {
            txtNombreProducto.setText(producto.getNombre());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            productosVendidos.add(producto);
            cantidadesVendidas.add(cantidad);
            double valorTotal = producto.getPrecioVenta() * cantidad;
            double totalActual = txtValorTotal.getText().isEmpty() ? 0 : Double.parseDouble(txtValorTotal.getText());
            txtValorTotal.setText(String.valueOf(totalActual + valorTotal));
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void totalizar() {
        try {
            double valorTotal = Double.parseDouble(txtValorTotal.getText());
            int iva = fachada.leerIVA();
            double valorIVA = valorTotal * iva / 100;
            double valorTotalConIVA = valorTotal + valorIVA;
            txtValorIVA.setText(String.valueOf(valorIVA));
            txtValorTotalConIVA.setText(String.valueOf(valorTotalConIVA));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al calcular el total", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void confirmarVenta() {
        String cedulaCliente = txtCedulaCliente.getText();
        double valorTotal = Double.parseDouble(txtValorTotal.getText());
        double valorIVA = Double.parseDouble(txtValorIVA.getText());
        double valorTotalConIVA = Double.parseDouble(txtValorTotalConIVA.getText());
        String metodoPago = (String) comboMetodoPago.getSelectedItem();

        try {
            if (metodoPago.equals("Efectivo")) {
                fachada.registrarVenta(cedulaCliente, valorTotal, valorIVA, valorTotalConIVA, productosVendidos, cantidadesVendidas);
                JOptionPane.showMessageDialog(this, "Venta registrada con éxito.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else if (metodoPago.equals("Crédito")) {
                new VentanaCredito(fachada, cedulaCliente, valorTotalConIVA, valorIVA, productosVendidos, cantidadesVendidas).setVisible(true);
            }
            limpiarCampos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtCedulaCliente.setText("");
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidad.setText("");
        txtValorTotal.setText("");
        txtValorIVA.setText("");
        txtValorTotalConIVA.setText("");
        productosVendidos.clear();
        cantidadesVendidas.clear();
    }
}
