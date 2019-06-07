package controlador;

import com.jfoenix.controls.JFXButton;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InicioSesionController implements Initializable {

    @FXML
    private JFXButton btnIniciarSesion;
    @FXML
    private void ventanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MenuPrincipal.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("InmoCorp");
            stage.setScene(scene);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inicio de Sesion");
                alert.setHeaderText("BIENVENIDO");
                //alert.setContentText("La fecha ingresada es menor a la actual,"
                //        + " por favor seleccione una correcta");
                alert.showAndWait();
            stage.setResizable(false);
            stage.show();
            Stage principal = (Stage) btnIniciarSesion.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana principal: " + ex.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
