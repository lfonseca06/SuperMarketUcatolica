package co.edu.ucatolica.vista;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import co.edu.ucatolica.controlador.Controlador;
import co.edu.ucatolica.modelo.SuperMarketFachada;
import co.edu.ucatolica.modelo.Tienda;

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

    private JLabel lblErrorNombre;
    private JLabel lblErrorTipoComercio;
    private JLabel lblErrorNIT;
    private JLabel lblErrorCiudad;
    private JLabel lblErrorValorIVA;
    private JLabel lblErrorTasaInteres;
    private JLabel lblErrorNombreBanco;
    private JLabel lblErrorNumeroCuenta;
    private JLabel lblErrorNombreGerente;

    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnCrear;
    private JButton btnConsultar;

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel consultaPanel;

    public VentanaParametrizacion(SuperMarketFachada fachada) {
        this.fachada = fachada;
        initComponents();
    }

    private void initComponents() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("./images/parametrizacion_logo.png"));
        setTitle("Parametrización de Tienda");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtNombre = createCenteredTextField();
        lblErrorNombre = createErrorLabel();
        txtTipoComercio = createCenteredTextField();
        lblErrorTipoComercio = createErrorLabel();
        txtNIT = createCenteredTextField();
        lblErrorNIT = createErrorLabel();
        txtCiudad = createCenteredTextField();
        lblErrorCiudad = createErrorLabel();
        txtValorIVA = createCenteredTextField();
        lblErrorValorIVA = createErrorLabel();
        txtTasaInteres = createCenteredTextField();
        lblErrorTasaInteres = createErrorLabel();
        txtNombreBanco = createCenteredTextField();
        lblErrorNombreBanco = createErrorLabel();
        txtNumeroCuenta = createCenteredTextField();
        lblErrorNumeroCuenta = createErrorLabel();
        txtNombreGerente = createCenteredTextField();
        lblErrorNombreGerente = createErrorLabel();

        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(txtNombre);
        inputPanel.add(lblErrorNombre);
        inputPanel.add(new JLabel("Tipo de Comercio:"));
        inputPanel.add(txtTipoComercio);
        inputPanel.add(lblErrorTipoComercio);
        inputPanel.add(new JLabel("NIT:"));
        inputPanel.add(txtNIT);
        inputPanel.add(lblErrorNIT);
        inputPanel.add(new JLabel("Ciudad:"));
        inputPanel.add(txtCiudad);
        inputPanel.add(lblErrorCiudad);
        inputPanel.add(new JLabel("Valor IVA:"));
        inputPanel.add(txtValorIVA);
        inputPanel.add(lblErrorValorIVA);
        inputPanel.add(new JLabel("Tasa de Interés:"));
        inputPanel.add(txtTasaInteres);
        inputPanel.add(lblErrorTasaInteres);
        inputPanel.add(new JLabel("Nombre del Banco:"));
        inputPanel.add(txtNombreBanco);
        inputPanel.add(lblErrorNombreBanco);
        inputPanel.add(new JLabel("Número de Cuenta:"));
        inputPanel.add(txtNumeroCuenta);
        inputPanel.add(lblErrorNumeroCuenta);
        inputPanel.add(new JLabel("Nombre del Gerente:"));
        inputPanel.add(txtNombreGerente);
        inputPanel.add(lblErrorNombreGerente);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnCrear = new JButton("Crear");
        btnConsultar = new JButton("Consultar");

        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnCrear);
        buttonPanel.add(btnConsultar);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        addValidation(txtNombre, lblErrorNombre, "letras");
        addValidation(txtTipoComercio, lblErrorTipoComercio, "letras");
        addValidation(txtNIT, lblErrorNIT, "numeros");
        addValidation(txtCiudad, lblErrorCiudad, "letras");
        addValidation(txtValorIVA, lblErrorValorIVA, "numero");
        addValidation(txtTasaInteres, lblErrorTasaInteres, "numero");
        addValidation(txtNombreBanco, lblErrorNombreBanco, "letras");
        addValidation(txtNumeroCuenta, lblErrorNumeroCuenta, "numeros");
        addValidation(txtNombreGerente, lblErrorNombreGerente, "letras");

        btnConsultar.addActionListener(e -> mostrarDatosEmpresa());
    }

    private JTextField createCenteredTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    private JLabel createErrorLabel() {
        JLabel label = new JLabel();
        label.setForeground(Color.RED);
        return label;
    }

    private void addValidation(JTextField textField, JLabel errorLabel, String tipoDato) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField();
            }

            private void validateField() {
                String text = textField.getText();
                boolean isValid = true;
                switch (tipoDato) {
                    case "letras":
                        if (!text.matches("[a-zA-Z\\s]+")) {
                            errorLabel.setText("Debe contener solo letras.");
                            isValid = false;
                        }
                        break;
                    case "numeros":
                        if (!text.matches("\\d+")) {
                            errorLabel.setText("Debe contener solo números.");
                            isValid = false;
                        }
                        break;
                    case "numero":
                        try {
                            Double.parseDouble(text);
                        } catch (NumberFormatException e) {
                            errorLabel.setText("Debe ser un número válido.");
                            isValid = false;
                        }
                        break;
                }
                if (isValid) {
                    errorLabel.setText("");
                }
            }
        });
    }

    private void mostrarDatosEmpresa() {
        Tienda tienda = fachada.getTienda();
        if (tienda != null) {
            consultaPanel = new JPanel();
            consultaPanel.setLayout(new GridLayout(10, 2, 10, 10));
            consultaPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JTextField txtNombreConsulta = createCenteredTextField();
            JTextField txtTipoComercioConsulta = createCenteredTextField();
            JTextField txtNITConsulta = createCenteredTextField();
            JTextField txtCiudadConsulta = createCenteredTextField();
            JTextField txtValorIVAConsulta = createCenteredTextField();
            JTextField txtTasaInteresConsulta = createCenteredTextField();
            JTextField txtNombreBancoConsulta = createCenteredTextField();
            JTextField txtNumeroCuentaConsulta = createCenteredTextField();
            JTextField txtNombreGerenteConsulta = createCenteredTextField();

            txtNombreConsulta.setText(tienda.getNombre());
            txtTipoComercioConsulta.setText(tienda.getTipoComercio());
            txtNITConsulta.setText(tienda.getNIT());
            txtCiudadConsulta.setText(tienda.getCiudad());
            txtValorIVAConsulta.setText(String.valueOf(tienda.getValorIVA()));
            txtTasaInteresConsulta.setText(String.valueOf(tienda.getTasaInteres()));
            txtNombreBancoConsulta.setText(tienda.getNombreBanco());
            txtNumeroCuentaConsulta.setText(tienda.getNumeroCuenta());
            txtNombreGerenteConsulta.setText(tienda.getNombreGerente());

            consultaPanel.add(new JLabel("Nombre:"));
            consultaPanel.add(txtNombreConsulta);
            consultaPanel.add(new JLabel("Tipo de Comercio:"));
            consultaPanel.add(txtTipoComercioConsulta);
            consultaPanel.add(new JLabel("NIT:"));
            consultaPanel.add(txtNITConsulta);
            consultaPanel.add(new JLabel("Ciudad:"));
            consultaPanel.add(txtCiudadConsulta);
            consultaPanel.add(new JLabel("Valor IVA:"));
            consultaPanel.add(txtValorIVAConsulta);
            consultaPanel.add(new JLabel("Tasa de Interés:"));
            consultaPanel.add(txtTasaInteresConsulta);
            consultaPanel.add(new JLabel("Nombre del Banco:"));
            consultaPanel.add(txtNombreBancoConsulta);
            consultaPanel.add(new JLabel("Número de Cuenta:"));
            consultaPanel.add(txtNumeroCuentaConsulta);
            consultaPanel.add(new JLabel("Nombre del Gerente:"));
            consultaPanel.add(txtNombreGerenteConsulta);

            JButton btnModificarConsulta = new JButton("Modificar");
            consultaPanel.add(btnModificarConsulta);

            mainPanel.removeAll();
            mainPanel.add(consultaPanel, BorderLayout.CENTER);
            mainPanel.revalidate();
            mainPanel.repaint();

            btnModificarConsulta.addActionListener(e -> {
                txtNombre.setText(txtNombreConsulta.getText());
                txtTipoComercio.setText(txtTipoComercioConsulta.getText());
                txtNIT.setText(txtNITConsulta.getText());
                txtCiudad.setText(txtCiudadConsulta.getText());
                txtValorIVA.setText(txtValorIVAConsulta.getText());
                txtTasaInteres.setText(txtTasaInteresConsulta.getText());
                txtNombreBanco.setText(txtNombreBancoConsulta.getText());
                txtNumeroCuenta.setText(txtNumeroCuentaConsulta.getText());
                txtNombreGerente.setText(txtNombreGerenteConsulta.getText());

                mainPanel.removeAll();
                mainPanel.add(inputPanel, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);
                mainPanel.revalidate();
                mainPanel.repaint();
            });
        } else {
            JOptionPane.showMessageDialog(this, "No hay empresa creada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    public JButton getBtnConsultar() {
        return btnConsultar;
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
        btnConsultar.addActionListener(controlador);
    }
    

}
