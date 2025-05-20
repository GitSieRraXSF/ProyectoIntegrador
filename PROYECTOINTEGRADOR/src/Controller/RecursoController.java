package Controller;

import Data.RecursoDAO;
import Model.Recurso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    
    private 
    private RecursoDAO recursoDAO = new RecursoDAO();
    
    @FXML
    public void initialize() {
    	
    	ObservableList<Recurso> availableRecurses = FXCollections.observableArrayList();
    	for (Recurso recurso : )
    }

    @FXML
    void actualizarLista(ActionEvent event) {
    	
    }
}