package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Application.Main;
import Model.SolicitudPrestamo;
import javafx.scene.control.Alert;
import oracle.jdbc.internal.OracleTypes;

public class SolicitudPrestamoDAO {
	
	private Connection connection;
	
	public SolicitudPrestamoDAO (Connection connection) {
		this.connection = connection;
	}
	
	public void save(SolicitudPrestamo solicitud) {
		String sql = "{call InsertSolicitudPrestamo(?, ?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, solicitud.getNombreUsuario());
			stmt.setString(2, solicitud.getFechaDevolucionReal());
			stmt.setString(3, solicitud.getFechainicio());
			stmt.setString(4, solicitud.getFechafinPrevista());
			stmt.setBoolean(5, solicitud.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<SolicitudPrestamo> fetch() {
		ArrayList<SolicitudPrestamo> solicitudes = new ArrayList<>();
		String sql = "{? = call FetchSolicitudPrestamo()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String nombreusuario = rs.getString("NombreUsuario");
					String fechainicio = rs.getString("fechainicio");
					String fechafinPrevista = rs.getString("fechafinPrevista");
					String fechaDevolucionReal = rs.getString("fechaDevolucionReal");
					boolean estado = rs.getBoolean("Estado");
					SolicitudPrestamo Solicitud = new SolicitudPrestamo(nombreusuario, fechainicio, fechafinPrevista, fechaDevolucionReal, estado);
					solicitudes.add(Solicitud);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return solicitudes;
	}
	
	public void update(SolicitudPrestamo solicitud) {
		String sql = "{call = UpdateSolicitud(?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, solicitud.getNombreUsuario());
			stmt.setString(2, solicitud.getFechaDevolucionReal());
			stmt.setString(3, solicitud.getFechainicio());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void delete(String user) {
		String sql = "{call DeleteSolicitudPrestamo(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, user);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public boolean authenticate(String user) {
		String sql = "{? = call AuthenticateSolicitud(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, user);
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