/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;
import java.util.Scanner;

/**
 *
 * @author giova
 */
public class CmRm extends Commande{
    private String chemin;
    private String cheminParent;
    private String cible;

    @Override
    public void executer() {
        if(!chemin.contains("/")){
            Navigateur.getInstance().getRepertoireCourant().supprimerElement(chemin);
        }else{String[] tabChemin = chemin.split("/");
            cible = tabChemin[tabChemin.length - 1];
            int i;
            for(i = 0; i < tabChemin.length - 1; i++){
                cheminParent = "";
                cheminParent += tabChemin[i]+ "/";
                
                Repertoire depart = Navigateur.getInstance().getRepertoireCourant();
                
                Navigateur.getInstance().changerRepertoire(cheminParent);
                Navigateur.getInstance().getRepertoireCourant().supprimerElement(cible);
                Navigateur.getInstance().setRepertoireCourant(depart);
            }
            
        }
    }

    @Override
    public void setParametre(String[] parametres) {
        this.chemin = parametres[0];
    }
    
}
