package Model;

public class SolicitudPrestamo {

	private int ID;
	private Usuario usuarioID;
	private Recurso RecursoID;
	private String FechaSolicitud;
	private boolean Estado;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Usuario getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Usuario usuarioID) {
		this.usuarioID = usuarioID;
	}
	public Recurso getRecursoID() {
		return RecursoID;
	}
	public void setRecursoID(Recurso recursoID) {
		RecursoID = recursoID;
	}
	public String getFechaSolicitud() {
		return FechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public SolicitudPrestamo(int iD, Usuario usuarioID, Recurso recursoID, String fechaSolicitud, boolean estado) {
		ID = iD;
		this.usuarioID = usuarioID;
		RecursoID = recursoID;
		FechaSolicitud = fechaSolicitud;
		Estado = estado;
	}
}