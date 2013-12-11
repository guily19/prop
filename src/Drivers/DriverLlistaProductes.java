/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drivers;

import CapaDomini.InOut;
import CapaDomini.LlistaProductes;
import java.util.PriorityQueue;
import java.util.ArrayList;

/**
 *
 * @author guillem
 */
public class DriverLlistaProductes {
    
    
    
    public static void main(String[] args) throws Exception {
        InOut ob = new InOut();
        LlistaProductes llista = new LlistaProductes();
        ob.write("Esriu el id de la llista de productes: ");
        llista.setId(ob.readint());
        ob.write("Esriu el nom de la llista de productes: ");
        llista.setNom(ob.readword());
        ob.write("Elegeix una opcio: \n");
        ob.write("Opcio -1: Sortir \n");
        ob.write("Opcio 1: Veure els identificadors dels productes de la llista\n");
        ob.write("Opcio 2: Añadir ID Producte \n");
        ob.write("Opcio 3: Treure ID producte\n");
        ob.write("Opcio 4: Veure ID de la llista\n");
        ob.write("Opcio 5: Veure Nom de la llista\n");
        
        int caso = ob.readint();
        while(caso != -1){
            switch(caso){
                case -1:{
                    break;
                }
                case 1:{
                    //Añadir producto
                    ob.write("Els identificadors que te la llista son : \n");
                    int tam = llista.getContaproductes();
                    ArrayList <Integer> list = llista.getArrayproductes();
                    for(int i = 0; i < tam; ++i){
                        ob.write(list.get(i));
                        ob.write(" ");
                        ob.write("\n");
                    }
                    break;
                }
                case 2:{
                    //Añadir producto
                    ob.write("Escribe el id del producto : \n");
                    int id = ob.readint();
                    llista.afegirProducte(id);
                    ob.write("Id llegit\n");
                    break;
                }
                case 3:{
                    //Añadir producto
                    ob.write("Quin id vols treure : \n");
                    int id = ob.readint();
                    llista.borrarProducte(id);
                    ob.write("Id tret\n");
                    break;
                }
                case 4:{
                    //Añadir producto
                    ob.write("El Id de la llista es : \n");
                    ob.write(llista.getId());
                    ob.write("\n");
                    break;
                }
                case 5:{
                    //Añadir producto
                    ob.write("El Nom de la llista es : \n");
                    ob.write(llista.getNom());
                    ob.write("\n");
                    break;
                }
                    
            }
            ob.write("Elegeix una opcio: \n");
            ob.write("Opcio -1: Sortir \n");
            ob.write("Opcio 1: Veure els identificadors dels productes de la llista\n");
            ob.write("Opcio 2: Añadir ID Producte \n");
            ob.write("Opcio 3: Treure ID producte\n");
            ob.write("Opcio 4: Veure ID de la llista\n");
            ob.write("Opcio 5: Veure Nom de la llista\n");
            caso = ob.readint();
        }
    }
}
