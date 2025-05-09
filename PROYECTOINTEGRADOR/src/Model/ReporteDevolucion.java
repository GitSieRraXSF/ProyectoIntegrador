package Model;

public class ReporteDevolucion {

	private int ID;
	private int solicitudID;
	private int supervisorID;
	private String FechaVerificacion, Reparacion;
	private boolean Estado;
	
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
	public int getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}
	public String getFechaVerificacion() {
		return FechaVerificacion;
	}
	public void setFechaVerificacion(String fechaVerificacion) {
		FechaVerificacion = fechaVerificacion;
	}
	public String getReparacion() {
		return Reparacion;
	}
	public void setReparacion(String reparacion) {
		Reparacion = reparacion;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public ReporteDevolucion(int iD, int solicitudID, int supervisorID, String fechaVerificacion, String reparacion,
			boolean estado) {
		ID = iD;
		this.solicitudID = solicitudID;
		this.supervisorID = supervisorID;
		FechaVerificacion = fechaVerificacion;
		Reparacion = reparacion;
		Estado = estado;
	}
}