package Controller;

import java.sql.Connection;

import Application.Main;
import Data.DBConnectionFactory;
import Data.EncuestaDAO;
import Model.Encuesta;
import Model.Usersession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EncuestaController implements ClearCampos {

	@FXML
    private Button btnEnviarEncuesta;

    @FXML
    private TextArea txtAFuncionalidad;

    @FXML
    private TextArea txtAInfraestructura;

    @FXML
    private TextField txtCalidad;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private EncuestaDAO encuestaDAO = new EncuestaDAO(connection);

    @FXML
    void enviarEncuesta(ActionEvent event) {
    	String funcion = txtAFuncionalidad.getText();
    	String Calidad = txtCalidad.getText();
    	String InfraEstruc = txtAInfraestructura.getText();
    	if ((txtAFuncionalidad.getText().isBlank() || txtCalidad.getText().isBlank() || txtAInfraestructura.getText().isBlank()) && Usersession.getInstance().getRole().equals("teacher")) {
    		Encuesta encuesta = new Encuesta(funcion, Calidad, InfraEstruc);
    		encuestaDAO.save(encuesta);
    		limpiarCampos();
    	} else {
    		Main.showAlert("Error!...", "Encuesta Invalida ó Rol Invalido!!", "No se ha podido registrar la encuesta dada.", Alert.AlertType.ERROR);
    	}
    }
    
    @FXML
    void verEncuestas(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher") || Usersession.getInstance().getRole().equals("admin")) {
    		Main.loadView("/view/ListaEncuestas.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }
    
    @FXML
    void LogOut(ActionEvent event) {
    	Usersession.getInstance().destroy();
    	Main.loadView("/view/accesoPL.fxml");
    }

	@Override
	public void limpiarCampos() {
		txtAFuncionalidad.clear();
		txtAInfraestructura.clear();
		txtCalidad.clear();
	}
}