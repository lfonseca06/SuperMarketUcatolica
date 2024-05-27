package co.edu.ucatolica.modelo;

import java.io.Serializable;

public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int NIT;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	
	public Proveedor(int NIT, String nombre, String direccion, String telefono, String ciudad) {
		this.NIT = NIT;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	public void guardarProveedor(){
		
	}
	
	public int getNIT() {
		return NIT;
	}
	
	public void setNIT(int NIT) {
		this.NIT = NIT;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "NIT: " + this.NIT + " Nombre: " + this.nombre + " Direccion: " + this.direccion + " Telefono: " + this.telefono + " Ciudad: " + this.ciudad;
	}
}

