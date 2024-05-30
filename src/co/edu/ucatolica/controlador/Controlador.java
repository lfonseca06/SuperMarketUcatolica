package co.edu.ucatolica.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.ucatolica.vista.*;
import co.edu.ucatolica.modelo.SuperMarketFachada;
import javax.swing.*;

public class Controlador implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private SuperMarketFachada fachada;

    public Controlador() {
        this.fachada = new SuperMarketFachada();
        this.ventanaPrincipal = new VentanaPrincipal(fachada);
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
            VentanaClientes ventanaClientes = new VentanaClientes(fachada);
            ventanaClientes.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnProveedores()) {
            // Abrir ventana de proveedores
            VistaProveedor ventanaProveedores = new VistaProveedor(fachada.getProveedorServicio());
            ventanaProveedores.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnProductos()) {
            // Abrir ventana de productos
            VentanaProductos ventanaProductos = new VentanaProductos(fachada);
            ventanaProductos.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnVentas()) {
            // Abrir ventana de ventas
            VentanaVentas ventanaVentas = new VentanaVentas(fachada);
            ventanaVentas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnCompras()) {
            // Abrir ventana de compras
            VentanaCompras ventanaCompras = new VentanaCompras(fachada);
            ventanaCompras.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnReportes()) {
            // Abrir ventana de reportes
            VentanaConsultas ventanaConsultas = new VentanaConsultas(fachada);
            ventanaConsultas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnTienda()) {
            // Abrir ventana de Tienda
            VentanaParametrizacion ventanaParametros = new VentanaParametrizacion(fachada);
            ventanaParametros.setVisible(true);
            ventanaParametros.setControlador(this);
        } else if (e.getSource() instanceof JButton) {
            manejarEventosParametrizacion(e);
        }
    }
    
    private void manejarEventosParametrizacion(ActionEvent e) {
        VentanaParametrizacion ventanaParametros = (VentanaParametrizacion) ((JButton) e.getSource()).getTopLevelAncestor();
        if (e.getSource() == ventanaParametros.getBtnCrear()) {
            if (fachada.existeEmpresa()) {
                JOptionPane.showMessageDialog(ventanaParametros, "Ya existe una empresa creada. Solo puede modificar los parámetros.");
            } else {
                fachada.crearParametros(
                        ventanaParametros.getNombre(),
                        ventanaParametros.getTipoComercio(),
                        ventanaParametros.getNIT(),
                        ventanaParametros.getCiudad(),
                        ventanaParametros.getValorIVA(),
                        ventanaParametros.getTasaInteres(),
                        ventanaParametros.getNombreBanco(),
                        ventanaParametros.getNumeroCuenta(),
                        ventanaParametros.getNombreGerente()
                );
                JOptionPane.showMessageDialog(ventanaParametros, "Empresa creada exitosamente.");
            }
        } else if (e.getSource() == ventanaParametros.getBtnGuardar()) {
            fachada.crearParametros(
                    ventanaParametros.getNombre(),
                    ventanaParametros.getTipoComercio(),
                    ventanaParametros.getNIT(),
                    ventanaParametros.getCiudad(),
                    ventanaParametros.getValorIVA(),
                    ventanaParametros.getTasaInteres(),
                    ventanaParametros.getNombreBanco(),
                    ventanaParametros.getNumeroCuenta(),
                    ventanaParametros.getNombreGerente()
            );
            JOptionPane.showMessageDialog(ventanaParametros, "Parámetros guardados exitosamente.");
        } else if (e.getSource() == ventanaParametros.getBtnModificar()) {
            fachada.modificarParametros(
                    ventanaParametros.getNombre(),
                    ventanaParametros.getTipoComercio(),
                    ventanaParametros.getNIT(),
                    ventanaParametros.getCiudad(),
                    ventanaParametros.getValorIVA(),
                    ventanaParametros.getTasaInteres(),
                    ventanaParametros.getNombreBanco(),
                    ventanaParametros.getNumeroCuenta(),
                    ventanaParametros.getNombreGerente()
            );
            JOptionPane.showMessageDialog(ventanaParametros, "Parámetros modificados exitosamente.");
        }
    }
    
    
}
