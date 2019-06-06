/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ClienteImp;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class SeleccionarClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcDireccion;
    @FXML
    private TableColumn tcTelefono;
    @FXML
    private TableColumn tcCorreo;
    @FXML
    private JFXButton btSalir;
    @FXML
    private JFXButton btSeleccionar;
    @FXML
    ObservableList<Cliente> clientest;
    
    RegistrarVentaController controllerVenta;
    RegistrarRentaController controllerRenta;
    private Cliente comprador;

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    
    
    public void setController(RegistrarVentaController controller){
       this.controllerVenta = controller;
    }
    public void setController(RegistrarRentaController controller){
       this.controllerRenta = controller;
    }
    
    @FXML
    private void botonSeleccionar(){
        comprador = obtenerClienteSeleccionado();
        System.out.println(comprador);
        if(comprador != null){
            
            if(controllerRenta != null){
                controllerRenta.setComprador(comprador);
            }else{
                controllerVenta.setComprador(comprador);
            }
            
            
            Stage principal = (Stage) btSeleccionar.getScene().getWindow();
            principal.close();
        }else {
            System.out.println("No se selecciono ningun cliente");
        }
    }
    
    
    public Cliente obtenerClienteSeleccionado() {
        if (tablaClientes != null) {
            Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
            return cliente;
        } else {
            return null;
        }
    }
    
    @FXML
    private void cargarClientes() {
        ClienteImp daoCliente = new ClienteImp();
        List<Cliente> listaClientes = daoCliente.getClientes();
        clientest = FXCollections.observableArrayList();
        for (Cliente cliente : listaClientes) {
            clientest.add(cliente);
        }
        tablaClientes.setItems(clientest);

    }

    @FXML
    private void cargarTablaClientes() {
        tcNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        tcDireccion.setCellValueFactory(new PropertyValueFactory<Cliente, String>("calle"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("correo"));
        cargarClientes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTablaClientes();
        
    }

}
