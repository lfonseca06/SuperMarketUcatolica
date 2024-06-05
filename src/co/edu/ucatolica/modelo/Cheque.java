package co.edu.ucatolica.modelo;

import java.io.IOException;
import java.io.Serializable;

import javax.swing.JTextField;

import co.edu.ucatolica.modelo.persistencia.GestorArchivos;

public class Cheque implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int consecutivo;
    private String nombreProveedor;
    private int valorTotalConIVA;
    private String nombreBanco;
    private String numeroCuenta;
    private static final String FILE_PATH = "./data/consecutivo_cheques.txt";

    // Constructor
    public Cheque(int consecutivo, String nombreProveedor, int valorTotalConIVA, String nombreBanco,
            String numeroCuenta) {
        this.consecutivo = consecutivo;
        this.nombreProveedor = nombreProveedor;
        this.valorTotalConIVA = valorTotalConIVA;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
    }
    
    public Cheque() {
        
    }

    // Método para leer el consecutivo de cheques
    public static int leerTexto() throws IOException {
    	return Integer.parseInt(GestorArchivos.leerTexto(FILE_PATH).trim());
    }

 // Método para actualizar el consecutivo de cheques
    public static void actualizarConsecutivoCheque(int nuevoConsecutivo) throws IOException {
        GestorArchivos.guardarTexto(FILE_PATH, Integer.toString(nuevoConsecutivo));
    }

    // Método para obtener y actualizar el consecutivo del cheque
    public int obtenerConsecutivoCheque() throws IOException {
        int consecutivoCheque = leerTexto();
        actualizarConsecutivoCheque(consecutivoCheque + 1);
        return consecutivoCheque;
    }

    // Método para generar la representación en texto del cheque
    public String generarTextoCheque() {
        StringBuilder chequeText = new StringBuilder();
        //chequeText.append("Consecutivo de cheque: ").append(consecutivo).append("\n");
        //chequeText.append("Nombre del proveedor: ").append(nombreProveedor).append("\n");
        //chequeText.append("Valor total con IVA (en cifra): $").append(valorTotalConIVA).append("\n");
        // Convertir el valor total con IVA a monto escrito
        String montoEscrito = convertirMontoEscrito(valorTotalConIVA);
        chequeText.append(montoEscrito).append("\n");
        
        //chequeText.append("Valor total con IVA (en monto escrito): ").append(montoEscrito).append("\n");
        //chequeText.append("Nombre del banco: ").append(nombreBanco).append("\n");
        //chequeText.append("Número de cuenta: ").append(numeroCuenta).append("\n");
        return chequeText.toString();
    }

    // Método para convertir el valor total con IVA a monto escrito
    private String convertirMontoEscrito(int valorTotalConIVA) {
    	String texto = NumeroATexto.convertir(valorTotalConIVA);
        return texto;
    }

    // Método para guardar los datos del cheque en un archivo
    public void guardarChequeArchivo(String filePath) throws IOException {
        String chequeText = generarTextoCheque();
        GestorArchivos.guardarTexto(filePath, chequeText);
    }

    // Getters y setters
    public static int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getValorTotalConIVA() {
        return valorTotalConIVA;
    }

    public void setValorTotalConIVA(int valorTotalConIVA) {
        this.valorTotalConIVA = valorTotalConIVA;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
