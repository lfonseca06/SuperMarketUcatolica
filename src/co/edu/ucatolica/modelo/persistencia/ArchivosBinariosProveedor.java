package co.edu.ucatolica.modelo.persistencia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import co.edu.ucatolica.modelo.Proveedor;

public class ArchivosBinariosProveedor {

	private static String rutaReg = "./data/proveedores.out";

	private static File f;
	private static FileOutputStream fos;
	private static DataOutputStream dos;
	private static FileInputStream fis;
	private static DataInputStream dis;

	public ArchivosBinariosProveedor() {
		// Constructor vacío
	}

	public static String escribirArchivoBinarioProveedor(Proveedor reg) {
		String mensaje = "Archivo Actualizado Exitosamente!";
		f = new File(rutaReg);
		try {
			fos = new FileOutputStream(f, true); // Modo de añadir (append)
			dos = new DataOutputStream(fos);

			dos.writeUTF(reg.getNIT());
			dos.writeUTF(reg.getNombre());
			dos.writeUTF(reg.getDireccion());
			dos.writeUTF(reg.getTelefono());
			dos.writeUTF(reg.getCiudad());

			dos.close();
		} catch (IOException e) {
			mensaje = "Error al escribir";
		}
		return mensaje;
	}

	public static Proveedor[] leerArchivoBinarioProveedores() {
		f = new File(rutaReg);
		if (!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("El archivo no existía y ha sido creado.");
				return new Proveedor[0];
			} catch (IOException e) {
				System.out.println("Error al crear el archivo");
				return null;
			}
		}
		try {
			fis = new FileInputStream(f);
			dis = new DataInputStream(fis);

			Proveedor[] proveedores = new Proveedor[10000];
			int index = 0;

			while (dis.available() > 0) {
				String NIT = dis.readUTF();
				String nombre = dis.readUTF();
				String direccion = dis.readUTF();
				String telefono = dis.readUTF();
				String ciudad = dis.readUTF();

				proveedores[index++] = new Proveedor(NIT, nombre, direccion, telefono, ciudad);
			}

			dis.close();
			return java.util.Arrays.copyOf(proveedores, index);
		} catch (EOFException e) {
			System.out.println("Fin del archivo");
		} catch (IOException e) {
			System.out.println("Error al leer");
		}
		return null;
	}

	public static String modificarProveedor(String NIT, Proveedor nuevoProveedor) {
		String mensaje = "Proveedor modificado exitosamente!";
		Proveedor[] proveedores = leerArchivoBinarioProveedores();
		
		if (proveedores == null) {
			return "Error al leer los proveedores";
		}
		
		boolean encontrado = false;
		for (int i = 0; i < proveedores.length; i++) {
			if (proveedores[i].getNIT().equals(NIT) ) {
				
				proveedores[i] = nuevoProveedor;
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			return "Proveedor con NIT " + NIT + " no encontrado.";
		}

		try {
			fos = new FileOutputStream(f); // Sobrescribir el archivo
			dos = new DataOutputStream(fos);

			for (Proveedor proveedor : proveedores) {
				dos.writeUTF(proveedor.getNIT());
				dos.writeUTF(proveedor.getNombre());
				dos.writeUTF(proveedor.getDireccion());
				dos.writeUTF(proveedor.getTelefono());
				dos.writeUTF(proveedor.getCiudad());
			}

			dos.close();
		} catch (IOException e) {
			mensaje = "Error al escribir";
		}

		return mensaje;
	}
	

	public static Proveedor bucarProveedor(String NIT) {
		Proveedor[] leidos = leerArchivoBinarioProveedores();
		if (leidos != null && leidos.length > 0) {
			for (Proveedor p : leidos) {
				
				if (p.getNIT().equals(NIT)) {
					return(p);
				}
			}
			
		} else {
			System.out.println("No se pudo leer ningún proveedor del archivo.");
		}
		return(null);
	
	}
	public static String eliminarProveedor(String NIT) {
        String mensaje = "Proveedor eliminado exitosamente!";
        Proveedor[] proveedores = leerArchivoBinarioProveedores();
        
        if (proveedores == null) {
            return "Error al leer los proveedores";
        }

        boolean encontrado = false;
        Proveedor[] nuevosProveedores = new Proveedor[proveedores.length];
        int index = 0;

        for (Proveedor proveedor : proveedores) {
            if (!proveedor.getNIT().equals(NIT)) {
                nuevosProveedores[index++] = proveedor;
            } else {
                encontrado = true;
            }
        }

        if (!encontrado) {
            return "Proveedor con NIT " + NIT + " no encontrado.";
        }

        try {
            fos = new FileOutputStream(f); // Sobrescribir el archivo
            dos = new DataOutputStream(fos);

            for (int i = 0; i < index; i++) {
                dos.writeUTF(nuevosProveedores[i].getNIT());
                dos.writeUTF(nuevosProveedores[i].getNombre());
                dos.writeUTF(nuevosProveedores[i].getDireccion());
                dos.writeUTF(nuevosProveedores[i].getTelefono());
                dos.writeUTF(nuevosProveedores[i].getCiudad());
            }

            dos.close();
        } catch (IOException e) {
            mensaje = "Error al escribir";
        }

        return mensaje;
    }
	
}


