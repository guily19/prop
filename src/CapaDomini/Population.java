/*
* Population.java
* Gestiona la poblacio de les sequencies candidates.
*/

package CapaDomini;


/**
 *
 * @author David Delgado
 */
public class Population {

    // Emmagatzema la poblacio de les sequencies.
    private Sequencia[] sequencies;

    // Crea una poblacio.

    /**
     * Creadora de poblacio
     * @param populationSize es un enter del tamany de la poblacio
     * @param initialise per si cal inicialitzar les sequencies
     * @param sal es la sequencia de la que partim d'algorismes anteriors
     */
        public Population(int populationSize, boolean initialise, Sequencia sal) {
        sequencies = new Sequencia[populationSize];
        if (initialise) {
            Sequencia newSequencia = sal;
            saveSequencia(0, newSequencia);
            // Itera i crea individuals.
            for (int i = 1; i < populationSize(); i++) {
                newSequencia.generateIndividual();
                saveSequencia(i, newSequencia);
            }
        }
    }
    
    /**
     * Creadora de Population
     * @param populationSize es un enter amb el tamany de la poblacio
     * @param initialise es un boolea per si cal inicialitzar
     */
    public Population(int populationSize, boolean initialise) {
        sequencies = new Sequencia[populationSize];
        // Si necessitem inicialitzar una població de sequencies fem això.
        if (initialise) {
            // Itera i crea individuals.
            for (int i = 0; i < populationSize(); i++) {
            Sequencia newSequencia = new Sequencia();
                newSequencia.generateIndividual();
                saveSequencia(i, newSequencia);
            }
        }
    }
    
    
   

    /**
     * Guarda una sequencia
     * @param index es l'identificador de la sequencia
     * @param seq es la sequencia a guardar 
     */
        public void saveSequencia(int index, Sequencia seq) {
        sequencies[index] = seq;
    }
    
    
    /**
     * Obte la sequencia identificada amb index
     * @param index es l'identificador de la sequencia que volem
     * @return la sequencia obtinguda
     */
        public Sequencia getSequencia(int index) {
        return sequencies[index];
    }

    /**
     * Obte la millor sequencia de la poblacio
     * @return la millor Sequencia
     */
        public Sequencia getFittest() {
        Sequencia fittest = sequencies[0];
        // Itera a través dels individuals per trobar el millor. 
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getSequencia(i).getFitness()) {
                fittest = getSequencia(i);
            }
        }
        return fittest;
    }


    /**
     * Funcio per obtenir el tamany de la poblacio
     * @return un enter amb el tamany de la poblacio
     */
        public int populationSize() {
        return sequencies.length;
    }
}