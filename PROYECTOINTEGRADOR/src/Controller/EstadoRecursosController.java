package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.RecursoDAO;
import Model.Recurso;
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

public class EstadoRecursosController {
	
	@FXML
    private Button btnActualizar;

    @FXML
    private Button btnVistaAnterior;

    @FXML
    private TableColumn<Recurso, Boolean> colEstadoDisp;

    @FXML
    private TableColumn<Recurso, Boolean> colEstadoPrest;

    @FXML
    private TableColumn<Recurso, String> colNumeroDisp;

    @FXML
    private TableColumn<Recurso, String> colNumeroPrest;

    @FXML
    private TableColumn<Recurso, String> colSoftwareDisp;

    @FXML
    private TableColumn<Recurso, String> colSoftwarePrest;

    @FXML
    private TableColumn<Recurso, String> colTipoDisp;

    @FXML
    private TableColumn<Recurso, String> colTipoPrest;

    @FXML
    private TableView<Recurso> tablaPrestados;

    @FXML
    private TableView<Recurso> tableDisponibles;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole())
			.getConnection();
	private RecursoDAO recursoDAO = new RecursoDAO(connection);
	
	public void initialize() {
		//Recursos Disponibles
		ObservableList<Recurso> availableRecursos = FXCollections.observableArrayList();
		for (Recurso recurso5 : recursoDAO.fetch()) {
			availableRecursos.add(recurso5);
		}
		colTipoDisp.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwareDisp.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colNumeroDisp.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		colEstadoDisp.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		tableDisponibles.setItems(availableRecursos);
		
		//Recursos Prestados:
		ObservableList<Recurso> borrowedRecursos = FXCollections.observableArrayList();
		for (Recurso recurso6 : recursoDAO.fetchPrestados()) {
			borrowedRecursos.add(recurso6);
		}
		colTipoPrest.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwarePrest.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colNumeroPrest.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		colEstadoPrest.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		tablaPrestados.setItems(availableRecursos);
	}

    @FXML
    void IrAtrasVista(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher")) {
    		Main.loadView("/view/FormatoSolicitud.fxml");
    	} else {
    		Main.showAlert("Error!.", "Role Invalido.", "Deberas tener el role correspondiente.", Alert.AlertType.ERROR);
    	}
    }

    @FXML
    void actualizarEstado(ActionEvent event) {
    	initialize();
    }
}