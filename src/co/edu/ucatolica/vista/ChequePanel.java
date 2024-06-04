package co.edu.ucatolica.vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ChequePanel extends JPanel {
    private JTextArea chequeArea;

    public ChequePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE), "Cheque", TitledBorder.LEFT, TitledBorder.TOP));

        chequeArea = new JTextArea(10, 10);
        chequeArea.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Cambio aquí el borde a amarillo claro
        add(new JScrollPane(chequeArea), BorderLayout.CENTER);
        
        chequeArea.setBackground(Color.LIGHT_GRAY);
    }

    public String getChequeText() {
        return chequeArea.getText();
    }
}