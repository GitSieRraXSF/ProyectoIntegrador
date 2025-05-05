package Model;

public class Usuario {

	private int Nro_id, Codigo_Rol, ClaveAsignada;

	public int getNro_id() {
		return Nro_id;
	}

	public void setNro_id(int nro_id) {
		Nro_id = nro_id;
	}

	public int getCodigo_Rol() {
		return Codigo_Rol;
	}

	public void setCodigo_Rol(int codigo_Rol) {
		Codigo_Rol = codigo_Rol;
	}

	public int getClaveAsignada() {
		return ClaveAsignada;
	}

	public void setClaveAsignada(int claveAsignada) {
		ClaveAsignada = claveAsignada;
	}

	public Usuario(int nro_id, int codigo_Rol, int claveAsignada) {
		Nro_id = nro_id;
		Codigo_Rol = codigo_Rol;
		ClaveAsignada = claveAsignada;
	}
	
}