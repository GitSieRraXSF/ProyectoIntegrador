package Model;

public class Usuario {

	private String Nombre, email, contraseña, SancionesPendientes;
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
	public String getSancionesPendientes() {
		return SancionesPendientes;
	}
	public void setSancionesPendientes(String sancionesPendientes) {
		SancionesPendientes = sancionesPendientes;
	}
	
	public Usuario(String nombre, String email, String contraseña, String sancionesPendientes) {
		Nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		SancionesPendientes = sancionesPendientes;
	}
}