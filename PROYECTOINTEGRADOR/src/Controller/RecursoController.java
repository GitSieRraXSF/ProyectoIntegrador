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
import javafx.scene.control.Alert;
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
    private TableColumn<Recurso, String> colNumrecurso1;

	@FXML
	private TableView<Recurso> tableRecursos;

	private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole())
			.getConnection();
	private RecursoDAO recursoDAO = new RecursoDAO(connection);

	@FXML
	public void initialize() {
		ObservableList<Recurso> availableRecursos = FXCollections.observableArrayList();
		for (Recurso recurso5 : recursoDAO.fetchPrestados()) {
			availableRecursos.add(recurso5);
		}
		colTipo.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwareR.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colEstado.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		colNumrecurso1.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
		tableRecursos.setItems(availableRecursos);
	}

	void LoadTableView(ArrayList<Recurso> recursos1) {
		colTipo.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
		colSoftwareR.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
		colNumrecurso1.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
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
    void goBin(ActionEvent event) {
		if (!tableRecursos.getSelectionModel().isEmpty()) {
			Recurso recurso = tableRecursos.getSelectionModel().getSelectedItem();
			recursoDAO.softdelete(recurso.getNumRecurso());
			initialize();
		} else {
			Main.showAlert("Error!", "Seleccion invalida...", "Seleccione un objecto para enviarlo a la papelera.", Alert.AlertType.NONE);
		}
		initialize();
    }

    @FXML
    void outBin(ActionEvent event) {
    	if (!tableRecursos.getSelectionModel().isEmpty()) {
			Recurso recurso = tableRecursos.getSelectionModel().getSelectedItem();
			recursoDAO.softdelete1(recurso.getNumRecurso());
			initialize();
		} else {
			Main.showAlert("Error!", "Seleccion invalida...", "Seleccione un objecto para enviarlo a la papelera.", Alert.AlertType.NONE);
		}
		initialize();
    }

	@FXML
	void VistaAnterior(ActionEvent event) {
		if (Usersession.getInstance().getRole().equals("admin")) {
			Main.loadView("/view/FormatoRecursos.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
	}
}