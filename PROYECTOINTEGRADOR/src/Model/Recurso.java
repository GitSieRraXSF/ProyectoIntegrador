package Model;

public class Recurso {

	private int ID;
	private String Tipo, ubicacion, softwareRequerido;
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
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	
	public Recurso(int iD, String tipo, String ubicacion, String softwareRequerido, boolean estado) {
		ID = iD;
		Tipo = tipo;
		this.ubicacion = ubicacion;
		this.softwareRequerido = softwareRequerido;
		this.estado = estado;
	}
}