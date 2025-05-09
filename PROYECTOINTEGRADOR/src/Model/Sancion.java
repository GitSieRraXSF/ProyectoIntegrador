package Model;

public class Sancion {

	private int ID, valorMulta;
	private int usuarioID;
	private int solicitudID;
	private String Motivo;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(int valorMulta) {
		this.valorMulta = valorMulta;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public int getSolicitudID() {
		return solicitudID;
	}
	public void setSolicitudID(int solicitudID) {
		this.solicitudID = solicitudID;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	
	public Sancion(int iD, int valorMulta, int usuarioID, int solicitudID, String motivo) {
		ID = iD;
		this.valorMulta = valorMulta;
		this.usuarioID = usuarioID;
		this.solicitudID = solicitudID;
		Motivo = motivo;
	}
}