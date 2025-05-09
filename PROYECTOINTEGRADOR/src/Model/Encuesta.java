package Model;

public class Encuesta {

	private int ID;
	private int solicitudID;
	private int usuarioID;
	private String Funcionalidad, Calidad, Infraestructura;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSolicitudID() {
		return solicitudID;
	}
	public void setSolicitudID(int solicitudID) {
		this.solicitudID = solicitudID;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getFuncionalidad() {
		return Funcionalidad;
	}
	public void setFuncionalidad(String funcionalidad) {
		Funcionalidad = funcionalidad;
	}
	public String getCalidad() {
		return Calidad;
	}
	public void setCalidad(String calidad) {
		Calidad = calidad;
	}
	public String getInfraestructura() {
		return Infraestructura;
	}
	public void setInfraestructura(String infraestructura) {
		Infraestructura = infraestructura;
	}
	
	public Encuesta(int iD, int solicitudID, int usuarioID, String funcionalidad, String calidad,
			String infraestructura) {
		ID = iD;
		this.solicitudID = solicitudID;
		this.usuarioID = usuarioID;
		Funcionalidad = funcionalidad;
		Calidad = calidad;
		Infraestructura = infraestructura;
	}
}