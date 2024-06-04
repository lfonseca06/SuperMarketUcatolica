package co.edu.ucatolica.vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class panelDetalleChequesExpedidos extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public panelDetalleChequesExpedidos() {
		setLayout( new GridLayout(1,2) );
		TitledBorder border = BorderFactory.createTitledBorder("Consulta Detalle Cheques Expedidos");
		border.setTitleColor(Color.BLACK);
		setBorder( border );
	}

}