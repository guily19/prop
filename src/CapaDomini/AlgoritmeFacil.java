/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;

import java.util.*;

/**
 *
 * @author guillem
 */
public class AlgoritmeFacil {
    private Graf graf;
    
    
    
    
    
    public void AlgoritmeFacil(Graf graf){
        this.graf = graf;
    }
    
    /**
     *
     * @return
     */
    public ArrayList <Integer> posible_solucio(){
        ArrayList <Integer> sol = new ArrayList<Integer>();
        //Algorithmo
        int[][] matriu = graf.consultar_matriu();
        PriorityQueue<GrauMinim> cua = graf.consultar_queue_minims();
        if(matriu.length > 1){
            int or = cua.element().id1;
            int ds = cua.element().id2;
            cua.poll();
            sol.add(or);
            sol.add(ds);
            boolean[] vis = new boolean[matriu.length];
            vis[or] = true;
            vis[ds] = true;
            
        }
        
        return sol;
    }
}
