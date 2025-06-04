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
		String sql = "{call InsertSancion(?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setInt(1, sancion69.getValorMulta());
			stmt.setString(2, sancion69.getMotivo());
			stmt.setString(3, sancion69.getUsuario_involucrado());
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
					String motivo = rs.getString("Motivo");
					String user = rs.getString("Usuario_Involucrado");
					Sancion sancion00 = new Sancion(valorMulta, motivo, user);
					sanciones.add(sancion00);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return sanciones;
	}
	
	public void delete(String user1) {
		String sql = "{call DeleteSancion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, user1);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(String user4) {
		String sql = "{? = call AuthenticateSancion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, user4);
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