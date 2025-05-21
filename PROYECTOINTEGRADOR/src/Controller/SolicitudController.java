package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.SolicitudPrestamoDAO;
import Model.SolicitudPrestamo;
import Model.Usersession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SolicitudController {

	@FXML
    private CheckBox CheckEstado;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtFechaSolicitante;

    @FXML
    private TextField txtfechaDevo;

    @FXML
    private TextField txthoraInico;

    @FXML
    private TextField txthorafin;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private SolicitudPrestamoDAO SolicitudDAO = new SolicitudPrestamoDAO(connection);
    
    @FXML
    void guardarSolicitud(ActionEvent event) {
    	String fechaSolicitud = txtFechaSolicitante.getText();
    	String fechaDevolucion = txtfechaDevo.getText();
    	String horainicio = txthoraInico.getText();
    	String horafin = txthorafin.getText();
    	boolean estado = CheckEstado.isSelected();
    	if (txtFechaSolicitante.getText().isBlank() || txtfechaDevo.getText().isBlank() || txthoraInico.getText().isBlank() || txthorafin.getText().isBlank()) {
	    	if (!SolicitudDAO.authenticate(fechaSolicitud) && Usersession.getInstance().getRole().equals("Docente")) {
	    		SolicitudPrestamo solicitud = new SolicitudPrestamo(fechaSolicitud, horainicio, horafin, fechaDevolucion, estado);
	    		SolicitudDAO.save(solicitud);
	    	} else {
	    		Main.showAlert("Error!...", "Solicitud Invalida ó Rol Invalido!!", "No se ha podido registrar la solicitud dada.", Alert.AlertType.ERROR);
	    	}
    	} else {
    		Main.showAlert("Error!...", "Informacion invalida!!", "Todos los campos (5 campos) deben esta llenos para registrarlo.", Alert.AlertType.NONE);
    	}
    }
}