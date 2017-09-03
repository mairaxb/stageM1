public class MonstreArcher extends Monstres
{
    //Definition des variables
    int nbFleches = 2;
    boolean mort = false;

    public MonstreArcher()
    {
	super();
    }

    public void damage(Plateau plateau)
    {
    //si lance son boomerang, 50% de chance de se faire tuer
	nbFleches--;
	if (nbFleches==0)
	    {
		mort = true;
		System.out.println("Monstre mort");
		//monstres a retirer du plateau
 		for (int j=0; j<plateau.matrice.length; j++)
		{  
		    for (int k=0; k<(plateau.matrice.length) ; k++)
			{
				if (plateau.matrice[j][k] != null)
				{
				    String sym = plateau.matrice[j][k].getSymbole();
				    if (sym == "\u01bf")
					{
					    plateau.matrice[j][k]=null;
					}
				}
			}
		}

	    }
    }
}
