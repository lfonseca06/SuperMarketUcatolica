package co.edu.ucatolica.modelo;

import co.edu.ucatolica.modelo.persistencia.PersistenciaClientes;
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correo;
    private transient PersistenciaClientes perClientes = new PersistenciaClientes();

    public Cliente() {}

    public Cliente(String cedula, String nombreCompleto, String direccion, String telefono, String correo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente crearCliente(){
        return new Cliente();
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public PersistenciaClientes getPersisClientes() {
        return perClientes;
    }
}
