package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.ucatolica.modelo.Cheque;
import co.edu.ucatolica.modelo.Compra;
import co.edu.ucatolica.modelo.Producto;
import co.edu.ucatolica.modelo.Proveedor;

// Clase para el panel de fondo
class FondoPanel extends JPanel {
    private Image imagen;

    // Constructor que carga la imagen desde un archivo
    public FondoPanel(String nombreImagen) {
        try {
            imagen = new ImageIcon(nombreImagen).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para pintar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class CompraVista extends JFrame {
    private ProveedorPanel proveedorPanel;
    private ProductoPanel productoPanel;
    private ChequePanel chequePanel;
    private Compra compra;
    private double valTotal = 0;

    public CompraVista(Compra compra) {
        this.compra = compra;
        setTitle("Gestión de Compras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        
        // Crear el panel de fondo con la imagen especificada
        FondoPanel fondoPanel = new FondoPanel("./images/imagendefondo.jpg");

        // Establecer el layout del panel de fondo
        fondoPanel.setLayout(new GridBagLayout());
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

        // Configurar GridBagConstraints para los paneles
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        fondoPanel.add(proveedorPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        fondoPanel.add(chequePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 0.5;
        fondoPanel.add(productoPanel, gbc);

        // Establecer el panel de fondo como el panel principal de la ventana
        setContentPane(fondoPanel);
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
                valTotal = productoPanel.calcularTotales(iva);
                compra.setValorTotalConIVA(valTotal);
            } else if (evento.getSource() == productoPanel.getConfirmarCompraButton()) {
                confirmarCompraAction();
            } else if (evento.getSource() == productoPanel.getButSalir()) {
                dispose();
            }
        }
    }

    public void confirmarCompraAction() {
        try {
            compra.generarCodigoCompra();
            String nombreProveedor = proveedorPanel.getNombreProveedor(); // Obtener el texto del JTextField
            String nombreBanco = compra.leerBanco();
            String numeroCuenta = compra.leerCuenta();
            Cheque cheque2 = new Cheque();
            
            int consecutivoCheque = cheque2.obtenerConsecutivoCheque(); // Obtener y actualizar el consecutivo del cheque

            //compra.confirmarCompra(consecutivoCheque, nombreProveedor, nombreBanco, numeroCuenta);
           
            // Mostrar detalles del cheque
            Cheque cheque = new Cheque(consecutivoCheque, nombreProveedor, (int)valTotal, nombreBanco, numeroCuenta);
            System.out.println(cheque);
            chequePanel.mostrarCheque(cheque);

            // Guardar datos de la compra
            compra.guardarCompraEnArchivo("./data/compras.txt");
            compra.guardarDetalleCompraEnArchivo("./data/detalle_compras.txt");
            compra.guardarChequeEnArchivo("./data/cheques.txt", consecutivoCheque);

            JOptionPane.showMessageDialog(this, "Compra confirmada y datos guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos de la compra: " + e.getMessage());
            e.printStackTrace();
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

    public void mostrarCheque(Cheque cheque) {
        chequePanel.mostrarCheque(cheque);
    }
}