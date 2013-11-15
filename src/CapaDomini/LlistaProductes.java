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
    private ArrayList<Integer> arrayproductes = new ArrayList();
    private int contaproductes = 0;
    private final ArrayList< ArrayList<Integer> > similituds = new ArrayList();
    
    public LlistaProductes(){};
    /**
     * 
     * @param arrayproducte 
     * La llista de llistes similituds es actualitzada amb els graus de similitud afegits del nou producte en la arrayproducte
     */
    private void afegir_producte_similituds(ArrayList<Integer> arrayproducte){
        for(int i = 0; i < similituds.size(); ++i){
            if(i != similituds.size()-1){
                ArrayList<Integer> ant = similituds.get(i);
                ant.add(arrayproducte.get(i));
                similituds.set(i, ant);
            }
        }
    }
    
    private void borrar_producte_similituds(int id){
        for(int i = 0; i < similituds.size(); ++i){
            ArrayList<Integer> ant = similituds.get(i);
            ant.remove(id);
            similituds.set(i,ant);
        }
    }
    
    /**
     * 
     * @param id
     * @return La array de similituds del producte amb identificador id amb la resta de productes de la llista
     */
    public ArrayList<Integer> consultar_array_producte(int id){
        return similituds.get(id);
    }
    
    public void AfegirProducte(int id, ArrayList<Integer> arrayProducte){
        this.getArrayproductes().add(id);
        this.setContaproductes(getArrayproductes().size());
        similituds.add(id,arrayProducte);
        afegir_producte_similituds(arrayProducte);
    }
    
    public void BorrarProductePosicio(int posicio){
        this.getArrayproductes().remove(posicio);
        this.setContaproductes(getArrayproductes().size());
        similituds.remove(posicio);
        borrar_producte_similituds(posicio);
    }
    
    public void BorrarProducte(int idproducte){
        this.getArrayproductes().remove(idproducte);
        this.setContaproductes(getArrayproductes().size());
        similituds.remove(idproducte);
        borrar_producte_similituds(idproducte);
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
    public ArrayList<Integer> getArrayproductes() {
        return arrayproductes;
    }

    /**
     * @param arrayproductes the arrayproductes to set
     */
    public void setArrayproductes(ArrayList<Integer> arrayproductes) {
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
