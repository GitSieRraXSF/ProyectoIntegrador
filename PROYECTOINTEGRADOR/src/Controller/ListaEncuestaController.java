package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import Application.Main;
import Data.DBConnectionFactory;
import Data.EncuestaDAO;
import Model.Encuesta;
import Model.Usersession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ListaEncuestaController {

    @FXML
    private Button btnActualizar;

    @FXML
    private TableColumn<Encuesta, String> colFuncionalidad;

    @FXML
    private TableColumn<Encuesta, String> colcalidad;

    @FXML
    private TableColumn<Encuesta, String> colinfraestruc;


    @FXML
    private TableView<Encuesta> tableEncuestas;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private EncuestaDAO encuestaDAO = new EncuestaDAO(connection);
    
    @FXML
    public void initialize() {
    	
    	ObservableList<Encuesta> availableEncuestas = FXCollections.observableArrayList();
    	for (Encuesta encuesta2 : encuestaDAO.fetch()) {
    		availableEncuestas.add(encuesta2);
    	}
    	colFuncionalidad.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
    	colcalidad.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
    	colinfraestruc.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	tableEncuestas.setItems(availableEncuestas);
    }
    
    void LoadTableView(ArrayList<Encuesta> encuestas) {
    	colFuncionalidad.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
    	colinfraestruc.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	colcalidad.setCellFactory(TextFieldTableCell.forTableColumn());
    	colcalidad.setOnEditCommit(event -> {
			Encuesta encuesta = event.getRowValue();
			encuesta.setCalidad(event.getNewValue());
			encuestaDAO.update(encuesta);
		});
    	tableEncuestas.getItems().setAll(encuestas);
    	tableEncuestas.setEditable(true);
    }

    @FXML
    void VistaAnterior(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher")) {
			Main.loadView("/view/FormularioEncuesta.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }
    
    @FXML
    void deleteEncuesta(ActionEvent event) {
    	if (!tableEncuestas.getSelectionModel().isEmpty() && Usersession.getInstance().getRole().equals("admin")) {
			Encuesta encuesta15 = tableEncuestas.getSelectionModel().getSelectedItem();
			encuestaDAO.delete(encuesta15.getCalidad());
			initialize();
		} else {
			Main.showAlert("Ninguna solicitud seleccionada O Acceso denegado", "Referencia repetida O Acceso denegado",
					"Debe registrar una referencia diferente O debes entrar al rol respectivo.",
					Alert.AlertType.WARNING);
		}
		initialize();
    }

    @FXML
    void actualizarLista(ActionEvent event) {
    	initialize();
    }
}