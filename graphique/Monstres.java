public class Monstres extends Element
{
    //Definition des variables
    int vie = 2;
    boolean vivant = true;
    //MonstreEpee monstresEpees = new MonstreEpee();

    //Constructeur
    public Monstres()
    {
	super();
    }

 
    public void findPlayer(Plateau plateau, Joueur lejoueur, int p, MonstreBoomerang lesmonstresBoomerang, MonstreArcher lesmonstresArcher)
    {
	//recuperation position joueur
	int X = lejoueur.getPosition().getX();
	int Y = lejoueur.getPosition().getY();
	
	//

	//portee va definir le type de monstre
	String symbMonstre = "\u03ef";
	if (p==1)
	{ symbMonstre = "\u03ef" ;}
	if (p==3)
	{ symbMonstre = "\u01bf" ;}
	if (p==5)
	{ symbMonstre = "\u262d" ;}

	try
	    {
	
		if(plateau.matrice[X-p][Y-p]!=null)
		    {
			if (plateau.matrice[X-p][Y-p].getSymbole()==symbMonstre)
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X-p][Y]!=null)
		    {
			if (plateau.matrice[X-p][Y].getSymbole()==symbMonstre)
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X-p][Y+p]!=null)
		    {
			if (plateau.matrice[X-p][Y+p].getSymbole()==symbMonstre)
		   
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X-p][Y+p]!=null)
		    {
			if (plateau.matrice[X-p][Y+p].getSymbole()==symbMonstre)
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X][Y-p]!=null)
		    {
			if (plateau.matrice[X][Y-p].getSymbole()==symbMonstre)
		    
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X][Y+p]!=null)
		    {
			if (plateau.matrice[X][Y+p].getSymbole()==symbMonstre)
		    
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X+p][Y-p]!=null)
		    {
			if (plateau.matrice[X+p][Y-p].getSymbole()==symbMonstre)
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }		   
	
		if(plateau.matrice[X+p][Y]!=null)
		    {
			if (plateau.matrice[X+p][Y].getSymbole()==symbMonstre)
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
		if(plateau.matrice[X+p][Y+p]!=null)
		    {
			if (plateau.matrice[X+p][Y+p].getSymbole()==symbMonstre) 
			    {
				lejoueur.attaque();
				if(p==3)
				    {
					lesmonstresArcher.damage(plateau);
				    }
				else if (p==5)
				    {
					lesmonstresBoomerang.damage(plateau);
				    }
			    }
		    }
	    }
	    catch(ArrayIndexOutOfBoundsException e){;}

    }
}
