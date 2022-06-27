package excelJava;

import java.sql.ResultSet;
import java.sql.Statement;

public class UsuariosExcel extends BDConecction {
	public UsuariosExcel() throws Exception {

	}

	public boolean estaUsuario(Usuario usuario) {
		try {
			String query = "SELECT count(*) FROM usuario WHERE correo = '" + usuario.getEmail() + "' AND contraseña = '"
					+ usuario.getPassword() + "';";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			int i = 0;
			if (resultado.next())
				i = resultado.getInt(1);
			if (i != 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Algo falló, contacta con el servicio técnico. Disculpa las molestias");
			return false;
		}

	}

	public boolean nuevoUsuario(Usuario usuario) {
		try {
			String st = "INSERT INTO usuario VALUES( '" + usuario.getEmail() + "' ,'" + usuario.getPassword() + "','"
					+ usuario.getName() + "', '" + usuario.getTelephone() + "');";
			Statement sentencia = this.getCon().createStatement();
			sentencia.executeUpdate(st);
			return true;
			
		} catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Disculpa las molestias");
			return false;
		}
	}
}