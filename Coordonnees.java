import java.util.*;
public class Coordonnees
    {
	int x = -1;
	int y = -1;

	public Coordonnees(){}
	
	public Coordonnees(int x, int y)
	{
	    this.x=x;
	    this.y=y;
	}

	public int getX()
	{
	    return x;
	}

	public int getY()
	{
	    return y;
	}

	public void setX(int newX)
	{
	    x = newX;
	}

	public void setY(int newY)
	{
	    y = newY;
	}
	    
		
}
