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
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Inmueble;

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
    @FXML
    private JFXButton btnSiguiente;

    @FXML
    private JFXButton btnAnterior;
    
    @FXML
    private ImageView img;
    
    
    MenuPrincipalController menuprincipal;
    Inmueble inmu;

    public void setController(MenuPrincipalController controller, Inmueble inmu){
       this.menuprincipal = controller;
       this.inmu = inmu;
       if(inmu != null){
           iniciarInterfaz();
       }
    }
    public void iniciarInterfaz() {
        txtCodigoInmu.setText(inmu.getCodigo());
        txtColoniaInmu.setText(inmu.getColonia());
        txtDireccionInmu.setText(inmu.getDireccion());
        txtTipoInmu.setText(inmu.getTipoInmuble());
        txtDescripcionInmu.setText(inmu.getNotas());
        txtCiudadInmu.setText(inmu.getCiudad());
        txtPrecioInmu.setText(Double.toString(inmu.getPrecioventa()));
        txtPrecioRenta.setText(Double.toString(inmu.getPreciorenta()));
        txtTipoOperacion.setText(inmu.getTipoOperacion());
        
        Image image = new Image("/fxml/img/que-es-bien-inmueble.jpg");
        img.setImage(image);
                
    }
    
    @FXML
    private void salir() {
        Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
