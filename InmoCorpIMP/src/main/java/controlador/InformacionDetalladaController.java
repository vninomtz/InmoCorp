/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class InformacionDetalladaController implements Initializable {

    @FXML
    private JFXTextField txtCodigoInmu;
    @FXML
    private JFXTextField txtColoniaInmu;
    @FXML
    private JFXTextField txtDireccionInmu;
    @FXML
    private JFXTextField txtTipoInmu;
    @FXML
    private JFXTextArea txtDescripcionInmu;
    @FXML
    private JFXTextField txtCiudadInmu;
    @FXML
    private JFXTextField txtPrecioInmu;
    @FXML
    private JFXTextField txtPrecioRenta;
    @FXML
    private JFXTextField txtTipoOperacion;
    @FXML
    private JFXButton btnSalir;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void salir() {
        exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
