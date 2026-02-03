/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author giova
 */
public class CmCp extends Commande{
    private String source;
    private String destination;

    @Override
    public void executer() {
        Repertoire depart = Navigateur.getInstance().getRepertoireCourant();
        Fichier original = Navigateur.getInstance().getRepertoireCourant().trouverElement(source);
        
        try{
            if(original == null){
                throw new FileNotFoundException("la source n'existe pas");
            }
            Fichier fichCopier = original.copier();
            Navigateur.getInstance().changerRepertoire(destination);
            Repertoire arrivee = Navigateur.getInstance().getRepertoireCourant();
            
            if(arrivee.trouverElement(fichCopier.getNom()) != null){
                throw new FileAlreadyExistsException("l'élément  existe déjà dans "+ destination);
            }
            
            arrivee.ajouterFichier(fichCopier);
            fichCopier.setRepertoireParent(arrivee);
            
            System.out.println("copie réussie");
        }catch(FileNotFoundException | FileAlreadyExistsException e){
            System.out.println("erreur : " + e.getMessage());
        }finally{
            Navigateur.getInstance().setRepertoireCourant(depart);
        }

    }

    @Override
    public void setParametre(String[] parametres) {
       if (parametres != null) {
            this.source = parametres[0];
            this.destination = (parametres.length >= 2) ? parametres[1] : ".";
        }
    }
    
}
