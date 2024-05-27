package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;


public class PanelProveedorAgregar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNIT, txtNombre, txtDireccion, txtTelefono, txtCiudad;
    private JButton  btnAgregar, btnModificarFinal;

    public static final String  AGREGAR_PROVEEDOR = "AgregarProveedor";
    public static final String  MOFICAR_PROVEEDOR = "ModificaProveedor";

    public PanelProveedorAgregar() {
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNIT = new JTextField();
        txtNombre = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCiudad = new JTextField();


        btnAgregar = new JButton("Agregar");
        btnAgregar.setActionCommand(AGREGAR_PROVEEDOR);

        btnModificarFinal = new JButton("Modificar");
        btnModificarFinal.setActionCommand(MOFICAR_PROVEEDOR);

        JLabel lblTitulo = new JLabel("PROVEEDORES", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.GREEN);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Espacio adicional para el título
        add(lblTitulo, gbc);

        gbc.insets = new Insets(5, 5, 5, 5); // Restaurar insets para el resto de los componentes
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("NIT:"), gbc);
        gbc.gridy = 2;
        add(txtNIT, gbc);
        
        gbc.gridy = 3;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridy = 4;
        add(txtNombre, gbc);
        
        gbc.gridy = 5;
        add(new JLabel("Dirección:"), gbc);
        gbc.gridy = 6;
        add(txtDireccion, gbc);
        
        gbc.gridy = 7;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridy = 8;
        add(txtTelefono, gbc);
        
        gbc.gridy = 9;
        add(new JLabel("Ciudad:"), gbc);
        gbc.gridy = 10;
        add(txtCiudad, gbc);

        // Agregar los botones de forma horizontal
        gbc.gridwidth = 1; // Un solo componente por celda
        gbc.gridy = 11;
        gbc.gridx = 0; // Columna izquierda
        add(btnAgregar, gbc);
        
        gbc.gridx = 1; // Columna derecha
        add(btnModificarFinal, gbc);
        
        


    }

    public static String getAgregarProveedor() {
        return AGREGAR_PROVEEDOR;
    }

    // Método para obtener el valor de MOFICAR_PROVEEDOR
    public static String getModificarProveedor() {
        return MOFICAR_PROVEEDOR;
    }
   
    public JTextField getTxtNIT() {
        return txtNIT;
    }

    public void setTxtNIT(JTextField txtNIT) {
        this.txtNIT = txtNIT;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(JTextField txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnModificarFinal() {
        return btnModificarFinal;
    }

    public void setBtnModificarFinal(JButton btnModificarFinal) {
        this.btnModificarFinal = btnModificarFinal;
    }
}