package Data;

public class DBConnectionFactory {

	public static DBConnection getConnectionByRole(String role) {
		switch (role.toLowerCase()) {
		case "admin":
			return AdminitradorConnection.getInstance();
		case "teacher":
			return DocenteConnection.getInstance();
		case "supervisor":
			return SupervisorConnection.getInstance();
		default:
			throw new IllegalArgumentException("Rol no válido: " + role);
		}
	}
}
