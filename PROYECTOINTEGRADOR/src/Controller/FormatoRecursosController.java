package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.RecursoDAO;
import Model.Recurso;
import Model.Usersession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FormatoRecursosController {
	
	@FXML
    private ComboBox<String> cbTipo;

    @FXML
    private CheckBox chkEstado;

    @FXML
    private TextField txtSoftwareR;
    
    @FXML
    private TextField txtnumeroRecur;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private RecursoDAO recursoDAO = new RecursoDAO(connection);
    
    @FXML
    public void initialize() {
    	cbTipo.getItems().addAll("Sala Informatica", "Equipo");
    }

    @FXML
    void guardarRecurso(ActionEvent event) {
    	switch (cbTipo.getSelectionModel().getSelectedItem()) {
    	case "Sala informaticaca":
    		if (recursoDAO.authenticate(cbTipo.getSelectionModel().getSelectedItem()) && (Usersession.getInstance().getRole().equals("teacher") || Usersession.getInstance().getRole().equals("admin"))) {
    			Recurso recurso = new Recurso(cbTipo.getSelectionModel().getSelectedItem(), txtSoftwareR.getText(), txtnumeroRecur.getText(), chkEstado.isSelected());
    			recursoDAO.save(recurso);
    		} else {
    			Main.showAlert("Error!", "Recurso Invalido", "Ingrese un nuevo recurso o actualice uno que ya esta.", Alert.AlertType.ERROR);
    		}
    	case "Equipo":
    		if (recursoDAO.authenticate(cbTipo.getSelectionModel().getSelectedItem()) && (Usersession.getInstance().getRole().equals("teacher") || Usersession.getInstance().getRole().equals("admin"))) {
    			Recurso recurso = new Recurso(cbTipo.getSelectionModel().getSelectedItem(), txtSoftwareR.getText(), txtnumeroRecur.getText(), chkEstado.isSelected());
    			recursoDAO.save(recurso);
    		} else {
    			Main.showAlert("Error!", "Recurso Invalido", "Ingrese un nuevo recurso o actualice uno que ya esta.", Alert.AlertType.ERROR);
    		}
    	default:
    		Main.showAlert("Advertencia!", "Guardado invalido", "Favor llenar los campos o ingrese una informacion valida.", Alert.AlertType.WARNING);
    	}
    }
    
    @FXML
    void verRecursosfull(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher") || Usersession.getInstance().getRole().equals("admin")) {
			Main.loadView("/view/RecursoController.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }
    
    @FXML
    void LogOut(ActionEvent event) {
    	Usersession.getInstance().destroy();
    	Main.loadView("/view/accesoPL.fxml");
    }
}