/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;
import java.util.*; 

/**
 *
 * @author Ruben Dominguez
 */
public class TrobarMinimSpanningTree {
    private Graf graf;
    private boolean[] visitat;
    
    private int formaCicle(int a, int b){
        if (visitat[a] ^ visitat[b]) return 0;
        else if (visitat[a] || visitat[b]) return 1;
        else return 2;
    }   
    
    private void iniciar_Alg(int mat[][], int tamany, GrauMinim gm){
        for(int j=0; j<tamany; ++j){
           visitat[j] = false;
           for(int k=0; k<tamany; ++k){
               mat[k][j]=-1;       
           }
        }   
       visitat[gm.id1] = true;
       visitat[gm.id2] = true;
       mat[gm.id1][gm.id2] = gm.grau;
       mat[gm.id2][gm.id1] = gm.grau;
    }
    
    public Graf getSpannningTree(Graf graf){
       PriorityQueue<GrauMinim> pq = graf.consultar_queue_minims();
       int N = graf.consultar_matriu().length;
       ArrayList<GrauMinim> llista = new ArrayList();
       visitat = new boolean[N];
       int[][] matriuResultat = new int[N][N];
       if (N==1) matriuResultat[N-1][N-1] = -1;
       else{
        GrauMinim gm;
        gm = pq.peek();
        iniciar_Alg(matriuResultat, N, gm);
        pq.poll();
        while(!pq.isEmpty()){
            gm = pq.peek();
            int x;
            x =formaCicle(gm.id1,gm.id2);
            if (x == 0){
                 visitat[gm.id1] = true;
                 visitat[gm.id2] = true;
                 matriuResultat[gm.id1][gm.id2] = gm.grau;
                 matriuResultat[gm.id2][gm.id1] = gm.grau;
                 pq.poll();
                     while(!llista.isEmpty()){
                         gm = llista.get(0);
                         pq.add(gm);
                         llista.remove(0);
                     }
            }
            else if(x==1) pq.poll();
            else{
                llista.add(pq.peek());
                pq.poll();
            }   
        }
       }
       Graf sol = new Graf(matriuResultat);
       return sol;
    }    
}

