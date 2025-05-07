package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.SolicitudPrestamo;

public class SolicitudPrestamoDAO implements CRUD_PI<SolicitudPrestamo, String> {
	
	private Connection connection;
	
	public SolicitudPrestamoDAO (Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(SolicitudPrestamo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<SolicitudPrestamo> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SolicitudPrestamo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authenticate(String estado) {
/*		String sql = "";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, nickname);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("nickname").equals(nickname) && rs.getString("contraseña").equals(contraseña);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return false;
	}
}