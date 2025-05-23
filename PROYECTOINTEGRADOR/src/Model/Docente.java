package Model;

public class Docente extends Usuario {

	private String Asignatura, especiabilidad;

	public String getAsignatura() {
		return Asignatura;
	}

	public void setAsignatura(String asignatura) {
		Asignatura = asignatura;
	}

	public String getEspeciabilidad() {
		return especiabilidad;
	}

	public void setEspeciabilidad(String especiabilidad) {
		this.especiabilidad = especiabilidad;
	}

	public Docente(String nombre, String email, String contraseña, String role,
			String asignatura, String especiabilidad) {
		super(nombre, email, contraseña, role);
		Asignatura = asignatura;
		this.especiabilidad = especiabilidad;
	}
}