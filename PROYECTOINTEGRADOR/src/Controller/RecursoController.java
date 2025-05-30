package Controller;

import java.sql.Connection;
import java.util.ArrayList;

import Application.Main;
import Data.DBConnectionFactory;
import Data.RecursoDAO;
import Model.Recurso;
import Model.Usersession;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecursoController {

	@FXML
	private Button btnActualizar;

	@FXML
	private TableColumn<Recurso, Boolean> colEstado;

	@FXML
	private TableColumn<Recurso, String> colSoftwareR;

	@FXML
	private TableColumn<Recurso, String> colTipo;

	@FXML
	private TableView<Recurso> tableRecursos;

	private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole())
			.getConnection();
	private RecursoDAO recursoDAO = new RecursoDAO(connection);

	@FXML
	public void initialize() {

		ObservableList<Recurso> availableRecursos = FXCollections.observableArrayList();
		for (Recurso recurso5 : recursoDAO.fetch()) {
			availableRecursos.add(recurso5);
		}
		colTipo.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwareR.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colEstado.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		tableRecursos.setItems(availableRecursos);
	}

	void LoadTableView(ArrayList<Recurso> recursos1) {
		colTipo.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwareR.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colEstado.setCellFactory(CheckBoxTableCell.forTableColumn(index -> {
			Recurso recurso = colEstado.getTableView().getItems().get(index);
			return new SimpleBooleanProperty(recurso.isEstado());
		}));
		colEstado.setOnEditCommit(event -> {
			event.getRowValue().setEstado(event.getNewValue());
		});
		tableRecursos.getItems().setAll(recursos1);
		tableRecursos.setEditable(true);
	}

	@FXML
	void actualizarLista(ActionEvent event) {
		initialize();
	}
	
	@FXML
    void VistaAnterior(ActionEvent event) {
		Main.loadView("/view/FormatoRecursos.fxml");
    }
}