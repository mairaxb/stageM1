import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
	System.out.println(" Bienvenue dans le jeu Monstre lunaire. ");
	//Definition de varibles du jeu
	Plateau plateau;
	Joueur lejoueur = new Joueur();
	Monstres lesmonstres = new Monstres();
	MonstreEpee lesmonstresEpees = new MonstreEpee();
	MonstreBoomerang lesmonstresBoomerang = new MonstreBoomerang();
	MonstreArcher lesmonstresArcher = new MonstreArcher();
	MonstreBloquant lesmonstresBloquant = new MonstreBloquant();

	
	//Fenetre fen = new Fenetre();

	//Definition des varibales graphiques
	Fenetre frame = new Fenetre(lejoueur);



	//Lancement des fonctions principales
	plateau = new Plateau();
	//init(plateau, lejoueur, lesmonstresEpees, lesmonstresBoomerang, lesmonstresArcher,lesmonstresBloquant);
	//jouer(plateau, lejoueur, lesmonstres, lesmonstresBoomerang, lesmonstresArcher, lesmonstresBloquant);
    }
}
