package Model;

public class ReporteDevolucion {

	private int ID;
	private int solicitudID;
	private int supervisorID;
	private String FechaVerificacion, Observaciones;
	private boolean estadoRecurso;
	
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
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public boolean isEstadoRecurso() {
		return estadoRecurso;
	}
	public void setEstadoRecurso(boolean estadoRecurso) {
		this.estadoRecurso = estadoRecurso;
	}
	
	public ReporteDevolucion(int iD, int solicitudID, int supervisorID, String fechaVerificacion, String observaciones,
			boolean estadoRecurso) {
		ID = iD;
		this.solicitudID = solicitudID;
		this.supervisorID = supervisorID;
		FechaVerificacion = fechaVerificacion;
		Observaciones = observaciones;
		this.estadoRecurso = estadoRecurso;
	}
}