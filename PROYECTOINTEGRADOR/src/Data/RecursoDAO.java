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
		String sql = "{call InsertRecurso(?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, recurso.getTipo());
			stmt.setString(2, recurso.getSoftwareRequerido());
			stmt.setString(3, recurso.getNumRecurso());
			stmt.setBoolean(4, recurso.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<Recurso> fetch() {
		ArrayList<Recurso> recursos = new ArrayList<>();
		String sql = "{? = call FetchRecursos()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String tipo = rs.getString("Tipo");
					String softwareR = rs.getString("SoftwareRequerido");
					String numRecurso = rs.getString("NumRecurso");
					boolean estado = rs.getBoolean("Estado");
					Recurso RE = new Recurso(tipo, softwareR, numRecurso, estado);
					recursos.add(RE);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return recursos;
	}
	
	public ArrayList<Recurso> fetchDisponibles() {
		ArrayList<Recurso> recursos = new ArrayList<>();
		String sql = "{? = call FetchRecursoDisponibles()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String tipo = rs.getString("Tipo");
					String softwareR = rs.getString("SoftwareRequerido");
					String numRecurso = rs.getString("NumRecurso");
					boolean estado = rs.getBoolean("Estado");
					Recurso RE1 = new Recurso(tipo, softwareR, numRecurso, estado);
					recursos.add(RE1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return recursos;
	}
	
	public ArrayList<Recurso> fetchPrestados() {
		ArrayList<Recurso> recursos9 = new ArrayList<>();
		String sql = "{? = call FetchRecursoPrestados()}";
		try (CallableStatement css = connection.prepareCall(sql)) {
			css.registerOutParameter(1, OracleTypes.CURSOR);
			css.execute();
			try (ResultSet rsc = (ResultSet) css.getObject(1)){
				while (rsc.next()) {
					String tipo = rsc.getString("Tipo");
					String softwareR = rsc.getString("SoftwareRequerido");
					String numRecurso = rsc.getString("NumRecurso");
					boolean estado = rsc.getBoolean("Estado");
					Recurso RE2 = new Recurso(tipo, softwareR, numRecurso, estado);
					recursos9.add(RE2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return recursos9;
	}
	
	public void softdelete1(String numRecurso) {
		String sql = "{call = softdeleteRecurso1(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, numRecurso);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void softdelete2(String numRecurso) {
		String sql = "{call = softdeleteRecurso2(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, numRecurso);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(String numRecurso) {
		String sql = "{? = call AuthenticateRecurso(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, numRecurso);
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