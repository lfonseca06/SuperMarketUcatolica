package co.edu.ucatolica.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.edu.ucatolica.controlador.Controlador;

public class VistaProveedor extends JFrame {

    private static final long serialVersionUID = 1L;

    private PanelProveedorFuncionesNit panelFuncionesNit;
    private PanelProveedorDatos panelDatosProveedores;
    private PanelProveedorAgregar panelAgregarProveedores;

    public VistaProveedor(Controlador control) {
        setSize(700, 500);
        setResizable(false);
        setTitle("Gestión de Proveedores");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear paneles
        panelFuncionesNit = new PanelProveedorFuncionesNit();
        panelDatosProveedores = new PanelProveedorDatos();
        panelAgregarProveedores = new PanelProveedorAgregar();

        // Crear un panel para contener panelFuncionesNit y panelDatosProveedores
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelCentro.add(panelFuncionesNit, gbc);
        
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        panelCentro.add(panelDatosProveedores, gbc);

        // Crear un panel para contener panelAgregarProveedores y panelCentro
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelAgregarProveedores, BorderLayout.WEST);
        mainPanel.add(panelCentro, BorderLayout.CENTER);

        // Establecer el tamaño fijo del panelAgregarProveedores
        panelAgregarProveedores.setPreferredSize(new java.awt.Dimension(200, getHeight()));

        // Añadir el panel principal al frame
        add(mainPanel, BorderLayout.CENTER);

        panelAgregarProveedores.getBtnAgregar().addActionListener(control);
        panelAgregarProveedores.getBtnModificarFinal().addActionListener(control);

        panelFuncionesNit.getButBuscarLeer().addActionListener(control);
        panelFuncionesNit.getButEliminar().addActionListener(control);
        panelFuncionesNit.getButSalir().addActionListener(control);


        
    }

    public PanelProveedorFuncionesNit getpanelFuncionesNit() {
        return panelFuncionesNit;
    }

    public void setpanelFuncionesNit(PanelProveedorFuncionesNit panelFuncionesNit) {
        this.panelFuncionesNit = panelFuncionesNit;
    }

    public PanelProveedorDatos getpanelDatosProveedores() {
        return panelDatosProveedores;
    }

    public void setpanelDatosProveedores(PanelProveedorDatos panelDatosProveedores) {
        this.panelDatosProveedores = panelDatosProveedores;
    }

    public PanelProveedorAgregar getpanelAgregarProveedores() {
        return panelAgregarProveedores;
    }
    
    
    public void setpanelAgregarProveedores(PanelProveedorAgregar panelAgregarProveedores) {
    	this.panelAgregarProveedores = panelAgregarProveedores;

    }

   

 
}
