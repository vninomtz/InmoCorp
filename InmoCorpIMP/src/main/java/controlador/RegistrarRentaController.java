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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class RegistrarRentaController implements Initializable {

    @FXML private JFXButton btnBuscar;
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
    @FXML private JFXTextField txtDepositoRen;
    @FXML private JFXDatePicker txtFechaInicioRen;
    @FXML private JFXDatePicker txtFechaFinRen;
    @FXML private JFXTextField txtTotalRen;
    @FXML private JFXButton btnRegistrarRenta;
    @FXML private JFXButton btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
