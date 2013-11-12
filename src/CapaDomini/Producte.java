package CapaDomini;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillem
 */
public class Producte {
    private int id;
    private String nom;
    private String tipus;
    private String subtipus;
    private String conservacio;
    
    public Producte(){}
    
    public Producte(int id, String nom, String tipus, String subtipus, String 
    conservacio){
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.subtipus = subtipus;
        this.conservacio = conservacio;
    };
    
    public void llegir_producte() throws Exception{
        InOut ob = new InOut();
        id = ob.readint();
        nom = ob.readname();
        tipus = ob.readname();
        subtipus = ob.readname();
        conservacio = ob.readname();
    }
    
    public void escriure_producte() throws Exception{
        InOut ob = new InOut();
        ob.write("ID = ");
        ob.write(id);
        ob.write("\n");
        ob.write("Nom: ");
        ob.write(nom);
        ob.write("\n");
        ob.write("Tipus: ");
        ob.write(tipus);
        ob.write("\n");
        ob.write("Subtipus: ");
        ob.write(subtipus);
        ob.write("\n");
        ob.write("Conservació: ");
        ob.write(conservacio);
        ob.write("\n");
        
    }

}
