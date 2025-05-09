package Model;

public class ReporteDevolucion {

	private int ID;
	private SolicitudPrestamo sulicitudID;
	private Supervisor supervisorID;
	private String FechaVerificacion, Observaciones;
	private boolean estadoRecurso;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public SolicitudPrestamo getSulicitudID() {
		return sulicitudID;
	}
	public void setSulicitudID(SolicitudPrestamo sulicitudID) {
		this.sulicitudID = sulicitudID;
	}
	public Supervisor getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(Supervisor supervisorID) {
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
	
	public ReporteDevolucion(int iD, SolicitudPrestamo sulicitudID, Supervisor supervisorID, String fechaVerificacion,
			String observaciones, boolean estadoRecurso) {
		ID = iD;
		this.sulicitudID = sulicitudID;
		this.supervisorID = supervisorID;
		FechaVerificacion = fechaVerificacion;
		Observaciones = observaciones;
		this.estadoRecurso = estadoRecurso;
	}
}