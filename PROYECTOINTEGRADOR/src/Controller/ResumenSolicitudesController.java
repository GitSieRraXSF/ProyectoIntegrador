package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResumenSolicitudesController {

    @FXML
    private Button btnActualizarResumen;

    @FXML
    private TableColumn<?, ?> colEstado;

    @FXML
    private TableColumn<?, ?> colFechaUso;

    @FXML
    private TableColumn<?, ?> colIdSolicitud;

    @FXML
    private TableColumn<?, ?> colRecurso;

    @FXML
    private TableColumn<?, ?> colSolicitante;

    @FXML
    private TableView<?> tableSolicitudes;

    @FXML
    void actualizarResumen(ActionEvent event) {

    }
}