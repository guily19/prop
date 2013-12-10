/*
 * Pair.java
 */

package CapaDomini;

/**
 *
 * @author David Delgado
 */
public class Pair {
    private int x;
    private int y;
    
    /**
     * Creadora
     */
    public Pair(){
        x = -1;
        y = -1;
    }
    
    /**
     * Creadora amb valors
     * @param x es el parametre x
     * @param y es el parametre y
     */
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Retorna la posicio x
     * @return un enter amb el valor x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Retorna la posicio y
     * @return un enter amb el valor y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Modifica el valor x 
     * @param novax es el nou valor de x
     */
    public void setX(int novax) {
        x = novax;
    }
    
    /**
     * Modifica el valor y
     * @param novay es el nou valor de y
     */
    public void setY(int novay) {
        y = novay;
    }
}
