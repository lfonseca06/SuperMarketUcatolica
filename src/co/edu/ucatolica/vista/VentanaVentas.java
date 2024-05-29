package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaVentas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCedulaCliente, txtCodigoProducto, txtCantidad, txtValorTotal, txtValorIVA, txtValorTotalConIVA;
    private JButton btnAgregarProducto, btnTotalizar, btnConfirmar;
    private SuperMarketFachada fachada;

    public VentanaVentas(SuperMarketFachada fachada) {
        this.fachada = fachada;
        setTitle("Gestión de Ventas");
        setSize(400, 400);
        setLayout(new GridLayout(9, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtCedulaCliente = new JTextField();
        txtCodigoProducto = new JTextField();
        txtCantidad = new JTextField();
        txtValorTotal = new JTextField();
        txtValorIVA = new JTextField();
        txtValorTotalConIVA = new JTextField();
        btnAgregarProducto = new JButton("Agregar Producto");
        btnTotalizar = new JButton("Totalizar");
        btnConfirmar = new JButton("Confirmar");

        add(new JLabel("Cédula del Cliente:"));
        add(txtCedulaCliente);
        add(new JLabel("Código del Producto:"));
        add(txtCodigoProducto);
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
        add(btnConfirmar);

        // Configurar acciones de los botones
        btnAgregarProducto.addActionListener(e -> agregarProducto());
        btnTotalizar.addActionListener(e -> totalizar());
        btnConfirmar.addActionListener(e -> confirmarVenta());
    }

    private void agregarProducto() {
        // Obtener los datos de los campos de texto
        String cedulaCliente = txtCedulaCliente.getText();
        String codigoProducto = txtCodigoProducto.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());

        // Llamar al método correspondiente de la fachada para agregar el producto a la venta
        //fachada.agregarProductoVenta(cedulaCliente, codigoProducto, cantidad);
    }

    private void totalizar() {
        // Obtener los datos de los campos de texto
        String cedulaCliente = txtCedulaCliente.getText();

        // Llamar al método correspondiente de la fachada para totalizar la venta
        //double valorTotal = fachada.totalizarVenta(cedulaCliente);

        // Mostrar el valor total en el campo de texto correspondiente
        //txtValorTotal.setText(String.valueOf(valorTotal));
    }

    private void confirmarVenta() {
        // Obtener los datos de los campos de texto
        String cedulaCliente = txtCedulaCliente.getText();

        // Llamar al método correspondiente de la fachada para confirmar la venta
        //boolean confirmacion = fachada.confirmarVenta(cedulaCliente);

        // Mostrar un mensaje de confirmación o error
        //if (confirmacion) {
         //   JOptionPane.showMessageDialog(this, "Venta confirmada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        //} else {
         //   JOptionPane.showMessageDialog(this, "Error al confirmar venta", "Error", JOptionPane.ERROR_MESSAGE);
        //}
    }
}
