/*
* Element.java
* Classe Element. 
*/

package CapaDomini;

/**
 *
 * @author David Delgado
 */
public class Element {
    private int id;
    private int x;
    private int y;
    private int[][] mat;
    

    /**
     * Crea una element amb un identificador idelement i les coordenades x i y
     * @param idelement representa l'identificador de l'element
     * @param x es el valor de la coordenada x de l'element
     * @param y es el valor de la coordenada y de l'element
     */
        public Element(int idelement, int x, int y){
        this.x = x;
        this.y = y;
        id = idelement;
    }
    
    /**
     * Crea una element amb un identificador idelement i les coordenades x i y
     * @param idelement representa l'identificador de l'element
     * @param mat representa la matriu d'adjecències del mapa
     */
        public Element(int idelement, int[][] mat){
        this.mat = mat;
        id = idelement;
    }    
        
     /**
     *
     * @return la matriu d'adjecencies del mapa
     */
        public int[][] getMat(){
            return this.mat;
        }
        
    /**
     *
     * @return el valor de la coordenada x de l'element
     */
        public int getX(){
        return this.x;
    }
    

    /**
     *
     * @return la coordenada y de l'element
     */
        public int getY(){
        return this.y;
    }
    

    /**
     *
     * @return l'identificador de l'element
     */
        public int getId() {
        return this.id;
    }
    

    /**
     *
     * @param nouid es el nou identificador que tindra l'element
     */
        public void setId(int nouid) {
        id = nouid;
    }

    /**
     *
     * @param novax es la nova coordenada x de l'element
     */
    public void setX(int novax) {
        x = novax;
    }

    
    /**
     *
     * @param novaMatriu es la nova matriu d'adjacencies del mapa on esta l'element
     */
    public void setMat(int[][] novaMatriu) {
        mat = novaMatriu;
    }
    
    
    /**
     *
     * @param novay es la nova coordenada y de l'element
     */
    public void setY(int novay) {
        y = novay;
    }
    
    
    /**
     * Retorna la distancia fins l'element "element"
     * @param element es el seguent element fins on volem calcular distancia
     * @return un double amb la distancia fins aquell element
     */
        public double distanceTo(Element element){
        int distanciaX = Math.abs(getX() - element.getX());
        int distanciaY = Math.abs(getY() - element.getY());
        //double distancia = Math.sqrt( (distanciaX*distanciaX) + (distanciaY*distanciaY) );
        double distancia = distanciaX+distanciaY;
        return distancia;
    }

    /**
     *
     * @return un string amb l'identificador de l'element 
     */
    @Override
    public String toString(){
        //return getX()+", "+getY();
        String identificador = Integer.toString(id);
        return identificador;
    }
    
}