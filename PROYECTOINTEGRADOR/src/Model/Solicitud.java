package Model;

public class Solicitud {

	private int Id;
	private Usuario Usuario1;
	private String FechaSolicitud, FechaUso, Horainicio, Horafin, DescripcionRequerimiento, estado;
	private Recurso RecursoSolicitado;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Usuario getUsuario1() {
		return Usuario1;
	}
	public void setUsuario1(Usuario usuario1) {
		Usuario1 = usuario1;
	}
	public String getFechaSolicitud() {
		return FechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}
	public String getFechaUso() {
		return FechaUso;
	}
	public void setFechaUso(String fechaUso) {
		FechaUso = fechaUso;
	}
	public String getHorainicio() {
		return Horainicio;
	}
	public void setHorainicio(String horainicio) {
		Horainicio = horainicio;
	}
	public String getHorafin() {
		return Horafin;
	}
	public void setHorafin(String horafin) {
		Horafin = horafin;
	}
	public String getDescripcionRequerimiento() {
		return DescripcionRequerimiento;
	}
	public void setDescripcionRequerimiento(String descripcionRequerimiento) {
		DescripcionRequerimiento = descripcionRequerimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Recurso getRecursoSolicitado() {
		return RecursoSolicitado;
	}
	public void setRecursoSolicitado(Recurso recursoSolicitado) {
		RecursoSolicitado = recursoSolicitado;
	}
	public Solicitud(int id, Usuario usuario1, String fechaSolicitud, String fechaUso, String horainicio,
			String horafin, String descripcionRequerimiento, String estado, Recurso recursoSolicitado) {
		Id = id;
		Usuario1 = usuario1;
		FechaSolicitud = fechaSolicitud;
		FechaUso = fechaUso;
		Horainicio = horainicio;
		Horafin = horafin;
		DescripcionRequerimiento = descripcionRequerimiento;
		this.estado = estado;
		RecursoSolicitado = recursoSolicitado;
	}
	
}