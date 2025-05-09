package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Sancion;

public class SancionDAO implements CRUD_PI<Sancion, String>{
	
	private Connection connection;
	
	public SancionDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(Sancion sancion69) {
		String sql = "INSERT INTO Sancion (IDSancion, IDUsuario, IDSolicitud, valorMulta, Motivo) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, sancion69.getID());
			stmt.setInt(2, sancion69.getUsuarioID());
			stmt.setInt(3, sancion69.getSolicitudID());
			stmt.setInt(4, sancion69.getValorMulta());
			stmt.setString(5, sancion69.getMotivo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Sancion> fetch() {
		ArrayList<Sancion> sancion2 = new ArrayList<>();
		String sql = "SELECT * FROM Sancion";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int iD = rs.getInt("IDSancion");
				int idusuario = rs.getInt("IDUsuario");
				int idsolicitud = rs.getInt("IDSolicitud");
				int valormulta = rs.getInt("IDvalorMulta");
				String motivo = rs.getString("Motivo");
				Sancion sancion6 = new Sancion(iD, idusuario, idsolicitud, valormulta, motivo);
				sancion2.add(sancion6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Sancion sancion1) {
		String sql = "UPDATE Sancion SET IDUsuario=?, IDSolictitud=?, valorMulta=?, Motivo=? WHERE IDSancion=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, sancion1.getUsuarioID());
			stmt.setInt(2, sancion1.getSolicitudID());
			stmt.setInt(3, sancion1.getValorMulta());
			stmt.setString(4, sancion1.getMotivo());
			stmt.setInt(5, sancion1.getID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authenticate(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}