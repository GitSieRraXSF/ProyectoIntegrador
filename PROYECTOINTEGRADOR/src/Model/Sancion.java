package Model;

public class Sancion {

	private int Id, DuracionDias;
	private Usuario Usuario3;
	private String Motivo, Fecha, Estado;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getDuracionDias() {
		return DuracionDias;
	}
	public void setDuracionDias(int duracionDias) {
		DuracionDias = duracionDias;
	}
	public Usuario getUsuario3() {
		return Usuario3;
	}
	public void setUsuario3(Usuario usuario3) {
		Usuario3 = usuario3;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public Sancion(int id, int duracionDias, Usuario usuario3, String motivo, String fecha, String estado) {
		Id = id;
		DuracionDias = duracionDias;
		Usuario3 = usuario3;
		Motivo = motivo;
		Fecha = fecha;
		Estado = estado;
	}
	
}