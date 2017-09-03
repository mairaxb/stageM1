import java.util.*;
public class Plateau
    {
	//Definition des variables
	public Element[][] matrice;

	//Constructeur
	public Plateau()
	{
	    System.out.println(" Creation de la grille. ");
	    matrice = new Element[20][20];
	}
        
        //Initialisation du plateau 
	public void init()
	{	
	    for(int i = 0; i < matrice.length; i++)
		{
		for(int j = 0; j < matrice[i].length; j++)
		    {
		    matrice[i][j] = null;
		    }
		}
	}
	    
	//Affichage du plateau 
	public void displayBoard()
	{
	    System.out.print("_");
	    for (int i=0; i<(matrice.length/0.67)*2 ; i++)
	    {
		System.out.print("_");
	    }
	    System.out.print("\n");
	    
	    for (int j=0; j<matrice.length; j++)
		{
		   
		    System.out.print("|");
		    for (int k=0; k<(matrice.length) ; k++)
			{
			    //si tableau vide afficher un point
			    if (matrice[j][k] == null)
				{
				    System.out.print(" . ");
				}

			    //si element present afficher element
			     else
				{
				    System.out.print(" "+matrice[j][k].getSymbole()+" " );
				   
				}
			}

		    System.out.print("|\n");
		}
	    System.out.print("|");
	    
	    for (int l=0; l<(matrice.length/0.67)*2 ; l++)
		{
		    System.out.print("_");
		}
	     System.out.print("|\n");

	}

	//positionner element sur plateau
	public void positionner(Element item)
	{
	    int x = item.getPosition().getX();
	    int y = item.getPosition().getY();
	    matrice[x][y] = item; //va donner a la matrice les coordonnees de l'objet item
	    
	}

	
}
	
 
