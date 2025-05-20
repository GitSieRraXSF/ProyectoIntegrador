package Data;

public class DBConnectionFactory {

	public static DBConnection getConnectionByRole(String role) {
		switch (role.toLowerCase()) {
		case "admin":
			return AdminitradorConnection.getInstance();
		case "student":
			return DocenteConnection.getInstance();
		case "teacher":
			return SupervisorConnection.getInstance();
		default:
			throw new IllegalArgumentException("Rol no válido: " + role);
		}
	}
}
