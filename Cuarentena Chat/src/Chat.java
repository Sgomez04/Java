import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Chat extends BDConecction {
	public Chat() throws Exception {

	}

	public boolean estaUsuario(Usuario usuario) {
		try {
			String query = "SELECT count(*) FROM usuario WHERE correo = '" + usuario.getEmail() + "' AND contraseña = '"
					+ usuario.getContraseña() + "';";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			int i = 0;
			if (resultado.next())
				i = resultado.getInt(1);
			if (i != 0) {
				return true;
			}
			return false;
		}

		catch (Exception e) {
			System.out.println("Algo falló, contacta con el servicio técnico. Disculpa las molestias");
			return false;
		}

	}

	public boolean nuevoUsuario(Usuario usuario) {
		try {
			String st = "INSERT INTO usuario VALUES( '" + usuario.getNombre() + "' ,'" + usuario.getContraseña() + "','"
					+ usuario.getEmail() + "');";
			Statement sentencia = this.getCon().createStatement();
			sentencia.executeUpdate(st);
			return true;

		} catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Disculpa las molestias");
			return false;
		}
	}

	public ArrayList<Mensaje> leerMensaje(String correo) {
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		try {
			String query = "SELECT * FROM chat WHERE receptor = '" + correo + "';";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				String e = resultado.getString(2);
				String r = resultado.getString(3);
				String m = resultado.getString(4);
				String f = resultado.getString(1);

				Mensaje men = new Mensaje(e, r, m, f);
				mensajes.add(men);
			}
			return mensajes;
		}

		catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Error 0xc12578Df");
			return null;
		}
	}
	
	public boolean enviarMSG(String receptorID, String texto) {
		try {
			String query = "INSERT INTO chat VALUES(CURRENT_TIMESTAMP(), '" + "luis@mychat.com" + "','" + receptorID + "', '" + texto +  "');";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			return true;
		}

		catch (Exception e) {
			System.out.println("Error en el sistema, inténtelo de nuevo -ERROR 479-");
			return false;
		}
	}

	public ArrayList<Usuario> verUsuariosAdmin() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String query = "SELECT * FROM usuario ORDER BY = email;";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				String e = resultado.getString(1);
				String n = resultado.getString(2);
				String c = resultado.getString(3);

				Usuario user = new Usuario(n, c, e);
				usuarios.add(user);
			}
			return usuarios;
		}

		catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Error 0xc12578Df");
			return null;
		}
	}

	public boolean borrarUsuario(String email) {
		try {
			String st = "DELETE FROM usuario WHERE email = '" + email + "';";
			Statement sentencia = this.getCon().createStatement();
			sentencia.executeUpdate(st);
			return true;
		}

		catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Disculpa las molestias");
			return false;
		}
	}

	public boolean isAdmin(String correo) {
		String admin = "admin@mychat.com";
		try {
			String query = "SELECT correo FROM usuario WHERE correo = '" + correo + "';";
			Statement sentencia = this.getCon().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			String a = resultado.getString(0);

			if (a.equals(admin)) {
				return true;
			}
			return false;
		}

		catch (Exception e) {
			System.out.println("Algo fallo, contacta con el servicio tecnico. Disculpa las molestias");

			return false;
		}
	}
}