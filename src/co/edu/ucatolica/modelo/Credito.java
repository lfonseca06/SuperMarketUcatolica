package co.edu.ucatolica.modelo;
import co.edu.ucatolica.modelo.Cuota;

import java.io.Serializable;
import java.util.List;

public class Credito implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int codigoVenta;
    private String cedulaCliente;
    private double montoFinanciar;
    private double tasaInteresNominal;
    private int plazoMeses;
    private List<Cuota> tablaAmortizacion;

    public Credito(int codigoVenta, String cedulaCliente, double montoFinanciar, double tasaInteresNominal, int plazoMeses, List<Cuota> tablaAmortizacion) {
        this.codigoVenta = codigoVenta;
        this.cedulaCliente = cedulaCliente;
        this.montoFinanciar = montoFinanciar;
        this.tasaInteresNominal = tasaInteresNominal;
        this.plazoMeses = plazoMeses;
        this.tablaAmortizacion = tablaAmortizacion;
    }

    // Getters y setters
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public double getMontoFinanciar() {
        return montoFinanciar;
    }

    public void setMontoFinanciar(double montoFinanciar) {
        this.montoFinanciar = montoFinanciar;
    }

    public double getTasaInteresNominal() {
        return tasaInteresNominal;
    }

    public void setTasaInteresNominal(double tasaInteresNominal) {
        this.tasaInteresNominal = tasaInteresNominal;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public List<Cuota> getTablaAmortizacion() {
        return tablaAmortizacion;
    }

    public void setTablaAmortizacion(List<Cuota> tablaAmortizacion) {
        this.tablaAmortizacion = tablaAmortizacion;
    }
}
