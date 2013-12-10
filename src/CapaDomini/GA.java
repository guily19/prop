/*
* GA.java
* Gestiona els algoritmes per evolucionar la poblacio.
*/

package CapaDomini;

/**
 *
 * @author David Delgado
 */
public class GA {

    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    private static Sequencia s = new Sequencia();

    /**
     * Funcio que evoluciona la poblacio en una generacio
     * @param pop es la poblacio a evolucionar
     * @param sal es la sequencia ordenada dels algorismes anteriors per comparar
     * @return una Population mes optima que al principi o la mateixa si ho es mes
     */
        public static Population evolvePopulation(Population pop, Sequencia sal) {
        Population newPopulation = new Population(pop.populationSize(), false, sal);

        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveSequencia(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Creuament de la poblacio
        // Itera a traves del tamany de les noves populations i crea individuals
        // a partir de la poblacio actual.
        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Selecccio dels pares.
            Sequencia pare1 = tournamentSelection(pop);
            Sequencia pare2 = tournamentSelection(pop);
            // Creuament dels pares.
            Sequencia fill = creuament(pare1, pare2);
            // Afegeix fill a la nova poblacio.
            newPopulation.saveSequencia(i, fill);
        }

        // Muta la nova poblacio
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getSequencia(i));
        }

        return newPopulation;
    }

    /**
     * Funcio que realitza el creument entre dos pares per obtenir un fill
     * @param pare1 es el primer Population del creuament
     * @param pare2 es el segon Population del creuament
     * @return una nova sequencia que es el fill del creuament
     */
        public static Sequencia creuament(Sequencia pare1, Sequencia pare2) {
        // Creció d'una nova sequencia fill.
        Sequencia fill = new Sequencia();

        int startPos = (int) (Math.random() * pare1.sequenciaSize());
        int endPos = (int) (Math.random() * pare1.sequenciaSize());

        for (int i = 0; i < fill.sequenciaSize(); i++) {
       
            if (startPos < endPos && i > startPos && i < endPos) {
                fill.setElement(i, pare1.getElement(i));
            } 
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    fill.setElement(i, pare1.getElement(i));
                }
            }
        }

        for (int i = 0; i < pare2.sequenciaSize(); i++) {
            if (!fill.containsElement(pare2.getElement(i))) {
                for (int ii = 0; ii < fill.sequenciaSize(); ii++) {
                    if (fill.getElement(ii) == null) {
                        fill.setElement(ii, pare2.getElement(i));
                        break;
                    }
                }
            }
        }
        return fill;
    }

    // Muta una sequencia utilitzant una mutacio de swap.
    private static void mutate(Sequencia sequencia) {
        // Itera a traves de les cruilles de la sequencia.
        for(int sequenciaPos1=0; sequenciaPos1 < sequencia.sequenciaSize(); sequenciaPos1++){
            // Aplica el rati de mutacio.
            if(Math.random() < mutationRate){
                // Obte una segona posicio aleatoria a la sequencia.
                int sequenciaPos2 = (int) (sequencia.sequenciaSize() * Math.random());

                // Obte els elements en una posicio concreta de la sequencia
                Element element1 = sequencia.getElement(sequenciaPos1);
                Element element2 = sequencia.getElement(sequenciaPos2);

                // Intercanvia
                sequencia.setElement(sequenciaPos2, element1);
                sequencia.setElement(sequenciaPos1, element2);
            }
        }
    }

    // Selecciona la sequencia candidata per a un creuament.
    private static Sequencia tournamentSelection(Population pop) {
        // Crea una poblacio de torneig.
        Population tournament = new Population(tournamentSize, false);
        // Per cada lloc al torneig obte un candidat sequencia aleatori i l'afegeix.
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveSequencia(i, pop.getSequencia(randomId));
        }
        // Obte la millor sequencia.
        Sequencia fittest = tournament.getFittest();
        return fittest;
    }
}