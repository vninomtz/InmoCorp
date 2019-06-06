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
        String sQuery = "SELECT * from inmueble_detalles";
        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Inmueble inmu = new Inmueble();
                
                inmu.setIdinmuble(rs.getInt("idinmueble"));
                inmu.setIdcliente(rs.getInt("idcliente"));
                inmu.setIdtipoinmueble(rs.getInt("idtipo_inmueble"));
                inmu.setIdciudad(rs.getInt("idciudad"));
                
                inmu.setCodigo(rs.getString("codigo_inmueble"));
                inmu.setDireccion(rs.getString("direccion_inmueble"));
                inmu.setDisponible(rs.getBoolean("disponible"));
                inmu.setNotas(rs.getString("notas"));
                inmu.setColonia(rs.getString("colonia_inmueble"));
                inmu.setTipoOperacion(rs.getString("tipo_operacion"));
                inmu.setPrecioventa(rs.getFloat("precio_venta"));
                inmu.setPreciorenta(rs.getFloat("precio_renta"));
                inmu.setCiudad(rs.getString("ciudad_inmueble"));
                inmu.setTipoInmuble(rs.getString("tipo_inmueble"));
                inmu.getCliente().setNombre(rs.getString("nombre_cliente"));
                inmu.getCliente().setPaterno(rs.getString("paterno_cliente"));
                inmu.getCliente().setMaterno(rs.getString("materno_cliente"));
                inmu.getCliente().setTelefono(rs.getString("telefono_cliente"));
                inmu.getCliente().setCalle(rs.getString("calle_cliente"));
                inmu.getCliente().setColonia(rs.getString("colonia_cliente"));
                inmu.getCliente().setCodigopostal(rs.getString("codigo_postal_cliente"));
                inmu.getCliente().setRfc(rs.getString("rfc_cliente"));
                inmu.getCliente().setTipo(rs.getString("tipo_cliente"));
                inmu.getCliente().setIdacceso(rs.getInt("idacceso_cliente"));
                inmu.getCliente().setCorreo(rs.getString("correo_cliente"));      
                
                //Se van a borrar estas consultas
                
                
                System.out.println(inmu.getCodigo());
                listaInmuebles.add(inmu);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaInmuebles;
    }
    
}
