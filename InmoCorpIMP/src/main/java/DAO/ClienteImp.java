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
import modelo.Cliente;

/**
 *
 * @author Vik-t
 */
public class ClienteImp implements IClienteDao{

    @Override
    public Cliente getCliente(int idcliente) {
        Cliente cliente = new Cliente();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from cliente where idcliente=" + idcliente +";";
        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setPaterno(rs.getString("paterno"));
                cliente.setMaterno(rs.getString("materno"));            
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setCodigopostal(rs.getString("codigo_postal"));
                cliente.setRfc(rs.getString("rfc"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setIdacceso(rs.getInt("idacceso"));
                cliente.setCorreo(rs.getString("correo"));
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
        return cliente;
    }

    @Override
    public List<Cliente> getClientes() {
       List<Cliente> listaInmuebles = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from cliente where tipo = 'Comprador'";
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setPaterno(rs.getString("paterno"));
                cliente.setMaterno(rs.getString("materno"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setCodigopostal(rs.getString("codigo_postal"));
                cliente.setRfc(rs.getString("rfc"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setIdcliente(rs.getInt("idacceso"));
                cliente.setCorreo(rs.getString("correo"));
                
                listaInmuebles.add(cliente);
                System.out.println(cliente);
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

    @Override
    public boolean nuevoCliente(Cliente cliente) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarCliente(Cliente cliente) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}
