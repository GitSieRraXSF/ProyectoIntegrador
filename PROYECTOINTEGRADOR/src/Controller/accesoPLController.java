package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class accesoPLController {
	
	@FXML
    private Button btnIniciarSesion;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;
    
    private Connection connection;
	private UsuarioDAO usuarioDAO;
	
	@FXML
	void initialize() {
		cbRol.getItems().addAll("admin", "teacher", "supervisor");
	}
	
    @FXML
    void iniciarSesion(ActionEvent event) {
    	switch (cbRol.getSelectionModel().getSelectedItem()) {
    	case "admin":
    		connection = DBConnectionFactory.getConnectionByRole("admin").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "admin")) {
				Main.loadView("/view/RegistroProductos.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
			break;
    	case "teacher":
    		connection = DBConnectionFactory.getConnectionByRole("teacher").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "teacher")) {
				Main.loadView("/view/RegistroProductos.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
			break;
    	case "supervisor":
    		connection = DBConnectionFactory.getConnectionByRole("teacher").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "supervisor")) {
				Main.loadView("/view/RegistroProductos.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
    	}
    }
}