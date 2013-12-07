/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDomini;

import java.util.ArrayList;
/**
 *
 * @author toni
 */
public class Prestatge {
    private int id;
    private String nom;
    private Boolean configuracio;
    private LlistaProductes llista;
    private ArrayList<Integer> solucio = new ArrayList();
    
    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public Boolean getConfiguracio(){
        return configuracio;
    }
    
    public LlistaProductes getLlista(){
        return llista;
    }
    
    public ArrayList<Integer> getSolucio(){
        return solucio;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setConfiguracio(Boolean configuracio){
        this.configuracio = configuracio;
    }
    
    public void setLlista(LlistaProductes ll){
        this.llista = ll;
    }
    
    public void setSolucio(ArrayList<Integer> s){
        this.solucio = s;
    }
    
    public void swap(int i,int j){
        int x = solucio.get(i);
        int y = solucio.get(j);
        solucio.set(i,y);
        solucio.set(j, x);
    }
}
