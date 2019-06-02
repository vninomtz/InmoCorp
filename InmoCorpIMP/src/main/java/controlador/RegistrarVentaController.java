/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ClienteImp;
import DAO.InmuebleImp;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    @FXML
    private JFXComboBox<TipoInmueble> cbTipoinmu;
    
    public RegistrarVentaController maincontroller;
    private Cliente comprador;
    
            //tratar la excepción
       

    @FXML
    private void ventanaComprador() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/SeleccionarCliente.fxml"));
            SeleccionarClienteController controller = (SeleccionarClienteController)loader.getController();
            //controller.setController(maincontroller);
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Cliente");
            stage.setScene(scene);
            
            stage.setOnHidden(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event){
                    comprador = controller.getComprador();
                    if(comprador != null){
                    txtNombreCom.setText(comprador.toString());
                }else {
                    System.out.println("No hay nada ");
                }
                }
            });
            stage.show();
            
            System.out.println(comprador);
        } catch (IOException ex) {
            Logger.getLogger(SeleccionarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
            //JOptionPane.showMessageDialog(null, "Buscar el inmueble antes de registrar la renta");
            return false;
        }
        if (txtFechaVen.getValue() == null) {
            //JOptionPane.showMessageDialog(null, "Ingresar la fecha de inicio de la renta");
            return false;
        }
        if (txtNombreCom.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Buscar al comprador antes de registrar la renta");
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
        //if (validarCampos()) {
        Venta venta = new Venta();
        venta.setIdinmueble(inmu.getIdinmuble());
        //venta.setIdcliente(comprador.getIdcliente());
        LocalDate date = txtFechaVen.getValue();
        venta.setFecha_venta(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        date = txtFechaVen.getValue();
        venta.setMonto(Double.parseDouble(txtTotalVen.getText()));

        System.out.println("idInmueble: " + venta.getIdinmueble());
        //System.out.println("idCliente: " + renta.getIdcliente());
        System.out.println("fechaVenta: " + venta.getFecha_venta());
        System.out.println("Monto: " + venta.getMonto());

        //}
    }

    @FXML
    private void botonBuscarInmueble() {
        ClienteImp clienteimp = new ClienteImp();
        String codigoInmueble = txtBuscarInm.getText();
        inmu = buscarInmueble(codigoInmueble);
        System.out.println("Akfkfkf::" + codigoInmueble);
        if (inmu != null) {
            txtCodigoInmu.setText(inmu.getCodigo());
            txtDireccionInmu.setText(inmu.getDireccion());
            txtColoniaInmu.setText(inmu.getColonia());
            txtCiudadInmu.setText(Integer.toString(inmu.getIdciudad()));
            cbTipoinmu.getSelectionModel().select(inmu.getIdtipoinmueble() - 1);
            txtPrecioInmu.setText(Double.toString(inmu.getPrecioventa()));
            txtDescripcionInmu.setText(inmu.getNotas());
            txtTotalVen.setText(Double.toString(inmu.getPrecioventa()));

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarInterfaz();
        llenarCbTipoInmueble();
        maincontroller = this;
    }

}
