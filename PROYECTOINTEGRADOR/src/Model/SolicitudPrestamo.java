package Model;

public class SolicitudPrestamo {

	private int ID, usuarioID, recursoID;
	private String FechaSolicitud, fechainicio, fechafinPrevista, fechaDevolucionReal;
	private boolean Estado;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public int getRecursoID() {
		return recursoID;
	}
	public void setRecursoID(int recursoID) {
		this.recursoID = recursoID;
	}
	public String getFechaSolicitud() {
		return FechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafinPrevista() {
		return fechafinPrevista;
	}
	public void setFechafinPrevista(String fechafinPrevista) {
		this.fechafinPrevista = fechafinPrevista;
	}
	public String getFechaDevolucionReal() {
		return fechaDevolucionReal;
	}
	public void setFechaDevolucionReal(String fechaDevolucionReal) {
		this.fechaDevolucionReal = fechaDevolucionReal;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public SolicitudPrestamo(int iD, int usuarioID, int recursoID, String fechaSolicitud, String fechainicio,
			String fechafinPrevista, String fechaDevolucionReal, boolean estado) {
		ID = iD;
		this.usuarioID = usuarioID;
		this.recursoID = recursoID;
		FechaSolicitud = fechaSolicitud;
		this.fechainicio = fechainicio;
		this.fechafinPrevista = fechafinPrevista;
		this.fechaDevolucionReal = fechaDevolucionReal;
		Estado = estado;
	}
}