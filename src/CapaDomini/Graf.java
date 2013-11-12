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
    
    private void llegir_matriu_i_queue() throws Exception{
        InOut ob = new InOut();
        for(int i = 0; i <  matriusimetrica.length; ++i){
            for(int j = 0; j < matriusimetrica.length; ++j){
                matriusimetrica[i][j] = ob.readint();
                if(i != j){
                    GrauMinim s = new GrauMinim();
                    s.id1 = i;
                    s.id2 = j;
                    s.grau = this.matriusimetrica[i][j];
                    this.camins_minims.add(s);
                }
        
            }
        }
 };
    
    private void llegir_priorityqueue(){
    };
    
    public Graf(){}
    
    public Graf(int[][] matriu){
        this.matriusimetrica = matriu;
        int tam = matriu.length;
        this.camins_minims = new PriorityQueue<GrauMinim>(tam,
            new Comparator<GrauMinim>( ){
                public int compare(GrauMinim a, GrauMinim b){
                    return a.grau - b.grau;
                }
        });
        GrauMinim s = new GrauMinim();
        for(int i = 0; i < matriu.length; ++i){
            for(int j = 0; j < matriu.length; ++j){
                if(i != j){
                    s.id1 = i;
                    s.id2 = j;
                    s.grau = this.matriusimetrica[i][j];
                    this.camins_minims.add(s);
                }
            }
        }
    }
    
    public void llegir_graf() throws Exception{
        InOut ob = new InOut();
        ob.write("Escribir tamany matriu: ");
        int tam = ob.readint();
        this.matriusimetrica = new int[tam][tam];
        this.camins_minims = new PriorityQueue<GrauMinim>(tam,
            new Comparator<GrauMinim>( ){
                public int compare(GrauMinim a, GrauMinim b){
                    return a.grau - b.grau;
                }
        });
        llegir_matriu_i_queue();
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

