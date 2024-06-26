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

	public Proveedor creaProveedor(String NIT, String nombre, String direccion, String telefono, String ciudad) {
		return(new Proveedor( NIT, nombre,direccion, telefono, ciudad));
	}
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
		Proveedor prov=persis.bucarProveedor(nit);
		if (prov==null){
			return("El proveedor con Nit: "+nit+" no esxite ");
		}
		return "El proveedor con NIT "+nit+" es :\n"+prov.toString();
	}

	public void eliminarProveedor(String nit){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		persis.eliminarProveedor(nit);
	}
	public String guardarProveedor(){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		String msg=persis.escribirArchivoBinarioProveedor(this);
		return msg;
	}
	public Proveedor[] verPro(){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		Proveedor[] leidos = persis.leerArchivoBinarioProveedores();
		return leidos;
	}
	public String modifPro(String nit ,Proveedor pro){
		ArchivosBinariosProveedor persis =new ArchivosBinariosProveedor();
		String msg=persis.modificarProveedor(nit,pro);
		return msg;
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

