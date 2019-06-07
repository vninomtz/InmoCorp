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
import modelo.Inmueble;

/**
 *
 * @author Vik-t
 */
public class InmuebleImp implements IInmuebleDao {

    @Override
    public List<Inmueble> getInmuebles() {
        List<Inmueble> listaInmuebles = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from inmueble_detalles;";

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
                if(inmu.isDisponible()){
                    listaInmuebles.add(inmu);
                }
                
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
        return listaInmuebles;
    }

    @Override
    public boolean updateDisponibilidad(int idinmueble, boolean disponible) {
        String sQuery = null;
        if (disponible) {
            sQuery = "UPDATE inmueble SET disponible = 1" + " WHERE idinmueble = "
                    + idinmueble + ";";
        } else {
            sQuery = "UPDATE inmueble SET disponible = 0" + " WHERE idinmueble = "
                    + idinmueble + ";";
        }
        System.out.println(sQuery);
        Connection conexionBD = new ConexionBD().getConexionBD();
        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(sQuery);
            if (rs == 1 || rs == 2 || rs == 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex);
            return false;
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return false;
    }

    @Override
    public List<Inmueble> getInmueblesFilitrado(String tipo_inmu, String tipo_operacion) {
        List<Inmueble> listaInmuebles = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery;

        if (tipo_inmu.equals("Todos") && tipo_operacion.equals("Todas")) {
            sQuery = "SELECT * from inmueble_detalles;";

        } else if (tipo_inmu.equals("Todos") && !tipo_operacion.equals("Todas")) {
            sQuery = "SELECT * from inmueble_detalles where tipo_operacion = '" + tipo_operacion + "'";

        } else if (!tipo_inmu.equals("Todos") && tipo_operacion.equals("Todas")) {

            sQuery = "SELECT * from inmueble_detalles where tipo_inmueble = '" + tipo_inmu + "'";
        } else {
            sQuery = "SELECT * from inmueble_detalles where tipo_operacion = '" + tipo_operacion + "'"
                    + " and tipo_inmueble = '" + tipo_inmu + "'";
        }

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
                System.out.println(inmu.getCodigo());

                //Se van a borrar estas consultas
                if(inmu.isDisponible()){
                    listaInmuebles.add(inmu);
                }
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
        return listaInmuebles;
    }

}
