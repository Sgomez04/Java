package excelJava;

public class Usuario {

	private String email;
	private String name;
	private String password;
	private String telephone;
	
	public Usuario(String email, String password, String name, String telephone){
	     this.name = name;
	     this.password = password;
	     this.email = email;
	     this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}