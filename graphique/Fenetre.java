import java.awt.*;
import javax.swing.*;
 
public class Fenetre extends JFrame {
  public Fenetre(Joueur lejoueur){  
	JFrame myFrame = new JFrame("Jeu graphique");
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(new Dimension(1000,1000));
	
        JPanel jp = new JPanel();
	
        //jp.setBackground(new Color(0x00FF00FF));
        JPanel jp2 = new JPanel(new BorderLayout());
        //jp2.setBackground(new Color(0x00000000));

        jp.setPreferredSize(new Dimension(800,800));
        jp2.setPreferredSize(new Dimension(200,200));
        jp2.setLocation(0, 512);

	JLabel jLabelObject = new JLabel();
	jLabelObject.setIcon(new ImageIcon("map20x20.png"));
	jp.add(jLabelObject);

	JLabel vies = new JLabel();
	vies.setText("Nombre de vies : "+lejoueur.getVies());  
	jp2.add(vies, BorderLayout.NORTH);

	
	
	JLabel protec = new JLabel();
	protec.setText("Nombre de protections : "+lejoueur.getProtection());  
	jp2.add(protec, BorderLayout.CENTER);
	

	JLabel obj = new JLabel();
	obj.setText("Nombre d'éléments trouvés: "+lejoueur.getNbrObjets());  
	jp2.add(obj, BorderLayout.SOUTH);

        myFrame.add(jp2, BorderLayout.SOUTH);
        myFrame.add(jp, BorderLayout.NORTH);

	myFrame.setVisible(true);              

  }     
}





/*
  public Frame(){                
    this.setTitle("Ma première fenêtre Java");
    this.setSize(800, 800);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setContentPane(new Panneau());

    this.setVisible(true);
  } 
*/
