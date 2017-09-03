public class Joueur extends Element			    
    {
	//Definition des variables
	protected int nbrVies = 3;
	protected int protection = 4;
	protected int nbrObj = 0;
	protected boolean mort = false;

	//Constructeur par defaut
	public Joueur()
	{
	    super();
	}

	public Joueur(String nom, Coordonnees position, String symbole, int nbrVies, int protection, int nbrObj)
	{
	    super(nom, position, symbole);
	    this.nbrVies = nbrVies;
	    this.protection = protection;
	    this.nbrObj = nbrObj;
	}

	//Accesseuer
	public int getVies()
	{
	    return nbrVies;
	}

	public int getProtection()
	{
	    return protection;
	}

	public int getNbrObjets()
	{
	    return nbrObj;
	}

	//Mutateur
	public void setVies(int pVies)
	{
	    nbrVies = pVies;
	}

	public void setProtection (int pProtection)
	{
	    protection = pProtection;
	}

	public void setNbrObjets(int pObjets)
	{
	    nbrObj = pObjets;
	}
	


	//afficher etat du joueur
	public void displayState()
	{
	    System.out.println("Nombre de vies : "+ nbrVies);
	    System.out.println("Protection : "+ protection);
	    System.out.println("Nombre d'éléments trouvés : "+ nbrObj);
	    
	}

	//diminution de vies/protection apres attaque de monstres
	public void attaque()
	{
	    protection--;
	    if (protection == -1)
		{
		    nbrVies--;
		    protection = 4;
		}
	    else if (nbrVies == 0 && protection == 0)
		{
		    mort = true;
		}
	}

	
}

	
	    
