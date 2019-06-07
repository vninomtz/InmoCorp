/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Renta;

/**
 *
 * @author Vik-t
 */
public class RentaImp implements IRegistrarRenta {

    @Override
    public boolean guardarRenta(Renta renta) {
        String sentencia = "INSERT INTO renta(fecha_inicio,fecha_fin,deposito,monto,idcliente,idinmueble) "
                + "VALUES ('" + renta.getFechainicio() + "','" + renta.getFechafin() + "','"
                + renta.getDeposito() + "','"
                + renta.getMonto() + "','"
                + renta.getIdcliente() + "','"
                + renta.getIdinmueble() + "');";
        System.out.println(sentencia);
        Connection conexionBD = new ConexionBD().getConexionBD();
        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(sentencia);
            if (rs == 1 || rs == 2 || rs == 0) {
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
