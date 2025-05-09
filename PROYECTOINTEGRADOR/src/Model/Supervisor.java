package Model;

public class Supervisor extends Usuario {

	private String AreasResponsabilidad;

	public String getAreasResponsabilidad() {
		return AreasResponsabilidad;
	}

	public void setAreasResponsabilidad(String areasResponsabilidad) {
		AreasResponsabilidad = areasResponsabilidad;
	}

	public Supervisor(int iD, String nombre, String email, String contraseña, String sancionesPendientes,
			String areasResponsabilidad) {
		super(iD, nombre, email, contraseña, sancionesPendientes);
		AreasResponsabilidad = areasResponsabilidad;
	}
}