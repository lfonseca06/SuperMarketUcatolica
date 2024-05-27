
package co.edu.ucatolica.modelo.persistencia;

import java.io.IOException;



public class EjemploGestorArchivos {

    public static void main(String[] args) {
        String rutaArchivoTexto = "datos.txt";
        String contenido = "Esto es un ejemplo de contenido de texto.";

        try {
            // Guardar texto en archivo
            GestorArchivos.guardarTexto(rutaArchivoTexto, contenido);
            System.out.println("Texto guardado exitosamente.");

            // Leer texto desde archivo
            String textoLeido = GestorArchivos.leerTexto(rutaArchivoTexto);
            System.out.println("Texto leído: " + textoLeido);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
