package co.edu.ucatolica.modelo;

import java.io.Serializable;
import java.util.List;

public class Compra implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String NITProveedor;
    private double valorTotal;
    private double valorIVA;
    private double valorTotalConIVA;
    private List<DetalleCompra> detalles;

    // Getters y Setters
}

