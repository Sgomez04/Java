import java.util.*;

import excelJava.UsuariosExcel;
import excelJava.Usuario;
import hoja.LeerArchivoExcel;

public class main {

	public static void main(String[] args) {
		System.out.println("Leyendo Book1.xlsx. Por favor espere..");
		LeerArchivoExcel hoja = new LeerArchivoExcel("Book1.xlsx");

		if (hoja.estado()) {
			try {
				ArrayList<Usuario> list = hoja.leerExcel();
			UsuariosExcel user = new UsuariosExcel();

				int orden = 1;
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Usuario " + orden + ":" + list.get(i).toString());
					if (user.estaUsuario(list.get(i)))
						System.out.println("El usuario ya existe en la base de datos");
					else {
						user.nuevoUsuario(list.get(i));
						if (user.estaUsuario(list.get(i)))
							System.out.println("Usuario añadido correctamente");
					}
				orden++;
				}
				if(hoja.close()) {
					System.out.println("Archivo cerrado");	
				} else {
					System.out.println("Fallo al cerrar el archivo");
				}
				
			} catch (Exception e) {
				System.out.println("Se encontraron problemas en la transmision del documento a la base de datos");
			}
		}
		else {
			System.out.println("Error");
		}
	}
}