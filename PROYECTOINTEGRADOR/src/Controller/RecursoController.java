package Controller;

import java.sql.Connection;
import Data.DBConnectionFactory;
import Data.RecursoDAO;
import Model.Recurso;
import Model.Usersession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecursoController {

    @FXML
    private Button btnActualizar;

    @FXML
    private TableColumn<Recurso, Boolean> colDisponibilidad;

    @FXML
    private TableColumn<Recurso, Integer> colId;

    @FXML
    private TableColumn<Recurso, String> colNombre;

    @FXML
    private TableColumn<Recurso, String> colTipo;

    @FXML
    private TableView<Recurso> tableRecursos;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private RecursoDAO recursoDAO = new RecursoDAO(connection);
    
    @FXML
    public void initialize() {
    	
    	ObservableList<Recurso> availableRecurses = FXCollections.observableArrayList();
    	for (Recurso recurso : recursoDAO.fetch()) {
    		availableRecurses.add(recurso);
    	}
    	// Bind only the columns you want to show
    	colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    	colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
    	colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
    	colDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("Estado"));
    	// Set data to TableView
    	tableRecursos.setItems(availableRecurses);
    }

    @FXML
    void actualizarLista(ActionEvent event) {
    	initialize();
    }
}