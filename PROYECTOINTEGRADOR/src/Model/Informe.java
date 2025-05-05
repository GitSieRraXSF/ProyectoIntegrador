package Model;

public class Informe {

	private String Titulo, Descripcion, Persona_Involucrada;
	private int IdInforme;
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getPersona_Involucrada() {
		return Persona_Involucrada;
	}
	public void setPersona_Involucrada(String persona_Involucrada) {
		Persona_Involucrada = persona_Involucrada;
	}
	public int getIdInforme() {
		return IdInforme;
	}
	public void setIdInforme(int idInforme) {
		IdInforme = idInforme;
	}
	
	public Informe(String titulo, String descripcion, String persona_Involucrada, int idInforme) {
		Titulo = titulo;
		Descripcion = descripcion;
		Persona_Involucrada = persona_Involucrada;
		IdInforme = idInforme;
	}
	
}