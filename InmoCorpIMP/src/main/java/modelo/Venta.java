/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alanglezh
 */
public class Venta {
    private int idVenta;
    private String fecha_venta;
    private double monto;
    private int idcliente;
    private int idinmueble;

    public Venta(int idVenta, String fecha_venta, double monto, int idcliente, int idinmueble) {
        this.idVenta = idVenta;
        this.fecha_venta = fecha_venta;
        this.monto = monto;
        this.idcliente = idcliente;
        this.idinmueble = idinmueble;
    }

    public Venta() {
        
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fecha_venta=" + fecha_venta + ", monto=" + monto + ", idcliente=" + idcliente + ", idinmueble=" + idinmueble + '}';
    }
    
    
}
