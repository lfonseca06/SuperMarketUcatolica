package co.edu.ucatolica.vista;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.edu.ucatolica.modelo.Cliente;
import co.edu.ucatolica.modelo.Reporte;
import co.edu.ucatolica.modelo.persistencia.PersistenciaClientes;

public class VistaReporte extends JFrame {
    
    private static final long serialVersionUID = 1L;

    //private panelClientes panelClientes;
    private panelTotalVentasClientes panelTotalVentasCliente;
    private panelDetalleVentasClientes panelDetalleVentasCliente;
    private panelTotalComprasProveedor panelTotalComprasProveedor;
    private panelDetalleChequesExpedidos panelDetalleChequesExpedidos;
    private JPanel containerPanel;
    private List<Cliente> listaClientes;
	
    
    public VistaReporte() {
        setTitle("Consultas del sistema");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        containerPanel = new JPanel(new BorderLayout());
        add(containerPanel, BorderLayout.CENTER);
    }

    public void mostrarPanelClientes() {
        limpiarPaneles();
        
        panelClientes panel = new panelClientes();
        
        // Modificación del modelo
        ////////////////////PersistenciaClientes cargar = new PersistenciaClientes(); 
        ////////////////////listaClientes = cargar.getListaClientes();
        Reporte clientePersis = new Reporte();
        listaClientes = clientePersis.getPersisClientes();
        
        panel.mostrarListaClientes(listaClientes);
        
        containerPanel.add(panel, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }

    public void mostrarPanelTotalVentasCliente() {
        limpiarPaneles();
        panelTotalVentasCliente = new panelTotalVentasClientes();
        containerPanel.add(panelTotalVentasCliente, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    public void mostrarDetalleVentasCliente() {
        limpiarPaneles();
        panelDetalleVentasCliente = new panelDetalleVentasClientes();
        containerPanel.add(panelDetalleVentasCliente, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }

    public void mostrarTotalComprasProveedor() {
        limpiarPaneles();
        panelTotalComprasProveedor = new panelTotalComprasProveedor();
        containerPanel.add(panelTotalComprasProveedor, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    public void mostrarDetalleChequesExpedidos() {
        limpiarPaneles();
        panelDetalleChequesExpedidos = new panelDetalleChequesExpedidos();
        containerPanel.add(panelDetalleChequesExpedidos, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }

    private void limpiarPaneles() {
        containerPanel.removeAll();
    }
}
