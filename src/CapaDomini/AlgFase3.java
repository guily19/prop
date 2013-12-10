/*
 * AlgFase3.java
 */

package CapaDomini;


import java.util.*;

/**
 *
 * @author David Delgado
 */
public class AlgFase3 {
    
    private ArrayList al;       // ArrayList amb el resultat dels algorismes fase 1 i 2
    private int [][] matriu;    // Matriu que representa el mapa 
    private Population pop;
    private int numeroElements; // Número d'elements de l'ArrayList resultant dels algorismes anteriors
    private Pair p;

    /**
     * Creadora per defecte de l'Algoritme Fase 3
     * @param al es una ArrayList amb identificadors dels paquets que intervindran al calcul de la ruta
     * @param mat es una matriu d'enters d'un tamany concret que conte la posicio dels paquets que intervindran a la ruta
     */
    public AlgFase3(ArrayList<Integer> al, int[][] mat) {
        SequenciaManager.cleanCruilles();
        matriu = mat;
        this.al = al;
        numeroElements = al.size();
        ArrayList<Element> sal = new ArrayList<Element>();
        for (int i = 0; i < al.size(); ++i) {
            // Afegeix l'element a la sequencia a calcular
            Element element = new Element(i, matriu);
            SequenciaManager.addElement(element);
            sal.add(element);
        }
        Sequencia seq = new Sequencia(); // Sequencia ArrayList (SAL)
        seq = new Sequencia(sal);
        pop = new Population(50, true, seq);
           
        
        // Evoluciona la poblacio per 50 generacions
        pop = GA.evolvePopulation(pop, seq);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop, seq);
        }

        
    }
    

    /**
     * Retorna un ArrayList amb els identificadors ordenats de la sortida de l'algorisme
     * @return una llista d'enters amb els identificadors dels paquets ordenats 
     */
    
    public ArrayList <Integer> getResult() {
        Sequencia resultat = pop.getFittest();
        ArrayList<Element> al = new ArrayList<Element>();
        al = resultat.getList();
        
        Element e;
        Iterator iter = al.iterator();
        ArrayList <Integer> alfinal = new ArrayList();
        while (iter.hasNext()) {
           e = (Element) iter.next();
           alfinal.add(e.getId());
       }
        return alfinal;
    }
    

    /**
     * 
     * @return un enter amb la distancia recorreguda en el calcul de la ruta
     */
    
    public int getDistance() {
        return (pop.getFittest().getDistance());
    }
   
}
    

