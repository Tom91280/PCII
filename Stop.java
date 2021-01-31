import javax.swing.JOptionPane;

public class Stop extends Thread {
	
	private Etat etat;
	
	/* On test si on a perdu tout les "timer" temps (en ms) */
	public int timer = 500;
	
	/* Constructeur de la classe Stop */
	
	public Stop(Etat etat) {
		this.etat = etat;
	}
	
	/* Méthode run permettant d'arrêter le jeu quand l'ovale sors de la ligne brisée */
	
	@Override
	public void run() {
		while(Affichage.boucle) {
			if(etat.testPerdu()) { /* Boucle permettant d'envoyer un message de retour dans une nouvelle fenêtre avec le score du joueur et permettant aussi de fermer les threads courants */
				JOptionPane.showMessageDialog(null,"Votre score est de : " + Parcours.position,"GAME OVER",JOptionPane.PLAIN_MESSAGE);
				Affichage.boucle = false;
			}	
			try {
				Thread.sleep(timer);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
