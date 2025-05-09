package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuario;

public class UsuarioDAO{
	
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Usuario usuario) {
		String sql = "INSERT INTO Usuario (IDUsuario, Nombre, Correo, Contraseña) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, usuario.getID());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getContraseña());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean authenticate(String Correo, String Contraseña) {
		String sql = "SELECT Correo, Contraseña FROM Usuario WHERE Correo = ? AND Contraseña = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, Correo);
			stmt.setString(2, Contraseña);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("Correo").equals(Correo) && rs.getString("Contraseña").equals(Contraseña);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}