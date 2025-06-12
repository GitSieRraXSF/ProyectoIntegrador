module PROYECTOINTEGRADOR {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires com.oracle.database.jdbc;
	requires poi;
	requires poi.ooxml;
	
	opens Controller;
	opens Application to javafx.graphics, javafx.fxml;
	opens Model to javafx.base, javafx.controls;
}
