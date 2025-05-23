package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<Sancion> fetch() {
		ArrayList<Sancion> sanciones = new ArrayList<>();
		String sql = "{? = call FetchUsuario()}";
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
		String sql = "{call = UpdateSolicitud(?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setInt(1, sancion1.getValorMulta());
			stmt.setString(2, sancion1.getMotivo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void delete(int IDSancion) {
		String sql = "DELETE FROM Sancion WHERE IDSancion=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDSancion);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(int IDSancion) {
		String sql = "SELECT IDSancion FROM Sancion WHERE IDSancion=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, IDSancion);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("IDSancion") == IDSancion;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}