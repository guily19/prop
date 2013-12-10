/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDomini;
import java.util.*;
/**
 *
 * @author Guillem
 */

public class Graf {
    private int[][] matriusimetrica;
    private PriorityQueue <GrauMinim>camins_minims;

    
    public Graf(int[][] matriu){
        this.matriusimetrica = matriu;
        int tam = matriu.length;
        this.camins_minims = new PriorityQueue<GrauMinim>(tam,
            new Comparator<GrauMinim>( ){
                public int compare(GrauMinim a, GrauMinim b){
                    return a.grau - b.grau;
                }
        });
        for(int i = 0; i <  matriusimetrica.length; ++i){
            for(int j = 0; j < matriusimetrica.length; ++j){
                if(i != j && i < j){
                    GrauMinim s = new GrauMinim();
                    s.id1 = i;
                    s.id2 = j;
                    s.grau = this.matriusimetrica[i][j];
                    this.camins_minims.add(s);
                }
            }
        }
    }

    
    public int[][] consultarMatriu (){
        return this.matriusimetrica;
    }
    
    public PriorityQueue consultarQueueMinims(){
        return this.camins_minims;
    }
}

