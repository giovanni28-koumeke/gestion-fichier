/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;



/**
 *
 * @author giova
 */
public class CmLS extends Commande {
    public String cheminCible;
    public String cible;
    
     @Override
    public void executer() {
       if(cheminCible ==null){
           Navigateur.getInstance().getRepertoireCourant().afficherContenu();
       }else{
          Repertoire depart = Navigateur.getInstance().getRepertoireCourant();
          Navigateur.getInstance().changerRepertoire(cheminCible);
          Navigateur.getInstance().getRepertoireCourant().afficherContenu();
          Navigateur.getInstance().setRepertoireCourant(depart);
          
       }
    }
    
    @Override
    public void setParametre(String[] parametres) {
       if(parametres != null){
           this.cheminCible = parametres[0];
       }else{
           cheminCible= null;
       }
    }
}
