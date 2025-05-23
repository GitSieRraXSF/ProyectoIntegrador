package Model;

public class Usuario {

	private String Nombre, email, contraseña, role;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Usuario(String nombre, String email, String contraseña, String role) {
		Nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.role = role;
	}
}