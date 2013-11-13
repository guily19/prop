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
    /*
    -1 3 12 1 2
    3 -1 9 5 4
    12 9 -1 2 2
    1 5 2 -1 3
    2 4 2 3 -1
    
    */

    
    public int[][] getSpannningTree(Graf graf){
       PriorityQueue<GrauMinim> pq = graf.consultar_queue_minims();
       Queue<GrauMinim> q;
       q = pq; //cua = prioritycua
       //Iterator it = pq.iterator();
       int N = graf.consultar_matriu().length;
       this.visitat = new boolean[N];
       int[][] matriuResultat = new int[N][N]; 
       GrauMinim gm;
       for(int j=0; j<N; j++){
           visitat[j] = false;
           for(int k=0; k<N;k++){
               matriuResultat[k][j]=-1;       
           }
       }
       gm = q.peek();
       visitat[gm.id1] = true;
       visitat[gm.id2] = true;
       matriuResultat[gm.id1][gm.id2] = gm.grau;
       matriuResultat[gm.id2][gm.id1] = gm.grau;  
       q.poll();
      
       
       while(!q.isEmpty()){
           gm = q.peek();
           int x;
           x =formaCicle(gm.id1,gm.id2);
           if (x == 0){
            visitat[gm.id1] = true;
            visitat[gm.id2] = true;
            matriuResultat[gm.id1][gm.id2] = gm.grau;
            matriuResultat[gm.id2][gm.id1] = gm.grau;
            q.poll();
            
           }
           else if(x==1){
               q.poll();
           }
           else{
               
               
           }
           
           
       }
               
       
       return matriuResultat;
    }
    
    
}
