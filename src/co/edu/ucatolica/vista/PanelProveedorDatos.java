package co.edu.ucatolica.vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Insets;


public class PanelProveedorDatos extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel labResultado;
    private JTextField txtMonto;

    public PanelProveedorDatos() {
        
        setLayout(new GridBagLayout()); // Usar GridBagLayout para mayor control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST; // Alinear los componentes al noroeste

        TitledBorder border = BorderFactory.createTitledBorder("");  // Titulo del Panel
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        labResultado = new JLabel("Los Datos del Proveedor Solicitado son:");
        txtMonto = new JTextField("");
        txtMonto.setFont(txtMonto.getFont().deriveFont(14f)); // Establecer un tamaño de fuente más grande

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Hacer que el componente ocupe todo el ancho disponible
        gbc.weighty = 0.1; // Proporcionar más espacio vertical
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 0, 10); // Espacio adicional en la parte superior
        add(labResultado, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.9; // Proporcionar más espacio vertical
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 10, 10); // Espacio adicional en la parte inferior
        add(txtMonto, gbc);
    }

    public JLabel getLabResultado() {
        return labResultado;
    }

    public void setLabResultado(JLabel labResultado) {
        this.labResultado = labResultado;
    }

    public JTextField getTxtMonto() {
        return txtMonto;
    }

    public void setTxtMonto(JTextField txtMonto) {
        this.txtMonto = txtMonto;
    }
}
