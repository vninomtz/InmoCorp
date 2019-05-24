/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.InmuebleImp;
import DAO.RentaImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelo.Inmueble;
import modelo.Renta;
import modelo.TipoInmueble;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class RegistrarRentaController implements Initializable {

    @FXML private JFXTextField txtBuscar;
    @FXML private JFXButton btnBuscar;
    @FXML private JFXTextField txtCodigoInmu;
   @FXML  private JFXComboBox<String> cbTipoinmu;
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
    @FXML
    private void botonBuscarInmueble(){
        String codigoInmueble = txtBuscar.getText();
        Inmueble inmu = buscarInmueble(codigoInmueble);
        if(inmu != null) {
            txtCodigoInmu.setText(inmu.getCodigo());
            txtDireccionInmu.setText(inmu.getDireccion());
            txtColoniaInmu.setText(inmu.getColonia());
            txtCiudadInmu.setText(Integer.toString(inmu.getIdciudad()));
           // cbTipoinmu.setSelectionModel(Integer.toString(inmu.getIdtipoinmueble()));
           txtPrecioInmu.setText(Double.toString(inmu.getPreciorenta()));
           txtDescripcionInmu.setText(inmu.getNotas());
            
        }
    }
    private void iniciarInterfaz() {
        txtCodigoInmu.setEditable(false);
        txtDireccionInmu.setEditable(false);
        txtColoniaInmu.setEditable(false);
        txtCiudadInmu.setEditable(false);
        cbTipoinmu.setEditable(false);
        txtPrecioInmu.setEditable(false);
        txtDescripcionInmu.setEditable(false);
    }
    
    public Inmueble buscarInmueble(String codigo) {
        Inmueble inmueble = null;
        InmuebleImp inmuebleimp = new InmuebleImp();
        List<Inmueble> listainmuebles = inmuebleimp.getInmuebles();
        for(Inmueble inmu: listainmuebles) {
            if(inmu.getCodigo().equals(codigo)){
                inmueble = inmu;
                break;
            }
        }
        return inmueble;
    }
    
    @FXML
    private void salir() {
        exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();
        // TODO
    }    
    
}
