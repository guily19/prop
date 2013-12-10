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
    
    private int id;
    private String nom;
    private ArrayList<Producte> arrayproductes = new ArrayList();
    private int contaproductes = 0;

    /**
     * Tenim una nova instancia de LlistaProductes buida
     */
    public LlistaProductes(){};

    


    /**
     * El objecte LlistaProductes ara disposa del identificador del producte amb identificador id
     * @param id 
     */
    public void afegirProducte(Producte p){
        this.getArrayproductes().add(p);
        this.setContaproductes(getArrayproductes().size());
    }
    
    /**
     * El objecte LlistaProductes ja no disposa del identificador del producte amb identificador idproducte
     * @param idproducte
     */
    public void borrarProducte(Producte p){
        this.getArrayproductes().remove((Object)p);
        this.setContaproductes(getArrayproductes().size());
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the arrayproductes
     */
    public ArrayList<Producte> getArrayproductes() {
        return arrayproductes;
    }

    /**
     * @param arrayproductes the arrayproductes to set
     */
    public void setArrayproductes(ArrayList<Producte> arrayproductes) {
        this.arrayproductes = arrayproductes;
    }

    /**
     * @return the contaproductes
     */
    public int getContaproductes() {
        return contaproductes;
    }

    /**
     * @param contaproductes the contaproductes to set
     */
    public void setContaproductes(int contaproductes) {
        this.contaproductes = contaproductes;
    }
    
}
