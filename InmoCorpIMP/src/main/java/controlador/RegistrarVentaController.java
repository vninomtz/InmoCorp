/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ClienteImp;
import DAO.InmuebleImp;
import DAO.TipoInmuebleImp;
import DAO.VentaImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Inmueble;
import modelo.Renta;
import modelo.TipoInmueble;
import modelo.Venta;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class RegistrarVentaController implements Initializable {

    private Inmueble inmu;
    @FXML
    private JFXTextField txtBuscarInm;
    @FXML
    private JFXButton btnBuscarInmu;
    @FXML
    private JFXTextField txtCodigoInmu;
    @FXML
    private JFXTextField txtEstadoInmu;
    @FXML
    private JFXTextField txtCiudadInmu;
    @FXML
    private JFXTextField txtColoniaInmu;
    @FXML
    private JFXTextField txtDireccionInmu;
    @FXML
    private JFXTextField txtTipoInmu;
    @FXML
    private JFXTextField txtPrecioInmu;
    @FXML
    private JFXTextArea txtDescripcionInmu;
    @FXML
    private JFXTextField txtNombreVen;
    @FXML
    private JFXTextField txtCorreoVen;
    @FXML
    private JFXTextField txtTelefonoVen;
    @FXML
    private JFXDatePicker txtFechaVen;
    @FXML
    private JFXTextField txtTotalVen;
    @FXML
    private JFXButton btnRegistrarVenta;
    @FXML
    private JFXButton btnSalir;
    @FXML
    public JFXTextField txtNombreCom;
    @FXML
    public JFXTextField txtCorreoCom;
    @FXML
    public JFXTextField txtTelefonoCom;
    @FXML
    private JFXButton btnBuscarCom;

    public RegistrarVentaController maincontroller;
    private Cliente comprador;

    //tratar la excepción
    @FXML
    private void ventanaComprador() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/SeleccionarCliente.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Cliente");
            stage.setScene(scene);
            SeleccionarClienteController controller = (SeleccionarClienteController) loader.getController();
            controller.setController(this);
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    txtNombreCom.setText(comprador.toString());
                    txtCorreoCom.setText(comprador.getCorreo());
                    txtTelefonoCom.setText(comprador.getTelefono());
                }
            });
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex.getMessage());
        }

    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    @FXML
    private void salir() {
        exit();
    }

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

    public boolean validarCampos() {
        if (txtCodigoInmu.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Buscar el inmueble antes de registrar la renta");
            alert.showAndWait();
            return false;
        }
        if (txtFechaVen.getValue() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar la fecha de la venta");
            alert.showAndWait();
            return false;

        } else {
            LocalDate fechaVenta = txtFechaVen.getValue();
            LocalDate fechaActual = LocalDate.now();

            if (fechaVenta.compareTo(fechaActual) > 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Error con la informacion");
                alert.setHeaderText("Ingrese una fecha valida");
                alert.setContentText("La fecha ingresada es mayor a la actual,"
                        + " por favor seleccione una correcta");
                alert.showAndWait();
                return false;
            }

        }
        if (txtNombreCom.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Buscar el comprador antes de registrar la venta");
            alert.showAndWait();
            return false;
        }

        return true;
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

    @FXML
    private void botonRegistrarVenta() {
        if (validarCampos()) {
            Venta venta = new Venta();
            venta.setIdinmueble(inmu.getIdinmuble());
            venta.setIdcliente(comprador.getIdcliente());
            LocalDate date = txtFechaVen.getValue();
            venta.setFecha_venta(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            venta.setMonto(Double.parseDouble(txtTotalVen.getText()));

            System.out.println("idInmueble: " + venta.getIdinmueble());
            System.out.println("idCliente: " + venta.getIdcliente());
            System.out.println("fechaVenta: " + venta.getFecha_venta());
            System.out.println("Monto: " + venta.getMonto());
            VentaImp ventaImp = new VentaImp();
            if (ventaImp.guardarVenta(venta)) {
                InmuebleImp inmuImp = new InmuebleImp();
                if (inmuImp.updateDisponibilidad(inmu.getIdinmuble(), false)) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Estado de registro");
                    alert.setHeaderText("Registro guardado exitosamente");
                    alert.showAndWait();
                    ventanaPrincipal();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Estado de registro");
                    alert.setHeaderText("Ocurrio un erorr al guardar");
                    alert.showAndWait();

                }

            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Estado de registro");
                alert.setHeaderText("Ocurrio un erorr al guardar");
                alert.showAndWait();
            }
        }
    }

    private boolean validarBusquedaInmueble(Inmueble inmueble) {
        if (txtBuscarInm.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar el codigo primero para buscar Inmueble");
            alert.showAndWait();
            return false;
        } else if (inmueble == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Codigo de inmueble no existente");
            alert.showAndWait();
            return false;
        }
        if (inmueble.getTipoOperacion().equals("Renta")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con el Inmueble");
            alert.setHeaderText("EL inmueble con código [" + inmueble.getCodigo() + "]"
                    + " solo está disponible para Renta");
            alert.showAndWait();
            return false;
        }
        if (!inmueble.isDisponible()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con el Inmueble");
            alert.setHeaderText("EL inmueble con código [" + inmueble.getCodigo() + "]"
                    + " ya no está disponible para Venta");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    @FXML
    private void botonBuscarInmueble() {
        String codigoInmueble = txtBuscarInm.getText();
        inmu = buscarInmueble(codigoInmueble);

        if (validarBusquedaInmueble(inmu)) {
            txtCodigoInmu.setText(inmu.getCodigo());
            txtDireccionInmu.setText(inmu.getDireccion());
            txtColoniaInmu.setText(inmu.getColonia());
            txtCiudadInmu.setText(Integer.toString(inmu.getIdciudad()));
            txtPrecioInmu.setText(Double.toString(inmu.getPrecioventa()));
            txtDescripcionInmu.setText(inmu.getNotas());
            txtTotalVen.setText(Double.toString(inmu.getPrecioventa()));
            txtNombreVen.setText(inmu.getCliente().toString());
            txtCorreoVen.setText(inmu.getCliente().getCorreo());
            txtTelefonoVen.setText(inmu.getCliente().getTelefono());

        }

    }

    private void iniciarInterfaz() {
        txtCodigoInmu.setEditable(false);
        txtDireccionInmu.setEditable(false);
        txtColoniaInmu.setEditable(false);
        txtCiudadInmu.setEditable(false);
        txtPrecioInmu.setEditable(false);
        txtDescripcionInmu.setEditable(false);
        txtNombreCom.setEditable(false);
        txtCorreoCom.setEditable(false);
        txtTelefonoCom.setEditable(false);
        txtNombreVen.setEditable(false);
        txtCorreoVen.setEditable(false);
        txtTelefonoVen.setEditable(false);
        LocalDate FechaActual = LocalDate.now();
        txtFechaVen.setDisable(false);
        txtFechaVen.setValue(FechaActual);

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();

        maincontroller = this;
    }

}
