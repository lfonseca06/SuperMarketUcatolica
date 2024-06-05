package co.edu.ucatolica.modelo;


import java.util.UUID;

public class GeneradorCodigo {
    public static String generarCodigoCompra() {
        // Genera un código único para la compra utilizando UUID
        return UUID.randomUUID().toString();
    }
}