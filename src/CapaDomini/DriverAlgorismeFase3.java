/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;
import CapaDomini.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author david.sola.sole
 */
public class DriverAlgorismeFase3 {
    
    public static void menuAlgorismeFase3(){
        System.out.println("Escull una opcio:");
        System.out.println("1: AlgFase3(ArrayList al, int[][] mat)");
        System.out.println("2: getResultat()");
        System.out.println("3: getDistancia()");
        System.out.println("4: Sortir");
    }
    
    
    private static AlgFase3 creaAlgFase3(AlgFase3 alf3, ArrayList al, int[][] mat,ConversorMatriu cm, Scanner scanner){
        System.out.println("Creacio del objecte AlgFase3...");
        al = new ArrayList();
        System.out.println("");
        System.out.println("Introduccio de dades");
        System.out.println("Introdueix el nombre de files i columnes de la matriu que representa el mapa");
        System.out.print("Nombre de files: ");
        int files, columnes;
        files = scanner.nextInt();
        System.out.print("Nombre de columnes: ");
        columnes = scanner.nextInt();
        mat = new int[files][columnes];
        System.out.println("Introdueix les dades de la matriu (un identificador de cada posicio)");
        int numElements = 0;   // numElements <- # elems != 0
        for(int i=0; i < files; ++i){
            System.out.print("Fila "+i+": ");
            for(int j = 0; j < columnes; ++j){
                mat[i][j] = scanner.nextInt();
                if(mat[i][j]!=0){
                    al.add(mat[i][j]);
                    ++numElements;
                }
            } 
        }
        int [][] matriuConvertida = cm.convertMatrix(mat, numElements);
        alf3 = new AlgFase3(al,matriuConvertida);                    
        System.out.println("Calcul del algorisme de la fase 3 satisfactori");
        System.out.println("");
        return alf3;
    }
    
    private static void getResultatAlgFase3(AlgFase3 alf3, ConversorMatriu cm){
        System.out.println("Obtencio del resultat a partir de l'execucio del algorisme de fase 3...");
        System.out.println("El resultat del algorisme de la fase 3 es el seguent:");
        int [] vid = cm.getId();
        ArrayList <Integer> solucio = new ArrayList();
        solucio = alf3.getResult();
        ArrayList<Integer> solucioFinal = new ArrayList();
        Iterator it = solucio.iterator();
        while (it.hasNext()) {
            int a = (int) it.next();
            solucioFinal.add(vid[a]);
        }
        System.out.println(solucioFinal);
        System.out.println("");
    }
    
    private static void getDistanciaAlgFase3(AlgFase3 alf3){
        System.out.println("Obtencio de la distancia del algorisme de fase 3...");
        System.out.print("La distancia del algorisme de la fase 3 es el seguent: ");
        System.out.println(alf3.getDistance()+" km"); 
        System.out.println("");
    }
    private static void invalid(){
        System.out.println("No has triat una opcio correcta, torna a intentar-ho");
        System.out.println("");
    }
    
    public static void main(String[] args)throws IOException  {
       //System.setIn(new FileInputStream("src/Data/JPDriverAlgorismeFase3.txt"));
       boolean ini = true;     // Evitem 2 menus al inici
       menuAlgorismeFase3();
       Scanner scanner = new Scanner(System.in);
       int opcio = -1;
       ArrayList al = new ArrayList();
       int[][] mat = new int[1][1];
       ConversorMatriu cm = new ConversorMatriu();
       AlgFase3 alf3 = new AlgFase3(al,mat);
        while(opcio != 4){
            if(!ini) menuAlgorismeFase3();
            ini = false;
            opcio = scanner.nextInt();
            switch(opcio) {
                case 1:     // AlgFase3(ArrayList al, int[][] mat)
                    alf3 = creaAlgFase3(alf3,al,mat,cm,scanner);
                    break;            
                case 2:     // getResultat()
                    getResultatAlgFase3(alf3,cm);    
                    break;
                case 3:     // getResultat()
                    getDistanciaAlgFase3(alf3);    
                    break;
                case 4:     // Sortida
                    System.out.println("Sortint...");     
                    break;      
                default:
                    invalid();
                    break;
            }
       }
       
    }
}
