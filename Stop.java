import javax.swing.JOptionPane;

public class Stop extends Thread {
	
	private Etat etat;
	
	/* Constructeur de la classe Stop */
	
	public Stop(Etat etat) {
		this.etat = etat;
	}
	
	/* Méthode run permettant d'arrêter le jeu quand l'ovale sors de la ligne brisée */
	
	@Override
	public void run() {
		while(Affichage.boucle) {
			if(etat.testPerdu()) {
				JOptionPane.showMessageDialog(null,"Votre score est de : " + Parcours.position,"GAME OVER",JOptionPane.PLAIN_MESSAGE);
				Affichage.boucle = false;
			}	
			try {
				Thread.sleep(500);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
