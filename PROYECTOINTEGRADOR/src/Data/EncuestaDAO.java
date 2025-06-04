package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Application.Main;
import Model.Encuesta;
import javafx.scene.control.Alert;
import oracle.jdbc.internal.OracleTypes;

public class EncuestaDAO {
	
	private Connection connection;
	
	public EncuestaDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Encuesta encuesta1) {
		String sql = "{call InsertEncuesta(?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, encuesta1.getFuncionalidad());
			stmt.setString(2, encuesta1.getCalidad());
			stmt.setString(3, encuesta1.getInfraestructura());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<Encuesta> fetch() {
		ArrayList<Encuesta> encuestas = new ArrayList<>();
		//String sequel = "SELECT * FROM PROGRAMMINGII.Producto";
		String sql = "{? = call FetchEncuesta()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String funcionalidad = rs.getString("Funcionalidad");
					String calidad = rs.getString("Calidad");
					String infraestrutura = rs.getString("Infraestrutura");
					Encuesta encuesta= new Encuesta(funcionalidad, calidad, infraestrutura);
					encuestas.add(encuesta);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return encuestas;
	}
	
	public void update(Encuesta encuesta) {
		String sql = "{call = UpdateEncuesta(?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(2, encuesta.getCalidad());
			stmt.setString(3, encuesta.getInfraestructura());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void delete(String Calidad) {
		String sql = "{call DeleteEncuesta(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, Calidad);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
}