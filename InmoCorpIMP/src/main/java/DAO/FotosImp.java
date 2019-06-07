/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import modelo.Foto;

/**
 *
 * @author Vik-t
 */
public class FotosImp implements IFotos{

    @Override
    public List<Foto> getFotos(int idinmueble) {
         List<Foto> listaFotos = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * FROM fotos WHERE idinmueble =" +idinmueble + ";";
      
        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();  
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Foto foto = new Foto();
                foto.setIdfoto(rs.getInt("idfoto"));
                foto.setUrl(rs.getString("ruta"));
                foto.setIdinmueble(rs.getInt("idinmueble"));
                listaFotos.add(foto);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaFotos;
    }
    
    
}
