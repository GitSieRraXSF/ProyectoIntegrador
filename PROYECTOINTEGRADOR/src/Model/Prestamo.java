package Model;

public class Prestamo {

	private Equipo equipo_;
	private Sala sala_;
	
	public Equipo getEquipo_() {
		return equipo_;
	}
	public void setEquipo_(Equipo equipo_) {
		this.equipo_ = equipo_;
	}
	public Sala getSala_() {
		return sala_;
	}
	public void setSala_(Sala sala_) {
		this.sala_ = sala_;
	}
	
	public Prestamo(Equipo equipo_, Sala sala_) {
		this.equipo_ = equipo_;
		this.sala_ = sala_;
	}
	
}