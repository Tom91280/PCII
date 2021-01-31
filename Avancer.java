public class Avancer extends Thread {
	
	private Affichage affichage;
	private Parcours parcours;
	
	public int timer = 200;
	
	/* Constructeur de la classe Voler */
	
	public Avancer(Affichage affichage, Parcours parcours) {
		this.affichage = affichage;
		this.parcours = parcours;
	}
	
	/* Méthode run permettant de faire avancer la ligne brisée lorsqu'elle est appeler dans le main */
	
	@Override
	public void run() {
		while(Affichage.boucle) {
			parcours.setPosition();
			affichage.revalidate();
			affichage.repaint();		
			try {
				Thread.sleep(timer);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
