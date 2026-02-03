/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author giova
 */
public class CmAide extends Commande {
    @Override
    public void executer() {
        System.out.println("Exit : Quitter le programme");
        System.out.println("Help : aide");
    }
    
    @Override
    public void setParametre(String[] parametres) {
        
    }
}
