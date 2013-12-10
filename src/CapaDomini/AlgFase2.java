package CapaDomini;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Marc Filbà
 * Date: 26/10/13
 * Time: 16:29
 * AlgFase2 és un algorisme que intenta trobar el camí mínim en un graf connex
 */
public class AlgFase2 {
    private Graf gmst;
    private Graf gIni;
    private Graf gWithWay;
       
    /**  Constructora per defecte **/
    public AlgFase2() {}

    /** Constructora amb setter **/
    public AlgFase2 (Graf gmst, Graf gIni) {
        this.gmst = gmst;
        this.gIni = gIni;
        this.gWithWay = gmst;
    }
    
    /**
     * @param gmst
     * Àrbre d'expansió mínim del graf sobre el qual es voldrà executar l'algorisme AlgFase2.
     * 
     * @param gIni 
     * Graf original, del qual s'ha extret l'abre d'expansió mínim anterior.
     */
    public void setData (Graf gmst, Graf gIni) {
        this.gmst = gmst;
        this.gIni = gIni;
        this.gWithWay = gmst;
    }
    
    /**
     * 
     * @param node 
     * Afegeix la branca amb menys pes que conté el graf original i no hi és al àrbre d'expansió mínim.
     */
    private void addMinBranch (int node) {
        int minWeight = Integer.MAX_VALUE;
        int posMinWeight = 0;
        int actualPos;
        int mat [][] = gWithWay.consultarMatriu();
        
        for (int i = 0; i < gIni.consultarMatriu() [node].length; ++i){ 
            actualPos = gIni.consultarMatriu()[node][i];
            if ((actualPos < minWeight) && (actualPos > 0) && (actualPos != (mat[node][i]))){
                minWeight = gIni.consultarMatriu()[node][i];
                posMinWeight = i;
            }
        }
        if (minWeight != Integer.MAX_VALUE){
            mat [node][posMinWeight] = minWeight;
            mat[posMinWeight][node] = minWeight;
            //System.out.println("Afegeixo Branca de " + node + " a " + posMinWeight);
        }
        gWithWay = new Graf(mat);
    }
  /**
   * Afegeix una branca a cada node, per fer-ho invoca a addMinBranch per a cada node.
   */
    private void addBranchEachNode() {
        for (int i = 0; i < gIni.consultarMatriu().length; ++i){
            addMinBranch (i);
        }
    }
    
    /**
     * Per a cada node, busca un camí que passi per tots els nodes i no en repeteixi cap. Per fer-ho executa findWayFromNode per a cada node.
     * @return Retorna el camí si existeix o NULL si no existeix.
     */
    private ArrayList <Integer> findWay () {
        ArrayList <Integer> way = new ArrayList();
        for (int i = 0; i < gmst.consultarMatriu().length && way.isEmpty();++i){
            way = findWayFromNode (i);
        }
        return way;
    }
    /**
     * Comprova que s'hagin visitat tots els nodes, si és el cas, significarà que hi ha un camí possible.
     * @param visited Cada posició indica si s'ha visitat o no el node i. 
     *      Si el seu valor és:
     *          visited [0] = false
     *          visited [1] = true
     *      indica que el node 1 ha estat visitat i que el 0 no.
     * 
     * @return Retorna true si tots els nodes han estat visitats o false si no ha estat així.
     */
    boolean wayOK(boolean visited []) {
        boolean way = true;
        for (int i = 0; i < visited.length && way; ++i){
            if (!visited[i]) way = false;
        }
        return way;
    }
   /**
    * Busca un camí possible donat un node. Funció recursiva.
    * @param node Node des d'on es comença a buscar.
    * @param way  Guarda el camí que va seguin tenir-lo quan acabi el backtracking
    * @param visited Cada posició indica si s'ha visitat o no el node i. 
     *      Si el seu valor és:
     *          visited [0] = false
     *          visited [1] = true
     *      indica que el node 1 ha estat visitat i que el 0 no.
    */
    void BackTrackFromNode (int node, ArrayList <Integer> way, boolean visited []) {
        visited [node] = true;
        way.add(node);
       
        for (int i = 0; i < gWithWay.consultarMatriu().length && !wayOK(visited); ++i){
            if (gWithWay.consultarMatriu()[node][i] > 0 && !visited[i]){
                //System.out.println ("Backtrack de " + node + " cap a " + i);
                BackTrackFromNode(i, way, visited);
                if (!wayOK(visited)){
                    visited[i] = false;
                    way.remove(way.size()-1);
                }
            }
        }
    }
    /**
     * Busca un camí possible donat un node. Per fer-ho crida BackTrackFromNode
     * @param node Node des d'on es comença a buscar.
     * @return Retorna el camí si existeix o NULL si no existeix.
     */
    ArrayList < Integer> findWayFromNode (int node) {
        ArrayList <Integer> way = new ArrayList();
        boolean visited [] = new boolean [gmst.consultarMatriu().length];
        //System.out.println ("Soc a " + node);
        BackTrackFromNode(node, way, visited);
        if (!wayOK(visited)) way = new ArrayList();
        return way;
    }

     /**
      * Busca un camí possible que passi per tots els nodes i no en repeteixi cap, a partir dels grafs gmst i gIni previament settejats.
      * @return Retorna el camí trobat.
      */
    public ArrayList <Integer> getSolution(){
        ArrayList <Integer> way = findWay();
        while (way.isEmpty()){
            addBranchEachNode ();
            way = findWay();
        }
        return way;
    }
}