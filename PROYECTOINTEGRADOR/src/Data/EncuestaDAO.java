package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Encuesta;

public class EncuestaDAO {
	
	private Connection connection;
	
	public EncuestaDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Encuesta encuesta1) {
		String sql = "INSERT INTO Encuesta (Funcionalidad, Calidad, Infraestructura) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, encuesta1.getFuncionalidad());
			stmt.setString(2, encuesta1.getCalidad());
			stmt.setString(3, encuesta1.getInfraestructura());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Encuesta> fetch() {
		ArrayList<Encuesta> encuestas1 = new ArrayList<>();
		String sql = "SELECT * FROM Encuesta";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String funcionalidad = rs.getString("Funcionalidad");
				String calidad = rs.getString("Calidad");
				String infraestructura = rs.getString("Infraestructura");
				Encuesta encuesta = new Encuesta(funcionalidad, calidad, infraestructura);
				encuestas1.add(encuesta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(int IDEncuesta) {
		String sql = "DELETE FROM Encuesta WHERE IDEncuesta=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDEncuesta);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(int IDEncuesta) {
		String sql = "SELECT IDEncuesta FROM Encuesta WHERE IDEncuesta=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDEncuesta);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("IDEncuesta") == IDEncuesta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}