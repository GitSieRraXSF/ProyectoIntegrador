package Model;

public class Supervisor extends Usuario {

	private String AreasResponsabilidad;

	public String getAreasResponsabilidad() {
		return AreasResponsabilidad;
	}

	public void setAreasResponsabilidad(String areasResponsabilidad) {
		AreasResponsabilidad = areasResponsabilidad;
	}

	public Supervisor(String nombre, String email, String contraseña, String role,
			String areasResponsabilidad) {
		super(nombre, email, contraseña, role);
		AreasResponsabilidad = areasResponsabilidad;
	}
}