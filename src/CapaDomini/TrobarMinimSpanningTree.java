/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;
import java.util.*; 

/**
 *
 * @author rubencin
 */
    public class TrobarMinimSpanningTree {
    private Graf graf;
    private boolean[] visitat;
    
    private int formaCicle(int a, int b){
        if (visitat[a] ^ visitat[b]) return 0;
        else if (visitat[a] || visitat[b]) return 1;
        else if (!visitat[a] && !visitat[b]) return 2;
        else return 3;
}
    
    public int[][] getSpannningTree(Graf graf){
       PriorityQueue<GrauMinim> pq = graf.consultar_queue_minims();
       int N = graf.consultar_matriu().length;
       ArrayList<GrauMinim> llista = new ArrayList();
       this.visitat = new boolean[N];
       int[][] matriuResultat = new int[N][N]; 
       GrauMinim gm;
       for(int j=0; j<N; j++){
           visitat[j] = false;
           for(int k=0; k<N;k++){
               matriuResultat[k][j]=-1;       
           }
       }
       gm = pq.peek();
       visitat[gm.id1] = true;
       visitat[gm.id2] = true;
       matriuResultat[gm.id1][gm.id2] = gm.grau;
       matriuResultat[gm.id2][gm.id1] = gm.grau;  
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
       return matriuResultat;
    }    
}

 /*
-1 3 12 1 2 3 -1 9 5 4 12 9 -1 2 2 1 5 2 -1 3 2 4 2 3 -1
    
 -1 3 2 5 3 3 -1 1 8 7 2 1 -1 3 5 5 8 3 -1 2 3 7 5 2 -1
    
    11
    -1 7 5 2 9 4 8 3 7 1 5
    7 -1 4 2 7 8 9 9 1 3 4
    5 4 -1 3 5 6 7 6 1 2 5
    2 2 3 -1 1 2 3 4 5 6 7
    9 7 5 1 -1 6 5 4 3 2 1
    4 8 6 2 6 -1 9 9 9 9 7
    8 9 7 3 5 9 -1 7 7 6 7
    3 9 6 4 4 9 7 -1 1 2 3
    7 1 1 5 3 9 7 1 -1 9 4
    1 3 2 6 2 9 6 2 9 -1 2
    5 4 5 7 1 7 7 3 4 2 -1
    */