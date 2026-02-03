/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author giova
 */
public class Navigateur {

    private static Navigateur instance;
    private Repertoire repertoireCourant;

    static {
        instance = new Navigateur();
    }

    private Navigateur() {
       
    }

    public static Navigateur getInstance() {
        return instance;
    }

    public Repertoire getRepertoireCourant() {
        return this.repertoireCourant;
    }

    public Repertoire setRepertoireCourant(Repertoire repertoireCourant) {
        return this.repertoireCourant = repertoireCourant;
    }

    public void changerRepertoire(String nom) {
        if (nom == null || nom.length() == 0) {
            return;
        }
        String[] nomsRepertoire = nom.split("/");
        Repertoire r = this.repertoireCourant;
        
        if(nom.startsWith("/")){
            this.repertoireCourant = Fichier.getRoot();
        }
        try {
            this.changerRepertoire(nomsRepertoire);
        } catch (FileNotFoundException e) {
            this.repertoireCourant = r;
        }
    }

    public void changerRepertoire(String[] nomsRepertoire) throws FileNotFoundException {
        for (String nomRepertoire : nomsRepertoire) {
            
            if(nomRepertoire.length() == 0 || nomRepertoire.equals(".")){
                continue;
            }
            
            if (nomRepertoire.equals("..") && this.repertoireCourant.getRepertoireParent() != null) {
                this.repertoireCourant = this.repertoireCourant.getRepertoireParent();
                continue;
            }
            this.repertoireCourant = this.repertoireCourant.getRepertoire(nomRepertoire);
        }
    }
}
