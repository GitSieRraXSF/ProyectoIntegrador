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
		String sql = "INSERT INTO Encuesta (IDEncuesta, IDSolicitud, IDUsuario, Funcionalidad, Calidad, Infraestructura) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, encuesta1.getID());
			stmt.setInt(2, encuesta1.getSolicitudID());
			stmt.setInt(3, encuesta1.getUsuarioID());
			stmt.setString(4, encuesta1.getFuncionalidad());
			stmt.setString(5, encuesta1.getCalidad());
			stmt.setString(6, encuesta1.getInfraestructura());
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
				int iD = rs.getInt("IDEncuesta");
				int solicitudID = rs.getInt("IDSolicitud");
				int usuarioID = rs.getInt("IDUsuario");
				String funcionalidad = rs.getString("Funcionalidad");
				String calidad = rs.getString("Calidad");
				String infraestructura = rs.getString("Infraestructura");
				Encuesta encuesta = new Encuesta(iD, solicitudID, usuarioID, funcionalidad, calidad, infraestructura);
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