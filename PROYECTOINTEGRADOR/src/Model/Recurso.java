package Model;

public class Recurso {

	private String Tipo, softwareRequerido, numRecurso;
	private boolean estado;
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getSoftwareRequerido() {
		return softwareRequerido;
	}
	public void setSoftwareRequerido(String softwareRequerido) {
		this.softwareRequerido = softwareRequerido;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getNumRecurso() {
		return numRecurso;
	}
	public void setNumRecurso(String numRecurso) {
		this.numRecurso = numRecurso;
	}
	
	public Recurso(String tipo, String softwareRequerido, String numRecurso, boolean estado) {
		Tipo = tipo;
		this.softwareRequerido = softwareRequerido;
		this.numRecurso = numRecurso;
		this.estado = estado;
	}
}