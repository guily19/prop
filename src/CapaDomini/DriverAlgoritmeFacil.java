/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;

import java.util.ArrayList;

/**
 *
 * @author guillem
 */



public class DriverAlgoritmeFacil {
    
  private static void llegir_matriu(int[][]mat) throws Exception{
        InOut ob = new InOut();
        for(int i = 0; i <  mat.length; ++i){
            for(int j = 0; j < mat.length; ++j){
                mat[i][j] = ob.readint();
            }
        }
    }
    
  public static void main(String[] args) throws Exception {
        // TODO code application logic here
        InOut ob = new InOut();
        ob.write("Indiqui el número de productes que vol posar al prestatge: ");
        int tam = ob.readint();
        int[][] matriu = new int[tam][tam];
        ob.write("Per tal de llegir la matriu de similituds haurà d'escriure totes les similituds d'un producte amb la resta\n");
        ob.write("Format: -1 2 3\n        2 -1 4\n        3 4 -1\n");
        ob.write("Llegim la Matriu: \n");
        llegir_matriu(matriu);
        Graf graf = new Graf(matriu);
        AlgoritmeFacil alg = new AlgoritmeFacil();
        alg.AlgoritmeFacil(graf);
        ArrayList <Integer> sol = new ArrayList<Integer>();
        sol = alg.posibleSolucio();
        int i = 0;
        while(i < sol.size()){
            int n = sol.get(i);
            ob.write(n);
            ob.write(" ");
            ++i;
        }
    }
    
    
}
