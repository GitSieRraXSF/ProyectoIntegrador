package Model;

public class ReporteDevolucion {

	private String FechaVerificacion, Descripcion, Reparacion;
	private boolean Estado;
	
	public String getFechaVerificacion() {
		return FechaVerificacion;
	}
	public void setFechaVerificacion(String fechaVerificacion) {
		FechaVerificacion = fechaVerificacion;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getReparacion() {
		return Reparacion;
	}
	public void setReparacion(String reparacion) {
		this.Reparacion = reparacion;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public ReporteDevolucion(String fechaVerificacion, String descripcion, String reparacion,
			boolean estado) {
		FechaVerificacion = fechaVerificacion;
		Descripcion = descripcion;
		Reparacion = reparacion;
		Estado = estado;
	}
}