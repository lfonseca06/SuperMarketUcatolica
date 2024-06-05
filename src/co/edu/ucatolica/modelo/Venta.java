package co.edu.ucatolica.modelo;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Venta {
    private static final String ARCHIVO_VENTAS = "data/ventas.dat";
    private static final String ARCHIVO_DETALLE_VENTAS = "data/detalle_ventas.dat";
    private static AtomicInteger contadorCodigoVenta = new AtomicInteger(0);

    public Venta() {
        // Inicializa el contador de código de venta desde el archivo de ventas si existe
        File fileVentas = new File(ARCHIVO_VENTAS);
        if (fileVentas.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileVentas))) {
                while (true) {
                    VentaRegistro registro = (VentaRegistro) ois.readObject();
                    contadorCodigoVenta.set(Math.max(contadorCodigoVenta.get(), registro.getCodigoVenta()));
                }
            } catch (EOFException e) {
                // Fin del archivo alcanzado
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar el archivo de ventas: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo cargar el archivo de ventas. Iniciando contador en 0.");
        }
    }

    public int generarCodigoVenta() {
        return contadorCodigoVenta.incrementAndGet();
    }

    public void registrarVenta(int codigoVenta, String cedulaCliente, double valorTotal, double valorIVA, double valorTotalConIVA) throws IOException {
        VentaRegistro registro = new VentaRegistro(codigoVenta, cedulaCliente, valorTotal, valorIVA, valorTotalConIVA);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VENTAS, true))) {
            oos.writeObject(registro);
        }
    }

    public void registrarVenta(String cedulaCliente, double valorTotal, double valorIVA, double valorTotalConIVA, List<Producto> productos, List<Integer> cantidades) throws IOException {
        int codigoVenta = generarCodigoVenta();
        registrarVenta(codigoVenta, cedulaCliente, valorTotal, valorIVA, valorTotalConIVA);

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            registrarDetalleVenta(codigoVenta, producto.getCodigo(), cantidad, producto.getPrecioVenta(), producto.getPrecioVenta() * cantidad);
        }
    }

    public void registrarDetalleVenta(int codigoVenta, String codigoProducto, int cantidad, double valorUnitario, double valorTotal) throws IOException {
        DetalleVenta detalle = new DetalleVenta(codigoVenta, codigoProducto, cantidad, valorUnitario, valorTotal);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DETALLE_VENTAS, true))) {
            oos.writeObject(detalle);
        }
    }
}
