package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Sancion;

public class SancionDAO {
	
	private Connection connection;
	
	public SancionDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Sancion sancion69) {
		String sql = "INSERT INTO Sancion (valorMulta, Motivo) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, sancion69.getValorMulta());
			stmt.setString(2, sancion69.getMotivo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sancion> fetch() {
		ArrayList<Sancion> sancion2 = new ArrayList<>();
		String sql = "SELECT * FROM Sancion";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int valormulta = rs.getInt("IDvalorMulta");
				String motivo = rs.getString("Motivo");
				Sancion sancion6 = new Sancion(valormulta, motivo);
				sancion2.add(sancion6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Sancion sancion1) {
		String sql = "UPDATE Sancion SET valorMulta=?, Motivo=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, sancion1.getValorMulta());
			stmt.setString(2, sancion1.getMotivo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int IDSancion) {
		String sql = "DELETE FROM Sancion WHERE IDSancion=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDSancion);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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