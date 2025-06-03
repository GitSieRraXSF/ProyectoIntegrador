package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.ReporteDevolucionDAO;
import Model.Usersession;
import Model.ReporteDevolucion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class FormatoReporteController {
	
	@FXML
    private CheckBox chkEstado;

    @FXML
    private TextField txtDescrip;

    @FXML
    private TextField txtFechaVeri;

    @FXML
    private TextField txtUsuarioinvolu;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private ReporteDevolucionDAO reporteDAO = new ReporteDevolucionDAO(connection);

    @FXML
    void LogOut(ActionEvent event) {
    	Usersession.getInstance().destroy();
    	Main.loadView("/view/accesoPL.fxml");
    }

    @FXML
    void guardarReporte(ActionEvent event) {
    	String fechaveri = txtFechaVeri.getText();
    	String descripcion = txtDescrip.getText();
    	String userIn = txtUsuarioinvolu.getText();
    	boolean gravedad = chkEstado.isSelected();
    	if (!txtFechaVeri.getText().isBlank() || !txtDescrip.getText().isBlank() || !txtUsuarioinvolu.getText().isBlank()) {
    		if (!reporteDAO.authenticate(fechaveri) || Usersession.getInstance().getRole().equals("admin")) {
    			ReporteDevolucion reporte4 = new ReporteDevolucion(fechaveri, descripcion, userIn, gravedad);
    			reporteDAO.save(reporte4);
    		} else {
    			Main.showAlert("Error!...", "Reporte Repetido ó Usuario invalido!", "Ingrese un reporte diferente o que no este, ó entre en el usuario valido", Alert.AlertType.ERROR);
    		}
    	} else {
    		Main.showAlert("Informacion...", "Guardado invalido", "Por favor llenos los campos que son obligatorios.", Alert.AlertType.INFORMATION);
    	}
    }
}