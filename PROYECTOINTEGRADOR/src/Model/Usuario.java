package Model;

public class Usuario {

	private int id;
	private String Nombre, Email, rol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Usuario(int id, String nombre, String email, String rol) {
		this.id = id;
		Nombre = nombre;
		Email = email;
		this.rol = rol;
	}
}