/*
* Sequencia.java
* Emmagatzema una sequencia candidata.
*/

package CapaDomini;

import CapaDomini.Element;
import java.util.*;

/**
 *
 * @author David Delgado
 */
public class Sequencia{

    // Guarda la sequencia d'elements
    private ArrayList <Element> sequencia = new ArrayList();
    // Dades en "cache"
    private double fitness = 0;
    private int distancia = 0;
    

    /**
     * Creadora de Sequencia
     */
        public Sequencia(){
        for (int i = 0; i < SequenciaManager.numElements(); i++) {
            sequencia.add(null);
        }
    }
    
    /**
     * Creadora amb un parametre ArrayList 
     * @param sequencia es una ArrayList 
     */
    public Sequencia(ArrayList <Element> sequencia){
        this.sequencia = sequencia;
    }


    /**
     * Operacio que genera una sequencia individual aleatoria
     */
        public void generateIndividual() {
        // Itera a través de totes les cruïlles destí i les afegeix a la sequencia.
        for (int elementIndex = 0; elementIndex < SequenciaManager.numElements(); elementIndex++) {
          setElement(elementIndex, SequenciaManager.getElement(elementIndex));
        }
        // Reordena aleatoriament la sequencia
        Collections.shuffle(sequencia);
    }



    /**
     * Obte un element d'una sequencia
     * @param sequenciaPosition es un enter amb la posicio a la sequencia
     * @return un Element que correspon a la posicio concreta de la sequencia
     */
        public Element getElement(int sequenciaPosition) {
        return (Element)sequencia.get(sequenciaPosition);
    }


    /**
     * Modifica un element a una posicio de la sequencia per un nou element
     * @param sequenciaPosition es un enter amb la posicio del que volem canviar
     * @param element es l'element a canviar
     */
        public void setElement(int sequenciaPosition, Element element) {
        sequencia.set(sequenciaPosition, element);
        // Si la sequencia es veu modificada cal resetejar el fitness i la distancia.
        fitness = 0;
        distancia = 0;
    }
    
    /**
     * Funcio que retorna el fitness de la sequencia
     * @return un double amb el fitness de la sequencia
     */
        public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    /**
     * Retorna la distancia total de la sequencia
     * @return un enter amb la distancia de la sequencia
     */
        public int getDistance(){
        if (distancia == 0) {
            int sequenciaDistancia = 0;
            // Itera a traves dels elements de la sequencia
            for (int elementIndex=0; elementIndex < sequenciaSize(); elementIndex++) {
                // Element d'on venim
                Element fromElement = getElement(elementIndex);
                // Element cap a on anem
                Element elementDesti;
                
                
                if(elementIndex+1 < sequenciaSize()){
                    elementDesti = getElement(elementIndex+1);
                    sequenciaDistancia += fromElement.getMat()[elementDesti.getId()][fromElement.getId()];
                }
                else{
                    elementDesti = getElement(0);
                }
             
                
            }
            distancia = sequenciaDistancia;
        }
        return distancia;
    }


        /**
     * Funcio que retorna el numero d'elements de la sequencia
     * @return un enter que representa el numero d'elements
     */
        public int sequenciaSize() {
        return sequencia.size();
    }
    


    /**
     * Funcio que comprova si la sequencia conte un element
     * @param element es l'element a comprovar
     * @return un boolea que sera true si hi es i false si no hi es
     */
        public boolean containsElement(Element element){
        return sequencia.contains(element);
    }
    
    /**
     *
     * @return un string amb la sequencia d'elements
     */
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < sequenciaSize(); i++) {
            geneString += getElement(i)+"|";
        }
        return geneString;
    }
    
    /**
     * 
     * @return una ArrayList amb la sequencia 
     */
    public ArrayList<Element> getList() {
        return sequencia;
    }
}