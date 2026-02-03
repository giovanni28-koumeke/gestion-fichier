/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.FileNotFoundException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class Repertoire extends Fichier {

    @Serial
    private static final long serialVersionUID = 1562482735474647L;
    private List<Fichier> fichiers = new ArrayList<>();
    private String nom;
    private String delateName;
    private boolean suppvalid;

    public Repertoire() {

    }

    public Repertoire(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }

    public Repertoire(String nom) {
        super(nom);
    }

//    public void getCheminSupp(String nom){
//        String[] nomChemin = nom.split("/");
//        delateName = nomChemin[nomChemin.length];
//        supprimerElement(delateName);
//    }
    public void supprimerElement(String nom) {
        suppvalid = fichiers.removeIf(f -> f.getNom().equals(nom));
        if (suppvalid) {
            System.out.println("fichier supprimer");
        } else {
            System.out.println("le fichier n'existe pas");
        }
    }

    public Fichier trouverElement(String nom) {
        for (Fichier fichier : this.fichiers) {
            if (fichier.getNom().equals(nom)) {
                return fichier;
            }
        }
        return null;
    }

    public boolean existeFichier(String nom) {
        for (Fichier fichier : fichiers) {
            if (fichier.getNom().equals(nom) ) {          //&& !estRepertoire()
                return true;
            }
        }
        return false;                       
    }

    public boolean existeRepertoire(String nom) {
        for (Fichier fichier : fichiers) {
            if (fichier.getNom().equals(nom) && estRepertoire()) {
                return true;
            }
        }
        return false;
    }

    public Repertoire getRepertoire(String nom) throws FileNotFoundException {
        if (nom == null) {
            return null;
        }
        if (nom.equals("..")) {
            return this.getRepertoireParent();
        }
        for (Fichier fichier : fichiers) {
            if (fichier.getNom().equals(nom) && fichier.estRepertoire()) {
                return (Repertoire) fichier;
            }
        }
        throw new FileNotFoundException(nom);
    }

    public void ajouterRepertoire(String nom) {
        new Repertoire(nom, this);
    }

    public void ajouterFichier(Fichier elementExistant) {
        if (elementExistant != null) {
            this.fichiers.add(elementExistant);
            elementExistant.setRepertoireParent(this);
        }
    }

    public void ajouterFichierSimple(String nom) {
        new FichierSimple(nom, this);
    }

    public void afficherContenu() {
        for (Fichier fichier : fichiers) {

            System.out.println(fichier.getNom() + "\t");
        }
    }

    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier fichier : fichiers) {
            taille += fichier.getTaille();
        }
        return taille;
    }

    public List<Fichier> getFichier() {
        return this.fichiers;
    }

    @Override
    public boolean estRepertoire() {
        return true;
    }

    @Override
    public Fichier copier() {
        Repertoire Rcopie = new Repertoire(this.getNom());
        for (Fichier fichier : this.fichiers) {
            Rcopie.ajouterFichier(fichier.copier());
        }
        return Rcopie;
    }

}
