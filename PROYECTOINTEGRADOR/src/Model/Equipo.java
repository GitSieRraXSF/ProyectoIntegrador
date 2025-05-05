package Model;

public class Equipo {

	private String Nombre_Equipo;
	private int ID_Equipo;
	private float Valor_Equipo;
	private boolean Estado_Equipo;
	public String getNombre_Equipo() {
		return Nombre_Equipo;
	}
	public void setNombre_Equipo(String nombre_Equipo) {
		Nombre_Equipo = nombre_Equipo;
	}
	public int getID_Equipo() {
		return ID_Equipo;
	}
	public void setID_Equipo(int iD_Equipo) {
		ID_Equipo = iD_Equipo;
	}
	public float getValor_Equipo() {
		return Valor_Equipo;
	}
	public void setValor_Equipo(float valor_Equipo) {
		Valor_Equipo = valor_Equipo;
	}
	public boolean isEstado_Equipo() {
		return Estado_Equipo;
	}
	public void setEstado_Equipo(boolean estado_Equipo) {
		Estado_Equipo = estado_Equipo;
	}
	
	public Equipo(String nombre_Equipo, int iD_Equipo, float valor_Equipo, boolean estado_Equipo) {
		Nombre_Equipo = nombre_Equipo;
		ID_Equipo = iD_Equipo;
		Valor_Equipo = valor_Equipo;
		Estado_Equipo = estado_Equipo;
	}
	
}