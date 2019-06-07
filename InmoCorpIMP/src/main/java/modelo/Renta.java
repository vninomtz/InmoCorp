/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Vik-t
 */
public class Renta {

    private int idrenta;
    private String fechainicio;
    private String fechafin;
    private double deposito;
    private double monto;
    private int idcliente;
    private int idinmueble;

    public Renta() {

    }

    public Renta(int idrenta, String fechainicio, String fechafin, double deposito, double monto, int idcliente, int idinmueble) {
        this.idrenta = idrenta;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.deposito = deposito;
        this.monto = monto;
        this.idcliente = idcliente;
        this.idinmueble = idinmueble;
    }

    public int getIdrenta() {
        return idrenta;
    }

    public void setIdrenta(int idrenta) {
        this.idrenta = idrenta;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
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

}
