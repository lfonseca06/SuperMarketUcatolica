package co.edu.ucatolica.vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelProveedorFuncionesNit extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel labEntrada1;
    private JTextField txtNumero;
    private JButton butBuscarLeer;
    private JButton butEliminar;
    private JButton butSalir;

    public static final String NIT = "NIT";
    public static final String BUSCAR_LEER = "Buscar/Leer";
    public static final String ELIMINAR = "Eliminar";
    public static final String SALIR = "Salir";

    public PanelProveedorFuncionesNit() {
        setLayout(new GridBagLayout()); // Utiliza GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        TitledBorder border = BorderFactory.createTitledBorder("");  // Titulo del Panel
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        labEntrada1 = new JLabel("INGRESE NIT A MODIFICAR");
        labEntrada1.setForeground(Color.GREEN); // Configurar el color del texto a verde
        labEntrada1.setHorizontalAlignment(JLabel.CENTER);

        txtNumero = new JTextField(20);
        txtNumero.setForeground(Color.BLACK);
        txtNumero.setBackground(Color.WHITE);

        butBuscarLeer = new JButton("Buscar/Leer");
        butBuscarLeer.setActionCommand(BUSCAR_LEER);

        butEliminar = new JButton("Eliminar");
        butEliminar.setActionCommand(ELIMINAR);

        butSalir = new JButton("Salir");
        butSalir.setActionCommand(SALIR);
        butSalir.setBackground(new Color(255, 102, 102)); // Cambiar color a rojo claro

        // Configuración de GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir labEntrada1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(labEntrada1, gbc);

        // Añadir txtNumero
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(txtNumero, gbc);

        // Añadir butBuscarLeer
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(butBuscarLeer, gbc);

        // Añadir butEliminar
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(butEliminar, gbc);

        // Añadir butSalir
        gbc.gridx = 4;
        gbc.gridy = 1;
        butSalir.setPreferredSize(new java.awt.Dimension(80, 30)); // Establecer tamaño preferido más pequeño
        add(butSalir, gbc);
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public JButton getButBuscarLeer() {
        return butBuscarLeer;
    }

    public JButton getButEliminar() {
        return butEliminar;
    }

    public JButton getButSalir() {
        return butSalir;
    }
}
