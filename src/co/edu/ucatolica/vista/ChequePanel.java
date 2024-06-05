package co.edu.ucatolica.vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import co.edu.ucatolica.modelo.Cheque;


public class ChequePanel extends JPanel {
    private JTextField consecutivoChequeField;
    private JTextField nombreProveedorField;
    private JTextField valorTotalField;
    private JTextField montoEscritoField;
    private JTextField nombreBancoField;
    private JTextField numeroCuentaField;

    public ChequePanel() {
        // Crear el panel de fondo
        BackgroundPanel backgroundPanel = new BackgroundPanel();

        // Centrar el título del panel
        backgroundPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 165, 0)), "Cheque", TitledBorder.CENTER, TitledBorder.TOP));
        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 30, 10); // Aumentar las distancias entre componentes verticalmente
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Anclar imagen al norte y oeste (izquierda)

        // Inicializar componentes
        Dimension fieldSize = new Dimension(200, 30);
        consecutivoChequeField = new JTextField();
        consecutivoChequeField.setPreferredSize(fieldSize);
        nombreProveedorField = new JTextField();
        nombreProveedorField.setPreferredSize(fieldSize);
        valorTotalField = new JTextField();
        valorTotalField.setPreferredSize(fieldSize);
        montoEscritoField = new JTextField();
        montoEscritoField.setPreferredSize(fieldSize);
        nombreBancoField = new JTextField();
        nombreBancoField.setPreferredSize(fieldSize);
        numeroCuentaField = new JTextField();
        numeroCuentaField.setPreferredSize(fieldSize);

        // Redimensionar y añadir la imagen del banco
        ImageIcon originalIcon = new ImageIcon("./images/logobanco.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(100, 40, Image.SCALE_SMOOTH); // Ajustar tamaño de la imagen
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel bankLogo = new JLabel(scaledIcon);
        backgroundPanel.add(bankLogo, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weighty = 0; // Restablecer peso

        // Crear etiquetas y hacerlas negritas
        JLabel consecutivoChequeLabel = new JLabel("CONSECUTIVO CHEQUE:", SwingConstants.CENTER);
        JLabel nombreProveedorLabel = new JLabel("NOMBRE PROVEEDOR:", SwingConstants.CENTER);
        nombreProveedorLabel.setFont(nombreProveedorLabel.getFont().deriveFont(Font.BOLD));
        JLabel valorTotalLabel = new JLabel("VALOR TOTAL:", SwingConstants.CENTER);
        valorTotalLabel.setFont(valorTotalLabel.getFont().deriveFont(Font.BOLD));
        JLabel montoEscritoLabel = new JLabel("MONTO ESCRITO:", SwingConstants.CENTER);
        montoEscritoLabel.setFont(montoEscritoLabel.getFont().deriveFont(Font.BOLD));
        JLabel nombreBancoLabel = new JLabel("NOMBRE BANCO:", SwingConstants.CENTER);
        nombreBancoLabel.setFont(nombreBancoLabel.getFont().deriveFont(Font.BOLD));
        JLabel numeroCuentaLabel = new JLabel("NÚMERO CUENTA:", SwingConstants.CENTER);
        numeroCuentaLabel.setFont(numeroCuentaLabel.getFont().deriveFont(Font.BOLD));

        // Ajustar todas las etiquetas al mismo ancho que los campos de texto
        Dimension labelSize = new Dimension(fieldSize.width, consecutivoChequeField.getPreferredSize().height);
        for (JLabel label : new JLabel[]{consecutivoChequeLabel, nombreProveedorLabel, valorTotalLabel, montoEscritoLabel, nombreBancoLabel, numeroCuentaLabel}) {
            label.setPreferredSize(labelSize);
            label.setBorder(BorderFactory.createRaisedBevelBorder());
        }

        // Añadir componentes al panel con las posiciones y distancias correctas
        addLabelWithBorder(backgroundPanel, consecutivoChequeLabel, consecutivoChequeField, gbc, 1);
        addLabelWithBorder(backgroundPanel, nombreProveedorLabel, nombreProveedorField, gbc, 2);
        addLabelWithBorder(backgroundPanel, valorTotalLabel, valorTotalField, gbc, 3);
        addLabelWithBorder(backgroundPanel, montoEscritoLabel, montoEscritoField, gbc, 4);
        addLabelWithBorder(backgroundPanel, nombreBancoLabel, nombreBancoField, gbc, 5);
        addLabelWithBorder(backgroundPanel, numeroCuentaLabel, numeroCuentaField, gbc, 6);

        // Añadir espacio extra entre la imagen y el primer campo
        gbc.gridy = 7;
        gbc.weighty = 1;
        backgroundPanel.add(Box.createVerticalGlue(), gbc);

        consecutivoChequeField.setEditable(false);
        nombreProveedorField.setEditable(false);
        valorTotalField.setEditable(false);
        montoEscritoField.setEditable(false);
        nombreBancoField.setEditable(false);
        numeroCuentaField.setEditable(false);

        // Establecer el panel de fondo como el panel principal
        setLayout(new BorderLayout());
        add(backgroundPanel, BorderLayout.CENTER);
    }
    private void addLabelWithBorder(JPanel panel, JLabel label, JTextField textField, GridBagConstraints gbc, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(label, gbc);

        textField.setBorder(BorderFactory.createLoweredBevelBorder());
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(textField, gbc);
    }

    


    public void mostrarCheque(Cheque cheque) {
        consecutivoChequeField.setText(String.valueOf(cheque.getConsecutivo()));
        nombreProveedorField.setText(cheque.getNombreProveedor());
        valorTotalField.setText(String.valueOf(cheque.getValorTotalConIVA()));
        montoEscritoField.setText(cheque.generarTextoCheque());
        nombreBancoField.setText(cheque.getNombreBanco());
        numeroCuentaField.setText(cheque.getNumeroCuenta());
    }
    // Clase interna para el panel de fondo
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Cargar la imagen de fondo
            backgroundImage = new ImageIcon("./images/imagendefondo.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Dibujar la imagen de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
