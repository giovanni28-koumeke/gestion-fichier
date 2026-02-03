/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author giova
 */
public class CmTouch extends Commande {

    public String nom;

    @Override
    public void executer() {
        if (nom == null) {
            System.out.println("ajoutez le nom du fichier");
            return;
        }

        try {
            if (Navigateur.getInstance().getRepertoireCourant().existeFichier(nom)) {
                throw new FileAlreadyExistsException("l'élément existe déjà");
            }

            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nom);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public void setParametre(String[] parametres) {
        if (parametres != null) {
            this.nom = parametres[0];
        } else {
            this.nom = null;
        }
    }
}
