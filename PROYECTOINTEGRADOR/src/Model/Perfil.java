package Model;

public class Perfil extends Usuario{

	private int IdPerfil;
	private String CorreoAlternativo, Telefono, Contraseña, UltimaActualizacion;
	public int getIdPerfil() {
		return IdPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		IdPerfil = idPerfil;
	}
	public String getCorreoAlternativo() {
		return CorreoAlternativo;
	}
	public void setCorreoAlternativo(String correoAlternativo) {
		CorreoAlternativo = correoAlternativo;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public String getUltimaActualizacion() {
		return UltimaActualizacion;
	}
	public void setUltimaActualizacion(String ultimaActualizacion) {
		UltimaActualizacion = ultimaActualizacion;
	}
	public Perfil(int usuario1, String nombre, String correoinstitucional, String cedula, String estado, String rol,
			int idPerfil, String correoAlternativo, String telefono, String contraseña, String ultimaActualizacion) {
		super(usuario1, nombre, correoinstitucional, cedula, estado, rol);
		IdPerfil = idPerfil;
		CorreoAlternativo = correoAlternativo;
		Telefono = telefono;
		Contraseña = contraseña;
		UltimaActualizacion = ultimaActualizacion;
	}
	
}