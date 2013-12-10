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
    
    public Producte(){}
    
    public Producte(int id, String nom, String tipus, String subtipus, String 
    conservacio){
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.subtipus = subtipus;
        this.conservacio = conservacio;
    };

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
     * @return the tipus
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * @param tipus the tipus to set
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /**
     * @return the subtipus
     */
    public String getSubtipus() {
        return subtipus;
    }

    /**
     * @param subtipus the subtipus to set
     */
    public void setSubtipus(String subtipus) {
        this.subtipus = subtipus;
    }

    /**
     * @return the conservacio
     */
    public String getConservacio() {
        return conservacio;
    }

    /**
     * @param conservacio the conservacio to set
     */
    public void setConservacio(String conservacio) {
        this.conservacio = conservacio;
    }

}
