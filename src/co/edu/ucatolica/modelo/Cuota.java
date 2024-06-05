package co.edu.ucatolica.modelo;

import java.io.Serializable;

public class Cuota implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int numeroCuota;
    private double saldo;
    private double valorCuota;
    private double intereses;
    private double amortizacionCapital;

    public Cuota(int numeroCuota, double saldo, double valorCuota, double intereses, double amortizacionCapital) {
        this.numeroCuota = numeroCuota;
        this.saldo = saldo;
        this.valorCuota = valorCuota;
        this.intereses = intereses;
        this.amortizacionCapital = amortizacionCapital;
    }

    // Getters y setters
    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public double getAmortizacionCapital() {
        return amortizacionCapital;
    }

    public void setAmortizacionCapital(double amortizacionCapital) {
        this.amortizacionCapital = amortizacionCapital;
    }
}
