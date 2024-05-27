package co.edu.ucatolica.modelo;

import java.io.Serializable;
import java.util.List;

public class Venta implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String cedulaCliente;
    private double valorTotal;
    private double valorIVA;
    private double valorTotalConIVA;
    private List<DetalleVenta> detalles;

    // Getters y Setters
}
