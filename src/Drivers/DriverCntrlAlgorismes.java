/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drivers;

import CapaDomini.CrtlAlgorismes;
import CapaDomini.Graf;
import CapaDomini.GrauMinim;
import CapaDomini.InOut;
import java.util.*;

/**
 *
 * @author guillem
 */
public class DriverCntrlAlgorismes {
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
    
    private static void escriure_array_int(ArrayList <Integer> sol) throws Exception{
        InOut ob = new InOut();
        int i = 0;
        while(i < sol.size()){
            int n = sol.get(i);
            ob.write(n);
            ob.write(" ");
            ++i;
        }
    }
    
    public static void main(String[] args) throws Exception {
        InOut ob = new InOut();
        ob.write("Indiqui el número de productes que vol posar al prestatge: ");
        int tam = ob.readint();
        int[][] matriu = new int[tam][tam];
        ArrayList <Integer>solucio = null;
        ob.write("Per tal de llegir la matriu de similituds haurà d'escriure totes les similituds d'un producte amb la resta\n");
        ob.write("Format: -1 2 3\n        2 -1 4\n        3 4 -1\n");
        ob.write("Llegim la Matriu: \n");
        llegir_matriu(matriu);
        Graf graf2 = new Graf(matriu);
        int[][] matriu2 = graf2.consultarMatriu();
        CrtlAlgorismes c = new CrtlAlgorismes(graf2);
        //escriure_priorityqueue(graf2.consultarQueueMinims());
        ob.write("Indiqui una opcio: \n");
        ob.write("1.Executar Algorisme Fàcil \n");
        ob.write("2.Executar Algorisme mes Complex \n");
        ob.write("3.Executar Millora \n");
        ob.write("4.Tornar a llegir la matriu \n");
        ob.write("5.Sortir \n");
        int caso = ob.readint();
        while(caso != 5){
            switch(caso){
                case 1:{
                    graf2 = new Graf(matriu);
                    c = new CrtlAlgorismes(graf2);
                    solucio = c.executarAlgoritme1();
                    ob.write("Solucio Facil: \n");
                    escriure_array_int(solucio);
                    ob.write("\n");
                    //ob.write("Suma total de graus: \n");
                    break;
                }
                case 2:{
                    graf2 = new Graf(matriu);
                    c = new CrtlAlgorismes(graf2);
                    solucio = c.executarAlgoritme2();
                    ob.write("Solucio més complexa: \n");
                    escriure_array_int(solucio);
                    ob.write("\n");
                    break;
                }
                case 3:{
                    graf2 = new Graf(matriu);
                    c = new CrtlAlgorismes(graf2);
                    if(solucio == null) ob.write("Primer has de executar un algorisme \n");
                    else{
                        solucio = c.executarMillora(solucio);
                        ob.write("Solucio més complexa: \n");
                        escriure_array_int(solucio);
                        ob.write("\n");
                    }
                    break;
                }
                case 4:{
                    ob.write("Indiqui el nimero de productes que vol posar al prestatge: ");
                    tam = ob.readint();
                    matriu = new int[tam][tam];
                    ob.write("Per tal de llegir la matriu de similituds haurà d'escriure totes les similituds d'un producte amb la resta \n");
                    ob.write("Format: -1 2 3\n        2 -1 4\n       3 4 -1\n");
                    ob.write("Llegim la Matriu: \n");
                    llegir_matriu(matriu);
                    graf2 = new Graf(matriu);
                    matriu2 = graf2.consultarMatriu();
                    c = new CrtlAlgorismes(graf2);
                    break;
                }
                case 5:{
                    break;
                }
            }

            ob.write("Indiqui una opcio: \n");
            ob.write("1.Executar Algorisme Fàcil \n");
            ob.write("2.Executar Algorisme mes Complex \n");
            ob.write("3.Executar Millora \n");
            ob.write("4.Tornar a llegir la matriu \n");
            ob.write("5.Sortir \n");
            caso = ob.readint();
        }
    }
}
