/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Venta;

/**
 *
 * @author alanglezh
 */
public class VentaImp implements IVentaDao{

    
    @Override
    public boolean guardarVenta(Venta venta) {
        String query = "INSERT INTO venta(fecha_venta,monto,idcliente,idinmueble) VALUES ('" + venta.getFecha_venta()+ "','"
                + venta.getMonto() + "','" + venta.getIdcliente()+ "','" + venta.getIdinmueble()+ "');";
        System.out.println(query);
        Connection conexionBD = new ConexionBD().getConexionBD();
        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(query);
            if(rs == 1 || rs ==2  || rs == 0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement" + ex.getMessage());
        } finally {
            try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }
        }
        return false;
    }
    
}
