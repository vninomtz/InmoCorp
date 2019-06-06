/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Vik-t
 */
public class Inmueble {
    private int idinmuble;
    private String codigo;
    private String direccion;
    private boolean disponible;
    private String notas;
    private String colonia;
    private String tipoOperacion;
    private float precioventa;
    private float preciorenta;
    private Cliente cliente = new Cliente();
    private String tipoInmuble;
    private String ciudad;
    
    //Se van a eliminar estos atributos
    private int idtipoinmueble;
    private int idciudad;
    private int idcliente;

    public Inmueble(int idinmuble, String codigo, String direccion, 
            boolean disponible, String notas, String colonia, String tipoOperacion, 
            float precioventa, float preciorenta, Cliente cliente, String tipoInmuble, 
            String ciudad, int idtipoinmueble, int idciudad, int idcliente) {
        this.idinmuble = idinmuble;
        this.codigo = codigo;
        this.direccion = direccion;
        this.disponible = disponible;
        this.notas = notas;
        this.colonia = colonia;
        this.tipoOperacion = tipoOperacion;
        this.precioventa = precioventa;
        this.preciorenta = preciorenta;
        this.cliente = cliente;
        this.tipoInmuble = tipoInmuble;
        this.ciudad = ciudad;
        this.idtipoinmueble = idtipoinmueble;
        this.idciudad = idciudad;
        this.idcliente = idcliente;
    }

    

    public Inmueble() {
        
    }

    public int getIdinmuble() {
        return idinmuble;
    }

    public void setIdinmuble(int idinmuble) {
        this.idinmuble = idinmuble;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public float getPreciorenta() {
        return preciorenta;
    }

    public void setPreciorenta(float preciorenta) {
        this.preciorenta = preciorenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoInmuble() {
        return tipoInmuble;
    }

    public void setTipoInmuble(String tipoInmuble) {
        this.tipoInmuble = tipoInmuble;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
    //Hacia bajo se van a eliminar 
    
    
    
    

    public int getIdtipoinmueble() {
        return idtipoinmueble;
    }

    public void setIdtipoinmueble(int idtipoinmueble) {
        this.idtipoinmueble = idtipoinmueble;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idciente) {
        this.idcliente = idciente;
    }
    
    
}
