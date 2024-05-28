package co.edu.ucatolica.vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VentanaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnClientes;
    private JButton btnProveedores;
    private JButton btnProductos;
    private JButton btnVentas;
    private JButton btnCompras;
    private JButton btnReportes;
    private JButton btnTienda;

    public VentanaPrincipal() {
        setTitle("UCatolica SuperMarket");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Prevenir que la ventana se maximice

        // Crear el panel principal con BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Cargar y redimensionar el logo
        try {
            BufferedImage originalImage = ImageIO.read(new File("./images/logo.jpg"));
            int width = originalImage.getWidth() - (int) (3 / 0.264583); // Convertir mm a px (1 mm ≈ 0.264583 px)
            int height = originalImage.getHeight() - (int) (3 / 0.264583); // Convertir mm a px
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon logoIcon = new ImageIcon(resizedImage);
            JLabel logoLabel = new JLabel(logoIcon);
            logoLabel.setHorizontalAlignment(JLabel.CENTER);  // Centrar el logo horizontalmente
            logoLabel.setBorder(new BevelBorder(BevelBorder.RAISED));  // Añadir borde con relieve al logo
            panel.add(logoLabel, BorderLayout.NORTH);  // Añadir el logo en la parte superior del panel
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear panel para los botones con un GridLayout de 2 filas y 4 columnas
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(2, 4, 10, 10));  // Añadir espacio entre los botones

        // Inicializar los botones
        btnTienda = new JButton("Tienda");
        btnClientes = new JButton("Clientes");
        btnProveedores = new JButton("Proveedores");
        btnProductos = new JButton("Productos");
        btnVentas = new JButton("Ventas");
        btnCompras = new JButton("Compras");
        btnReportes = new JButton("Reportes");

        // Aplicar borde biselado a los botones
        JButton[] botones = {btnTienda, btnClientes, btnProveedores, btnProductos, btnVentas, btnCompras, btnReportes};
        for (JButton boton : botones) {
            boton.setBorder(new BevelBorder(BevelBorder.RAISED));
            boton.setMargin(new Insets(3, 13, 3, 13)); // Ajustar los márgenes si es necesario
        }

        // Añadir los botones al panel de botones
        botonesPanel.add(btnTienda);
        botonesPanel.add(btnClientes);
        botonesPanel.add(btnProveedores);
        botonesPanel.add(btnProductos);
        botonesPanel.add(btnVentas);
        botonesPanel.add(btnCompras);
        botonesPanel.add(btnReportes);

        // Crear un panel contenedor para los botones con márgenes a los lados y margen inferior
        JPanel botonesContainer = new JPanel(new BorderLayout());
        botonesContainer.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));  // Añadir márgenes de 10 píxeles a los lados y margen inferior
        botonesContainer.add(botonesPanel, BorderLayout.CENTER);

        // Añadir el panel de botones al centro del panel principal
        panel.add(botonesContainer, BorderLayout.CENTER);

        // Añadir el panel principal al contenido de la ventana
        getContentPane().add(panel);
    }

    public void setControlador(ActionListener controlador) {
        btnTienda.addActionListener(controlador);
        btnClientes.addActionListener(controlador);
        btnProveedores.addActionListener(controlador);
        btnProductos.addActionListener(controlador);
        btnVentas.addActionListener(controlador);
        btnCompras.addActionListener(controlador);
        btnReportes.addActionListener(controlador);
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JButton getBtnVentas() {
        return btnVentas;
    }

    public JButton getBtnCompras() {
        return btnCompras;
    }

    public JButton getBtnReportes() {
        return btnReportes;
    }

    public JButton getBtnTienda() {
        return btnTienda;
    }
}
