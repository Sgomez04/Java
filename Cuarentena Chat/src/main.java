
import java.util.*;
import javax.swing.JOptionPane;

public class main {
	public static BDConecction conexion;
	public static Chat chat;
	public static Mensaje mensaje;
	public static Usuario user;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int respuesta;
		try {
			chat = new Chat();

			do {
				System.out.println("");
				System.out.println("|==========================|");
				System.out.println("|  ¡BIENVENIDO A MyCHAT!   |");
				System.out.println("|==========================|");

				System.out.println("¿Tienes una cuenta en MyChat? Utiliza esta opción");
				System.out.println("1-Logearse");
				System.out.println("");
				System.out.println("¿Aun no perteneces a nuestra comunidad? Utiliza esta opción");
				System.out.println("2-Registrarse");
				System.out.println("");
				System.out.println("Utiliza esta opción si deseas salir");
				System.out.println("0-Salir");
				respuesta = teclado.nextInt();
				switch (respuesta) {
				case 1:
					logearse();
					break;
				case 2:
					registrarse();
					break;
				case 0:
					System.out.println("");
					System.out.println("¡ESPERAMOS QUE VUELVAS PRONTO!");
					System.out.println("====Atte: Equipo MyChat!====");

					break;
				}
			} while (respuesta != 0);

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void logearse() {

		try {
			int respuesta;
			String correo, contraseña;
			
			System.out.println("");
			System.out.println("|============SIGN_IN=============|");
			System.out.println("");
			System.out.println("Introduce tu correo");
			correo = teclado.next().toLowerCase();
			System.out.println("");
			System.out.println("Introduce tu contraseña");
			contraseña = teclado.next().toLowerCase();
			
			user = new Usuario(contraseña, correo);
			
			if (chat.estaUsuario(user)){
				if(chat.isAdmin(correo) == true) {
				lobbyAdmin();
					}
				else {
				lobbyUser(user);
					}
			}
			
			else {
				System.out.println("El usuario esta equivocado o no se encuentra registrado");
				System.out.println("Por favor intentelo de nuevo");
			}
			
		} catch (Exception e) {
			System.out.println("Error al conectar");
		}
	}

	public static void registrarse() {
		try {
			boolean error = true;
			String prohibida = "admin@mychat.com";
			chat = new Chat();
			
			while(error = true) {
			System.out.println("");
			System.out.println("|============REGISTER==============|");
			System.out.println("Introduce un nombre de usuario (Max. 20 caracteres)");
			String nombre = teclado.next();
			System.out.println("Introduce nuevo email (Max. 60 caracteres)");
			String correo = teclado.next().toLowerCase();
			if (correo.equals(prohibida)) {
				System.out.println("correo no permitido, intentelo de nuevo");
				error = true;}
			else {
			System.out.println("Introduce una contraseña (Max. 30 caracteres)");
			String contraseña = teclado.next().toLowerCase();
			System.out.println("Vuelve a introducir la contraseña");
			String contraseña1 = teclado.next().toLowerCase();
			
			if (contraseña.equals(contraseña1))
				error = false;
			
			while (error == true) {
				System.out.println("Las contraseñas no coinciden vuelve a ingresar una nueva contraseña");
				System.out.println();
				System.out.println("Introduce la nueva contraseña");
				contraseña = teclado.next();
				System.out.println("Vuelve a introducir la contraseña");
				contraseña1 = teclado.next();
				if (contraseña.equals(contraseña1))
					error = false;
			}
			error = false;
			Usuario user = new Usuario(nombre, contraseña, correo);
			
			if (chat.nuevoUsuario(user)) {
				System.out.println("Usuario añadido correctamente");
				break;
			} else {
				System.out.println("Error . . . \nUsuario ya existente!");
			}
			}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void lobbyAdmin() {
		int respuesta;
		do {
			System.out.println("|==========================================================================|");
			System.out.println("| 1 -   | USUARIOS REGISTRADOS |  (Ver todos los usuarios registrados)     |");
			System.out.println("|------------------------------|-------------------------------------------|");
			System.out.println("| 2 -   |   BORRRAR USUARIO    |        (Eliminar al usuario deseado)      |");
			System.out.println("|==========================================================================|");
			System.out.println("| 0 -   |                         LOG_OUT (SALIR)                          |");
			System.out.println("|==========================================================================|");
			respuesta = teclado.nextInt();
			switch (respuesta) {
			case 1:
				System.out.println("A continuacion se muestran todos los usuario registrados:");
				chat.verUsuariosAdmin();
				break;
			case 2:
				System.out.println("Introduce el email del usuario que desea eliminar");
				String email = teclado.next();
				chat.borrarUsuario(email);
				break;
			}
		} while (respuesta != 0);
	}

	public static void lobbyUser(Usuario user) {
		int respuesta;
		do {
			System.out.println("|=========================================================================|");
			System.out.println("| 1 -   | BANDEJA DE ENTRADA  |          (Leer todos los mensajes)        |");
			System.out.println("|-----------------------------|-------------------------------------------|");
			System.out.println("| 2 -   |   ENVIAR MENSAJES   |        (Mensaje a un usuario elegido)     |");
			System.out.println("|=========================================================================|");
			System.out.println("| 0 -   |                        LOG_OUT (SALIR)                          |");
			System.out.println("|=========================================================================|");
			respuesta = teclado.nextInt();
			switch (respuesta) {
			case 1:
				bandeja1(user);
				break;
			case 2:
				enviar1(user);
				break;
			}
		} while (respuesta != 0);
	}
	
	public static void bandeja1(Usuario user) {
		try {
			int pos = 0;
			for (int i = 0; i < chat.leerMensaje(user.getEmail()).size();i++) {
				
				System.out.println("================================");
				chat.leerMensaje(user.getEmail()).get(pos++).getEmisor();
				chat.leerMensaje(user.getEmail()).get(pos++).getTexto();
				System.out.println("================================");
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enviar1(Usuario user) {
		try {
			System.out.println("|============MENSAJE=============|");
			System.out.println("");
			System.out.println("Introduce el correo del usuario destinatario");
			String r = teclado.next();
			System.out.println("");
			System.out.println("Introduce el mensaje");
			String t = teclado.next();

			if (chat.enviarMSG(r, t) == true)
				JOptionPane.showMessageDialog(null, "Mensaje enviado correctamente.", "+Info",
						JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
