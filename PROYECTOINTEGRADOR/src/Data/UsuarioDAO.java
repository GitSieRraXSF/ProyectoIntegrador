package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import Application.Main;
import Model.Usuario;
import javafx.scene.control.Alert;

public class UsuarioDAO{
	
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Usuario usuario) {
		String sql = "{call InsertUsuario(?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getContraseña());
			stmt.setString(4, usuario.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(String Nombre, String Correo, String Contraseña, String role) {
		String sql = "{? = call AuthenticateUsuario(?, ?, ?, ?)}";
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(2, Nombre);
			stmt.setString(3, Correo);
			stmt.setString(4, Contraseña);
			stmt.setString(5, role);
			stmt.execute();
			int Result = stmt.getInt(1);
			return Result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			Main.showAlert("Error!!...", "Proceso invalido", e.getMessage(), Alert.AlertType.ERROR);
		}
		return false;
	}
}