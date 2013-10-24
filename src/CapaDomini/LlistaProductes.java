/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;


import java.util.*;
/**
 *
 * @author guillem
 */
public class LlistaProductes {
    
    private ArrayList <Producte> arrayproductes = new ArrayList<Producte>();
    private int contaproductes = 0;
    
    public LlistaProductes(){};
    
    public void AfegirProducte(Producte producte){
        this.arrayproductes.add(producte);
        this.contaproductes = arrayproductes.size();
    }
    
    public void BorrarProductePosicio(int posicio){
        this.arrayproductes.remove(posicio);
        this.contaproductes = arrayproductes.size();
    }
    
    public void BorrarProducte(Producte producte){
        this.arrayproductes.remove(producte);
        this.contaproductes = arrayproductes.size();
    }
    
}
