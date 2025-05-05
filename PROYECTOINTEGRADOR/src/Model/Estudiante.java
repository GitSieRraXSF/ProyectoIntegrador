package Model;

public class Estudiante extends Usuario {

	private String Nombre, Apellido, Fecha_nac;
	private long Cedula;
	private int Cod_Semestre;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getFecha_nac() {
		return Fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		Fecha_nac = fecha_nac;
	}
	public long getCedula() {
		return Cedula;
	}
	public void setCedula(long cedula) {
		Cedula = cedula;
	}
	public int getCod_Semestre() {
		return Cod_Semestre;
	}
	public void setCod_Semestre(int cod_Semestre) {
		Cod_Semestre = cod_Semestre;
	}
	
	public Estudiante(int nro_id, int codigo_Rol, int claveAsignada, String nombre, String apellido, String fecha_nac,
			long cedula, int cod_Semestre) {
		super(nro_id, codigo_Rol, claveAsignada);
		Nombre = nombre;
		Apellido = apellido;
		Fecha_nac = fecha_nac;
		Cedula = cedula;
		Cod_Semestre = cod_Semestre;
	}
	
}