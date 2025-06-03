package Model;

public class SolicitudPrestamo {

	private String NombreUsuario, fechainicio, fechafinPrevista, fechaDevolucionReal;
	private boolean Estado;
	
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String ns) {
		NombreUsuario = ns;
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
	
	public SolicitudPrestamo(String us, String fechainicio, String fechafinPrevista, String fechaDevolucionReal, boolean estado) {
		NombreUsuario = us;
		this.fechainicio = fechainicio;
		this.fechafinPrevista = fechafinPrevista;
		this.fechaDevolucionReal = fechaDevolucionReal;
		Estado = estado;
	}
}