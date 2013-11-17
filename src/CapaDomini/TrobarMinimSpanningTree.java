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
    private Graf graf; //Graf amb la matriu i PriorityQueue al qual aplicarem el MST
    private boolean[] visitat; //Vector de Booleans per saber si es forma cicle
    
    /**
     * Funció que mira si es forma un cicle en el MST
     * @param a es un identificador d'un valor de la matriu. 
     * @param b es un identificador d'un valor de la matriu.
     * @return un int amb diferents valors. 0 si hem d'agafar els id's pel msp, 1 si l'hem de descartar i 2 si l'hem de guardar.
     */
    private int formaCicle(int a, int b){
        if (visitat[a] ^ visitat[b]) return 0; //Si xor cert return 0
        else if (visitat[a] || visitat[b]) return 1;//Si v[a] i v[b] són certs return 1
        else return 2; //Si els 2 no estan visitats return 2
    }  
    
    /**
     * Accio que inicialitza els primers valors del algoritme.
     * @param mat es una matriu buida
     * @param tamany es el tamany de la matriu
     * @param gm es el primer valor de la priorityqueue
     */
    private void iniciar_Alg(int mat[][], int tamany, GrauMinim gm){
        for(int j=0; j<tamany; ++j){ 
           visitat[j] = false; //Inicialitzacio del vector de booleans tot a false
           for(int k=0; k<tamany; ++k){
               mat[k][j]=-1; //Inicialitzacio de la matriu del mst tot a -1
           }
        }   
       //Posem els primers valors de la priorityqueue a la matriu i els posem com a visitats en el vector. 
       visitat[gm.id1] = true;
       visitat[gm.id2] = true;
       mat[gm.id1][gm.id2] = gm.grau;
       mat[gm.id2][gm.id1] = gm.grau;
    }
    
    /**
     * Creador per defecte de l'algoritme MST
     * @param graf es un Graf amb la matriu de productes i priorityqueue d'aquests ordenats per GrauMinim
     * @return Un graf on la matriu és el resultat d'un MST amb el valor -1 entre els vertex no adjacents.
     */
    public Graf getSpannningTree(Graf graf){
       PriorityQueue<GrauMinim> pq = graf.consultar_queue_minims();
       int N = graf.consultar_matriu().length;
       ArrayList<GrauMinim> llista = new ArrayList();
       visitat = new boolean[N];
       int[][] matriuResultat = new int[N][N];
       if (N==1) matriuResultat[N-1][N-1] = -1; //Cas base
       else{
        GrauMinim gm;
        gm = pq.peek();
        iniciar_Alg(matriuResultat, N, gm);
        pq.poll();
        while(!pq.isEmpty()){
            gm = pq.peek();
            int x;
            x =formaCicle(gm.id1,gm.id2); //x ens dira que hem de fer amb l'element gm de la priorityqueue
            if (x == 0){ //Si hem d'agafar l'element, modifiquem la matriuResultat i posem a visitats
                 visitat[gm.id1] = true;
                 visitat[gm.id2] = true;
                 matriuResultat[gm.id1][gm.id2] = gm.grau;
                 matriuResultat[gm.id2][gm.id1] = gm.grau;
                 pq.poll();
                 //Despres de modificar la matriu mirem si tenim elements ja visitats pero guardats a la llista
                     while(!llista.isEmpty()){ //Si no esta buida tornem els elements a la priorityqueue
                         gm = llista.get(0);
                         pq.add(gm);
                         llista.remove(0);
                     }
            }
            //Si es forma cicle descartem l'element de priorityqueue
            else if(x==1) pq.poll();
            else{ //Si cap dels dos elements esta visitat el guardem a una llista per tornarlo a visitar mes tard
                llista.add(pq.peek());
                pq.poll();
            }   
        }
       }
       Graf sol = new Graf(matriuResultat);
       return sol;
    }    
}

