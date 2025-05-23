package Model;

public class Administrador extends Usuario {

	private String NivelAcceso;

	public String getNivelAcceso() {
		return NivelAcceso;
	}

	public void setNivelAcceso(String nivelAcceso) {
		NivelAcceso = nivelAcceso;
	}

	public Administrador(String nombre, String email, String contraseña, String role,
			String nivelAcceso) {
		super(nombre, email, contraseña, role);
		NivelAcceso = nivelAcceso;
	}
}