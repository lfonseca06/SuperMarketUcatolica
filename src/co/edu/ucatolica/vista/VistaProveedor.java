package co.edu.ucatolica.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import co.edu.ucatolica.modelo.Proveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaProveedor extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private PanelProveedorFuncionesNit panelFuncionesNit;
    private PanelProveedorDatos panelDatosProveedores;
    private PanelProveedorAgregar panelAgregarProveedores;
    private Proveedor proveedor;
    
    public VistaProveedor( Proveedor prov) {
        setProveedor(prov);
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

        panelAgregarProveedores.getBtnAgregar().addActionListener(this);
        panelAgregarProveedores.getBtnModificarFinal().addActionListener(this);

        panelFuncionesNit.getButBuscarLeer().addActionListener(this);
        panelFuncionesNit.getButEliminar().addActionListener(this);
        panelFuncionesNit.getButSalir().addActionListener(this);
       
        Proveedor[] ad=prov.verPro();
        this.getpanelDatosProveedores().setProveedor(ad);

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(this.getpanelAgregarProveedores().AGREGAR_PROVEEDOR)){
            String nit=this.getpanelAgregarProveedores().getTxtNIT().getText();
            String nombre=this.getpanelAgregarProveedores().getTxtNombre().getText();
            String direccion =this.getpanelAgregarProveedores().getTxtDireccion().getText();
            String telefono=this.getpanelAgregarProveedores().getTxtTelefono().getText();
            String ciudad=this.getpanelAgregarProveedores().getTxtCiudad().getText();
            
            Proveedor prov = proveedor.creaProveedor(nit, nombre, direccion, telefono, ciudad);
            prov.guardarProveedor();
            Proveedor[] ad=prov.verPro();
            this.getpanelDatosProveedores().setProveedor(ad);
            
            
        }
        if(e.getActionCommand().equals(this.getpanelAgregarProveedores().MOFICAR_PROVEEDOR)){
            String nit=this.getpanelAgregarProveedores().getTxtNIT().getText();
            String nombre=this.getpanelAgregarProveedores().getTxtNombre().getText();
            String direccion =this.getpanelAgregarProveedores().getTxtDireccion().getText();
            String telefono=this.getpanelAgregarProveedores().getTxtTelefono().getText();
            String ciudad=this.getpanelAgregarProveedores().getTxtCiudad().getText();
            
            String modifNit=this.getpanelFuncionesNit().getTxtNumero().getText(); 
            Proveedor prov = proveedor.creaProveedor(nit, nombre, direccion, telefono, ciudad);
            prov.modifPro(modifNit, prov);
            Proveedor[] ad=prov.verPro();
            this.getpanelDatosProveedores().setProveedor(ad);
        }
        
        if(e.getActionCommand().equals(this.getpanelFuncionesNit().BUSCAR_LEER)){
            String modifNit=this.getpanelFuncionesNit().getTxtNumero().getText(); 
            
            this.mensageEmergente(proveedor.buscarProv(modifNit));
            Proveedor[] ad=proveedor.verPro();
            this.getpanelDatosProveedores().setProveedor(ad);
        }
        if(e.getActionCommand().equals(this.getpanelFuncionesNit().ELIMINAR)){
            String modifNit=this.getpanelFuncionesNit().getTxtNumero().getText(); 
    
            proveedor.eliminarProveedor(modifNit);
            this.mensageEmergente("Se elimino Correctamente");
            Proveedor[] ad=proveedor.verPro();
            this.getpanelDatosProveedores().setProveedor(ad);
        }

        if(e.getActionCommand().equals(this.getpanelFuncionesNit().SALIR)){
            this.dispose();
            
        } 
    }
    public void mensageEmergente(String msg){
        JOptionPane.showMessageDialog(null, msg);
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
    public void setProveedor(Proveedor prov){
        this.proveedor=prov;
    }

   

 
}
