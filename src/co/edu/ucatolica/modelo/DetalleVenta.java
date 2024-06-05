package co.edu.ucatolica.modelo;

import java.io.Serializable;

public class DetalleVenta implements Serializable {
    private int codigoVenta;
    private String codigoProducto;
    private int cantidad;
    private double valorUnitario;
    private double valorTotal;

    public DetalleVenta(int codigoVenta, String codigoProducto, int cantidad, double valorUnitario, double valorTotal) {
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
