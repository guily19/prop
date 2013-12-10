

package CapaDomini;

import java.util.ArrayList;

/**
 *
 * @author David Delgado
 */
public class SequenciaManager {

    private static ArrayList destinationCruilles = new ArrayList();


    /**
     * Afegim un element desti nou
     * @param element es l'element afegit
     */
        public static void addElement(Element element) {
        destinationCruilles.add(element);
    }
    

    /**
     *
     * @param index es l'identificador de l'element que fem el get
     * @return un Element amb identificador index
     */
        public static Element getElement(int index){
        return (Element)destinationCruilles.get(index);
    }
    

    /**
     * Aquesta operacio retorna el numero d'elements
     * @return un enter amb el numero d'elements
     */
        public static int numElements(){
        return destinationCruilles.size();
    }
    
    /**
     * Neteja els elements per executar un altre cop l'algorisme amb dades noves
     */
    public static void cleanCruilles(){
        destinationCruilles = new ArrayList();
    }
}