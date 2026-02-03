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
public class CmMv extends Commande {

    private String source;
    private String destination;

    @Override
    public void executer() {
        Repertoire depart = Navigateur.getInstance().getRepertoireCourant();

        try {
            Fichier original = Navigateur.getInstance().getRepertoireCourant().trouverElement(source);
            if (original == null) {
                throw new FileNotFoundException("la source n'existe pas");
            }

            Navigateur.getInstance().changerRepertoire(destination);
            Repertoire arrivee = Navigateur.getInstance().getRepertoireCourant();

            if (arrivee.trouverElement(original.getNom()) != null) {
                throw new FileAlreadyExistsException("Erreur, l'élément existe déjà dans " + destination);
            }

            depart.getFichier().remove(original);
            original.setRepertoireParent(arrivee);
            arrivee.ajouterFichier(original);

            System.out.println("déplacement réussi");
        } catch (FileNotFoundException | FileAlreadyExistsException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
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
