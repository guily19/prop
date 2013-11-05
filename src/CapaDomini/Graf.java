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
    private PriorityQueue camins_minims;
    
    public Graf(){}
    
    public Graf(int[][] matriu, PriorityQueue pq){
        this.matriusimetrica = matriu;
        this.camins_minims = pq;
    }
    
    public void llegir_graf(){
        
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
