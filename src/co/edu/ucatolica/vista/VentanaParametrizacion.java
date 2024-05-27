package co.edu.ucatolica.vista;
import co.edu.ucatolica.controlador.Controlador;
import javax.swing.*;
import java.awt.*;

public class VentanaParametrizacion extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre, txtTipoComercio, txtNIT, txtCiudad, txtIVA, txtTasaInteres, txtBanco, txtNumeroCuenta, txtGerente;
    private JButton btnGuardar, btnModificar, btnCrear;

    public VentanaParametrizacion() {
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
    }

    public void setControlador(Controlador controlador) {
        btnGuardar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnCrear.addActionListener(controlador);
    }
}
