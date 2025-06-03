package Model;

public class ReporteDevolucion {

	private String FechaVerificacion, Descripcion, UsuarioInvolucrado;
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
	public String getUsuarioInvolucrado() {
		return UsuarioInvolucrado;
	}
	public void setUsuarioInvolucrado(String userInvolu) {
		this.UsuarioInvolucrado = userInvolu;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	public ReporteDevolucion(String fechaVerificacion, String descripcion, String userInvolu,
			boolean estado) {
		FechaVerificacion = fechaVerificacion;
		Descripcion = descripcion;
		UsuarioInvolucrado = userInvolu;
		Estado = estado;
	}
}