package Model;

public class AreaAdministrativa extends Usuario {

	private String Area;

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public AreaAdministrativa(String nombre, String email, String contraseña, String role,
			String area) {
		super(nombre, email, contraseña, role);
		Area = area;
	}
}