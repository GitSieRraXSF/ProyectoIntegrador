package Controller;

import java.sql.Connection;
import Data.DBConnectionFactory;
import Data.EncuestaDAO;
import Model.Usersession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class EncuestaController {

    @FXML
    private Button btnEnviarEncuesta;

    @FXML
    private CheckBox cbPregunta1;

    @FXML
    private CheckBox cbPregunta2;

    @FXML
    private TextArea txtComentarios;
    
    private Connection connection = DBConnectionFactory.getConnectionByRole(Usersession.getInstance().getRole()).getConnection();
    private EncuestaDAO encuestaDAO = new EncuestaDAO(connection);

    @FXML
    void enviarEncuesta(ActionEvent event) {
    	boolean Pregunta1 = Boolean.parseBoolean(cbPregunta1.getTypeSelector());
    	boolean Pregunta2 = Boolean.parseBoolean(cbPregunta2.getTypeSelector());
    	String Comentario = txtComentarios.getText();
    	if (Usersession.getInstance().getRole().equals("Docente")) {
    		
    	}
    }
}