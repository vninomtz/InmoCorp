/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.InmuebleImp;
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
import static javafx.application.Platform.exit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Inmueble;
import modelo.TipoInmueble;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class MenuPrincipalController implements Initializable {

    List<Inmueble> listaInmueble = new ArrayList();
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnVerDetalles;
    @FXML
    private JFXButton btnConsultar;
    @FXML
    private JFXTextField txtBuscarInmu;
    @FXML
    private JFXButton btnBuscarInmu;
    @FXML
    private JFXComboBox<TipoInmueble> cbTipoInmu;
    @FXML
    private JFXComboBox<String> cbTipoOperacion;
    @FXML
    private TableColumn<Inmueble, String> colTipoOperacion;
    @FXML
    private TableColumn<Inmueble, String> colTipoInmu;
    @FXML
    private TableColumn<Inmueble, String> colDescripcion;
    @FXML
    private TableColumn<Inmueble, Integer> colCiudad;
    @FXML
    private TableColumn<Inmueble, String> colColonia;
    @FXML
    private TableColumn<Inmueble, Double> colPrecioRenta;
    @FXML
    private TableColumn<Inmueble, Double> colPrecioVenta;
    @FXML
    private TableView<Inmueble> tablaInmueble;

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

    public Inmueble buscarInmueble(String codigo) {
        Inmueble inmueble = null;
        InmuebleImp inmuebleimp = new InmuebleImp();
        List<Inmueble> listainmuebles = inmuebleimp.getInmuebles();
        for (Inmueble inmu : listainmuebles) {
            if (inmu.getCodigo().equals(codigo)) {
                inmueble = inmu;

                break;
            }
        }

        return inmueble;
    }

    @FXML
    private void btBuscarInmueble() {
        if (txtBuscarInmu.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la busqueda");
            alert.setHeaderText("Por favor ingrese un codigo de inmueble");
            alert.showAndWait();
        } else if (buscarInmueble(txtBuscarInmu.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la busqueda");
            alert.setHeaderText("Inmueble no existente");
            alert.showAndWait();
        } else {
            Inmueble inmu = buscarInmueble(txtBuscarInmu.getText());

            ObservableList<Inmueble> observableListInmu = FXCollections.observableArrayList(inmu);
            tablaInmueble.setItems(observableListInmu);
        }
    }

    private boolean validarFiltrado() {
        String tipoOperacion = cbTipoOperacion.getValue();

        if (cbTipoInmu.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la busqueda");
            alert.setHeaderText("Por favor seleccione un tipo de inmueble");
            alert.showAndWait();
            return false;
        } else if (tipoOperacion == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la busqueda");
            alert.setHeaderText("Por favor seleccione un tipo de operación");
            alert.showAndWait();
            return false;
        }

        return true;

    }

    @FXML
    private void filitrarInmuebles() {
        if (validarFiltrado()) {
            InmuebleImp inmuebleimp = new InmuebleImp();
            listaInmueble = inmuebleimp.getInmueblesFilitrado(cbTipoInmu.getValue().getTipo(), cbTipoOperacion.getValue());

            ObservableList<Inmueble> observableListInmu = FXCollections.observableArrayList(listaInmueble);
            tablaInmueble.setItems(observableListInmu);
        }

    }

    @FXML
    private void verDetalles() {
        Inmueble inmu = obtenerInmuebleSeleccionado();
        if (inmu != null) {
            try {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/InformacionDetallada.fxml"));
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                scene.getStylesheets().add("/styles/Styles.css");
                Stage stage = new Stage();
                InformacionDetalladaController controller = (InformacionDetalladaController) loader.getController();
                controller.setController(this, inmu);

                stage.setTitle("Detalle Inmueble");
                stage.setScene(scene);
                stage.alwaysOnTopProperty();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException ex) {
                System.out.println("Error al mostrar ventana Rentas: " + ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Seleccionar Inmuble");
            alert.setHeaderText("Para ver el detalle del inmueble "
                    + "por favor seleccione el inmuble");
            alert.showAndWait();
        }

    }

    @FXML
    private void salir() {
        exit();
    }

    private void llenarCbTipoInmueble() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        ObservableList<TipoInmueble> observablelisttipo
                = FXCollections.observableArrayList(tipoinmuebleimp.getTipoInmuebles());
        cbTipoInmu.setItems(observablelisttipo);
    }

    private void llenarCbTipoOperacion() {
        List<String> listaTipoOperacion = new ArrayList();
        listaTipoOperacion.add("Renta");
        listaTipoOperacion.add("Venta");
        listaTipoOperacion.add("Venta/Renta");
        listaTipoOperacion.add("Todas");
        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaTipoOperacion);
        cbTipoOperacion.setItems(obsevableListaTipoOpe);
    }

    private void llenarTablaInmuebles() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        List<TipoInmueble> listaTipoCd = tipoinmuebleimp.getTipoInmuebles();
        colTipoOperacion.setCellValueFactory(new PropertyValueFactory("tipoOperacion"));
        colTipoInmu.setCellValueFactory(new PropertyValueFactory("tipoInmuble"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory("notas"));
        colCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        colColonia.setCellValueFactory(new PropertyValueFactory("colonia"));
        colPrecioRenta.setCellValueFactory(new PropertyValueFactory("preciorenta"));
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory("precioventa"));
        InmuebleImp controller = new InmuebleImp();
        listaInmueble = controller.getInmuebles();
        ObservableList<Inmueble> observableListInmu = FXCollections.observableArrayList(listaInmueble);
        tablaInmueble.setItems(observableListInmu);
    }

    public Inmueble obtenerInmuebleSeleccionado() {
        if (tablaInmueble != null) {
            Inmueble inmu = tablaInmueble.getSelectionModel().getSelectedItem();
            return inmu;
        } else {
            return null;
        }
    }

    private void iniciarInterfaz() {
        llenarCbTipoInmueble();
        llenarCbTipoOperacion();
        llenarTablaInmuebles();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();
    }

}
