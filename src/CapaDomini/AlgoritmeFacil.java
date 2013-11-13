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

    public ArrayList <Integer> posible_solucio() throws Exception{
        ArrayList <Integer> sol = new ArrayList<Integer>();
        InOut ob = new InOut();
        int[][] matriu = graf.consultar_matriu();
        PriorityQueue<GrauMinim> cua = graf.consultar_queue_minims();
        int cont;
        if(matriu.length > 1){
            int or = cua.element().id1;
            int ds = cua.element().id2;
            cua.poll();
            sol.add(or);
            sol.add(ds);
            cont = 2;
            boolean[] vis = new boolean[matriu.length];
            vis[or] = true;
            vis[ds] = true;
            or = ds;
            while(cont < matriu.length){
                int min = 0;
                //Calculem el primer min posible
                int i;
                i = 0;
                boolean trobat = false;
                while(!trobat){
                    if (!vis[i] && or != i){
                        min = matriu[or][i];
                        ds = i;
                        trobat = true;
                    }
                    ++i;
                }
                for(int j = 0; j < matriu.length; ++j){
                    if(or != j && !vis[j]){
                        if(min > matriu[or][j]){
                            min = matriu[or][j];
                            ds = j;
                        }
                    }
                }
                sol.add(ds);
                vis[ds] = true;
                or = ds;
                ++cont;
            }   
        }
        return sol;
    }
}
