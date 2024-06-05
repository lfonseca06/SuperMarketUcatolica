package co.edu.ucatolica.modelo.persistencia;

import co.edu.ucatolica.modelo.DetalleVenta;
import co.edu.ucatolica.modelo.VentaRegistro;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class VerificarArchivos {
    public static void main(String[] args) {
        leerArchivoVentas();
        leerArchivoDetalleVentas();
    }

    public static void leerArchivoVentas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/ventas.dat"))) {
            while (true) {
                VentaRegistro registro = (VentaRegistro) ois.readObject();
                System.out.println(registro);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void leerArchivoDetalleVentas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/detalle_ventas.dat"))) {
            while (true) {
                DetalleVenta detalle = (DetalleVenta) ois.readObject();
                System.out.println(detalle);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
