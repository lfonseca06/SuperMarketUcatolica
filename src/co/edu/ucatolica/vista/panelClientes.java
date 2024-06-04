package co.edu.ucatolica.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.edu.ucatolica.modelo.Cliente;

public class panelClientes extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable tableClientes;
	
	public panelClientes() {
		
		setLayout(new BorderLayout());
        
        // Título del panel
        TitledBorder border = BorderFactory.createTitledBorder("Consulta de Clientes");
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        
        // Título
        JLabel lblTitulo = new JLabel("");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setOpaque(true);
        lblTitulo.setForeground(Color.GREEN);
        
        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        
        // Tabla
        tableClientes = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio de 10 píxeles a los lados
        
        add(panelTitulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

	}

	public void mostrarListaClientes(List<Cliente> clientes) {
		String[] columnNames = {"Cédula", "Nombre Completo", "Dirección", "Teléfono", "Correo Electrónico"};
        String[][] data = new String[clientes.size()][5];
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = cliente.getCedula();
            data[i][1] = cliente.getNombreCompleto();
            data[i][2] = cliente.getDireccion();
            data[i][3] = cliente.getTelefono();
            data[i][4] = cliente.getCorreo();
        }
        
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
			
	}
}
