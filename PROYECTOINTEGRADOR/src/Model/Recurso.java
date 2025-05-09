package Model;

public class Recurso {

	private int ID;
	private String Tipo, softwareRequerido;
	private boolean estado;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
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
	
	public Recurso(int iD, String tipo, String softwareRequerido, boolean estado) {
		ID = iD;
		Tipo = tipo;
		this.softwareRequerido = softwareRequerido;
		this.estado = estado;
	}
}