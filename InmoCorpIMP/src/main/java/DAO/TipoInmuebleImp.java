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
import modelo.TipoInmueble;

/**
 *
 * @author Vik-t
 */
public class TipoInmuebleImp implements ITipoInmuebleDao{

    @Override
    public List<TipoInmueble> getTipoInmuebles() {
        List<TipoInmueble> listaTipoInmuebles = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from tipo_inmueble";
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                TipoInmueble tipo = new TipoInmueble();
                tipo.setIdtipoinmueble(rs.getInt("idtipo_inmueble"));
                tipo.setTipo(rs.getString("tipo"));
                listaTipoInmuebles.add(tipo);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            return null;
        } finally {
            /*try {
                conexionBD.close();                
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion:");
            }*/
           
        }
        return listaTipoInmuebles;
    }
    
}
