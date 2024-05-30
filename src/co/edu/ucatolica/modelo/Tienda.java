package co.edu.ucatolica.modelo;

import java.io.*;
import java.util.Properties;

public class Tienda implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String CONFIG_PATH = "data/config.dat";
    
    private String nombre;
    private String tipoComercio;
    private String NIT;
    private String ciudad;
    private double valorIVA;
    private double tasaInteres;
    private String nombreBanco;
    private String numeroCuenta;
    private String nombreGerente;

    public static boolean existeEmpresa() {
        File configFile = new File(CONFIG_PATH);
        return configFile.exists();
    }

    public void guardarConfiguracion() throws IOException {
        File configDir = new File("persistencia");
        if (!configDir.exists()) {
            configDir.mkdir();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONFIG_PATH))) {
            oos.writeObject(this);
        }
    }

    public void cargarConfiguracion() throws IOException {
        File configFile = new File(CONFIG_PATH);
        if (configFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(configFile))) {
                Tienda tienda = (Tienda) ois.readObject();
                this.nombre = tienda.nombre;
                this.tipoComercio = tienda.tipoComercio;
                this.NIT = tienda.NIT;
                this.ciudad = tienda.ciudad;
                this.valorIVA = tienda.valorIVA;
                this.tasaInteres = tienda.tasaInteres;
                this.nombreBanco = tienda.nombreBanco;
                this.numeroCuenta = tienda.numeroCuenta;
                this.nombreGerente = tienda.nombreGerente;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  // Imprime la traza de la excepción para más detalles
                throw new IOException("Error al cargar la configuración: " + e.getMessage());
            }
        }
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipoComercio() { return tipoComercio; }
    public void setTipoComercio(String tipoComercio) { this.tipoComercio = tipoComercio; }
    public String getNIT() { return NIT; }
    public void setNIT(String NIT) { this.NIT = NIT; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public double getValorIVA() { return valorIVA; }
    public void setValorIVA(double valorIVA) { this.valorIVA = valorIVA; }
    public double getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }
    public String getNombreBanco() { return nombreBanco; }
    public void setNombreBanco(String nombreBanco) { this.nombreBanco = nombreBanco; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public String getNombreGerente() { return nombreGerente; }
    public void setNombreGerente(String nombreGerente) { this.nombreGerente = nombreGerente; }
    
}
