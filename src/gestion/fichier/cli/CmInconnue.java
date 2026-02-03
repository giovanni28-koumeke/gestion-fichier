/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author giova
 */
public class CmInconnue extends Commande {
    @Override
    public void executer() {
        System.out.println("commande Inconnue");
    }
    
    @Override
    public void setParametre(String[] parametres) {
        
    }
}
