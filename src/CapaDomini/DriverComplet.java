package CapaDomini;

import java.util.PriorityQueue;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillem
 */
public class DriverComplet {
    /**
     * @param args the command line arguments
     * 
     */
    private static void escriure_matriu(int[][] mat) throws Exception{
        InOut ob = new InOut();
        ob.write("Escric la matriu: \n");
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat.length; ++j){
                ob.write(mat[i][j]);
                ob.write(" ");
            }
            ob.write("\n");
        }
    }
    
    private static void escriure_priorityqueue(PriorityQueue<GrauMinim> cua) throws Exception{
        GrauMinim g = new GrauMinim();
        InOut ob = new InOut();
        ob.write("Escric la queue: \n");
        while(!cua.isEmpty()){
            g = cua.element();
            ob.write(g.id1);
            ob.write(" ");
            ob.write(g.id2);
            ob.write(" ");
            ob.write(g.grau);
            ob.write("\n");
            cua.poll();
        }
    }
    
    private static void llegir_matriu(int[][]mat) throws Exception{
        InOut ob = new InOut();
        for(int i = 0; i <  mat.length; ++i){
            for(int j = 0; j < mat.length; ++j){
                mat[i][j] = ob.readint();
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        InOut ob = new InOut();
        int tam = ob.readint();
        int[][] matriu = new int[tam][tam];
        llegir_matriu(matriu);
        Graf graf1 = new Graf(matriu);
        AlgoritmeFacil alg = new AlgoritmeFacil();
        alg.AlgoritmeFacil(graf1);
        ArrayList <Integer> sol = new ArrayList<Integer>();
        sol = alg.posibleSolucio();
        int i =0;
        while(i < sol.size()){
            int n = sol.get(i);
            ob.write(n);
            ob.write(" ");
            ++i;
        }
    }
    
}
