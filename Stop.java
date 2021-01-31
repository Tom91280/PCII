import javax.swing.JOptionPane;

public class Stop extends Thread {
	
	private Etat etat;
	
	/* Constructeur de la classe Voler */
	
	public Stop(Etat etat) {
		this.etat = etat;
	}
	
	/* Méthode run permettant de faire avancer la ligne brisée lorsqu'elle est appeler dans le main */
	
	@Override
	public void run() {
		while(true) {
			if(etat.testPerdu()) {
				JOptionPane.showMessageDialog(null,"Votre score est de : " + Parcours.position,"GAME OVER",JOptionPane.PLAIN_MESSAGE);
			}	
			try {
				Thread.sleep(500);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
