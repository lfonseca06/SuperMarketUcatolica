package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.ucatolica.controlador.Controlador;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaParametrizacion extends JFrame {
    private SuperMarketFachada fachada;

    private JTextField txtNombre;
    private JTextField txtTipoComercio;
    private JTextField txtNIT;
    private JTextField txtCiudad;
    private JTextField txtValorIVA;
    private JTextField txtTasaInteres;
    private JTextField txtNombreBanco;
    private JTextField txtNumeroCuenta;
    private JTextField txtNombreGerente;

    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnCrear;

    public VentanaParametrizacion(SuperMarketFachada fachada) {
        this.fachada = fachada;
        initComponents();
    }

    private void initComponents() {
        setTitle("Parametrización de Tienda");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        txtNombre = new JTextField();
        txtTipoComercio = new JTextField();
        txtNIT = new JTextField();
        txtCiudad = new JTextField();
        txtValorIVA = new JTextField();
        txtTasaInteres = new JTextField();
        txtNombreBanco = new JTextField();
        txtNumeroCuenta = new JTextField();
        txtNombreGerente = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnCrear = new JButton("Crear");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Tipo de Comercio:"));
        panel.add(txtTipoComercio);
        panel.add(new JLabel("NIT:"));
        panel.add(txtNIT);
        panel.add(new JLabel("Ciudad:"));
        panel.add(txtCiudad);
        panel.add(new JLabel("Valor IVA:"));
        panel.add(txtValorIVA);
        panel.add(new JLabel("Tasa de Interés:"));
        panel.add(txtTasaInteres);
        panel.add(new JLabel("Nombre del Banco:"));
        panel.add(txtNombreBanco);
        panel.add(new JLabel("Número de Cuenta:"));
        panel.add(txtNumeroCuenta);
        panel.add(new JLabel("Nombre del Gerente:"));
        panel.add(txtNombreGerente);
        panel.add(btnGuardar);
        panel.add(btnModificar);
        panel.add(btnCrear);

        getContentPane().add(panel);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getTipoComercio() {
        return txtTipoComercio.getText();
    }

    public String getNIT() {
        return txtNIT.getText();
    }

    public String getCiudad() {
        return txtCiudad.getText();
    }

    public double getValorIVA() {
        return Double.parseDouble(txtValorIVA.getText());
    }

    public double getTasaInteres() {
        return Double.parseDouble(txtTasaInteres.getText());
    }

    public String getNombreBanco() {
        return txtNombreBanco.getText();
    }

    public String getNumeroCuenta() {
        return txtNumeroCuenta.getText();
    }

    public String getNombreGerente() {
        return txtNombreGerente.getText();
    }

    public void setControlador(Controlador controlador) {
        btnGuardar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnCrear.addActionListener(controlador);
    }
}
