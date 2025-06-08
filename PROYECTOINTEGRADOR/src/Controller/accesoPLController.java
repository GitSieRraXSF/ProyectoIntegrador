package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.UsuarioDAO;
import Model.Usersession;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class accesoPLController implements ClearCampos {
	
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
	private Usersession UserS;
	
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
				UserS = Usersession.getInstance(txtNombre.getText(), "admin");
				limpiarCampos();
				Main.loadView("/view/FormatoReportes.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
			break;
    	case "teacher":
    		connection = DBConnectionFactory.getConnectionByRole("teacher").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "teacher")) {
				UserS = Usersession.getInstance(txtNombre.getText(), "teacher");
				limpiarCampos();
				Main.loadView("/view/FormatoSolicitud.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
			break;
    	case "supervisor":
    		connection = DBConnectionFactory.getConnectionByRole("supervisor").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "supervisor")) {
				UserS = Usersession.getInstance(txtNombre.getText(), "supervisor");
				limpiarCampos();
				Main.loadView("/view/ListaRecursos.fxml");
			} else {
				Main.showAlert("Usuario Invalida", "Usuario Invalido", "ingrese un usuario valido.", Alert.AlertType.WARNING);
			}
			break;
		default:
			Main.showAlert("Peligro...!", "Proceso Erroneo!", "Favor llenar los espacios obligatorios para el ingreso al programa.", Alert.AlertType.WARNING);
    	}
    }
    
    @FXML
    void RegistrarUsuario(ActionEvent event) {
    	switch (cbRol.getSelectionModel().getSelectedItem()) {
    	case "admin":
    		connection = DBConnectionFactory.getConnectionByRole("admin").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (!usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "admin")) {
				String nombre = txtNombre.getText();
				String correo = txtEmail.getText();
				String pass = txtContraseña.getText();
				String role = "admin";
				Usuario user = new Usuario(nombre, correo, pass, role);
				usuarioDAO.save(user);
				limpiarCampos();
			} else {
				Main.showAlert("Error!.", "Registro Erroneo!", "El usuario que acabas de poner ya esta registrado en el sistema.", Alert.AlertType.ERROR);
			}
    	case "teacher":
    		connection = DBConnectionFactory.getConnectionByRole("teacher").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (!usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "teacher")) {
				String nombre1 = txtNombre.getText();
				String correo1 = txtEmail.getText();
				String pass1 = txtContraseña.getText();
				String role1 = "teacher";
				Usuario user1 = new Usuario(nombre1, correo1, pass1, role1);
				usuarioDAO.save(user1);
				limpiarCampos();
			} else {
				Main.showAlert("Error!.", "Registro Erroneo!", "El usuario que acabas de poner ya esta registrado en el sistema.", Alert.AlertType.ERROR);
			}
    	case "supervisor":
    		connection = DBConnectionFactory.getConnectionByRole("supervisor").getConnection();
			usuarioDAO = new UsuarioDAO(connection);
			if (!usuarioDAO.authenticate(txtNombre.getText(), txtEmail.getText(), txtContraseña.getText(), "supervisor")) {
				String nombre2 = txtNombre.getText();
				String correo2 = txtEmail.getText();
				String pass2 = txtContraseña.getText();
				String role2 = "supervisor";
				Usuario user2 = new Usuario(nombre2, correo2, pass2, role2);
				usuarioDAO.save(user2);
				limpiarCampos();
			} else {
				Main.showAlert("Error!.", "Registro Erroneo!", "El usuario que acabas de poner ya esta registrado en el sistema.", Alert.AlertType.ERROR);
			}
    	default:
			Main.showAlert("Peligro...!", "Proceso Erroneo!", "Favor llenar los espacios obligatorios para el ingreso al programa.", Alert.AlertType.WARNING);
    	}
    }

	@Override
	public void limpiarCampos() {
		txtNombre.clear();
		txtEmail.clear();
		txtContraseña.clear();
	}
}