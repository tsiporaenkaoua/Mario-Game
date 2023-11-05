package jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	private ImageIcon iconBack;
	private Image imageBack1;
	private ImageIcon iconMario;//**PROVISOIRE
	private Image imageMario; //**PROVISOIRE
	private int xBack1;//abcisse du fond
	private int dx; // pr gérer le déplacement du fond
	
	//********CONSTRUCTEUR*********//
	public Scene() {
		
		super();// pour faire appel au constructeur de la superclasse JPanel
		//instanciation des variables
		this.xBack1 = -50;
		this.dx = 0;
		
		iconBack = new ImageIcon(getClass().getResource("/images/fondEcran.png"));//permet de chercher l'image. Puisque notre appli va être un fichier jar et que les fichiers n'auront pas la même place, ne pas utiliser la méthode normal 
		this.imageBack1 = this.iconBack.getImage();
		iconMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imageMario = this.iconMario.getImage();
		
		
		this.setFocusable(true);//focus sur l'ecran
		this.requestFocusInWindow();//recupération du focus
		this.addKeyListener(new Keyboard());//lancement de la réaction à l'evenement
		
		//programme indépendant qui tourne en parralèle du reste : thread 
		//naw Chrono correspond à la tache que le thread doit executer
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	//***********GETTERS**********//
	
	public int getDx() {return dx;}
	
	//**********SETTERS**********//
	
	public void setDx(int dx) { this.dx = dx;}
	
	//********METHODES**********//
	
	public void moveBackground() {
		this.xBack1 = this.xBack1 - this.dx ;
	}
	

	//Cette méthode est utilisée pour dessiner le contenu du composant(JPanel par ex), c'est-à-dire pour personnaliser son apparence en dessinant des formes, du texte, des images, etc.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;//caster en 2D pour une avoir un meilleur rendu
		this.moveBackground();
		g2.drawImage(this.imageBack1,this.xBack1,0, null);
		g2.drawImage(this.imageMario,300,245, null);//*PROVISOIRE
	}
	
	
	

}
