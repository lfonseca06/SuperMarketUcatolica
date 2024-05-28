package co.edu.ucatolica.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.ucatolica.modelo.Proveedor;
import co.edu.ucatolica.vista.*;

public class Controlador implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private VistaProveedor visProv;
    
    public Controlador() {
        this.ventanaPrincipal = new VentanaPrincipal();
        this.ventanaPrincipal.setVisible(true);
        this.ventanaPrincipal.setControlador(this);
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        if (ventanaPrincipal != null) {
            manejarEventosPrincipal(e);
        } 
    }

    private void manejarEventosPrincipal(ActionEvent e) {
        if (e.getSource() == ventanaPrincipal.getBtnClientes()) {
            // Abrir ventana de clientes
            VentanaClientes ventanaClientes = new VentanaClientes();
            ventanaClientes.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnProveedores()) {
            // Abrir ventana de proveedores
        	  visProv = new VistaProveedor(this);
              visProv.setVisible(true);
              Proveedor prov = new Proveedor();
              Proveedor[] ad=prov.verPro();
              visProv.getpanelDatosProveedores().setProveedor(ad);

          } else if (e.getSource() == ventanaPrincipal.getBtnProductos()) {
        	
        	
            // Abrir ventana de productos
            VentanaProductos ventanaProductos = new VentanaProductos();
            ventanaProductos.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnVentas()) {
            // Abrir ventana de ventas
            VentanaVentas ventanaVentas = new VentanaVentas();
            ventanaVentas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnCompras()) {
            // Abrir ventana de compras
            VentanaCompras ventanaCompras = new VentanaCompras();
            ventanaCompras.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnReportes()) {
            // Abrir ventana de consultas
            VentanaConsultas ventanaConsultas = new VentanaConsultas();
            ventanaConsultas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnTienda()) {
            // Abrir ventana de Tienda
            VentanaParametrizacion ventanaParametros = new VentanaParametrizacion();
            ventanaParametros.setVisible(true);
        }
        
        
        //botones proveedor
        if(e.getActionCommand().equals(visProv.getpanelAgregarProveedores().AGREGAR_PROVEEDOR)){
            String nit=visProv.getpanelAgregarProveedores().getTxtNIT().getText();
            String nombre=visProv.getpanelAgregarProveedores().getTxtNombre().getText();
            String direccion =visProv.getpanelAgregarProveedores().getTxtDireccion().getText();
            String telefono=visProv.getpanelAgregarProveedores().getTxtTelefono().getText();
            String ciudad=visProv.getpanelAgregarProveedores().getTxtCiudad().getText();
            
            Proveedor prov = new Proveedor(nit, nombre, direccion, telefono, ciudad);
            prov.guardarProveedor();
            Proveedor[] ad=prov.verPro();
            visProv.getpanelDatosProveedores().setProveedor(ad);
            
            
        }
        if(e.getActionCommand().equals(visProv.getpanelAgregarProveedores().MOFICAR_PROVEEDOR)){
            String nit=visProv.getpanelAgregarProveedores().getTxtNIT().getText();
            String nombre=visProv.getpanelAgregarProveedores().getTxtNombre().getText();
            String direccion =visProv.getpanelAgregarProveedores().getTxtDireccion().getText();
            String telefono=visProv.getpanelAgregarProveedores().getTxtTelefono().getText();
            String ciudad=visProv.getpanelAgregarProveedores().getTxtCiudad().getText();
            
            String modifNit=visProv.getpanelFuncionesNit().getTxtNumero().getText(); 
            Proveedor prov = new Proveedor(nit, nombre, direccion, telefono, ciudad);
            prov.modifPro(modifNit, prov);
            Proveedor[] ad=prov.verPro();
            visProv.getpanelDatosProveedores().setProveedor(ad);
        }
        
        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().BUSCAR_LEER)){
            String modifNit=visProv.getpanelFuncionesNit().getTxtNumero().getText(); 
            Proveedor prov = new Proveedor();
            
            visProv.mensageEmergente(prov.buscarProv(modifNit));
            Proveedor[] ad=prov.verPro();
            visProv.getpanelDatosProveedores().setProveedor(ad);
        }
        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().ELIMINAR)){
            String modifNit=visProv.getpanelFuncionesNit().getTxtNumero().getText(); 
            Proveedor prov = new Proveedor();
            prov.eliminarProveedor(modifNit);
            visProv.mensageEmergente("Se elimino Correctamente");
            Proveedor[] ad=prov.verPro();
            visProv.getpanelDatosProveedores().setProveedor(ad);
        }

        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().SALIR)){
            visProv.dispose();
            
        }   
        
    }

	public VistaProveedor getVisProv() {
		return visProv;
	}

	public void setVisProv(VistaProveedor visProv) {
		this.visProv = visProv;
	}

    
}