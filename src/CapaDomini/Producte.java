package CapaDomini;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillem
 */
public class Producte {
    private int id;
    private String nom;
    private String tipus;
    private String subtipus;
    private String conservacio;
    
  
    
    public Producte(int id, String nom, String tipus, String subtipus, String 
    conservacio){
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.subtipus = subtipus;
        this.conservacio = conservacio;
    };


    /**
     * @param s
     *
     */
    public void setConservacio(String s) {
        this.conservacio = s;
    }

}
