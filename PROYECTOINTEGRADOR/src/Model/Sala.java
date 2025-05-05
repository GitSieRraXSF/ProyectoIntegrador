package Model;

public class Sala {

	private String Ubicacion_Sala, Requisito;
	private int Codigo_Sala;
	private boolean Estado_Sala;
	public String getUbicacion_Sala() {
		return Ubicacion_Sala;
	}
	public void setUbicacion_Sala(String ubicacion_Sala) {
		Ubicacion_Sala = ubicacion_Sala;
	}
	public String getRequisito() {
		return Requisito;
	}
	public void setRequisito(String requisito) {
		Requisito = requisito;
	}
	public int getCodigo_Sala() {
		return Codigo_Sala;
	}
	public void setCodigo_Sala(int codigo_Sala) {
		Codigo_Sala = codigo_Sala;
	}
	public boolean isEstado_Sala() {
		return Estado_Sala;
	}
	public void setEstado_Sala(boolean estado_Sala) {
		Estado_Sala = estado_Sala;
	}
	
	public Sala(String ubicacion_Sala, String requisito, int codigo_Sala, boolean estado_Sala) {
		Ubicacion_Sala = ubicacion_Sala;
		Requisito = requisito;
		Codigo_Sala = codigo_Sala;
		Estado_Sala = estado_Sala;
	}
	
}