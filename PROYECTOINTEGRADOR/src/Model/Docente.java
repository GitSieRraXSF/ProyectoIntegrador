package Model;

public class Docente extends Usuario{

	private String Nombre, Apellido;
	private int Curso, Cod_Asignado;
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
	public int getCurso() {
		return Curso;
	}
	public void setCurso(int curso) {
		Curso = curso;
	}
	public int getCod_Asignado() {
		return Cod_Asignado;
	}
	public void setCod_Asignado(int cod_Asignado) {
		Cod_Asignado = cod_Asignado;
	}
	public long getCedula() {
		return Cedula;
	}
	public void setCedula(long cedula) {
		Cedula = cedula;
	}
	
	public Docente(int nro_id, int codigo_Rol, int claveAsignada, String nombre, String apellido, int curso,
			int cod_Asignado, long cedula) {
		super(nro_id, codigo_Rol, claveAsignada);
		Nombre = nombre;
		Apellido = apellido;
		Curso = curso;
		Cod_Asignado = cod_Asignado;
		Cedula = cedula;
	}
	
}