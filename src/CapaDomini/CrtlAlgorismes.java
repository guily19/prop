/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDomini;

import java.util.ArrayList;

/**
 *
 * @author guillem
 */
public class CrtlAlgorismes {
    private Graf graf;
    private ArrayList <Integer> solucio = new ArrayList();
    
    
    
    /**
     * Tenim una nova instancia de CrtlAlgorismes amb el Graf graf
     * @param graf 
     */
    public CrtlAlgorismes(Graf graf){
        this.graf = graf;
    }
    /**
     * Aquesta funcio retorna una posible solucio al ordenar els elements que son
     * els indexos de la matriu del Graf graf amb els graus de similitud que tenen aquets amb la resta d'elements del Graf graf
     * @return Retorna un ArrayList amb els identificadors dels elements del Graf graf ordenats segons el seu grau de similitud
     * amb un algoritme senzill
     * @throws Exception 
     */
    public ArrayList <Integer> executarAlgoritme1() throws Exception{
        InOut ob = new InOut();
        AlgoritmeFacil algfacil = new AlgoritmeFacil();
        algfacil.AlgoritmeFacil(graf);
        solucio = algfacil.posibleSolucio();
        //ob.write("Fins aqui tot de wais");
        //AlgFase3 algfase3 = new AlgFase3(solucio, graf.consultar_matriu());
        //solucio = algfase3.getResultat();
        return solucio;
    }
    
    /**
     * Aquesta funcio retorna una posible solucio al ordenar els elements que son
     * els indexos de la matriu del Graf graf amb els graus de similitud que tenen aquets amb la resta d'elements del Graf graf
     * @return Retorna un ArrayList amb els identificadors dels elements del Graf graf ordenats segons el seu grau de similitud
     * amb un algoritme mes complex.
     * @throws Exception 
     */
    public ArrayList <Integer> executarAlgoritme2() throws Exception{
        InOut ob = new InOut();
        TrobarMinimSpanningTree algofase1 = new TrobarMinimSpanningTree();
        Graf mst = algofase1.getSpannningTree(graf);
        AlgFase2 algfase2 = new AlgFase2(mst, graf);
        //AlgFase3 algfase3= new AlgFase3(solucio, graf.consultar_matriu());
        solucio = algfase2.getSolution();
        return solucio;
    }
    
}
