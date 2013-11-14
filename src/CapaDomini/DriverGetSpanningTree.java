/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;

/**
 *
 * @author rubencin
 */
public class DriverGetSpanningTree {
    
    private static void llegir_matriu(int[][] matriu) throws Exception{
        InOut ob = new InOut();
        for(int i = 0; i < matriu.length; ++i){
            for(int j = 0; j < matriu.length; ++j){
                matriu[i][j] = ob.readint();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        InOut ob = new InOut();
        int tam = ob.readint();
        int[][] matriu = new int[tam][tam];
        llegir_matriu(matriu);
        Graf graf = new Graf(matriu);
        TrobarMinimSpanningTree t = new TrobarMinimSpanningTree();
        int[][] res = t.getSpannningTree(graf);
        for(int i = 0; i < res.length; ++i){
            for(int j = 0; j < res.length; ++j){
                ob.write(res[i][j]);
                ob.write(" ");
            }
            ob.write("\n");
        }
    }
}
