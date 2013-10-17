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
    private int id = 0;
    private double preu = 0;
    private double grau_similitud = 0;
    
    public Producte(){};
    
    public Producte(int id, double preu,double grau){
        setId(id);
        setPreu(preu);
        setGrau_similitud(grau);
    };

    /**
     * @return the preu
     */
    public double getPreu() {
        return preu;
    }

    /**
     * @param preu the preu to set
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }

    /**
     * @return the grau_similitud
     */
    public double getGrau_similitud() {
        return grau_similitud;
    }

    /**
     * @param grau_similitud the grau_similitud to set
     */
    public void setGrau_similitud(double grau_similitud) {
        this.grau_similitud = grau_similitud;
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
    
   
    
    
}
