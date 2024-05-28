package co.edu.ucatolica.modelo;

import java.io.Serializable;
import co.edu.ucatolica.modelo.persistencia.*;

public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String NIT;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;

	public Proveedor() {
		
	}
	
	public Proveedor(String NIT, String nombre, String direccion, String telefono, String ciudad) {
		this.NIT = NIT;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	public String buscarProv(String nit ){
		if (nit.equals("")){
			return("el esta bacio");
		}
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		String prov=persis.bucarProveedor(nit).toString();
		if (prov==null){
			return("El proveedor con Nit: "+nit+" no esxite ");
		}
		return prov;
	}

	public void eliminarProveedor(String nit){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		persis.eliminarProveedor(nit);
	}
	public void guardarProveedor(){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		persis.escribirArchivoBinarioProveedor(this);
		
	}
	public Proveedor[] verPro(){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		Proveedor[] leidos = persis.leerArchivoBinarioProveedores();
		return leidos;
	}
	public void modifPro(String nit ,Proveedor pro){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		persis.modificarProveedor(nit,pro);
		
	}

	
	public String getNIT() {
		return NIT;
	}
	
	public void setNIT(String NIT) {
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

