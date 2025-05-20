package Model;

public class Usersession {

	private static Usersession instance;

    private String username;
    private String role;

    // Private constructor to prevent instantiation
    private Usersession(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Static method to initialize or get the instance
    public static Usersession getInstance(String username, String role) {
        if (instance == null) {
            instance = new Usersession(username, role);
        }
        return instance;
    }

    // Overload for just accessing the session
    public static Usersession getInstance() {
        if (instance == null) {
            throw new IllegalStateException("User session has not been initialized.");
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    // Method to destroy session (e.g., on logout)
    public void destroy() {
        instance = null;
    }
}
