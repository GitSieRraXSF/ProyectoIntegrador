package Model;

public class Encuesta {

	private int ID;
	private SolicitudPrestamo solicitudID;
	private Usuario usuarioID;
	private float Calificacion;
	private String Comentario;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public SolicitudPrestamo getSolicitudID() {
		return solicitudID;
	}
	public void setSolicitudID(SolicitudPrestamo solicitudID) {
		this.solicitudID = solicitudID;
	}
	public Usuario getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Usuario usuarioID) {
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
	
	public Encuesta(int iD, SolicitudPrestamo solicitudID, Usuario usuarioID, float calificacion, String comentario) {
		ID = iD;
		this.solicitudID = solicitudID;
		this.usuarioID = usuarioID;
		Calificacion = calificacion;
		Comentario = comentario;
	}
}