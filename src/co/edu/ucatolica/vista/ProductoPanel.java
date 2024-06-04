package co.edu.ucatolica.vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import co.edu.ucatolica.modelo.Compra;
import co.edu.ucatolica.modelo.Producto;
import co.edu.ucatolica.modelo.Proveedor;
import java.util.List;

public class ProductoPanel extends JPanel {
    private JComboBox<String> codigoProductoField;
    private JTextField nombreProductoField;
    private JTextField cantidadField;
    private JTextField valorField;
    private JButton buscarProductoButton;
    private JButton agregarButton;
    private Compra compra;
    private JTextField cantidadComprarField;
    private JTextField valorTotalCompraField;
    private JTextField valorTotalConIVAField;
    private JButton totalizarButton;
    private JButton confirmarCompraButton;
    private JButton butSalir;
    
    
    public static final String SALIR = "Salir";
    
    private JTextArea produc, valUni, cantidad, valorTotal, ValorAc;

    public ProductoPanel(Compra compra) {
        this.compra = compra;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE), "Producto", TitledBorder.LEFT, TitledBorder.TOP));
        
        gbc.gridx = 0;
        gbc.gridy = 6; // Ajusta esta posición según la ubicación deseada en tu diseño
        gbc.gridwidth = 4; // O el número de columnas que desees ocupar
        gbc.weighty = 1.0; // Para que el JTextArea se expanda verticalmente
        gbc.fill = GridBagConstraints.BOTH; // Para que el JTextArea se expanda en ambas direcciones        
        
        // Inicialización de campos
        codigoProductoField = new JComboBox<>();
        nombreProductoField = new JTextField(15);
        cantidadField = new JTextField(5);
        valorField = new JTextField(10);
        buscarProductoButton = new JButton("Buscar Producto");
        agregarButton = new JButton("Agregar");
        totalizarButton = new JButton("Totalizar");
        confirmarCompraButton = new JButton("Confirmar Compra");
        
        butSalir = new JButton("Salir");
        butSalir.setActionCommand(SALIR);
        butSalir.setBackground(new Color(255, 102, 102)); // Cambiar color a rojo claro

        
        gbc.insets = new Insets(5, 5, 5, 5); // Ajustar el espaciado entre componentes

        cantidadComprarField = new JTextField(15);
        valorTotalCompraField = new JTextField(15);
        valorTotalConIVAField = new JTextField(15);
        

        // Campos de texto para la tabla de lectura de registros
        produc = createTextArea();
        valUni = createTextArea();
        cantidad = createTextArea();
        valorTotal = createTextArea();
        ValorAc = createTextArea();

        // Layout configuración
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.1;
        add(new JLabel("Código del producto"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.8;
        add(codigoProductoField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(buscarProductoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(new JLabel("Nombre del Producto"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 0.9;
        add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(new JLabel("Cantidad a comprar"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0.8;
        add(cantidadField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(agregarButton, gbc);

        // Añadir las áreas de texto para la tabla de lectura de registros
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(createTablePanel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0;
        add(new JLabel("Valor Total de la Compra"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 0.9;
        add(valorTotalCompraField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(new JLabel("Valor Total con IVA"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 0.9;
        add(valorTotalConIVAField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(totalizarButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(confirmarCompraButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        add(butSalir, gbc);

        buscarProductoButton.setBackground(Color.LIGHT_GRAY);
        codigoProductoField.setBackground(Color.YELLOW);
        totalizarButton.setBackground(Color.LIGHT_GRAY);
        confirmarCompraButton.setBackground(Color.LIGHT_GRAY);

    }

    JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(100, 100)); // Ajustar el tamaño preferido
        return textArea;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE), "Lectura Registros"));
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        tablePanel.add(createTitleLabel("Producto"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        tablePanel.add(createTitleLabel("Valor Unitario"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        tablePanel.add(createTitleLabel("Cantidad"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        tablePanel.add(createTitleLabel("Valor Total"), gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        tablePanel.add(createTitleLabel("Acomulado"), gbc);

        addTextAreaToPanel(tablePanel, produc, gbc, 0);
        addTextAreaToPanel(tablePanel, valUni, gbc, 1);
        addTextAreaToPanel(tablePanel, cantidad, gbc, 2);
        addTextAreaToPanel(tablePanel, valorTotal, gbc, 3);
        addTextAreaToPanel(tablePanel, ValorAc, gbc, 4);

        return tablePanel;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(100, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    private void addTextAreaToPanel(JPanel panel, JTextArea textArea, GridBagConstraints gbc, int x) {
        gbc.gridx = x;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(new JScrollPane(textArea), gbc);
    }
    
    public JButton getTotalizarButton() {
        return totalizarButton;
    }

    public JButton getBuscarProductoButton() {
        return buscarProductoButton;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JComboBox<String> getCodigoProductoField() {
        return codigoProductoField;
    }

    public String getCodigoProducto() {
        return (String) codigoProductoField.getSelectedItem();
    }

    public void setNombreProductoField(String nombre) {
        nombreProductoField.setText(nombre);
    }

    public void setCantidadField(String cantidad) {
        cantidadField.setText(cantidad);
    }

    public void setValorField(String valor) {
        valorField.setText(valor);
    }

    public JTextField getNombreProductoField() {
        return nombreProductoField;
    }

    public JTextField getCantidadField() {
        return cantidadField;
    }

    public JTextField getValorField() {
        return valorField;
    }

    public void buscarProducto() {
        String codigo = getCodigoProducto();
        List<Producto> productos = compra.leerProductos();
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                setNombreProductoField(producto.getNombre());
                return;
            }
        }
        setNombreProductoField("Producto no encontrado");
    }

    public JTextField getCantidadComprarField() {
        return cantidadComprarField;
    }

    public void setCantidadComprarField(JTextField cantidadComprarField) {
        this.cantidadComprarField = cantidadComprarField;
    }

    public JTextField getValorTotalCompraField() {
        return valorTotalCompraField;
    }

    public void setValorTotalCompraField(JTextField valorTotalCompraField) {
        this.valorTotalCompraField = valorTotalCompraField;
    }

    public void setProductos(List<Producto> productos, List<Integer> cantidades) {
        StringBuilder nombreText = new StringBuilder();
        StringBuilder valorUnitarioText = new StringBuilder();
        StringBuilder cantidadText = new StringBuilder();
        StringBuilder valorTotalText = new StringBuilder();
        StringBuilder valorAcumuladoText = new StringBuilder();
        double valorAcumulado = 0;

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            double valorTotal = producto.getPrecioVenta() * cantidad;
            valorAcumulado += valorTotal;

            nombreText.append(producto.getNombre()).append("\n");
            valorUnitarioText.append(producto.getPrecioVenta()).append("\n");
            cantidadText.append(cantidad).append("\n");
            valorTotalText.append(valorTotal).append("\n");
            valorAcumuladoText.append(valorAcumulado).append("\n");
        }

        produc.setText(nombreText.toString());
        valUni.setText(valorUnitarioText.toString());
        cantidad.setText(cantidadText.toString());
        valorTotal.setText(valorTotalText.toString());
        ValorAc.setText(valorAcumuladoText.toString());
    }
    
    public JButton getConfirmarCompraButton() {
        return confirmarCompraButton;
    }
    
    public JButton getButSalir() {
        return butSalir;
    }


}
