package co.edu.ucatolica.modelo;

import java.util.UUID;

public class GeneradorCodigo {
    public static String generarCodigoCompra() {
        // Genera un código único para la compra utilizando UUID
        String codigo = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        // Toma los primeros 8 caracteres del UUID
        return codigo.substring(0, 8);
    }
}
