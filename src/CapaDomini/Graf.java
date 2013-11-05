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

class GrauMinim{
    int id1;
    int id2;
    int grau;
};

public class Graf {
    private int[][] matriusimetrica;
    private PriorityQueue <GrauMinim>camins_minims;
    
    private void llegir_matriu(){
    };
    
    private void llegir_priorityqueue(){
    }
    
    public Graf(){}
    
    public Graf(int[][] matriu, PriorityQueue pq){
        this.matriusimetrica = matriu;
        this.camins_minims = pq;
    }
    
    public void llegir_graf(){
        llegir_matriu();
        llegir_priorityqueue();
    }
    
    public void afegir_element(){
        
    }
    
    public int[][] consultar_matriu (){
        return this.matriusimetrica;
    }
    
    public PriorityQueue consultar_queue_minims(){
        return this.camins_minims;
    }
}
