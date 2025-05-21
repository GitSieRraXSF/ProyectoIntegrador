package Model;

public class AreaAdministrativa extends Usuario {

	private String Area;

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public AreaAdministrativa(String nombre, String email, String contraseña, String sancionesPendientes,
			String area) {
		super(nombre, email, contraseña, sancionesPendientes);
		Area = area;
	}
}