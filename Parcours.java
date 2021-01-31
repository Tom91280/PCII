import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	public static int position = 0;
	private int X_ESPACE = 0;
	
	private final int POSAV = 10; 
	private final int ESPACE = 100;
	
	public int MIDY_OVAL = 360;
	
	private Random r = new Random();
	
	/* Constructeur de la classe Parcours */
	
	public Parcours() {
		/* On initialise le premier point correspond au centre de l'ovale et un deuxieme à la même hauteur pour avoir une ligne droite au départ */
        points.add(new Point(Affichage.MIDX_OVAL, MIDY_OVAL));
        X_ESPACE += ESPACE;
        points.add(new Point(Affichage.MIDX_OVAL + ESPACE, MIDY_OVAL));
        X_ESPACE += ESPACE;
        /* On initialise les points suivants jusqu'au dernier point qui dépasse l'écran de jeu */
        while(X_ESPACE <= Affichage.LARG + ESPACE) {
        	points.add(new Point(X_ESPACE, r.nextInt(Affichage.HAUT)));
            X_ESPACE += ESPACE;
        }
	}
	
	/* Getter de la position */
	
	public int getPosition() {
		return position;
	}
	
	/* Setter de la position */
	
	public void setPosition() {
		position += POSAV;
		/* On ajoute un point supplémentaire lorsque le dernier point rentre dans la fenêtre visible */
		if(position + Affichage.LARG > points.get(points.size()-1).x) {
			points.add(new Point(X_ESPACE, r.nextInt(Affichage.HAUT)));
			X_ESPACE += ESPACE;
		}
		/* On supprime le premier point de la liste lorsque le deuxième point n'est plus visible */
		if(position > points.get(1).x) {
			points.remove(0);
		}
	}
	
	/* Méthode permettant de récuperer la liste de points visibles sur l'écran */
	
	public ArrayList<Point> getParcours() {
        ArrayList<Point> copie = new ArrayList<>();
        for(int i = 0 ; i < points.size(); i++) {
                copie.add(new Point(points.get(i).x - position, points.get(i).y));
        }
        return copie;
    }
}
