public class Voler extends Thread {
	
	private Etat etat;
	private Affichage affichage;
	
	/* Constructeur de la classe Voler */
	
	public Voler(Etat etat, Affichage affichage) {
		this.etat = etat;
		this.affichage = affichage;
	}
	
	/* Méthode run permettant de faire descendre l'ovale tout les x temps en le redescinant lorsqu'elle est appeler dans le main */
	
	@Override
	public void run() {
		while(true) {
			etat.moveDown();
			affichage.revalidate();
			affichage.repaint();
			try {
				Thread.sleep(300);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
