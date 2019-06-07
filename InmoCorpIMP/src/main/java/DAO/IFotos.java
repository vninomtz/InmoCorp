/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Foto;

/**
 *
 * @author Vik-t
 */
public interface IFotos {
    public List<Foto> getFotos(int idinmueble);
}
