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
		String sql = "INSERT INTO Solicitud_Prestamo (IDSolicitud, IDUsuario, IDRecurso, fechaSolicitud, fechaDevolucionREAL, HoraInicio, HoraFin, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, solicitud.getID());
			stmt.setInt(2, solicitud.getUsuarioID());
			stmt.setInt(3, solicitud.getRecursoID());
			stmt.setString(4, solicitud.getFechaSolicitud());
			stmt.setString(5, solicitud.getFechaDevolucionReal());
			stmt.setString(6, solicitud.getFechainicio());
			stmt.setString(7, solicitud.getFechafinPrevista());
			stmt.setBoolean(8, solicitud.isEstado());
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
				int iD = rs.getInt("IDSolicitud");
				int usuarioID = rs.getInt("IDUsuario");
				int recursoID = rs.getInt("IDRecurso");
				String fechaSolicitud = rs.getString("fechaSolicitud");
				String fechainicio = rs.getString("HoraInicio");
				String fechafinPrevista = rs.getString("HoraFin");
				String fechaDevolucionReal = rs.getString("fechaDevolucionReal");
				boolean estado = rs.getBoolean("Estado");
				SolicitudPrestamo solicitud = new SolicitudPrestamo(iD, usuarioID, recursoID, fechaSolicitud, fechainicio, fechafinPrevista, fechaDevolucionReal, estado);
				solicitudes.add(solicitud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(SolicitudPrestamo solicitud) {
		String sql = "UPDATE solicitud SET IDSolicitud=?, IDRecurso=?, fechaSolicitud=?, fechaDevolucionREAL=?, HoraInicio=?, HoraFin=?, Estado=? WHERE IDUsuario=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, solicitud.getID());
			stmt.setInt(2, solicitud.getRecursoID());
			stmt.setString(3, solicitud.getFechaSolicitud());
			stmt.setString(4, solicitud.getFechaDevolucionReal());
			stmt.setString(5, solicitud.getFechainicio());
			stmt.setString(6, solicitud.getFechafinPrevista());
			stmt.setBoolean(7, solicitud.isEstado());
			stmt.setInt(8, solicitud.getUsuarioID());
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
	
	public boolean authenticate(int IDSolicitud) {
		String sql = "SELECT IDSolicitud FROM Solicitud WHERE IDSolicitud=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, IDSolicitud);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("IDSolicitud") == IDSolicitud;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}