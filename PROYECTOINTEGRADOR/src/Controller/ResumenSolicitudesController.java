package Controller;

import java.sql.Connection;
import Data.DBConnectionFactory;
import Data.SolicitudPrestamoDAO;
import Model.SolicitudPrestamo;
import Model.Usersession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResumenSolicitudesController {

    @FXML
    private Button btnActualizarResumen;

    @FXML
    private TableColumn<SolicitudPrestamo, Boolean> colEstado;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colFechaUso;

    @FXML
    private TableColumn<SolicitudPrestamo, Integer> colIdSolicitud;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colRecurso;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colSolicitante;

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
    	colIdSolicitud.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	colSolicitante.setCellValueFactory(new PropertyValueFactory<>("Solicitante"));
    	colRecurso.setCellValueFactory(new PropertyValueFactory<>("Recurso"));
    	colFechaUso.setCellValueFactory(new PropertyValueFactory<>("FechaUso"));
    	colEstado.setCellValueFactory(new PropertyValueFactory<>("Estado"));
    	// Set data to TableView
    	tableSolicitudes.setItems(availableSolicitudes);
    }

    @FXML
    void actualizarResumen(ActionEvent event) {
    	initialize();
    	//mostrar
    }
}