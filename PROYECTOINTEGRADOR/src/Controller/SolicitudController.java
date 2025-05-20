package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SolicitudController {

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<?> cbRecurso;

    @FXML
    private ComboBox<?> cbTipoRecurso;

    @FXML
    private DatePicker dpFechaUso;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtSolicitante;

    @FXML
    void guardarSolicitud(ActionEvent event) {
    	
    	
    }
}