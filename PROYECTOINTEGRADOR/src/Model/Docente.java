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

	public Docente(int iD, String nombre, String email, String contraseña, String sancionesPendientes,
			String asignatura, String especiabilidad) {
		super(iD, nombre, email, contraseña, sancionesPendientes);
		Asignatura = asignatura;
		this.especiabilidad = especiabilidad;
	}
}