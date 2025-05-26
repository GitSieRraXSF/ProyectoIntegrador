package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Application.Main;
import Model.Recurso;
import javafx.scene.control.Alert;
import oracle.jdbc.internal.OracleTypes;

public class RecursoDAO {
	
	private Connection connection;
	
	public RecursoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Recurso recurso) {
		String sql = "{call InsertRecurso(?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, recurso.getTipo());
			stmt.setString(2, recurso.getSoftwareRequerido());
			stmt.setBoolean(3, recurso.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<Recurso> fetch() {
		ArrayList<Recurso> recursos = new ArrayList<>();
		String sql = "{? = call FetchRecurso()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String tipo = rs.getString("Tipo");
					String softwareR = rs.getString("SoftwareRequerido");
					boolean estado = rs.getBoolean("Estado");
					Recurso RE = new Recurso(tipo, softwareR, estado);
					recursos.add(RE);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return recursos;
	}
	
	public void update(Recurso recurso) {
		String sql = "{call = UpdateRecurso(?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, recurso.getTipo());
			stmt.setString(2, recurso.getSoftwareRequerido());
			stmt.setBoolean(3, recurso.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(String tipo) {
		String sql = "{? = call AuthenticateRecurso(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, tipo);
			stmt.execute();
			int result = stmt.getInt(1);
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return false;
	}
}