package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.ReporteDevolucion;

public class ReporteDevolucionDAO {
	
	private Connection connection;
	
	public ReporteDevolucionDAO (Connection connection) {
		this.connection = connection;
	}
	
	public void save(ReporteDevolucion reporte) {
		String sql = "INSERT INTO Reporte_Devolucion (IDReporte, IDSolicitud, IDSupervisor, Estado, FechaVerificacion, Reparacion) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, reporte.getID());
			stmt.setInt(2, reporte.getSolicitudID());
			stmt.setInt(3, reporte.getSupervisorID());
			stmt.setBoolean(4, reporte.isEstado());
			stmt.setString(5, reporte.getFechaVerificacion());
			stmt.setString(6, reporte.getReparacion());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReporteDevolucion> fetch() {
		ArrayList<ReporteDevolucion> reportes = new ArrayList<>();
		String sql = "SELECT * FROM Reporte_Devolucion";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int iD = rs.getInt("IDReporte");
				int solicitudID = rs.getInt("IDSolicitud");
				int supervisorID = rs.getInt("IDSupervisor");
				boolean estado = rs.getBoolean("Estado");
				String fechaverificacion = rs.getString("FechaVerificacion");
				String reparacion = rs.getString("reparacion");
				ReporteDevolucion reporte1 = new ReporteDevolucion(iD, solicitudID, supervisorID, fechaverificacion, reparacion, estado);
				reportes.add(reporte1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(ReporteDevolucion reporte1) {
		String sql = "UPDATE Reporte_Devolucion SET Estado=?, FechaVerificacion=?, Reparacion=? WHERE IDReporte=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBoolean(1, reporte1.isEstado());
			stmt.setString(2, reporte1.getFechaVerificacion());
			stmt.setString(3, reporte1.getReparacion());
			stmt.setInt(4, reporte1.getID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int IDReporte) {
		String sql = "DELETE FROM Reporte_Devolucion WHERE IDReporte=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDReporte);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(int IDReporte) {
		String sql = "SELECT IDReporte FROM Reporte_Devolucion WHERE IDReporte=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, IDReporte);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("IDReporte") == IDReporte;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}