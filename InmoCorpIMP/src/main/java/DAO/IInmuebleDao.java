/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Inmueble;

/**
 *
 * @author Vik-t
 */
public interface IInmuebleDao {

    public List<Inmueble> getInmuebles();

    public boolean updateDisponibilidad(int idinmueble, boolean disponible);

    public List<Inmueble> getInmueblesFilitrado(String tipo_inmu, String tipo_operacion);

}
