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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    private JFXComboBox<TipoInmueble> cbTipoinmu;
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
    private void botonRegistrarRenta() {
        if (validarCampos()) {
            Renta renta = new Renta();
            renta.setIdinmueble(inmu.getIdinmuble());
            //renta.setIdcliente(comprador.getIdcliente());
            LocalDate date = txtFechaInicioRen.getValue();
            renta.setFechainicio(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            date = txtFechaFinRen.getValue();
            renta.setFechafin(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            renta.setDeposito(Double.parseDouble(txtDepositoRen.getText()));
            renta.setMonto(Double.parseDouble(txtTotalRen.getText()));

            System.out.println("idInmueble: " + renta.getIdinmueble());
            //System.out.println("idCliente: " + renta.getIdcliente());
            System.out.println("FechaInicio: " + renta.getFechainicio());
            System.out.println("FechaFin: " + renta.getFechafin());
            System.out.println("Deposito: " + renta.getDeposito());
            System.out.println("Monto: " + renta.getMonto());

        }
    }

   

    public boolean validarCampos() {
        if (txtCodigoInmu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Buscar el inmueble antes de registrar la renta");
            return false;
        }
        if (txtFechaInicioRen.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Ingresar la fecha de inicio de la renta");
            return false;
        }
        if (txtFechaFinRen.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Ingresar la fecha de fin de la renta");
            return false;
        }
        if (txtNombreCom.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Buscar al comprador antes de registrar la renta");
            return false;
        }

        return true;
    }

    @FXML
    private void botonBuscarInmueble() {
        ClienteImp clienteimp = new ClienteImp();
        String codigoInmueble = txtBuscar.getText();
        inmu = buscarInmueble(codigoInmueble);
        
        if (inmu != null) {
            txtCodigoInmu.setText(inmu.getCodigo());
            txtDireccionInmu.setText(inmu.getDireccion());
            txtColoniaInmu.setText(inmu.getColonia());
            txtCiudadInmu.setText(Integer.toString(inmu.getIdciudad()));
            cbTipoinmu.getSelectionModel().select(inmu.getIdtipoinmueble() - 1);
            txtPrecioInmu.setText(Double.toString(inmu.getPreciorenta()));
            txtDescripcionInmu.setText(inmu.getNotas());
            double monto = inmu.getPreciorenta() + (IVA_RENTA * inmu.getPreciorenta());
            txtTotalRen.setText(Double.toString(monto));
        }

        Cliente cliente = clienteimp.getCliente(inmu.getIdcliente());
        System.out.println("ObjetoCliente id: " + cliente.getNombre());
        if (cliente != null) {
            txtNombreVen.setText(cliente.toString());
            txtCorreoVen.setText(cliente.getCorreo());
            txtTelefonoVen.setText(cliente.getTelefono());
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

    private void llenarCbTipoInmueble() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        ObservableList<TipoInmueble> observablelisttipo = FXCollections.observableArrayList(tipoinmuebleimp.getTipoInmuebles());
        cbTipoinmu.setItems(observablelisttipo);

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
        llenarCbTipoInmueble();
        // TODO
    }

}
