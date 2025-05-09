package Model;

public class Administrador extends Usuario {

	private String NivelAcceso;

	public String getNivelAcceso() {
		return NivelAcceso;
	}

	public void setNivelAcceso(String nivelAcceso) {
		NivelAcceso = nivelAcceso;
	}

	public Administrador(int iD, String nombre, String email, String contraseña, String sancionesPendientes,
			String nivelAcceso) {
		super(iD, nombre, email, contraseña, sancionesPendientes);
		NivelAcceso = nivelAcceso;
	}
}