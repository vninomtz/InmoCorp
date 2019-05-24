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
import modelo.Inmueble;

/**
 *
 * @author Vik-t
 */
public class InmuebleImp implements IInmuebleDao{

    @Override
    public List<Inmueble> getInmuebles() {
        List<Inmueble> listaInmuebles = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from inmueble";
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Inmueble inmu = new Inmueble();
                inmu.setIdinmuble(rs.getInt("idinmueble"));
                inmu.setCodigo(rs.getString("codigo"));
                inmu.setDireccion(rs.getString("direccion"));
                inmu.setDisponible(rs.getBoolean("disponible"));
                inmu.setNotas(rs.getString("notas"));
                inmu.setColonia(rs.getString("colonia"));
                inmu.setPreciorenta(rs.getFloat("precio_renta"));
                inmu.setPrecioventa(rs.getFloat("precio_venta"));
                inmu.setIdtipoinmueble(rs.getInt("idtipo_inmueble"));
                inmu.setIdciudad(rs.getInt("idciudad"));
                inmu.setIdcliente(rs.getInt("idcliente"));
                listaInmuebles.add(inmu);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
        } finally {
            try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }
        }
        return listaInmuebles;
    }
    
}
