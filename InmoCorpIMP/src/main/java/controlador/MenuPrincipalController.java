/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.TipoInmuebleImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Inmueble;
import modelo.TipoInmueble;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class MenuPrincipalController implements Initializable {

    
    @FXML private JFXButton btnSalir;
    @FXML private JFXTextField txtBuscarInmu;
    @FXML private JFXButton btnBuscarInmu;
    @FXML private JFXComboBox<TipoInmueble> cbTipoInmu;
    @FXML private JFXComboBox<String> cbTipoOperacion;
    @FXML private TableColumn<Inmueble, String> colTipoOperacion;
    @FXML private TableColumn<Inmueble, String> colTipoInmu;
    @FXML private TableColumn<Inmueble, String> colDescripcion;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, String> colEstado;
    @FXML private TableColumn<Inmueble,Double> colPrecioRenta;
    @FXML private TableColumn<Inmueble,Double> colPrecioVenta;

    @FXML
    private void ventanaVenta() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarVenta.fxml"));
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
            System.out.println("Error al mostrar ventana Ventas: " + ex);
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
            System.out.println("Error al mostrar ventana Rentas: " + ex);
        }
    }
    
    private void cargarCbTipoInmueble() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        ObservableList<TipoInmueble> observablelisttipo = 
                FXCollections.observableArrayList(tipoinmuebleimp.getTipoInmuebles());
        cbTipoInmu.setItems(observablelisttipo);    
    }
    
    private void cargarCbTipoOperacion() {
        List<String> listaTipoOperacion = new ArrayList(); 
        listaTipoOperacion.add("Renta");
        listaTipoOperacion.add("Venta");
        listaTipoOperacion.add("Venta/Renta");
        ObservableList<String> obsevableListaTipoOpe = 
                FXCollections.observableArrayList(listaTipoOperacion);
        cbTipoOperacion.setItems(obsevableListaTipoOpe);
    }
    private void iniciarInterfaz() {
        cargarCbTipoInmueble();
        cargarCbTipoOperacion();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();
    }
    
}
