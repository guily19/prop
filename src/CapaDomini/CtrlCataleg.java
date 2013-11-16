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
    
    private final InOut consola = new InOut();
    private final ControladorDades ctrl;
    private ArrayList<Producte> productes;
    private ArrayList<LlistaProductes> llistes;
    private ArrayList<ArrayList<Integer>> similituds;
    private final String path;
    private ArrayList<Prestatge> prestatges;
    private int nextProd;
    private int nextLlis;
    private int nextPres;
    
    /**
     * Creadora de la clase
     * @param name nom del cataleg a carregar
     */
    public CtrlCataleg(String name){
        productes = new ArrayList();
        llistes = new ArrayList();
        path = name;
        prestatges = new ArrayList();
        ctrl = new ControladorDades();
        similituds = new ArrayList();
        nextProd = 0;
        nextLlis = 0;
        nextPres = 0;
    }
    
    
    //#####Consultores####
    public ArrayList<Producte> getProductes(){
        return this.productes;
    }
    
    public ArrayList<LlistaProductes> getLlistes(){
        return this.llistes;
    }
    
    public ArrayList<Prestatge> getPrestatges(){
        return this.prestatges;
    }
    
    public ArrayList<ArrayList<Integer>> getSimilituds(){
        return similituds;
    }
    
     /**
     * @return the nextProd
     */
    public int getNextProd() {
        return nextProd;
    }

    /**
     * @return the nextLlis
     */
    public int getNextLlis() {
        return nextLlis;
    }

    /**
     * @return the nextPres
     */
    public int getNextPres() {
        return nextPres;
    }

    //#####Modificadores######
    
    public void setProducte(Producte p){
        int id = p.getId();
        if(id == nextProd){
            ++nextProd;
            ArrayList<Integer> aux = new ArrayList();
            for(int i = 0; i < nextProd-1; ++i){
                similituds.get(i).add(5);
                aux.add(5);
            }
            aux.add(-1);
            similituds.add(aux);
        }
        else productes.remove(id);
        productes.add(id,p);
    }
    
    public void setLlista(LlistaProductes ll){
        int i = ll.getId();
        if(i == nextLlis) ++nextLlis;
        else llistes.remove(i);
        llistes.add(i,ll);
    }
    
   public void setPrestatge(Prestatge p){
        int i = p.getId();
        if(i == nextPres) ++nextPres;
        prestatges.add(i,p);
    }
   
   public void removeLlista(int id){
       llistes.remove(id);
       --nextLlis;
       for(int i = id; i < nextLlis; ++i){
           LlistaProductes ll = llistes.get(i);
           ll.setId(ll.getId() - 1);
           setLlista(ll);
       }
   }
   
   public void removePrestatge(int id){
       prestatges.remove(id);
       --nextPres;
       for(int i = id; i < nextPres; ++i){
           Prestatge p = prestatges.get(i);
           p.setId(p.getId() - 1);
           setPrestatge(p);
       }
   }
   
   public void removeProducte(int id){
       similituds.remove(id);
       for(int i = 0; i < nextProd - 1; ++i) similituds.get(i).remove(id);
       productes.remove(id);
       --nextProd;
       for(int i = id; i < nextProd; ++i){
           Producte p = productes.get(i);
           p.setId(p.getId() - 1);
           setProducte(p);
       }
   }
    
    //#####I/O a Fixers#####
    public void saveProductes() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        ArrayList<String[]> sim = new ArrayList();
        for(int i = 0; i < nextProd; ++i){
            String[] s = new String[5];
            String[]ss = new String[nextProd];
            ArrayList<Integer> simil = similituds.get(i);
            for(int j = 0; j < nextProd; ++j)ss[j] = Integer.toString(simil.get(j));
            Producte p = productes.get(i);
            s[0] = Integer.toString(p.getId());
            s[1] = p.getNom();
            s[2] = p.getTipus();
            s[3] = p.getSubtipus();
            s[4] = p.getConservacio();
            aux.add(s);
            sim.add(ss);
        }
        ctrl.writeFile(aux, "./" + path +"/Productes.data");
        ctrl.writeFile(sim, "./" + path +"/Graf.data");
    }
    
    public void saveLlistes() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        for(int i = 0; i < nextLlis; ++i){
            LlistaProductes ll = llistes.get(i);
            String[] s = new String[ll.getContaproductes() + 3];
            s[0] = Integer.toString(ll.getId());
            s[1] = ll.getNom();
            int n;
            s[2] = Integer.toString(n = ll.getContaproductes());
            ArrayList<Integer> aux2 = ll.getArrayproductes();
            for(int j = 0; j < n; ++j) s[j + 3] =Integer.toString(aux2.get(j));
            aux.add(s);
        }
        ctrl.writeFile(aux, "./"+path+"/Llistes.data");
    }
    
    public void savePrestatges() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        for(int i = 0; i < nextPres; ++i){
            Prestatge p = prestatges.get(i);
            int n = p.getN();
            String s[] = new String[n+5];
            s[0] = Integer.toString(p.getId());
            s[1] = p.getNom();
            s[2] = Integer.toString(p.getIdllista());
            s[3] = p.getConfiguracio().toString();
            s[4] = Integer.toString(n);
            ArrayList<Integer> ids = p.getProductos();
            for(int j = 0; j < n; ++j) s[j+5] = Integer.toString(ids.get(j));
            aux.add(s);
        }
        ctrl.writeFile(aux, "./" + path +"/Prestatges.data");
    }
    
    public void loadProductes() throws IOException, Exception{
        ArrayList<String[]> aux = ctrl.readFile("./"+path+"/Productes.data");
        nextProd = aux.size();
        for(int i = 0; i < nextProd; ++i){
            String[] s = aux.get(i);
            Producte p = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
            productes.add(p);
        }
        aux = ctrl.readFile("./"+path+"/Graf.data"); 
        for(int i = 0; i < nextProd; ++i){
            String[] s = aux.get(i);
            ArrayList<Integer> aux2 = new ArrayList();
            for(int j = 0; j < nextProd; ++j) aux2.add(Integer.parseInt(s[j]));
            similituds.add(aux2);
        }
    }
    
    public void loadLlistes() throws IOException{
        ArrayList<String[]> aux = ctrl.readFile("./"+path+"/Llistes.data");
        nextLlis = aux.size();
        for(int i = 0; i < nextLlis; ++i){
            String[] s = aux.get(i);
            int n = s.length;
            LlistaProductes ll = new LlistaProductes();
            ll.setId(Integer.parseInt(s[0]));
            ll.setNom(s[1]);
            ll.setContaproductes( Integer.parseInt(s[2]));
            ArrayList<Integer> aux2 = new ArrayList();
            for(int j = 3; j < n; ++j) aux2.add(Integer.parseInt(s[j]));
            ll.setArrayproductes(aux2);
            llistes.add(ll);
        }
    }
    
    public void loadPrestatges() throws IOException, Exception{
        ArrayList<String[]> aux = ctrl.readFile("./"+path+"/Prestatges.data");
        nextPres = aux.size();
        for(int i = 0; i < nextPres; ++i){
            String[] s = aux.get(i);
            int n = s.length;
            Prestatge p = new Prestatge();
            p.setId(Integer.parseInt(s[0]));
            p.setNom(s[1]);
            p.setIdLlista(Integer.parseInt(s[2]));
            ArrayList<Integer> aux2 = new ArrayList();
            p.setConfiguracio(Boolean.getBoolean(s[3]));
            for(int j = 5; j < n; ++j) aux2.add(Integer.parseInt(s[j]));
            p.setProductos(aux2);
            prestatges.add(p);
        }
    }
}