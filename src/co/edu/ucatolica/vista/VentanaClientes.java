package co.edu.ucatolica.vista;

import javax.swing.*;
import co.edu.ucatolica.modelo.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaClientes extends JFrame {

    private JTextField txtCedula;
    private JTextField txtNombreCompleto;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTable tableClientes;
    private List<Cliente> listaClientes;
    private Cliente clientePersis;
    
    private int selectedRow; //añadido por victor 
    
   
    
    public VentanaClientes(Cliente cli) {
        super("Clientes");
        
        
        
        clientePersis = cli.crearCliente();
        listaClientes = clientePersis.getPersisClientes().getListaClientes();

        JLabel lblTitulo = new JLabel("Gestión de Clientes");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setOpaque(true);
        lblTitulo.setForeground(Color.GREEN);

        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblTelefono = new JLabel("Teléfono:");
        JLabel lblCorreo = new JLabel("Correo Electrónico:");

        txtCedula = new JTextField(20);
        txtNombreCompleto = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCorreo = new JTextField(20);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        
        
        
        
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                String nombreCompleto = txtNombreCompleto.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();

                if (!cedulaExiste(cedula)) {
                    Cliente cliente = new Cliente(cedula, nombreCompleto, direccion, telefono, correo);
                    clientePersis.getPersisClientes().guardarCliente(cliente);
                    listaClientes = clientePersis.getPersisClientes().getListaClientes();
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Se guardo cliente satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(null, "La cédula ya existe. No se puede guardar el cliente.");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criterio = txtCedula.getText();
                //buscarCliente(criterio); //eliminado por victor 
                
                
                //Añadido por victor
                if (criterio.isEmpty()) {
                    // El campo txtCedula está vacío
                    JOptionPane.showMessageDialog(null, "Debe ingresar un criterio de búsqueda");
                    return; // Salir del método actionPerformed
                }
                else if (!criterio.isEmpty()) {
                	selectedRow =(buscarCliente_enLista(criterio));//añadido por victor 
                    System.out.println("busqueda de posicion lista: "+selectedRow);//añadido por victor 
                	
                }
                //Añadido por victor
                
                
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectedRow = tableClientes.getSelectedRow(); //borrado por victor 
            	System.out.println("modificar posicion lista: "+selectedRow);//añadido por victor 
                if (selectedRow >= 0) {
                    Cliente cliente = listaClientes.get(selectedRow);
                    cliente.setCedula(txtCedula.getText());
                    cliente.setNombreCompleto(txtNombreCompleto.getText());
                    cliente.setDireccion(txtDireccion.getText());
                    cliente.setTelefono(txtTelefono.getText());
                    cliente.setCorreo(txtCorreo.getText());
                    
                    clientePersis.getPersisClientes().guardarListaClientes();
                    listaClientes = clientePersis.getPersisClientes().getListaClientes();
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Cliente editado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla para modificar.");
                }
                
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectedRow = tableClientes.getSelectedRow();//eliminado por victor 
            	System.out.println("eliminar posicion lista: "+selectedRow);//añadido por victor 
                if (selectedRow >= 0) {
                    listaClientes.remove(selectedRow);
                    clientePersis.getPersisClientes().guardarListaClientes();
                    listaClientes = clientePersis.getPersisClientes().getListaClientes();
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla para eliminar.");
                }
            }
        });
        
        /*
        //eliminado por victor 
        tableClientes = new JTable();
        actualizarTabla();

        tableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tableClientes.getSelectedRow() != -1) {
                    int selectedRow = tableClientes.getSelectedRow();
                    Cliente cliente = listaClientes.get(selectedRow);
                    txtCedula.setText(cliente.getCedula());
                    txtNombreCompleto.setText(cliente.getNombreCompleto());
                    txtDireccion.setText(cliente.getDireccion());
                    txtTelefono.setText(cliente.getTelefono());
                    txtCorreo.setText(cliente.getCorreo());
                }
            }
        });
        //eliminado por victor 
        */
        
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(lblCedula);
        panel.add(txtCedula);
        panel.add(lblNombreCompleto);
        panel.add(txtNombreCompleto);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnModificar);
        panel.add(btnEliminar);
        
        
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // Espacio de 20 píxeles a la derecha e izquierda
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelTitulo, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
        
        
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        
        
        
        
    }
    
    
    /*
    //eliminado por victor 
    private void buscarCliente(String criterio) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(criterio) || cliente.getNombreCompleto().contains(criterio)) {
                clientesEncontrados.add(cliente);
            }
        }
        mostrarClientes(clientesEncontrados); 
    }
    //eliminado por victor 
    */
    
    public void limpiarCampos() {
    	// Inicializar campos en vacío
        txtCedula.setText("");
        txtNombreCompleto.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    
 
    
    
    //añadido por victor
    private int buscarCliente_enLista(String criterio) {
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            
            System.out.println("criterio es: "+criterio);

            if (cliente.getCedula().equals(criterio) || cliente.getNombreCompleto().contains(criterio)) {

                // Llenar los campos con la información del cliente encontrado
                txtNombreCompleto.setText(cliente.getNombreCompleto());
                txtDireccion.setText(cliente.getDireccion());
                txtTelefono.setText(cliente.getTelefono());
                txtCorreo.setText(cliente.getCorreo());

                // Retornar la posición del cliente en la lista
                return i;
            }
            
        }
        // Si no se encuentra el cliente, retornar -1
        JOptionPane.showMessageDialog(null, "Cliente no se encuentra");
        return -1;
        
    }
    //añadido por victor
    
    /*
    //eliminado por victor 
    public void mostrarClientes(List<Cliente> clientes) {
        String[] columnNames = {"Cédula", "Nombre Completo", "Dirección", "Teléfono", "Correo Electrónico"};
        String[][] data = new String[clientes.size()][5];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = cliente.getCedula();
            data[i][1] = cliente.getNombreCompleto();
            data[i][2] = cliente.getDireccion();
            data[i][3] = cliente.getTelefono();
            data[i][4] = cliente.getCorreo();
        }

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
    //eliminado por victor
    */
    
    private void actualizarTabla() {
        //mostrarClientes(listaClientes); //eliminado por victor 
    }

    private boolean cedulaExiste(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }
}

