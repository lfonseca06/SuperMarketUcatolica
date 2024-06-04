package co.edu.ucatolica.vista;
 

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import co.edu.ucatolica.modelo.Proveedor;
import co.edu.ucatolica.modelo.Compra;
import java.util.List;

public class ProveedorPanel extends JPanel {
    private JComboBox<String> nitField;
    private JTextField nombreProveedorField;
    private JButton buscarProveedorButton;
    private Compra compra;
    private ProductoPanel productoPanel; // Añadido
    private JLabel imagenLabel; // Añadido para la imagen

    public ProveedorPanel(Compra compra, ProductoPanel productoPanel) { // Modificado
        this.compra = compra;
        this.productoPanel = productoPanel; // Añadido
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE), "Proveedor", TitledBorder.LEFT, TitledBorder.TOP));
        String[] opciones = getNitsFromProveedores(compra);
        nitField = new JComboBox<>(opciones);
        nombreProveedorField = new JTextField(15);
        buscarProveedorButton = new JButton("Buscar Proveedor");

        gbc.insets = new Insets(2, 2, 2, 2);
        
     // Añadir la imagen al panel
        imagenLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(new File("./images/logo.jpg")));
            // Redimensionar la imagen a un 60% de su tamaño original
            Image scaledImage = icon.getImage().getScaledInstance(icon.getIconWidth() * 60 / 100, icon.getIconHeight() * 60 / 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            imagenLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5; // Para que la imagen ocupe el ancho completo de los elementos debajo
        gbc.anchor = GridBagConstraints.CENTER;
        add(imagenLabel, gbc);

        gbc.gridwidth = 1; // Restablecer el ancho de los componentes a 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("NIT"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nitField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        add(buscarProveedorButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Nombre del Proveedor"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(nombreProveedorField, gbc);


        buscarProveedorButton.setBackground(Color.LIGHT_GRAY);
        nitField.setBackground(Color.YELLOW);
    }

    private String[] getNitsFromProveedores(Compra compra) {
        Proveedor[] proveedores = compra.leerProveedores();
        String[] nits = new String[proveedores.length];
        
        for (int i = 0; i < proveedores.length; i++) {
            nits[i] = proveedores[i].getNIT();
        }
        return nits;
    }

    public JButton getBuscarProveedorButton() {
        return buscarProveedorButton;
    }

    public String getNit() {
        return (String) nitField.getSelectedItem();
    }

    public void setNombreProveedorField(String nombre) {
        nombreProveedorField.setText(nombre);
    }

    public JTextField getNombreProveedorField() {
        return nombreProveedorField;
    }
    
    public void actualizarProveedores() {
        String[] opciones = getNitsFromProveedores(compra);
        nitField.setModel(new DefaultComboBoxModel<>(opciones));
    }

    public void buscarProveedor() {
        if (productoPanel != null) {
            String nit = getNit();
            Proveedor proveedor = compra.buscarProveedor(nit);
            if (proveedor != null) {
                setNombreProveedorField(proveedor.getNombre());

                // Obtener los códigos de los productos relacionados con este proveedor
                List<String> codigosProductos = compra.obtenerCodigosProductosPorNITProveedor(nit);

                // Actualizar el JComboBox de códigos de producto en el ProductoPanel
                productoPanel.getCodigoProductoField().setModel(new DefaultComboBoxModel<>(codigosProductos.toArray(new String[0])));
            } else {
                setNombreProveedorField("Proveedor no encontrado");
            }
        } else {
            // Manejo de la situación donde productoPanel es null
            System.out.println("productoPanel es null");
        }
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        actualizarProveedores();
    }
}