public class Avancer extends Thread {
	
	private Affichage affichage;
	private Parcours parcours;
	
	/* Constructeur de la classe Voler */
	
	public Avancer(Affichage affichage, Parcours parcours) {
		this.affichage = affichage;
		this.parcours = parcours;
	}
	
	/* Méthode run permettant de faire avancer la ligne brisée lorsqu'elle est appeler dans le main */
	
	@Override
	public void run() {
		while(true) {
			parcours.setPosition();
			affichage.revalidate();
			affichage.repaint();
			/* System.out.println(parcours.getParcours() + "/n"); (je vérifiais que le premier élément de la liste sois bien supprimer à chaque fois */			
			try {
				Thread.sleep(200);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
