import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
	
	private Affichage affichage;
	private Etat etat;
	
	/* Constructeur de la classe Control */
	
	public Control(Etat etat, Affichage affichage) {
		this.etat = etat;
		this.affichage = affichage;
	}
	
	/* Méthode mouseClicked implémenter par MouseListener permettant de réagir lorsqu'on clique sur notre souris, ici on appelle la méthode jump d'état pour faire sauter l'ovale */
	
	public void mouseClicked(MouseEvent e) {
		etat.jump();
		affichage.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
