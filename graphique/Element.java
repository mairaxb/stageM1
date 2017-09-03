import java.util.*;
public class Element 
    {
	//Definition des variables
	protected String nom = null;
	protected Coordonnees position =null;
	protected String symbole = null;

	protected boolean mort = false;

	//Constructeur
	public Element(){;}
	   
	
	public Element(String pNom, int x, int y, String pSymbole)
	{
	    nom = pNom;
	    position = new Coordonnees(x,y);
	    symbole = pSymbole;
	}

	public Element(String pNom, Coordonnees position, String pSymbole)
	{
	    nom = pNom;
	    this.position = position;
	    symbole = pSymbole;
	}

	//Accesseurs
	public String getNom()
	{
	    return nom;
	}

	public Coordonnees getPosition()
	{
	    return position;
	    
	}
	
	public String getSymbole()
	{
	    return symbole;
	}

	//Mutateurs
	public void setNom(String pNom)
	{
	    nom = pNom;
	}

	public void setCoordonnees(Coordonnees position)
	{
	    this.position = position;
	}

	public void setSymbole(String pSymbole)
	{
	    symbole = pSymbole;
	}
	
	
}
	   
	   
