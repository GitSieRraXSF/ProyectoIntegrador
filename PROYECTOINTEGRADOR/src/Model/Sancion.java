package Model;

public class Sancion {

	private int ID, MontoMulta;
	private Usuario usuarioID;
	private String Motivo, FechaAplicacion;
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
	
	public Sancion(int iD, int montoMulta, Usuario usuarioID, String motivo, String fechaAplicacion) {
		ID = iD;
		MontoMulta = montoMulta;
		this.usuarioID = usuarioID;
		Motivo = motivo;
		FechaAplicacion = fechaAplicacion;
	}
}