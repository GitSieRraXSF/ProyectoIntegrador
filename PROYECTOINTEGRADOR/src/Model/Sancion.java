package Model;

public class Sancion {

	private int valorMulta;
	private String Motivo, Usuario_involucrado;
	
	public int getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(int valorMulta) {
		this.valorMulta = valorMulta;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getUsuario_involucrado() {
		return Usuario_involucrado;
	}
	public void setUsuario_involucrado(String usuario_involucrado) {
		Usuario_involucrado = usuario_involucrado;
	}
	
	public Sancion(int valorMulta, String motivo, String userInv) {
		this.valorMulta = valorMulta;
		Motivo = motivo;
		Usuario_involucrado = userInv;
	}
}