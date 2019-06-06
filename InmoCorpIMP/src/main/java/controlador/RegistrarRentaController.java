/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ClienteImp;
import DAO.InmuebleImp;
import DAO.RentaImp;
import DAO.TipoInmuebleImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Inmueble;
import modelo.Renta;
import modelo.TipoInmueble;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class RegistrarRentaController implements Initializable {

    private Inmueble inmu;
    private Cliente comprador;
    private final double IVA_RENTA = 0.16;
    @FXML
    private JFXTextField txtBuscar;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXTextField txtCodigoInmu;
    
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
    private JFXTextField txtDepositoRen;
    @FXML
    private JFXDatePicker txtFechaInicioRen;
    @FXML
    private JFXDatePicker txtFechaFinRen;
    @FXML
    private JFXTextField txtTotalRen;
    @FXML
    private JFXButton btnRegistrarRenta;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXTextField txtNombreCom;
    @FXML
    private JFXTextField txtCorreoCom;
    @FXML
    private JFXTextField txtTelefonoCom;
    @FXML
    private JFXButton btnBuscarCom;

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
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            Logger.getLogger(SeleccionarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
    @FXML
    private void ventanaSeleccionarCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/SeleccionarCliente.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Rentas");
            stage.setScene(scene);
            SeleccionarClienteController controller = (SeleccionarClienteController)loader.getController();
            controller.setController(this);
            stage.setOnHidden(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event){
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
    private void botonRegistrarRenta() {
        if (validarCampos()) {
            Renta renta = new Renta();
            renta.setIdinmueble(inmu.getIdinmuble());
            renta.setIdcliente(comprador.getIdcliente());
            LocalDate date = txtFechaInicioRen.getValue();
            renta.setFechainicio(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            date = txtFechaFinRen.getValue();
            renta.setFechafin(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            renta.setDeposito(Double.parseDouble(txtDepositoRen.getText()));
            renta.setMonto(Double.parseDouble(txtTotalRen.getText()));

            InmuebleImp inmuebleimp = new InmuebleImp();
            RentaImp rentaimp = new RentaImp();
            if(rentaimp.guardarRenta(renta)) {
                if(inmuebleimp.updateDisponibilidad(inmu.getIdinmuble(), false)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Renta Guardada");
                    alert.setHeaderText("La renta se a guardado Exitosamente");
                    alert.showAndWait();
                    ventanaPrincipal();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error en BD");
                alert.setHeaderText("Hubo un error en la conexión a la Base de Datos"
                        + "Por favor intente más tarde");
                alert.showAndWait();
            }
            

        }
    }

   

    public boolean validarCampos() {
        if (txtCodigoInmu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Buscar el inmueble antes de registrar la renta");
            alert.showAndWait();
            return false;
        }
        
        //Inicio fecha inicio renta
        if (txtFechaInicioRen.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar la fecha del inicio de la renta");
            alert.showAndWait();
            return false;

        } else {
            LocalDate fechaInicioRen = txtFechaInicioRen.getValue();
            LocalDate fechaActual = LocalDate.now();

            if (fechaInicioRen.compareTo(fechaActual) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error con la informacion");
                alert.setHeaderText("Ingrese una fecha valida");
                alert.setContentText("La fecha ingresada es menor a la actual,"
                        + " por favor seleccione una correcta");
                alert.showAndWait();
                return false;
            }
        }
        //inicio fecha fin renta
        if (txtFechaFinRen.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar la fecha del fin de la renta");
            alert.showAndWait();
            return false;
        } else {
            LocalDate fechaInicioRen = txtFechaInicioRen.getValue();
            LocalDate fechaFinRen = txtFechaFinRen.getValue();

            if (fechaFinRen.compareTo(fechaInicioRen) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error con la informacion");
                alert.setHeaderText("Ingrese una fecha valida");
                alert.setContentText("La fecha de fin es menor a la fecha de inicio ,"
                        + " por favor seleccione una correcta");
                alert.showAndWait();
                return false;
            }
        }
        
        if (txtNombreCom.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Buscar el comprador antes de registrar la venta");
            alert.showAndWait();
            return false;
        }
        if (txtDepositoRen.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar el deposito de la renta");
            alert.showAndWait();
            return false;
        } else {
            try {
                 Double deposito = Double.parseDouble(txtDepositoRen.getText());
            } catch(NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error con la informacion");
                alert.setHeaderText("Ingrese un deposito valido");
                alert.setContentText("El precio del desposito es inválido ,"
                        + " por favor ingresar uno correcto");
                alert.showAndWait();
                return false;
            }
           
        }
        
        

        return true;
    }
    
    private boolean validarBusquedaInmueble(Inmueble inmueble) {
        if (txtBuscar.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Ingresar el codigo primero para buscar Inmueble");
            alert.showAndWait();
            return false;
        } else if (inmueble == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con la informacion");
            alert.setHeaderText("Codigo de inmueble no existente");
            alert.showAndWait();
            return false;
        }
        if(inmueble.getTipoOperacion().equals("Venta")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con el Inmueble");
            alert.setHeaderText("EL inmueble con código ["+ inmueble.getCodigo()+ "]"
            + " solo está disponible para Venta");
            alert.showAndWait();
            return false;
        }
        if(!inmueble.isDisponible()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con el Inmueble");
            alert.setHeaderText("EL inmueble con código ["+ inmueble.getCodigo()+ "]"
            + " ya no está disponible para Rentar");
            alert.showAndWait();
            return false;
        }
        
        return true;
    }

    @FXML
    private void botonBuscarInmueble() {
        String codigoInmueble = txtBuscar.getText();
        inmu = buscarInmueble(codigoInmueble);
        
        if (validarBusquedaInmueble(inmu)) {
            txtCodigoInmu.setText(inmu.getCodigo());
            txtDireccionInmu.setText(inmu.getDireccion());
            txtColoniaInmu.setText(inmu.getColonia());
            txtCiudadInmu.setText(inmu.getCiudad());
            txtTipoInmu.setText(inmu.getTipoInmuble());
            txtPrecioInmu.setText(Double.toString(inmu.getPreciorenta()));
            txtDescripcionInmu.setText(inmu.getNotas());
            double monto = inmu.getPreciorenta() + (IVA_RENTA * inmu.getPreciorenta());
            txtTotalRen.setText(Double.toString(monto));
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
        txtTipoInmu.setEditable(false);
        txtPrecioInmu.setEditable(false);
        txtDescripcionInmu.setEditable(false);
        txtTotalRen.setEditable(false);
        
        txtNombreVen.setEditable(false);
        txtCorreoVen.setEditable(false);
        txtTelefonoVen.setEditable(false);
        
        txtNombreCom.setEditable(false);
        txtCorreoCom.setEditable(false);
        txtTelefonoCom.setEditable(false);
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
    private void salir() {
        exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();
        
    }

}
