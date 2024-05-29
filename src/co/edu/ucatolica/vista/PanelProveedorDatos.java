package co.edu.ucatolica.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import co.edu.ucatolica.modelo.Proveedor;

public class PanelProveedorDatos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextArea NitCon, nombreCon, direccionCon, telefonoCon, ciudadCon;

    public PanelProveedorDatos() {
        setLayout(new GridBagLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Lectura Registros");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        // Panel para los títulos
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.anchor = GridBagConstraints.LINE_START;
        gbcTitle.weightx = 1.0;
        gbcTitle.fill = GridBagConstraints.HORIZONTAL; // Ajuste para que ocupe todo el ancho
        gbcTitle.insets.set(5, 0, 0, 0); // Menos espacio en la parte superior

        // Etiquetas de los títulos con menos altura
        titlePanel.add(createTitleLabel("Nit"), gbcTitle);
        gbcTitle.gridx++;
        titlePanel.add(createTitleLabel("Nombre"), gbcTitle);
        gbcTitle.gridx++;
        titlePanel.add(createTitleLabel("Direccion"), gbcTitle);
        gbcTitle.gridx++;
        titlePanel.add(createTitleLabel("Telefono"), gbcTitle);
        gbcTitle.gridx++;
        titlePanel.add(createTitleLabel("Ciudad"), gbcTitle);

        // Panel para el contenido
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcContent = new GridBagConstraints();
        gbcContent.gridx = 0;
        gbcContent.gridy = 0;
        gbcContent.fill = GridBagConstraints.BOTH;
        gbcContent.weightx = 1.0;
        gbcContent.weighty = 1.0;

        // Campos de texto
        NitCon = createTextArea();
        contentPanel.add(new JScrollPane(NitCon), gbcContent);

        gbcContent.gridx++;
        nombreCon = createTextArea();
        contentPanel.add(new JScrollPane(nombreCon), gbcContent);

        gbcContent.gridx++;
        direccionCon = createTextArea();
        contentPanel.add(new JScrollPane(direccionCon), gbcContent);

        gbcContent.gridx++;
        telefonoCon = createTextArea();
        contentPanel.add(new JScrollPane(telefonoCon), gbcContent);

        gbcContent.gridx++;
        ciudadCon = createTextArea();
        contentPanel.add(new JScrollPane(ciudadCon), gbcContent);

        // Añadir los paneles al panel principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Ajuste para que ocupe todo el ancho
        add(titlePanel, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0; // Ajuste para que ocupe todo el alto disponible
        gbc.fill = GridBagConstraints.BOTH;
        add(contentPanel, gbc);
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(60, 20)); // Ajustar el tamaño
        label.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        return label;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(200, 100)); // Ajustar el tamaño
        return textArea;
    }

    // Método para establecer los datos de los proveedores en los text areas
    public void setProveedor(Proveedor[] proveedores) {
        StringBuilder nitText = new StringBuilder();
        StringBuilder nombreText = new StringBuilder();
        StringBuilder direccionText = new StringBuilder();
        StringBuilder telefonoText = new StringBuilder();
        StringBuilder ciudadText = new StringBuilder();

        for (Proveedor proveedor : proveedores) {
            nitText.append(proveedor.getNIT()).append("\n");
            nombreText.append(proveedor.getNombre()).append("\n");
            direccionText.append(proveedor.getDireccion()).append("\n");
            telefonoText.append(proveedor.getTelefono()).append("\n");
            ciudadText.append(proveedor.getCiudad()).append("\n");
            
        }
        
        NitCon.setText(nitText.toString());
        nombreCon.setText(nombreText.toString());
        direccionCon.setText(direccionText.toString());
        telefonoCon.setText(telefonoText.toString());
        ciudadCon.setText(ciudadText.toString());
    }
}
