package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Recurso;

public class RecursoDAO {
	
	private Connection connection;
	
	public RecursoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Recurso recurso) {
	 String sql = "INSERT INTO Recurso (tipo, softwareRequerido, estado) VALUES (?, ?, ?)";
	 try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, recurso.getTipo());
		    stmt.setBoolean(2, recurso.isEstado());
		    stmt.setString(3, recurso.getSoftwareRequerido());
		    stmt.executeUpdate(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	public ArrayList<Recurso> fetch() {
		ArrayList<Recurso> recursos1 = new ArrayList<>();
		String sql = "SELECT * FROM Recurso";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String tipo = rs.getString("Tipo");
				boolean estado = rs.getBoolean("Estado");
				String softwarerequerido = rs.getString("SoftwareRequerido");
				Recurso recursos = new Recurso(tipo, softwarerequerido, estado);
				recursos1.add(recursos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recursos1;
	}
	
	public void update(Recurso recurso) {
		String sql = "UPDATE Recurso SET Tipo=?, Estado=?, SoftwareRequerido=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, recurso.getTipo());
		        stmt.setBoolean(2, recurso.isEstado());
		        stmt.setString(3, recurso.getSoftwareRequerido());
		        stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(int IDRecurso) {
		String sql = "SELECT IDRecurso FROM Recurso WHERE IDRecurso=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, IDRecurso);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("IDRecurso") == IDRecurso;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
