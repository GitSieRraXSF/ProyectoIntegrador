package Model;

public class Sancion {

	private int ID, MontoMulta;
	private Usuario usuarioID;
	private SolicitudPrestamo solicitudID;
	private String Motivo, FechaAplicacion;
	private boolean Pagado;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getMontoMulta() {
		return MontoMulta;
	}
	public void setMontoMulta(int montoMulta) {
		MontoMulta = montoMulta;
	}
	public Usuario getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Usuario usuarioID) {
		this.usuarioID = usuarioID;
	}
	public SolicitudPrestamo getSolicitudID() {
		return solicitudID;
	}
	public void setSolicitudID(SolicitudPrestamo solicitudID) {
		this.solicitudID = solicitudID;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getFechaAplicacion() {
		return FechaAplicacion;
	}
	public void setFechaAplicacion(String fechaAplicacion) {
		FechaAplicacion = fechaAplicacion;
	}
	public boolean isPagado() {
		return Pagado;
	}
	public void setPagado(boolean pagado) {
		Pagado = pagado;
	}
	
	public Sancion(int iD, int montoMulta, Usuario usuarioID, SolicitudPrestamo solicitudID, String motivo,
			String fechaAplicacion, boolean pagado) {
		ID = iD;
		MontoMulta = montoMulta;
		this.usuarioID = usuarioID;
		this.solicitudID = solicitudID;
		Motivo = motivo;
		FechaAplicacion = fechaAplicacion;
		Pagado = pagado;
	}
}