package co.edu.ucatolica.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private String NITProveedor;
    private double precioCompra;
    private double precioVenta;

    public Producto() {}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNITProveedor() {
        return NITProveedor;
    }

    public void setNITProveedor(String NITProveedor) {
        this.NITProveedor = NITProveedor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return codigo + " " + nombre + " " + NITProveedor + " " + precioCompra + " " + precioVenta;
    }
}
