import javax.swing.JFrame;

public class Main {
	
	public static void main(String [] args) {
        
		Parcours parcours = new Parcours();
        Etat etat = new Etat(parcours);
        Affichage affichage = new Affichage(etat);
        Control control = new Control(etat, affichage);
        
        /* Création de la fenêtre de jeu */
        
        JFrame jeu = new JFrame("Flappy Bird");
        jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jeu.add(affichage);
        jeu.pack();
        jeu.setVisible(true);
        
        /* Ajout de notre méthode pour pouvoir faire sauter notre ovale */

	    affichage.addMouseListener(control);
	        
	    /* Ajout de notre thread permettant de faire redescendre notre ovale tout les x temps */
	        
	    (new Thread(new Voler(etat, affichage))).start();
	        
	    /* Ajout de notre thread permettant de faire avancer la ligne brisée tout les x temps */
	        
	    (new Thread(new Avancer(affichage, parcours))).start();
	    
	    /* Ajout de notre thread permettant de vérifier qu'on ne perd pas */
	    
	    (new Thread(new Stop(etat))).start();
 
	}
}
