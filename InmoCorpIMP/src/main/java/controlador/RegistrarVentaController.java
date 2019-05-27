/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class RegistrarVentaController implements Initializable {

    @FXML private JFXTextField txtBuscarInm;
    @FXML private JFXButton btnBuscarInmu;
    @FXML private JFXTextField txtCodigoInmu;
    @FXML private JFXTextField txtEstadoInmu;
    @FXML private JFXTextField txtCiudadInmu;
    @FXML private JFXTextField txtColoniaInmu;
    @FXML private JFXTextField txtDireccionInmu;
    @FXML private JFXTextField txtTipoInmu;
    @FXML private JFXTextField txtPrecioInmu;
    @FXML private JFXTextArea txtDescripcionInmu;
    @FXML private JFXTextField txtNombreVen;
    @FXML private JFXTextField txtCorreoVen;
    @FXML private JFXTextField txtTelefonoVen;
    @FXML private JFXDatePicker txtFechaVen;
    @FXML private JFXTextField txtTotalVen;
    @FXML private JFXButton btnRegistrarVenta;
    @FXML private JFXButton btnSalir;
    @FXML private JFXTextField txtNombreCom;
    @FXML private JFXTextField txtCorreoCom;
    @FXML private JFXTextField txtTelefonoCom;
    @FXML private JFXButton btnBuscarCom;

    @FXML
    private void ventanaVenta() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarRenta.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Ventas");
            stage.setScene(scene);
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            Logger.getLogger(RegistrarRentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana principal: " + ex.getMessage());
        }
    }
    @FXML
    private void ventanaRenta() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarRenta.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Rentas");
            stage.setScene(scene);
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex.getMessage());
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void botonBuscarInmueble(ActionEvent event) {
    }
    
}
