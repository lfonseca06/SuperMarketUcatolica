package co.edu.ucatolica.modelo;

import java.io.Serializable;
import java.util.List;

import co.edu.ucatolica.modelo.persistencia.PersistenciaClientes;

public class Reporte implements Serializable{
    
	 private static final long serialVersionUID = 1L;
	 private List<Cliente> listaClientes;
	 //private transient PersistenciaClientes listaClientes = new PersistenciaClientes();
     //listaClientes = cargar.getListaClientes();
	 
	 public List<Cliente> getPersisClientes() {
		 PersistenciaClientes cargar = new PersistenciaClientes(); 
		 listaClientes = cargar.getListaClientes();
		 return listaClientes;
	 }
	
}
