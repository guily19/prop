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
    private ArrayList<String> catalegs;
    private ArrayList<String> pruebas;
    private ArrayList<Producte> productes;
    private ArrayList<LlistaProductes> llistes;
    private ArrayList<ArrayList<Integer>> similituds;
    private String path;
    private ArrayList<Prestatge> prestatges;
    private int nextProd;
    private int nextLlis;
    private int nextPres;
    
    /**
     * Creadora de la clase
     */
    public CtrlCataleg(){
        catalegs = new ArrayList();
        productes = new ArrayList();
        llistes = new ArrayList();
        pruebas = new ArrayList();
        path = "./Cataleg/";
        prestatges = new ArrayList();
        ctrl = new ControladorDades();
        similituds = new ArrayList();
        nextProd = 0;
        nextLlis = 0;
        nextPres = 0;
    }
    
    
    //#####Consultores####
    public ArrayList<String> getCatalegs(){
        return this.catalegs;
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
    
    public ArrayList<ArrayList<Integer>> getSimilituds(){
        return similituds;
    }
    
    public ArrayList<ArrayList<Integer>> getSimilitudsLlista(LlistaProductes ll){
        int n = ll.getContaproductes();
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<Producte> prod = ll.getArrayproductes();
        for(int i = 0; i < n; ++i) ids.add(prod.get(i).getId());
        ArrayList<ArrayList<Integer>> sim = new ArrayList();
        for(int i = 0; i < n; ++i){
            ArrayList<Integer> aux = new ArrayList();
            for(int j = 0; j< n; ++j) aux.add(similituds.get(ids.get(i)).get(ids.get(j)));
            sim.add(aux);
        }
        return sim;
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
    
    public void setPath(String name){
        path = "./Cataleg/" + name + "/";
    }
    
    public void setProducte(Producte p, ArrayList<Integer> sim, Boolean b){
        int id = p.getId();
        if(id == nextProd){
            ++nextProd;
            similituds.add(sim);
        }
        else {
            productes.set(id,p);    
            if(b){
                similituds.set(id, sim);
            }
        }
        if(b){
            for(int i = 0; i < nextProd; ++i) similituds.get(id).set(id, sim.get(i));
        }
    }
    
    public void setLlista(LlistaProductes ll){
        if(ll.getId() == nextLlis) ++nextLlis;
        llistes.add(ll);
    }
    
   public void setPrestatge(Prestatge p){
        int i = p.getId();
        if(i == nextPres) ++nextPres;
        prestatges.add(p);
    }
   
   public void removeLlista(LlistaProductes ll){
       llistes.remove(ll);
   }
   
   public void removePrestatge(Prestatge p){
       prestatges.remove(p);
   }
   
   public void removeProducte(Producte p){
       productes.remove(p);
   }
    
    //#####I/O a Fixers#####
    public void saveProductes() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        ArrayList<String[]> sim = new ArrayList();
        int n = productes.size();
        for(int i = 0; i < n; ++i){
            String[] s = new String[5];
            for(int j = 0; j< 5; ++j) s[j] = " ";
            String[]ss = new String[nextProd];
            ArrayList<Integer> simil = similituds.get(i);
            for(int j = 0; j < nextProd; ++j)ss[j] = Integer.toString(simil.get(j));
            Producte p = productes.get(i);
            if(p != null){
                s[0] = Integer.toString(p.getId());
                s[1] = p.getNom();
                s[2] = p.getTipus();
                s[3] = p.getSubtipus();
                s[4] = p.getConservacio();
            }
            aux.add(s);
            sim.add(ss);
        }
        String[] s = new String[1];
        s[0] = Integer.toString(nextProd);
        aux.add(s);
        ctrl.writeFile(aux, path +"Dades/Productes.data");
        ctrl.writeFile(sim, path +"Dades/Graf.data");
    }
    
    public void saveLlistes() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        ArrayList<String[]> list = new ArrayList();
        int m = llistes.size();
        for(int i = 0; i < m; ++i){
            LlistaProductes ll = llistes.get(i);
                String[] s = new String[3];
                String[] ss = new String[1];
                s[0] = Integer.toString(ll.getId());
                s[1] = ll.getNom();
                ss[0] = s[1];
                int n;
                s[2] = Integer.toString(n = ll.getContaproductes());
                ArrayList<Producte> aux2 = ll.getArrayproductes();
                for(int j = 0; j < n; ++j){
                    String[] prod = new String[5];
                    Producte p = aux2.get(j);
                    prod[0] = Integer.toString(p.getId());
                    prod[1] = p.getNom();
                    prod[2] = p.getTipus();
                    prod[3] = p.getSubtipus();
                    prod[4] = p.getConservacio();
                    aux.add(prod);
                }
                aux.add(s);
                list.add(ss);
                ctrl.writeFile(aux,path + "Dades/" + s[1] + ".list");
            aux.clear();
        }
        String[] s = new String[1];
        s[0] = Integer.toString(nextLlis);
        list.add(s);
        ctrl.writeFile(list, path+"Dades/Llistes.data");
    }
    
    public void savePrestatges() throws IOException{
        ArrayList<String[]> aux = new ArrayList();
        ArrayList<String[]> list = new ArrayList();
        int m = prestatges.size();
        for(int i = 0; i < m; ++i){
            Prestatge p = prestatges.get(i);
                String[] prest = new String[3];
                String[] llista = new String[3];
                String[] nom = new String[1];
                prest[0] = Integer.toString(p.getId());
                prest[1] = p.getNom();
                nom[0] = prest[1];
                prest[2] = p.getConfiguracio().toString();
                LlistaProductes ll = p.getLlista();
                llista[0] = Integer.toString(ll.getId());
                llista[1] = ll.getNom();
                int n;
                llista[2] = Integer.toString(n = ll.getContaproductes());
                aux.add(prest);
                aux.add(llista);
                list.add(nom);
                ArrayList<Producte> aux2 = ll.getArrayproductes();
                for(int j = 0; j < n; ++j){
                    String[] prod = new String[5];
                    Producte p2 = aux2.get(j);
                    prod[0] = Integer.toString(p2.getId());
                    prod[1] = p2.getNom();
                    prod[2] = p2.getTipus();
                    prod[3] = p2.getSubtipus();
                    prod[4] = p2.getConservacio();
                    aux.add(prod);
                }
                ArrayList<Integer> ids = p.getSolucio();
                String[] ss = new String[n];
                for(int j = 0; j < n; ++j) ss[j] = Integer.toString(ids.get(j));
                aux.add(ss);
                ctrl.writeFile(aux, path + "Dades/" + nom[0] + ".prest");
            aux.clear();
        }
        String[] s = new String[1];
        s[0] = Integer.toString(nextPres);
        list.add(s);
        ctrl.writeFile(list, path +"Dades/Prestatges.data");
    }
    
    public void loadProductes() throws IOException{
        ArrayList<String[]> aux = ctrl.readFile(path+"Dades/Productes.data");
        int n = aux.size();
        nextProd = Integer.parseInt(aux.get(n-1)[0]);
        for(int i = 0; i < n - 1; ++i){
            String[] s = aux.get(i);
            Producte p;
            if(!s[0].equals(" ")){
                p = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
            }
            else p = null;
            productes.add(p);
        }
        aux = ctrl.readFile(path+"Dades/Graf.data"); 
        for(int i = 0; i < nextProd; ++i){
            String[] s = aux.get(i);
            ArrayList<Integer> aux2 = new ArrayList();
            for(int j = 0; j < nextProd; ++j) aux2.add(Integer.parseInt(s[j]));
            similituds.add(aux2);
        }
    }
    
    public void loadLlistes() throws IOException{
        ArrayList<String[]> aux = ctrl.readFile(path+"Dades/Llistes.data");
        int m = aux.size();
        nextLlis  = Integer.parseInt(aux.get(m-1)[0]);
        for(int i = 0; i < m-1; ++i){
            String file = aux.get(i)[0];
            ArrayList<String[]> param = ctrl.readFile(path + "Dades/" + file + ".list");
            LlistaProductes ll = new LlistaProductes();
            ll.setId(Integer.parseInt(param.get(0)[0]));
            ll.setNom(param.get(0)[1]);
            int n;
            ll.setContaproductes(n= Integer.parseInt(param.get(0)[2]));
            ArrayList<Producte> aux2 = new ArrayList();
            for(int j = 0; j < n; ++j){
                String[] s = param.get(j + 1);
                Producte p = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
                aux2.add(p);
            }
            ll.setArrayproductes(aux2);
            llistes.add(ll);
        }
    }
    
    public void loadPrestatges() throws IOException, Exception{
        ArrayList<String[]> aux = ctrl.readFile(path+"Dades/Prestatges.data");
        int m = aux.size();
        nextPres  = Integer.parseInt(aux.get(m-1)[0]);
        for(int i = 0; i < m-1; ++i){
            String file = aux.get(i)[0];
            ArrayList<String[]> param = ctrl.readFile(path + "Dades/" + file + ".prest");
            Prestatge p = new Prestatge();
            p.setId(Integer.parseInt(param.get(0)[0]));
            p.setNom(param.get(0)[1]);
            p.setConfiguracio(Boolean.parseBoolean(param.get(0)[2]));
            LlistaProductes ll = new LlistaProductes();
            ll.setId(Integer.parseInt(param.get(1)[0]));
            ll.setNom(param.get(1)[1]);
            int n;
            ll.setContaproductes(n = Integer.parseInt(param.get(1)[2]));
            ArrayList<Producte> aux2 = new ArrayList();
            for(int j = 0; j < n; ++j){
                String[] s = param.get(j + 2);
                Producte prod = new Producte(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4]);
                aux2.add(prod);
            }
            ll.setArrayproductes(aux2);
            p.setLlista(ll);
            ArrayList<Integer> sol = new ArrayList();
            for(int j = 0; j < n; ++j){
                sol.add(Integer.parseInt(param.get(n + 2)[j]));
            }
            p.setSolucio(sol);
            prestatges.add(p);
        }
    }
    
    public void loadCatalegs() throws IOException{
         ArrayList<String[]> out = ctrl.readFile(path + "Cataleg.data");
         int n = out.size();
         for(int i = 0; i < n; ++i) catalegs.add(out.get(i)[0]);
    }
    
    public void loadPruebas() throws IOException{
        ArrayList<String[]> out = ctrl.readFile(path + "JP/jp.data");
         int n = out.size();
         for(int i = 0; i < n; ++i) catalegs.add(out.get(i)[0]);
    }
}