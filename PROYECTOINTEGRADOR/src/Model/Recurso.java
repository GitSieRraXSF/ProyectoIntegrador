package Model;

public class Recurso {

	private int Id;
	private String Tipo, Ubicacion, softwareRequerido;
	private boolean Estado;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}
	public String getSoftwareRequerido() {
		return softwareRequerido;
	}
	public void setSoftwareRequerido(String softwareRequerido) {
		this.softwareRequerido = softwareRequerido;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public Recurso(int id, String tipo, String ubicacion, String softwareRequerido, boolean estado) {
		Id = id;
		Tipo = tipo;
		Ubicacion = ubicacion;
		this.softwareRequerido = softwareRequerido;
		Estado = estado;
	}
}