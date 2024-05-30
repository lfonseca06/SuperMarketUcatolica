package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.ucatolica.controlador.Controlador;
import co.edu.ucatolica.modelo.SuperMarketFachada;

public class VentanaParametrizacion extends JFrame {
    
	private static final long serialVersionUID = 1L;
    private SuperMarketFachada fachada;
    private JTextField txtNombre, txtTipoComercio, txtNIT, txtCiudad, txtIVA, txtTasaInteres, txtBanco, txtNumeroCuenta, txtGerente;
    private JButton btnGuardar, btnModificar, btnCrear;
    
    
    
    public VentanaParametrizacion(SuperMarketFachada fachada) {
        setTitle("Parametrización de la Tienda");
        setSize(400, 400);
        setLayout(new GridLayout(11, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtNombre = new JTextField();
        txtTipoComercio = new JTextField();
        txtNIT = new JTextField();
        txtCiudad = new JTextField();
        txtIVA = new JTextField();
        txtTasaInteres = new JTextField();
        txtBanco = new JTextField();
        txtNumeroCuenta = new JTextField();
        txtGerente = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnCrear = new JButton("Crear");

        add(new JLabel("Nombre de la Tienda:"));
        add(txtNombre);
        add(new JLabel("Tipo de Comercio:"));
        add(txtTipoComercio);
        add(new JLabel("NIT:"));
        add(txtNIT);
        add(new JLabel("Ciudad:"));
        add(txtCiudad);
        add(new JLabel("Valor de IVA:"));
        add(txtIVA);
        add(new JLabel("Tasa de Interés:"));
        add(txtTasaInteres);
        add(new JLabel("Nombre del Banco:"));
        add(txtBanco);
        add(new JLabel("Número de Cuenta:"));
        add(txtNumeroCuenta);
        add(new JLabel("Nombre del Gerente:"));
        add(txtGerente);
        add(btnGuardar);
        add(btnModificar);
        add(btnCrear);

        // Asignar acciones a los botones utilizando la fachada
        //btnGuardar.addActionListener(e -> {
            //fachada.guardarParametros(/* pasar los parámetros necesarios */);
        //});

        //btnModificar.addActionListener(e -> {
            //fachada.modificarParametros(/* pasar los parámetros necesarios */);
        //});

        //btnCrear.addActionListener(e -> {
            //fachada.crearParametros(/* pasar los parámetros necesarios */);
        //});
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
        return Double.parseDouble(txtIVA.getText());
    }

    public double getTasaInteres() {
        return Double.parseDouble(txtTasaInteres.getText());
    }

    public String getNombreBanco() {
        return txtBanco.getText();
    }

    public String getNumeroCuenta() {
        return txtNumeroCuenta.getText();
    }

    public String getNombreGerente() {
        return txtGerente.getText();
    }

    public void setControlador(Controlador controlador) {
        btnGuardar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnCrear.addActionListener(controlador);
    }
    
}
