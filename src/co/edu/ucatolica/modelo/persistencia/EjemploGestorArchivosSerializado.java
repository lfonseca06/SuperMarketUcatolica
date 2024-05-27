package co.edu.ucatolica.modelo.persistencia;

import java.io.IOException;
import java.io.Serializable;

public class EjemploGestorArchivosSerializado {

    public static void main(String[] args) {
        String rutaArchivoObjeto = "objeto.dat";
        Persona persona = new Persona("Juan", 30);

        try {
            // Guardar objeto serializado en archivo
            GestorArchivos.guardarSerializado(rutaArchivoObjeto, persona);
            System.out.println("Objeto guardado exitosamente.");

            // Leer objeto desde archivo serializado
            Persona personaLeida = (Persona) GestorArchivos.leerSerializado(rutaArchivoObjeto);
            System.out.println("Objeto leído: " + personaLeida);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
