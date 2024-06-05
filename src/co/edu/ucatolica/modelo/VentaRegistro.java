package co.edu.ucatolica.modelo;

import java.io.Serializable;

public class VentaRegistro implements Serializable {
    private int codigoVenta;
    private String cedulaCliente;
    private double valorTotal;
    private double valorIVA;
    private double valorTotalConIVA;

    public VentaRegistro(int codigoVenta, String cedulaCliente, double valorTotal, double valorIVA, double valorTotalConIVA) {
        this.codigoVenta = codigoVenta;
        this.cedulaCliente = cedulaCliente;
        this.valorTotal = valorTotal;
        this.valorIVA = valorIVA;
        this.valorTotalConIVA = valorTotalConIVA;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorIVA() {
        return valorIVA;
    }

    public double getValorTotalConIVA() {
        return valorTotalConIVA;
    }
}
