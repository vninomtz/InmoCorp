/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Vik-t
 */
public interface IClienteDao {
    public Cliente getCliente(int idcliente);
    public List<Cliente> getClientes();
    public boolean nuevoCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
    boolean editarCliente(Cliente cliente);
}
