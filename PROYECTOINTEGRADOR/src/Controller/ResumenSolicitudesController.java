package Controller;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import Application.Main;
import Data.ApacheProyect;
import Data.DBConnectionFactory;
import Data.SolicitudPrestamoDAO;
import Model.SolicitudPrestamo;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ResumenSolicitudesController {

    @FXML
    private Button btnActualizarResumen;
    
    @FXML
    private Button CATemplate;

    @FXML
    private TableColumn<SolicitudPrestamo, Boolean> colEstado;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colNombreuser;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colfechaDevo;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colfechafinprevista;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colfechainicio;

    @FXML
    private TableView<SolicitudPrestamo> tableSolicitudes;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private SolicitudPrestamoDAO SolicitudDAO = new SolicitudPrestamoDAO(connection);
    
    @FXML
    public void initialize() {
    	
    	ObservableList<SolicitudPrestamo> availableSolicitudes = FXCollections.observableArrayList();
    	for (SolicitudPrestamo solicitud2 : SolicitudDAO.fetch()) {
    		availableSolicitudes.add(solicitud2);
    	}
    	// Bind only the columns you want to show
    	colNombreuser.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
    	colfechainicio.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
    	colfechafinprevista.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	colfechaDevo.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucionReal"));
    	colEstado.setCellValueFactory(new PropertyValueFactory<>("Estado"));
    	// Set data to TableView
    	tableSolicitudes.setItems(availableSolicitudes);
    }

    @FXML
    void actualizarResumen(ActionEvent event) {
    	//Display data in the table
    	initialize();
    }
    
    @FXML
    void SubirTemplate(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("admin")) {
			FileChooser file = new FileChooser();
			file.setTitle("Seleccionar archivo de excel");
			file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arhivos Excel", "*.xlsx"));
			Stage stage = (Stage) CATemplate.getScene().getWindow();
			File archivoSeleccionado = file.showOpenDialog(stage);
			ArrayList<SolicitudPrestamo> SolicitudesExcel = ApacheProyect.fetchExcel(archivoSeleccionado);
			LoadTableView(SolicitudesExcel);
		} else {
			Main.showAlert("Acceso denegado", "Rol no correspondiente", "Debes entrar al rol respectivo para cargar archivos.", Alert.AlertType.WARNING);
		}
    }

	void LoadTableView(ArrayList<SolicitudPrestamo> solicitudes) {
		colNombreuser.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
    	colfechainicio.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
    	colfechafinprevista.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	colfechaDevo.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucionReal"));
    	colEstado.setCellValueFactory(new PropertyValueFactory<>("Estado"));
    	colfechainicio.setCellFactory(TextFieldTableCell.forTableColumn());
    	colfechainicio.setOnEditCommit(event -> {
			SolicitudPrestamo solicitud = event.getRowValue();
			solicitud.setNombreUsuario(event.getNewValue());
			SolicitudDAO.update(solicitud);
		});
    	tableSolicitudes.getItems().setAll(solicitudes);
    	tableSolicitudes.setEditable(true);
	}
	
	@FXML
    void deleteSolicitud(ActionEvent event) {
		if (!tableSolicitudes.getSelectionModel().isEmpty() && Usersession.getInstance().getRole().equals("teacher")) {
			SolicitudPrestamo soli1 = tableSolicitudes.getSelectionModel().getSelectedItem();
			SolicitudDAO.delete(soli1.getNombreUsuario());
			initialize();
		} else {
			Main.showAlert("Ninguna solicitud seleccionada O Acceso denegado", "Referencia repetida O Acceso denegado",
					"Debe registrar una referencia diferente O debes entrar al rol respectivo.",
					Alert.AlertType.WARNING);
		}
		initialize();
    }
	
	@FXML
    void VistaAnterior(ActionEvent event) {
		if (Usersession.getInstance().getRole().equals("teacher")) {
			Main.loadView("/view/SolicitudController.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }
}