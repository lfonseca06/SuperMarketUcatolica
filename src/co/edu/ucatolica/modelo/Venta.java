package co.edu.ucatolica.modelo;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Venta {
    private static final String ARCHIVO_VENTAS = "data/ventas.txt";
    private static final String ARCHIVO_DETALLE_VENTAS = "data/detalle_ventas.txt";
    private static AtomicInteger contadorCodigoVenta = new AtomicInteger(0);

    public Venta() {
        // Inicializa el contador de código de venta desde el archivo de ventas si existe
        File fileVentas = new File(ARCHIVO_VENTAS);
        if (fileVentas.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileVentas))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    int codigoVenta = Integer.parseInt(datos[0].split(":")[1].trim());
                    contadorCodigoVenta.set(Math.max(contadorCodigoVenta.get(), codigoVenta));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int generarCodigoVenta() {
        return contadorCodigoVenta.incrementAndGet();
    }

    public void registrarVenta(int codigoVenta, String cedulaCliente, double valorTotal, double valorIVA, double valorTotalConIVA) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_VENTAS, true))) {
            writer.write("Código de Venta: " + codigoVenta + ", Cédula del Cliente: " + cedulaCliente + ", Valor Total: " + valorTotal + ", Valor IVA: " + valorIVA + ", Valor Total con IVA: " + valorTotalConIVA);
            writer.newLine();
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_DETALLE_VENTAS, true))) {
            writer.write("Código de Venta: " + codigoVenta + ", Código de Producto: " + codigoProducto + ", Cantidad: " + cantidad + ", Valor Unitario: " + valorUnitario + ", Valor Total: " + valorTotal);
            writer.newLine();
        }
    }
}
