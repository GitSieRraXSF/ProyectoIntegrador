package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.ReporteDevolucionDAO;
import Model.ReporteDevolucion;
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

public class ListaReportesController {
	
	@FXML
    private Button btnActualizar;

    @FXML
    private TableColumn<ReporteDevolucion, String> colDescrip;

    @FXML
    private TableColumn<ReporteDevolucion, Boolean> colEstado;

    @FXML
    private TableColumn<ReporteDevolucion, String> colFechaVeri;

    @FXML
    private TableColumn<ReporteDevolucion, String> colUsers1;
    
    @FXML
    private TableView<ReporteDevolucion> tableReportes;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private ReporteDevolucionDAO reporteDAO = new ReporteDevolucionDAO(connection);
    
    @FXML
    public void initialize() {
    	
    	ObservableList<ReporteDevolucion> availableReportes = FXCollections.observableArrayList();
    	for (ReporteDevolucion reporte1 : reporteDAO.fetch()) {
    		availableReportes.add(reporte1);
    	}
    	colFechaVeri.setCellValueFactory(new PropertyValueFactory<>("FechaSolicitud"));
    	colDescrip.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
    	colUsers1.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	colEstado.setCellValueFactory(new PropertyValueFactory<>("fechafinPrevista"));
    	tableReportes.setItems(availableReportes);
    }

    @FXML
    void VistaAnterior(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher")) {
			Main.loadView("/view/SolicitudController.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }

    @FXML
    void actualizarLista(ActionEvent event) {
    	initialize();
    	Main.showAlert("Informacion", "Actualizado!", "La lista ha sido actualizada.", Alert.AlertType.INFORMATION);
    }
}