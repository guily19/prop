/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Toni
 * @version 1.0
 * 
 * ControladorDades controla les lectures i escritures a archius
 * L'archiu en el qual es vol llegir o escriure sempre ha de existir, en cas
 * contrari saltara FileNotFoundException
 */


public class ControladorDades {
    
    
    /** Constructora per defecte**/
    public ControladorDades(){
    
    }
    /**
     * 
     * 
     * @param file
     * nom de l'archiu que es vol llegir
     * @return
     * Retorna un ArrayList de vector String, on cada String[] és una linia
     * de l'archiu. Ex:
     *                  file:
     *                          1;LLet;Pascual;Semidesnatada
     *                          2;Flan;Danone;D'ou
     *                  Llavor al ArrayList:
     *                      pos(0)-> string[] = {1,Llet,Pascual,Semidesnatada}
     *                      pos(1)-> string[] = {2,Flan,Danone,D'ou}
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    public ArrayList<String[]> readFile(String file) throws FileNotFoundException, IOException{
        ArrayList<String[] > params = new ArrayList();
        FileReader fr = new FileReader(file);
        BufferedReader in = new BufferedReader(fr);
        String s;
        while ((s=in.readLine()) != null) params.add(s.split(";"));
        in.close();
        return params;
    }
    
    /**
     * Escriu una linia al final del archiu amb nom = file
     * String[] -> {"1", "Aigua", "FontVella"}
     * Al final de file -> 1;Aigua;FontVella
     * @param params
     * Cada String[i] és un parametre  
     * @param n
     * Tamany del String[]
     * @param file
     * Nom del archiu
     * @throws IOException 
     */
    public void writeLineFile(String[] params,int n, String file) throws IOException{
        FileWriter fw= new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.print(params[0]);
        for(int i = 1; i < n; ++i) out.print(";" + params[i]);
        out.print("\n");
        out.close();
    }
    /**
     * Escriu varies linies al final de file
     * @param params
     * ArrayList de vector String, on cada String[] és una linia
     * de l'archiu
     * @param n
     * Tamany de tots els String[]
     * @param file
     * Nom de l'archiu
     * @throws IOException 
     */
    public void writeFile(ArrayList<String[]> params,int n, String file) throws IOException{
        FileWriter fw= new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (int i = 0; i < params.size(); ++i){
            out.print(params.get(i)[0]);
            for(int j = 1; j < n; ++j) out.print(";" + params.get(i)[j]);
            out.print("\n");
        }
        out.close();     
    }

}
