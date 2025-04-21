package Model;

public class Recurso {

	private int Id, CantidadDisponible;
	private String Nombre, Tipo, Descripcion, estado;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCantidadDisponible() {
		return CantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		CantidadDisponible = cantidadDisponible;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Recurso(int id, int cantidadDisponible, String nombre, String tipo, String descripcion, String estado) {
		Id = id;
		CantidadDisponible = cantidadDisponible;
		Nombre = nombre;
		Tipo = tipo;
		Descripcion = descripcion;
		this.estado = estado;
	}
	
}