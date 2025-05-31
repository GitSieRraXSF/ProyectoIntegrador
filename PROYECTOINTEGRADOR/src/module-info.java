module PROYECTOINTEGRADOR {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires com.oracle.database.jdbc;
	
	opens Application to javafx.graphics, javafx.fxml;
}
