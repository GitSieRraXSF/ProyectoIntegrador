package Model;

public class Prestamo {

	private int Id;
	private Solicitud solicitud;
	private String Fechainicio, Fechafin, Estado;
	private Recurso recurso;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public String getFechainicio() {
		return Fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		Fechainicio = fechainicio;
	}
	public String getFechafin() {
		return Fechafin;
	}
	public void setFechafin(String fechafin) {
		Fechafin = fechafin;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	public Prestamo(int id, Solicitud solicitud, String fechainicio, String fechafin, String estado, Recurso recurso) {
		Id = id;
		this.solicitud = solicitud;
		Fechainicio = fechainicio;
		Fechafin = fechafin;
		Estado = estado;
		this.recurso = recurso;
	}
	
}