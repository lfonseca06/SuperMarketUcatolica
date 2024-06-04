package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import co.edu.ucatolica.modelo.Compra;
import co.edu.ucatolica.modelo.Producto;
import co.edu.ucatolica.modelo.Proveedor;

public class CompraVista extends JFrame {
    private ProveedorPanel proveedorPanel;
    private ProductoPanel productoPanel;
    private ChequePanel chequePanel;
    private Compra compra;
    private VentanaPrincipal ventanaPrincipal;

    public CompraVista(Compra compra) {
        this.compra = compra;
        setTitle("Gestión de Compras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        productoPanel = new ProductoPanel(compra);
        proveedorPanel = new ProveedorPanel(compra, productoPanel);
        chequePanel = new ChequePanel();

        
        proveedorPanel.getBuscarProveedorButton().addActionListener(new ButtonListener());
        productoPanel.getBuscarProductoButton().addActionListener(new ButtonListener());
        productoPanel.getAgregarButton().addActionListener(new ButtonListener());
        productoPanel.getTotalizarButton().addActionListener(new ButtonListener());
        productoPanel.getConfirmarCompraButton().addActionListener(new ButtonListener());
        productoPanel.getButSalir().addActionListener(new ButtonListener());

        gbc.insets = new Insets(2, 2, 2, 2);

     //   // Configurar GridBagConstraints para el panel de proveedor
        // Configurar GridBagConstraints para el panel de proveedor
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3; // Ancho relativo al de los otros paneles
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        add(proveedorPanel, gbc);

        // Configurar GridBagConstraints para el panel de cheque
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2; // Ocupa dos filas para tener el mismo alto que la suma de los otros dos paneles
        gbc.weightx = 0.2; // Reducir el peso horizontal para disminuir el ancho del panel de cheque
        gbc.weighty = 1.0; // Ocupa todo el espacio vertical disponible
        add(chequePanel, gbc);

        // Configurar GridBagConstraints para el panel de producto
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3; // Mismo ancho que el panel de proveedor
        gbc.weighty = 0.5;
        add(productoPanel, gbc);

        
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == proveedorPanel.getBuscarProveedorButton()) {
                proveedorPanel.buscarProveedor();
            } else if (evento.getSource() == productoPanel.getBuscarProductoButton()) {
                productoPanel.buscarProducto();
            } else if (evento.getSource() == productoPanel.getAgregarButton()) {
                String codigoProducto = productoPanel.getCodigoProducto();
                String cantidadStr = productoPanel.getCantidadField().getText();
                
                if (codigoProducto != null && !cantidadStr.isEmpty()) {
                    try {
                        int cantidad = Integer.parseInt(cantidadStr);
                        Producto producto = compra.buscarProductoPorCodigo(codigoProducto);
                        if (producto != null) {
                            compra.agregarProducto(producto, cantidad);
                            productoPanel.setProductos(compra.getProductosComprados(), compra.getCantidades());
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto y ingrese una cantidad.");
                }
            } else if (evento.getSource() == productoPanel.getTotalizarButton()) {
            	int iva = compra.leerIVA();
                
                // Calcular los totales y actualizar los campos de texto
                productoPanel.calcularTotales(iva);
            } else if (evento.getSource() == productoPanel.getConfirmarCompraButton()) {
                // Aquí debes añadir tu lógica para modificar un proveedor
                // ...
                // Y luego actualizar el JComboBox
            } else if (evento.getSource() == productoPanel.getButSalir()) {
                dispose();
            }
        }
    }

    public ProveedorPanel getProveedorPanel() {
        return proveedorPanel;
    }

    public ProductoPanel getProductoPanel() {
        return productoPanel;
    }

    public ChequePanel getChequePanel() {
        return chequePanel;
    }


    public CompraVista(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
}
