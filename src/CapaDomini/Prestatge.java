/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDomini;

import java.util.ArrayList;
/**
 *
 * @author Alfred
 */
public class Prestatge {
    private int id;
    private String nom;
    private Boolean configuracio;
    private int idllista;
    private ArrayList<Integer> productos = new ArrayList();
    private int n;
    
    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public Boolean getConfiguracio(){
        return configuracio;
    }
    
    public int getIdllista(){
        return idllista;
    }
    
    public ArrayList<Integer> getProductos(){
        return productos;
    }
    
    public int getProductoId(int i){
        return productos.get(i);
    }
    
    public int getProductoPos(int x){
        for(int i = 0;i < productos.size();++i){
            if(productos.get(i) == x)return i;
        }
        return -1;
    }
    
    public int getN(){
        return n;
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
    
    public void setIdLlista(int i){
        this.idllista = i;
    }
    
    public void setProductos(ArrayList<Integer> productos){
        n = productos.size();
        this.productos = productos;
    }
    
    public void itercanvi(int p1,int p2){
        int aux = getProductoPos(p2);
        productos.set(getProductoPos(p1), p2);
        productos.set(aux, p1);
    }
}
