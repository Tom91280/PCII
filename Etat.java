import java.awt.Point;
import java.util.ArrayList;

public class Etat {
	
	private Parcours parcours;
	
	private int hauteur = 320;
	private int SAUT = 40;
	private int DESCENTE = 30;
	
	/* Constructeur de la classe Etat */
	
	public Etat(Parcours parcours) {
		this.parcours = parcours;
	}
	
	/* Getter de la hauteur */
	
	public int getHauteur() {
		return hauteur;
	}
	
	/* Méthode jump permettant de faire sauter l'ovale, c'est-à-dire qui diminue la taille de la hauteur du centre de l'ovale par rapport au haut de l'écran (0) sans dépasser l'écran de jeu */
	
	public void jump() {
		if(hauteur > SAUT) {
			this.hauteur = this.hauteur - SAUT;
		}
    }
	
	/* Méthode moveDown permettant de faire descendre l'ovale, cettte fois ci on augmente la taille sans dépasser l'écran de jeu (HAUT) */
	
	public void moveDown() {
		if(hauteur + DESCENTE <= Affichage.HAUT - Affichage.HAUT_OVAL) {
			this.hauteur = this.hauteur + DESCENTE;
		}
	}
	
	/* Méthode getParcours permettant de récuperer la liste des points visibles sur l'écran */
	
	public ArrayList<Point> getParcours() {
		return parcours.getParcours();
    }
	
	public boolean testPerdu() {
		Point p1 = getParcours().get(0);
		Point p2 = getParcours().get(1);
		float pente = ((p1.y) - (p2.y) )/ ((float)(p1.x) - (float)(p2.x));
		float y = p1.y - pente * (p1.x - Affichage.X_OVAL-20);
		//System.out.println(y);
		if(y < hauteur || y > hauteur + Affichage.HAUT_OVAL) {
			return true;
		}
		return false;
	}
}
