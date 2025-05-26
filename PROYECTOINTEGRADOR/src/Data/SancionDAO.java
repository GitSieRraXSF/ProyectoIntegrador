package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Application.Main;
import Model.Sancion;
import javafx.scene.control.Alert;
import oracle.jdbc.internal.OracleTypes;

public class SancionDAO {
	
	private Connection connection;
	
	public SancionDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Sancion sancion69) {
		String sql = "{call InsertSancion(?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setInt(1, sancion69.getValorMulta());
			stmt.setString(2, sancion69.getMotivo());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<Sancion> fetch() {
		ArrayList<Sancion> sanciones = new ArrayList<>();
		String sql = "{? = call FetchSancion()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					int valorMulta = rs.getInt("valorMulta");
					String motivo = rs.getString("Email");
					Sancion user = new Sancion(valorMulta, motivo);
					sanciones.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return sanciones;
	}
	
	public void update(Sancion sancion1) {
		String sql = "{call = UpdateSancion(?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setInt(1, sancion1.getValorMulta());
			stmt.setString(2, sancion1.getMotivo());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void delete(int valorMotivo) {
		String sql = "{call DeleteSancion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setInt(1, valorMotivo);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(int valorMotivo) {
		String sql = "{? = call AuthenticateSancion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setInt(2, valorMotivo);
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