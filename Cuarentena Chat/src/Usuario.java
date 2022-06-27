
public class Usuario {

	private String nombre;
	private String contrase�a;
	private String email;
	
	public Usuario(String nombre, String contrase�a, String email){
	     this.nombre = nombre;
	     this.contrase�a = contrase�a;
	     this.email = email;
	}
	
	public Usuario(String contrase�a, String email){
	     this.contrase�a = contrase�a;
	     this.email = email;
	}
	
	public Usuario(){
	     this.email = "admin@mychat.com";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
