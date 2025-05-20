package Controller;

import java.sql.Connection;
import Data.DBConnectionFactory;
import Data.SolicitudPrestamoDAO;
import Model.SolicitudPrestamo;
import Model.Recurso;
import Model.Usuario;
import Model.Usersession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SolicitudController {

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<String> cbRecurso;

    @FXML
    private ComboBox<String> cbTipoRecurso;

    @FXML
    private TextField txtFechasoli;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtSolicitante;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private SolicitudPrestamoDAO SolicitudDAO = new SolicitudPrestamoDAO(connection);
    
    @FXML
    public void initialize() {
    	cbRecurso.getItems().addAll("admin", "student", "teacher");
    }

    @FXML
    void guardarSolicitud(ActionEvent event) {
    	int ID = Integer.parseInt(txtSolicitante.getText());
    	String recursoespecifico = cbRecurso.getSelectionModel().getSelectedItem();
    	String tiporecurso = cbRecurso.getSelectionModel().getSelectedItem();
    	String fechasolicitud = txtFechasoli.getText();
    	String horas = txtDuracion.getText();
    	if (!SolicitudDAO.authenticate(ID) && Usersession.getInstance().getRole().equals("Docente")) {
    		
    	}
    }
}