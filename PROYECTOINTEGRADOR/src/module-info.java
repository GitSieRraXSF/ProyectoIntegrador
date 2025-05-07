module PROYECTOINTEGRADOR {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens Application to javafx.graphics, javafx.fxml;
}
