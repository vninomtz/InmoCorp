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
    private float precioventa;
    private float preciorenta;
    private int idtipoinmueble;
    private int idciudad;
    private int idciente;

    public Inmueble(String codigo, int idinmuble, String direccion, boolean disponible, String notas, String colonia, float precioventa, float preciorenta, int idtipoinmueble, int idciudad, int idciente) {
        this.codigo = codigo;
        this.idinmuble = idinmuble;
        this.direccion = direccion;
        this.disponible = disponible;
        this.notas = notas;
        this.colonia = colonia;
        this.precioventa = precioventa;
        this.preciorenta = preciorenta;
        this.idtipoinmueble = idtipoinmueble;
        this.idciudad = idciudad;
        this.idciente = idciente;
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

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public float getPreciorenta() {
        return preciorenta;
    }

    public void setPreciorenta(float preciorenta) {
        this.preciorenta = preciorenta;
    }

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

    public int getIdciente() {
        return idciente;
    }

    public void setIdciente(int idciente) {
        this.idciente = idciente;
    }
    
    
}
