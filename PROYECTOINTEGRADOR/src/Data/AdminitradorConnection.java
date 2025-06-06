package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminitradorConnection implements DBConnection{

	private static AdminitradorConnection instance; //Singleton
    private Connection connection;
	private final String username = "Admin";
	private final String password = "Admin";
	private final String host = "192.168.254.215";
	private final String port = "1521";
	private final String service = "orcl";

    private AdminitradorConnection() {
        try {
            connection = DriverManager.getConnection(getConnectionString(), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.");
        }
    }

    public static AdminitradorConnection getInstance() {
        if (instance == null) instance = new AdminitradorConnection();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
	public String getConnectionString() {
		return String.format("jdbc:oracle:thin:@%s:%s:%s", this.host, this.port, this.service);
	}
}