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
	private Image imageBack2;
	private ImageIcon iconCastle1;
	private Image imgCastle1;
	private ImageIcon iconStart;
	private Image imgStart;
	private ImageIcon iconMario;//**PROVISOIRE
	private Image imageMario; //**PROVISOIRE
	
	private int xBack1;//abcisse du fond
	private int xBack2;
	private int dx; // pr gérer le déplacement du fond : a chaque fois qu'on appuis sur les touches droite et gauche ca modifie cette variable en 1 ou -1
	private int xPos;// rajout de cette variable pour gérer l'emplacement des objet dans le fond (chateau...)
	
	//********CONSTRUCTEUR*********//
	public Scene() {
		
		super();// pour faire appel au constructeur de la superclasse JPanel
		//instanciation des variables
		this.xBack1 = -50;
		this.xBack2 = 750;
		this.dx = 0;
		this.xPos = -1;
		
		iconBack = new ImageIcon(getClass().getResource("/images/fondEcran.png"));//permet de chercher l'image. Puisque notre appli va être un fichier jar et que les fichiers n'auront pas la même place, ne pas utiliser la méthode normal 
		this.imageBack1 = this.iconBack.getImage();
		this.imageBack2 = this.iconBack.getImage();
		
		iconCastle1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));//permet de chercher l'image. Puisque notre appli va être un fichier jar et que les fichiers n'auront pas la même place, ne pas utiliser la méthode normal 
		this.imgCastle1 = this.iconCastle1.getImage();
		
		iconStart = new ImageIcon(getClass().getResource("/images/depart.png"));//permet de chercher l'image. Puisque notre appli va être un fichier jar et que les fichiers n'auront pas la même place, ne pas utiliser la méthode normal 
		this.imgStart = this.iconStart.getImage();

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

	public int getxPos() {return xPos;}


	//**********SETTERS**********//
	public void setDx(int dx) { this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setxBack1(int xBack1) {this.xBack1 = xBack1;}

	public void setxBack2(int xBack2) {this.xBack2 = xBack2;}
	
	//********METHODES**********//
	
	public void moveBackground() {
		if(this.xPos >=0) {
			this.xPos = this.xPos + this.dx;
			this.xBack1 = this.xBack1 - this.dx ;
			this.xBack2 = this.xBack2 - this.dx;
		}
		//remettre à zéro nos fond d'écran pour qu'ils tournent en boucle constamment
		if(this.xBack1 == -800) {this.xBack1 = 800;}
		else if(this.xBack2 == -800) {this.xBack2 = 800;}
		else if(this.xBack1 == 800) {this.xBack1 = -800;}
		else if(this.xBack2 == 800) {this.xBack2 =-800 ;}
	}
	

	//Cette méthode est utilisée pour dessiner le contenu du composant(JPanel par ex), c'est-à-dire pour personnaliser son apparence en dessinant des formes, du texte, des images, etc.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;//caster en 2D pour une avoir un meilleur rendu
		this.moveBackground();
		g2.drawImage(this.imageBack1,this.xBack1,0, null);
		g2.drawImage(this.imageBack2,this.xBack2,0, null);
		g2.drawImage(this.imageMario,300,245, null);//*PROVISOIRE
		g2.drawImage(this.imgCastle1,10 -this.xPos,95, null);
		g2.drawImage(this.imgStart,220-this.xPos,234, null);
		
	}
	
	
	

}
