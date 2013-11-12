/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;

import CapaDades.ControladorDades;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author toni
 */
public class CtrlCataleg {
    
    private final ControladorDades ctrl;
    private final ArrayList<Producte> productes;
    private final ArrayList<LlistaProductes> llistes;
    private final ArrayList<Prestatge> prestatges;
    
    /**
     * Creadora de la clase
     */
    public CtrlCataleg(){
        productes = new ArrayList();
        llistes = new ArrayList();
        prestatges = new ArrayList();
        ctrl = new ControladorDades();
    }
    
    public ArrayList<Producte> getProductes(){
        return this.productes;
    }
    
    public ArrayList<LlistaProductes> getLlistes(){
        return this.llistes;
    }
    
    public ArrayList<Prestatge> getPrestatges(){
        return this.prestatges;
    }
    
    public void saveProductes(){
        
    }
    
    public void saveLlistes(){
        
    }
    
    public void savePrestatges(){
        
    }
    
    public void loadProductes() throws IOException{
        ArrayList<String[]> aux = ctrl.readFile("./Dades/Productes.data");
        int n = aux.size();
        for(int i = 0; i < n; ++i){
            String[] s = aux.get(i);
            Producte p = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
            productes.add(p);
        }
    }
    
    public void loadLlistes() throws IOException{
        ArrayList<String[]> aux = ctrl.readFile("./Dades/Llistes.data");
        int n = aux.size();
        for(int i = 0; i < n; ++i){
            String[] s = aux.get(i);
            Producte p = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
            productes.add(p);
        }
    }
    
    public void loadPrestatges(){
    
    }
}
