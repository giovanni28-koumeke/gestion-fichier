/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;

/**
 *
 * @author giova
 */
public class CmCd extends Commande {
    private String nom;

    @Override
    public void executer() {
        if(this.nom == null){
            Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
        }else{
            Navigateur.getInstance().changerRepertoire(nom);

        }
    }

    @Override
    public void setParametre(String[] parametres) {
        if(parametres != null ){
            this.nom = parametres[0];
        }else{
            this.nom = null;
        }
    }

   

}

