import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class MainJeu {
    public static void main(String[] args){
	System.out.println(" Bienvenue dans le jeu Monstre lunaire. ");
	//Definition de variables
	Plateau plateau;
	Joueur lejoueur = new Joueur();
	Monstres lesmonstres = new Monstres();
	MonstreEpee lesmonstresEpees = new MonstreEpee();
	MonstreBoomerang lesmonstresBoomerang = new MonstreBoomerang();
	MonstreArcher lesmonstresArcher = new MonstreArcher();
	MonstreBloquant lesmonstresBloquant = new MonstreBloquant();
	

	//Lancement des fonctions principales
	plateau = new Plateau();
	init(plateau, lejoueur, lesmonstresEpees, lesmonstresBoomerang, lesmonstresArcher,lesmonstresBloquant);
	instructions();
	jouer(plateau, lejoueur, lesmonstres, lesmonstresBoomerang, lesmonstresArcher, lesmonstresBloquant);
 
    }

    public static void init(Plateau plateau, Joueur lejoueur, MonstreEpee lesmonstresEpees, MonstreBoomerang lesmonstresBoomerang, MonstreArcher lesmonstresArcher, MonstreBloquant lesmonstresBloquant)
    {
        //initialisation du plateau
	plateau.init();
	
	//init du joueur
	initPos(lejoueur, 10, 10, "\u001B[33m\u265e\u001B[0m");
	plateau.positionner(lejoueur);

	//init sortie
	Element sortie = new Element();
	initPos(sortie, 0, 0, "\u001B[32m\u2b58\u001B[0m");
	plateau.positionner(sortie);

	//init objectifs
	Objectifs obj1 = new Objectifs();
	Objectifs obj2 = new Objectifs();
	Objectifs obj3 = new Objectifs();
	
	initPos(obj1, 1, 8, "\u001B[31m\u2055\u001B[0m");
	plateau.positionner(obj1);
	
	initPos(obj2, 8, 5, "\u001B[31m\u25ca\u001B[0m");
	plateau.positionner(obj2);

	initPos(obj3, 17, 12, "\u001B[31m\u2605\u001B[0m");
	plateau.positionner(obj3);
	
	//init obstacles
	Obstacles barriere = new Obstacles();
	Obstacles interdiction = new Obstacles();
	

	initPos(barriere, 1, 5, "\u001B[34m\u1699\u001B[0m");
	plateau.positionner(barriere);
	initPos(interdiction, 10, 18, "\u001B[34m\u2b59\u001B[0m");
	plateau.positionner(interdiction);


	//init des monstres 
	for(int i = 0; i < 5; i++)
	{
            //monstres epees  
            Random r1 = new Random();
            int a = r1.nextInt(20);
            Random r2 = new Random();
            int b = r2.nextInt(20);
            
            if (a!=10 && b!=10)
            {
	    initPos(lesmonstresEpees,a,b,"\u03ef");
            plateau.positionner(lesmonstresEpees);
            }

	    //monstres boomerang
	    Random r3 = new Random();
            int c = r3.nextInt(20);
            Random r4 = new Random();
            int d = r4.nextInt(20);
            
	    if (plateau.matrice[c][d]== null)
            {  
            initPos(lesmonstresBoomerang,c,d,"\u262d");
            plateau.positionner(lesmonstresBoomerang);
            }

	    //monstres archers
	    Random r5 = new Random();
            int e = r5.nextInt(20);
            Random r6 = new Random();
            int f = r6.nextInt(20);
            
	    if (plateau.matrice[e][f]== null)
            {  
            initPos(lesmonstresArcher,e,f,"\u01bf");
            plateau.positionner(lesmonstresArcher);
            }

	    //monstres bloquant
	    Random r7 = new Random();
            int g = r7.nextInt(20);
            Random r8 = new Random();
            int h = r8.nextInt(20);
            
	    if (plateau.matrice[g][h]== null)
            {  
            initPos(lesmonstresBloquant,g,h,"\u105d");
            plateau.positionner(lesmonstresBloquant);
            }
    
        }
	
	//affichage du plateau de depart
	plateau.displayBoard();

    }

    public static void initPos(Element item, int x, int y, String symb)
    {
	Coordonnees cord = new Coordonnees(x,y);
	
	item.setCoordonnees(cord);
	item.setSymbole(symb);
    }

    public static int addDirection()
    {
 	{
	    try
		{
		    BufferedReader buff = new BufferedReader
			(new InputStreamReader(System.in));
		    String chaine= buff.readLine();
		    if (chaine.equals("8") || chaine.equals("\u001B[A"))
			{chaine = "8";}
		    if (chaine.equals("2") || chaine.equals("\u001B[B"))
			{chaine = "2";}
		    if (chaine.equals("4") || chaine.equals("\u001B[D"))
			{chaine = "4";}
		    if (chaine.equals("6") || chaine.equals("\u001B[C"))
			{chaine = "6";}
		    int num = Integer.parseInt(chaine);
		    return num;
		}
	    catch(IOException e){return 0;}
	    catch(NumberFormatException f){return 0;}
	}
    }

    
    //pour le deplacement du joueur
    public static void deplacementJoueur(Plateau plateau, Joueur lejoueur)
    {
	//recuperer ancienne position du joueur;
	int oldPosX = lejoueur.getPosition().getX();
	int oldPosY = lejoueur.getPosition().getY();
	int newPosX = lejoueur.getPosition().getX();
	int newPosY = lejoueur.getPosition().getY();
	System.out.println("Veuillez entrer une position à l'aide des flèches");
	switch(addDirection())
	    {
	    case 4 : newPosY--;
		break;
	    case 6 : newPosY++;
		break;
	    case 8 : newPosX--;
		break;
	    case 2 : newPosX++;
		break;
	    }
	
	//on remet l'ancienne position comme nulle
	plateau.matrice[oldPosX][oldPosY] = null;
	
	//on met a jour la nouvelle position du joueur si la case jouée est vide
	if((plateau.matrice[newPosX][newPosY])==null)
	    {
		initPos(lejoueur, newPosX, newPosY, "\u001B[33m\u265e\u001B[0m");
		plateau.positionner(lejoueur);
	    }

	//si nouvelle position contient un element
	else if((plateau.matrice[newPosX][newPosY])!=null)
	    {
		//recuperation du symbole de l'element present
		String symb = plateau.matrice[newPosX][newPosY].getSymbole();

		
		//initialisation des array contenant les symboles des differents elements
		String [] arrayObjets = {"\u001B[31m\u2055\u001B[0m", "\u001B[31m\u25ca\u001B[0m", "\u001B[31m\u2605\u001B[0m"};
		String [] arrayObstacles= {"\u001B[34m\u1699\u001B[0m", "\u001B[34m\u2b59\u001B[0m"};


		//comparaison pour connaitre le type de symbole et donc le type d'element
		//si c'est un objet a recuperer
		for (int i = 0; i < arrayObjets.length; i++)
		    {
		    if(symb==arrayObjets[i])
			{
			    initPos(lejoueur, newPosX, newPosY, "\u001B[33m\u265e\u001B[0m");
			    plateau.positionner(lejoueur);
			    lejoueur.setNbrObjets(lejoueur.getNbrObjets()+1);
			}
		    }

		//si c'est un obstacle
		for (int a = 0; a < arrayObstacles.length; a++)
		    {
		    if(symb==arrayObstacles[a])
			{
			    initPos(lejoueur, oldPosX, oldPosY, "\u001B[33m\u265e\u001B[0m");
			    plateau.positionner(lejoueur);
			    System.out.println("Vous venez de percuter un obstacle.");
			    lejoueur.attaque();
			}
		    }

		//si c'est la sortie
		if(symb=="\u001B[32m\u2b58\u001B[0m")
		    {
			int obj = lejoueur.getNbrObjets();
			if(obj!=3)
			    {
				initPos(lejoueur, oldPosX, oldPosY, "\u001B[33m\u265e\u001B[0m");
				plateau.positionner(lejoueur);
			    }
			if(obj==3)
			    {
				initPos(lejoueur, newPosX, newPosY, "\u001B[33m\u265e\u001B[0m");
				plateau.positionner(lejoueur);
				   
			    }
		    }

	    }
    }

    //pour le deplacement du monstre bloquant(seul monstre qui se deplace)
    public static void deplacementMonstre(Plateau plateau, MonstreBloquant lesmonstresBloquant)
    {
	try
	    {
		for (int j=0; j<plateau.matrice.length; j++)
		    {  
			for (int k=0; k<(plateau.matrice.length) ; k++)
			    {
				if (plateau.matrice[j][k] != null)
				    {
					String sym = plateau.matrice[j][k].getSymbole();
					if (sym == "\u105d")
					    {
			        
						int a =  lesmonstresBloquant.getPosition().getX();
						int b =  lesmonstresBloquant.getPosition().getY();
						int c =  lesmonstresBloquant.getPosition().getX();
						int d =  lesmonstresBloquant.getPosition().getY();

						plateau.matrice[a][b]=null;
						c--;
						d--;
					
						if(plateau.matrice[j--][k--]!=null)
						    {
							initPos(lesmonstresBloquant,c,d,"\u105d");
							plateau.positionner(lesmonstresBloquant);
						    }
					    }
				    }
			    }
		    }
	    }
		catch(ArrayIndexOutOfBoundsException e){;}

    }

    public static boolean finJeu(Plateau plateau, Joueur lejoueur)
    {
	//on recupere la position du joueur
	int PosX = lejoueur.getPosition().getX();
	int PosY = lejoueur.getPosition().getY();

	if((PosX==0 &&PosY==0) && lejoueur.getNbrObjets()==3)
	    {
		return true;
	    }
	else{return false;}
    }

    public static void instructions()
    {
	System.out.println("Le joueur est représenté par le pion jaune.");
	System.out.println("Les obstacles sont en bleu.");
	System.out.println("Les éléments à récupérer sont en rouge.");
	System.out.println("Les monstres sont en blanc.");
	System.out.println("Le but est de récupérer les éléments en rouge et de trouver la sortie en échappant aux monstres.");
		    
	System.out.println("Utiliser les fleches du clavier pour vous déplacer à chaque tour.");
	System.out.println("C'est partie !");

    }


    public static boolean jouer(Plateau plateau, Joueur lejoueur, Monstres lesmonstres, MonstreBoomerang lesmonstresBoomerang, MonstreArcher lesmonstresArcher, MonstreBloquant lesmonstresBloquant)
    {
        while(true)
        {
            plateau.displayBoard();
	    lejoueur.displayState();
	    deplacementJoueur(plateau, lejoueur);
	    //deplacement des monstres
	    lesmonstres.findPlayer(plateau, lejoueur, 1,lesmonstresBoomerang, lesmonstresArcher);
	    lesmonstres.findPlayer(plateau, lejoueur, 3,lesmonstresBoomerang, lesmonstresArcher);
	    lesmonstres.findPlayer(plateau, lejoueur, 5,lesmonstresBoomerang, lesmonstresArcher);
	    deplacementMonstre(plateau, lesmonstresBloquant);

	    
	    if(lejoueur.getVies()==0)
		{
		    System.out.println("GAME OVER.");
		    return false;
		}
	    if(finJeu(plateau, lejoueur))
		{
		    System.out.println("V I C T O I R E !");
		    return false;
		}

        }
            
    }
    
    
}
