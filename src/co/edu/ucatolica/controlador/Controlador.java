package co.edu.ucatolica.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.ucatolica.vista.*;

public class Controlador implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private VentanaConsultas ventanaConsultas;
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
        } else if (ventanaConsultas != null) {
            manejarEventosConsultas(e);
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
        } else if (e.getSource() == ventanaPrincipal.getBtnConsultas()) {
            // Abrir ventana de consultas
            VentanaConsultas ventanaConsultas = new VentanaConsultas();
            ventanaConsultas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnParametros()) {
            // Abrir ventana de parámetros
            VentanaParametrizacion ventanaParametros = new VentanaParametrizacion();
            ventanaParametros.setVisible(true);
        }


        //botones proveedor
        if(e.getActionCommand().equals(visProv.getpanelAgregarProveedores().AGREGAR_PROVEEDOR)){
            String nit=visProv.getpanelAgregarProveedores().getTxtNIT().getText();
            String nombre=visProv.getpanelAgregarProveedores().getTxtDireccion().getText();
            System.err.println("sadsadsa");
        }
        if(e.getActionCommand().equals(visProv.getpanelAgregarProveedores().MOFICAR_PROVEEDOR)){
            System.err.println("sadsadsa");
        }
        
        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().BUSCAR_LEER)){
            System.err.println("sadsadsa");
        }
        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().ELIMINAR)){
            System.err.println("sadsadsa");
        }

        if(e.getActionCommand().equals(visProv.getpanelFuncionesNit().SALIR)){
            
            System.err.println(visProv.getpanelFuncionesNit().getTxtNumero().getText());
        }
    }

    private void manejarEventosConsultas(ActionEvent e) {
        // Implementa aquí la lógica para manejar eventos en la ventana de consultas
    }
}
