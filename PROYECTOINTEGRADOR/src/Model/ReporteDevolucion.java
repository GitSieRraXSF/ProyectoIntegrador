package Model;

public class ReporteDevolucion {

	private String FechaVerificacion, Reparacion;
	private boolean Estado;
	
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
	
	public ReporteDevolucion(String fechaVerificacion, String reparacion,
			boolean estado) {
		FechaVerificacion = fechaVerificacion;
		Reparacion = reparacion;
		Estado = estado;
	}
}