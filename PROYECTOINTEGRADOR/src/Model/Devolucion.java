package Model;

public class Devolucion {

	private int Id;
	private Prestamo prestamo;
	private String FechaDevolucion, HoraDevolucion, estadoRecurso, Observaciones;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	public String getFechaDevolucion() {
		return FechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
		FechaDevolucion = fechaDevolucion;
	}
	public String getHoraDevolucion() {
		return HoraDevolucion;
	}
	public void setHoraDevolucion(String horaDevolucion) {
		HoraDevolucion = horaDevolucion;
	}
	public String getEstadoRecurso() {
		return estadoRecurso;
	}
	public void setEstadoRecurso(String estadoRecurso) {
		this.estadoRecurso = estadoRecurso;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	
	public Devolucion(int id, Prestamo prestamo, String fechaDevolucion, String horaDevolucion, String estadoRecurso,
			String observaciones) {
		Id = id;
		this.prestamo = prestamo;
		FechaDevolucion = fechaDevolucion;
		HoraDevolucion = horaDevolucion;
		this.estadoRecurso = estadoRecurso;
		Observaciones = observaciones;
	}
	
	
}