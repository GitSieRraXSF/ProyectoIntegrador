package Controller;

import java.sql.Connection;
import Application.Main;
import Data.DBConnectionFactory;
import Data.ReporteDevolucionDAO;
import Data.SancionDAO;
import Model.Usersession;
import Model.ReporteDevolucion;
import Model.Sancion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class FormatoReporteController {
	
	@FXML
    private CheckBox chkEstado;
	
	@FXML
    private CheckBox chkfianza;

    @FXML
    private TextField txtDescrip;

    @FXML
    private TextField txtFechaVeri;

    @FXML
    private TextField txtUsuarioinvolu;
    
    @FXML
    private TextField txtMotivoSancion;
    
    @FXML
    private TextField txtvalormultaSancion;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private ReporteDevolucionDAO reporteDAO = new ReporteDevolucionDAO(connection);
    private SancionDAO sancionDAO = new SancionDAO(connection);

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
    	if (!txtFechaVeri.getText().isBlank() || !txtDescrip.getText().isBlank() || !txtUsuarioinvolu.getText().isBlank() || !chkEstado.isSelected()) {
    		if (!reporteDAO.authenticate(fechaveri) || Usersession.getInstance().getRole().equals("admin")) {
    			ReporteDevolucion reporte4 = new ReporteDevolucion(fechaveri, descripcion, userIn, gravedad);
    			reporteDAO.save(reporte4);
    		if (!sancionDAO.authenticate(userIn) && chkEstado.isSelected()) {
    			String motivo = txtMotivoSancion.getText();
    			int valorM = Integer.parseInt(txtvalormultaSancion.getText());
    			Sancion sancion = new Sancion(valorM, motivo, userIn);
    			sancionDAO.save(sancion);
    		}
    		} else {
    			Main.showAlert("Error!...", "Reporte Repetido ó Usuario invalido!", "Ingrese un reporte diferente o que no este, ó entre en el usuario valido", Alert.AlertType.ERROR);
    		}
    	} else {
    		Main.showAlert("Informacion...", "Guardado invalido", "Por favor llenos los campos que son obligatorios.", Alert.AlertType.INFORMATION);
    	}
    	limpiarCampos();
    }
    
    @FXML
    void deleteSancion(ActionEvent event) {
    	if (chkfianza.isSelected() && !txtUsuarioinvolu.getText().isBlank()) {
    		String userIn = txtUsuarioinvolu.getText();
    		sancionDAO.delete(userIn);
    		Main.showAlert("Exito!", "Sancion Eliminada", "La sancion que colocaste al usuario ha sido eliminado con exito!", Alert.AlertType.CONFIRMATION);
    	} else {
    		Main.showAlert("Error!", "Procedimiento invalido!", "No se ha podido eliminar la sancion al usuario, favor colocar uno.", Alert.AlertType.ERROR);
    	}
    }
    
    private void limpiarCampos() {
    	txtDescrip.clear();
    	txtFechaVeri.clear();
    	txtUsuarioinvolu.clear();
    	txtMotivoSancion.clear();
    	txtvalormultaSancion.clear();
    }
}