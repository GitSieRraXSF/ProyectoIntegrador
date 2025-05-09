package Model;

public class SolicitudPrestamo {

	private int ID;
	private Usuario usuarioID;
	private Recurso RecursoID;
	private String FechaSolicitud, fechainicio, fechafinPrevista, fechaDevolucionReal;
	private ReporteDevolucion reportedevolucionID;
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
	public ReporteDevolucion getReportedevolucionID() {
		return reportedevolucionID;
	}
	public void setReportedevolucionID(ReporteDevolucion reportedevolucionID) {
		this.reportedevolucionID = reportedevolucionID;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public SolicitudPrestamo(int iD, Usuario usuarioID, Recurso recursoID, String fechaSolicitud, String fechainicio,
			String fechafinPrevista, String fechaDevolucionReal, ReporteDevolucion reportedevolucionID,
			boolean estado) {
		ID = iD;
		this.usuarioID = usuarioID;
		RecursoID = recursoID;
		FechaSolicitud = fechaSolicitud;
		this.fechainicio = fechainicio;
		this.fechafinPrevista = fechafinPrevista;
		this.fechaDevolucionReal = fechaDevolucionReal;
		this.reportedevolucionID = reportedevolucionID;
		Estado = estado;
	}
}