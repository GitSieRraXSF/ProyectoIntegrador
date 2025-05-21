package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.SolicitudPrestamo;

public class SolicitudPrestamoDAO {
	
	private Connection connection;
	
	public SolicitudPrestamoDAO (Connection connection) {
		this.connection = connection;
	}
	
	public void save(SolicitudPrestamo solicitud) {
		String sql = "INSERT INTO Solicitud_Prestamo (fechaSolicitud, fechaDevolucionREAL, HoraInicio, HoraFin, Estado) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, solicitud.getFechaSolicitud());
			stmt.setString(2, solicitud.getFechaDevolucionReal());
			stmt.setString(3, solicitud.getFechainicio());
			stmt.setString(4, solicitud.getFechafinPrevista());
			stmt.setBoolean(5, solicitud.isEstado());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<SolicitudPrestamo> fetch() {
		ArrayList<SolicitudPrestamo> solicitudes = new ArrayList<>();
		String sql = "SELECT * FROM SolicitudPrestamo";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String fechaSolicitud = rs.getString("fechaSolicitud");
				String fechainicio = rs.getString("HoraInicio");
				String fechafinPrevista = rs.getString("HoraFin");
				String fechaDevolucionReal = rs.getString("fechaDevolucionReal");
				boolean estado = rs.getBoolean("Estado");
				SolicitudPrestamo solicitud = new SolicitudPrestamo(fechaSolicitud, fechainicio, fechafinPrevista, fechaDevolucionReal, estado);
				solicitudes.add(solicitud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(SolicitudPrestamo solicitud) {
		String sql = "UPDATE Solicitud_Prestamo SET fechaSolicitud=?, fechaDevolucionREAL=?, HoraInicio=?, HoraFin=?, Estado=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, solicitud.getFechaSolicitud());
			stmt.setString(2, solicitud.getFechaDevolucionReal());
			stmt.setString(3, solicitud.getFechainicio());
			stmt.setString(4, solicitud.getFechafinPrevista());
			stmt.setBoolean(5, solicitud.isEstado());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int IDSolicitud) {
		String sql = "DELETE FROM Book WHERE IDSolicitud=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, IDSolicitud);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(String fecha) {
		String sql = "SELECT fechaSolicitud FROM Solicitud WHERE fechaSolicitud=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, fecha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("fechasolicitud").equals(fecha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}