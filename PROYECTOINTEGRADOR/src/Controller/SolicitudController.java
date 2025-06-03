package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.ReporteDevolucionDAO;
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
    private TextField txtNombreUser;
    
    @FXML
    private TextField txtfechaDevo;

    @FXML
    private TextField txthoraInico;

    @FXML
    private TextField txthorafin;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private SolicitudPrestamoDAO SolicitudDAO = new SolicitudPrestamoDAO(connection);
    private ReporteDevolucionDAO reporteDAO = new ReporteDevolucionDAO(connection);
    
    @FXML
    void guardarSolicitud(ActionEvent event) {
    	String nombreuser = txtNombreUser.getText();
    	String fechaDevolucion = txtfechaDevo.getText();
    	String horainicio = txthoraInico.getText();
    	String horafin = txthorafin.getText();
    	boolean estado = CheckEstado.isSelected();
    	if (txtNombreUser.getText().isBlank() || txtfechaDevo.getText().isBlank() || txthoraInico.getText().isBlank() || txthorafin.getText().isBlank()) {
	    	if (!SolicitudDAO.authenticate(nombreuser) || Usersession.getInstance().getRole().equals("teacher")) {
	    		if (!reporteDAO.authenticate(nombreuser)) {
	    			SolicitudPrestamo solicitud = new SolicitudPrestamo(nombreuser, horainicio, horafin, fechaDevolucion, estado);
		    		SolicitudDAO.save(solicitud);
	    		} else {
	    			Main.showAlert("Error!", "Restringido!", "Tienes por lo menos una sancion.", Alert.AlertType.ERROR);
	    		}
	    	} else {
	    		Main.showAlert("Error!...", "Solicitud Invalida ó Rol Invalido!!", "No se ha podido registrar la solicitud dada.", Alert.AlertType.ERROR);
	    	}
    	} else {
    		Main.showAlert("Error!...", "Informacion invalida!!", "Todos los campos (5 campos) deben esta llenos para registrarlo.", Alert.AlertType.NONE);
    	}
    }
    
    @FXML
    void verSoliresumen(ActionEvent event) {
    	if (Usersession.getInstance().getRole().equals("teacher") || Usersession.getInstance().getRole().equals("admin")) {
    		Main.loadView("/view/ResumenSolicitudes.fxml");
		} else {
			Main.showAlert("Aviso!", "Rol invalido!", "Tienes que tener el rol adecuado para entrar a la vista", Alert.AlertType.INFORMATION);
		}
    }
    
    @FXML
    void LogOut(ActionEvent event) {
    	Usersession.getInstance().destroy();
    	Main.loadView("/view/accesoPL.fxml");
    }
}