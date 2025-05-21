package Model;

public class Sancion {

	private int valorMulta;
	private String Motivo;
	
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
	
	public Sancion(int valorMulta, String motivo) {
		this.valorMulta = valorMulta;
		Motivo = motivo;
	}
}