package Model;

public class Supervisor extends Usuario{

	private String Nombre, Apellido, Papel;
	private long Cedula;
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
	public String getPapel() {
		return Papel;
	}
	public void setPapel(String papel) {
		Papel = papel;
	}
	public long getCedula() {
		return Cedula;
	}
	public void setCedula(long cedula) {
		Cedula = cedula;
	}
	
	public Supervisor(int nro_id, int codigo_Rol, int claveAsignada, String nombre, String apellido, String papel,
			long cedula) {
		super(nro_id, codigo_Rol, claveAsignada);
		Nombre = nombre;
		Apellido = apellido;
		Papel = papel;
		Cedula = cedula;
	}
	
}