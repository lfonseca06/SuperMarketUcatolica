package co.edu.ucatolica.vista;

import co.edu.ucatolica.controlador.Controlador;
import co.edu.ucatolica.modelo.SuperMarketFachada;
import javax.swing.*;
import java.awt.*;

public class VentanaCompras extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNITProveedor, txtCodigoProducto, txtCantidad, txtValorTotal, txtValorIVA, txtValorTotalConIVA;
    private JButton btnAgregarProducto, btnTotalizar, btnConfirmar;
    private SuperMarketFachada fachada;

    public VentanaCompras(SuperMarketFachada fachada) {
        this.fachada = fachada;

        setTitle("Gestión de Compras");
        setSize(400, 400);
        setLayout(new GridLayout(9, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtNITProveedor = new JTextField();
        txtCodigoProducto = new JTextField();
        txtCantidad = new JTextField();
        txtValorTotal = new JTextField();
        txtValorIVA = new JTextField();
        txtValorTotalConIVA = new JTextField();
        btnAgregarProducto = new JButton("Agregar Producto");
        btnTotalizar = new JButton("Totalizar");
        btnConfirmar = new JButton("Confirmar");

        add(new JLabel("NIT del Proveedor:"));
        add(txtNITProveedor);
        add(new JLabel("Código del Producto:"));
        add(txtCodigoProducto);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(new JLabel(""));
        add(btnAgregarProducto);
        add(new JLabel(""));
        add(btnTotalizar);
        add(new JLabel("Valor Total:"));
        add(txtValorTotal);
        add(new JLabel("Valor IVA:"));
        add(txtValorIVA);
        add(new JLabel("Valor Total con IVA:"));
        add(txtValorTotalConIVA);
        add(new JLabel(""));
        add(btnConfirmar);
    }

    public void setControlador(Controlador controlador) {
        btnAgregarProducto.addActionListener(controlador);
        btnTotalizar.addActionListener(controlador);
        btnConfirmar.addActionListener(controlador);
    }

    public String getNITProveedor() {
        return txtNITProveedor.getText();
    }

    public String getCodigoProducto() {
        return txtCodigoProducto.getText();
    }

    public int getCantidad() {
        try {
            return Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setValorTotal(double valor) {
        txtValorTotal.setText(String.valueOf(valor));
    }

    public void setValorIVA(double valor) {
        txtValorIVA.setText(String.valueOf(valor));
    }

    public void setValorTotalConIVA(double valor) {
        txtValorTotalConIVA.setText(String.valueOf(valor));
    }

    public void limpiarCampos() {
        txtNITProveedor.setText("");
        txtCodigoProducto.setText("");
        txtCantidad.setText("");
        txtValorTotal.setText("");
        txtValorIVA.setText("");
        txtValorTotalConIVA.setText("");
    }
}
