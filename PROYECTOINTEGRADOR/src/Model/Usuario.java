package Model;

public class Usuario {

	private int Usuario1;
	private String Nombre, correoinstitucional, cedula, estado, rol;
	
	public int getUsuario1() {
		return Usuario1;
	}
	public void setUsuario1(int usuario1) {
		Usuario1 = usuario1;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCorreoinstitucional() {
		return correoinstitucional;
	}
	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Usuario(int usuario1, String nombre, String correoinstitucional, String cedula, String estado, String rol) {
		Usuario1 = usuario1;
		Nombre = nombre;
		this.correoinstitucional = correoinstitucional;
		this.cedula = cedula;
		this.estado = estado;
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [Usuario1=" + Usuario1 + ", Nombre=" + Nombre + ", correoinstitucional=" + correoinstitucional
				+ ", cedula=" + cedula + ", estado=" + estado + ", rol=" + rol + "]";
	}
	
	public void InfoUsuario() {
		System.out.println(toString());
	}
}