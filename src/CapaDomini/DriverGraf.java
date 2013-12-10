package CapaDomini;

import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillem
 */
public class DriverGraf {
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
        ob.write("Indiqui el tamany de la matriu: ");
        int tam = ob.readint();
        int[][] matriu = new int[tam][tam];
        ob.write("Per tal de llegir la matriu de similituds haurà d'escriure totes les similituds d'un producte amb la resta\n");
        ob.write("Format: -1 2 3\n        2 -1 4\n        3 4 -1\n");
        ob.write("Llegim la Matriu: \n");
        llegir_matriu(matriu);
        Graf graf2 = new Graf(matriu);
        int[][] matriu2 = graf2.consultarMatriu();
        PriorityQueue<GrauMinim> cua2 = graf2.consultarQueueMinims();
        ob.write("Opcio 1: Veure la matriu del graf\n");
        ob.write("Opcio 2: Veure la Priorityqueue del graf\n");
        ob.write("Opcio 3: Sortir\n");
        int caso = ob.readint();
        while(caso != 3){
            switch(caso){
                case 1:{
                    escriure_matriu(matriu2);
                    break;
                }
                case 2:{
                    escriure_priorityqueue(cua2);
                    break;
                }
            }
            ob.write("Opcio 1: Veure la matriu del graf\n");
            ob.write("Opcio 2: Veure la Priorityqueue del graf\n");
            ob.write("Opcio 3: Sortir\n");
            caso = ob.readint();
        }
    }
    
}
