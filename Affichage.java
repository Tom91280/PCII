import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Affichage extends JPanel {

		private Etat etat;
	    //private Parcours parcours;
	
		private static final long serialVersionUID = 1L;
		public static final int LARG = 600;
        public static final int HAUT = 400;
        public static final int X_OVAL = 5;
        public static final int LARG_OVAL = 40;
        public static final int HAUT_OVAL = 80;
        
        public static final int MIDX_OVAL = X_OVAL + (LARG_OVAL/2);
        
        public static final int MID_LARG = LARG/2;
        public static final int H_SCORE = 20;
        
        public static boolean boucle = true;
        
        //private String score = "Score :" + parcours.getPosition() ; /* J'ai voulu rajouter + parcours.getPosition() sauf que le jeu plante pour l'affichage du nombre */
        
        
        /* Constructeur de la classe Affichage */
        
        public Affichage(Etat etat) {
        	this.etat = etat;
            setPreferredSize(new Dimension(LARG, HAUT));
        }
        
        /* Fonction paint permetant de tracer notre ovale ainsi que nos lignes */
        
        @Override
        public void paint(Graphics g) {
        	super.paint(g);
        
        	paintOval(g);
        	paintLigne(g);
            //g.drawString(score , MID_LARG, H_SCORE); /* affichage du score en partie */
        }
        
        public void paintOval(Graphics g) {
        	/* Affichage ovale bleu*/
        	g.setColor(Color.blue);
        	g.drawOval(X_OVAL,etat.getHauteur(),LARG_OVAL,HAUT_OVAL);
        }
        
        public void paintLigne(Graphics g) {
        	/* Affichage lignes avec couleur rouge*/
        	g.setColor(Color.red);
        	for(int i=0;i<etat.getParcours().size()-1;i++) {
                g.drawLine(etat.getParcours().get(i).x,etat.getParcours().get(i).y,etat.getParcours().get(i+1).x,etat.getParcours().get(i+1).y);
            }
        }
        
}
