package co.edu.ucatolica.vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class panelTotalVentasClientes extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public panelTotalVentasClientes() {
		setLayout( new GridLayout(1,2) );
		TitledBorder border = BorderFactory.createTitledBorder("Consulta Total Ventas por Cliente");
		border.setTitleColor(Color.BLACK);
		setBorder( border );
	}
	
}