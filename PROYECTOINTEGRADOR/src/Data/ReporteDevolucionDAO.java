package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Application.Main;
import Model.ReporteDevolucion;
import javafx.scene.control.Alert;
import oracle.jdbc.internal.OracleTypes;

public class ReporteDevolucionDAO {
	
	private Connection connection;
	
	public ReporteDevolucionDAO (Connection connection) {
		this.connection = connection;
	}
	
	public void save(ReporteDevolucion reporte) {
		String sql = "{call InsertReporteDevolucion(?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, reporte.getFechaVerificacion());
			stmt.setString(2, reporte.getDescripcion());
			stmt.setString(3, reporte.getUsuarioInvolucrado());
			stmt.setBoolean(4, reporte.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public ArrayList<ReporteDevolucion> fetch() {
		ArrayList<ReporteDevolucion> reportes = new ArrayList<>();
		String sql = "{? = call FetchReporteDevolucion()}";
		try (CallableStatement cs = connection.prepareCall(sql)) {
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			try (ResultSet rs = (ResultSet) cs.getObject(1)){
				while (rs.next()) {
					String fechaveri = rs.getString("Fechaverificacion");
					String desc = rs.getString("Descripcion");
					String userI = rs.getString("UsuarioInvolucrado");
					boolean estado = rs.getBoolean("Estado");
					ReporteDevolucion reporte = new ReporteDevolucion(fechaveri, desc, userI, estado);
					reportes.add(reporte);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
		return reportes;
	}
	
	public void update(ReporteDevolucion reporte1) {
		String sql = "{call = UpdateReporteDevolucion(?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, reporte1.getFechaVerificacion());
			stmt.setString(2, reporte1.getDescripcion());
			stmt.setString(3, reporte1.getUsuarioInvolucrado());
			stmt.setBoolean(4, reporte1.isEstado());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error...!", "Proceso invalido!", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	public void delete(String fecha) {
		String sql = "{call DeleteReporteDevolucion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, fecha);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(String userInvolu) {
		String sql = "{? = call AuthenticateReporteDevolucion(?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, userInvolu);
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