package Model;

public class SolicitudPrestamo {

	private String FechaSolicitud, fechainicio, fechafinPrevista, fechaDevolucionReal;
	private boolean Estado;
	
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
	
	public SolicitudPrestamo(String fechaSolicitud, String fechainicio, String fechafinPrevista, String fechaDevolucionReal, boolean estado) {
		FechaSolicitud = fechaSolicitud;
		this.fechainicio = fechainicio;
		this.fechafinPrevista = fechafinPrevista;
		this.fechaDevolucionReal = fechaDevolucionReal;
		Estado = estado;
	}
}