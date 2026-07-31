# Gestionnaire de fichiers en ligne de commande

Ce projet est une application Java de type shell de fichiers, inspirée du comportement d’un terminal Unix. Elle permet de naviguer dans une arborescence de dossiers et de fichiers, de créer, lister, supprimer, copier et déplacer des éléments.

## Fonctionnalités

- Navigation dans les répertoires avec `cd`
- Création de dossiers avec `mkdir`
- Création de fichiers avec `touch`
- Affichage du contenu d’un répertoire avec `ls`
- Suppression d’éléments avec `rm`
- Copie avec `cp`
- Déplacement avec `mv`
- Aide avec `help`
- Quitter l’application avec `exit`

## Structure du projet

- `src/gestion/fichier/Main.java` : point d’entrée de l’application
- `src/gestion/fichier/cli/` : classes de commandes et du parseur
- `src/gestion/fichier/metier/` : logique métier des fichiers et répertoires

## Prérequis

- Java JDK 8 ou plus
- Apache NetBeans ou un environnement Java compatible

## Exécution

### Avec NetBeans

1. Ouvrir le projet dans NetBeans.
2. Cliquer sur “Run Project” ou exécuter la classe `Main`.

### En ligne de commande

Depuis la racine du projet :

```bash
javac -d build/classes $(find src -name "*.java")
javac -cp build/classes gestion.fichier.Main
```

Ou en utilisant Ant :

```bash
ant run
```

## Commandes disponibles

```bash
help
mkdir <nom>
touch <nom>
ls
ls <chemin>
cd <chemin>
cd ..
cd /
rm <nom-ou-chemin>
cp <source> <destination>
mv <source> <destination>
exit
```

## Exemple d’utilisation

```bash
Bonjour !!!

 Taper votre commande :
help
mkdir documents
cd documents
touch note.txt
ls
```

## Notes

Le programme sauvegarde l’état de la structure de fichiers à la fermeture, grâce à la sérialisation Java.

## Auteur

Projet développé en Java dans le cadre d’un exercice de programmation orientée objet par :
Giovanni KOUMEKE
