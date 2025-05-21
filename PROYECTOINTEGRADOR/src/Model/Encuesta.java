package Model;

public class Encuesta {

	private String Funcionalidad, Calidad, Infraestructura;
	
	public String getFuncionalidad() {
		return Funcionalidad;
	}
	public void setFuncionalidad(String funcionalidad) {
		Funcionalidad = funcionalidad;
	}
	public String getCalidad() {
		return Calidad;
	}
	public void setCalidad(String calidad) {
		Calidad = calidad;
	}
	public String getInfraestructura() {
		return Infraestructura;
	}
	public void setInfraestructura(String infraestructura) {
		Infraestructura = infraestructura;
	}
	
	public Encuesta(String funcionalidad, String calidad, String infraestructura) {
		Funcionalidad = funcionalidad;
		Calidad = calidad;
		Infraestructura = infraestructura;
	}
}