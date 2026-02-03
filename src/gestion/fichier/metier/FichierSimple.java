/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.Serial;
import java.util.List;


/**
 *
 * @author giova
 */
public class FichierSimple extends Fichier{
    @Serial
   private static final long serialVersionUID = 1562482735474647L;
   private String donnee;
   private List<FichierSimple> fichierSimples;
   
    public FichierSimple(){
        
    }
    
     public FichierSimple(String nom, Repertoire repertoireParent){
        super(nom,repertoireParent);
    }
     
     public FichierSimple (String nom, String donnee){
         super(nom);
         this.donnee = donnee;
     }
     

    @Override
    public int getTaille() {
        return (donnee != null) ? donnee.length() : 0;
    }

    @Override
    public boolean estRepertoire() {
        return false;
    }

    @Override
    public Fichier copier() {
        return new FichierSimple( this.getNom(), this.donnee);
    }
    
    

   
}
