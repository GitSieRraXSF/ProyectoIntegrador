package Model;

public class Encuesta {

	private int ID;
	private int solicitudID;
	private int usuarioID;
	private float Calificacion;
	private String Comentario, Funcionalidad, Calidad, Infraestructura;
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
	public float getCalificacion() {
		return Calificacion;
	}
	public void setCalificacion(float calificacion) {
		Calificacion = calificacion;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
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
	
	public Encuesta(int iD, int solicitudID, int usuarioID, float calificacion, String comentario, String funcionalidad,
			String calidad, String infraestructura) {
		ID = iD;
		this.solicitudID = solicitudID;
		this.usuarioID = usuarioID;
		Calificacion = calificacion;
		Comentario = comentario;
		Funcionalidad = funcionalidad;
		Calidad = calidad;
		Infraestructura = infraestructura;
	}
}