/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Vik-t
 */
public class ConexionBD {
    private Connection conexion;
    private final String host = "localhost";
    private final String db = "inmocorp";
    private final String username = "administrador";
    private final String password = "inmobiliaria";
    private final String url = "jdbc:mysql://" + host + "/" + db;
    
    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try {
                conexion = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Error al obtener conexióna a BD: " + ex.getMessage());
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error con BD");
                alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                        + "por favor intente más tarde");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error en la instancia del controlador: " + ex.getMessage());
        }
    }
    
    public Connection getConexionBD() {
        return conexion;
    }
    public void closeConexionBD() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión en la BD:" + ex);
        }
    }
}
