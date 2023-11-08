package personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu.main;

public class Personnage {

	//****VARIABLES****//
	private int height, width;
	private int x,y;
	private boolean walk;
	private boolean toRight;
	public int counter;//gere la fréquence des pas du pers
	
	
	//****CONSTRUCTEUR****//
	public Personnage(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.counter = 0;
		this.walk = false;
		this.toRight = true;
	}

	
	
	//**** GETTERS****//
	
	public int getHeight() {return height;}

	public int getWidth() {return width;}

	public int getX() {return x;}

	public boolean isWalk() {return walk;}

	public int getY() {return y;}
	
	public boolean isToRight() {return toRight;}
	
	public int getCounter() {return counter;}

	
	
	//****SETTERS****//

	public void setX(int x) {this.x = x;}
	
	public void setY(int y) {this.y = y;}

	public void setWalk(boolean walk) {this.walk = walk;}

	public void setToRight(boolean toRight) {this.toRight = toRight;}

	public void setCounter(int counter) {this.counter = counter;}
	
	
	//****METHODES****//
	
	public Image walk(String nom, int frequence) {
		String str;
		ImageIcon icon;
		Image img;
		
		if(this.walk == false || main.scene.getxPos()<=0) {
			//image quand on ne bouge pas
			if(this.toRight) {str = "/images/"+ nom + "ArretDroite.png";}
			else {str = "/images/"+ nom + "ArretGauche.png";}
		}else {
			this.counter++;//a chaque pixel parcouru on rentre dans cette boucle et donc on augmente le compteur
			if(this.counter / frequence == 0) {//counter et frequence sont des entier, en java le type du résultat sera un entier
				if(this.toRight) {
					str = "/images/"+ nom + "ArretDroite.png";
				}else{str = "/images/"+ nom + "ArretGauche.png";}	 
			}else {
				if(this.toRight) {
					str = "/images/"+ nom + "MarcheDroite.png";
				}else{str = "/images/"+ nom + "MarcheGauche.png";}	
			}
			if(this.counter == 2 * frequence) {
				this.counter = 0;
			}
		}
		//Affichage de l'image du personnage
		icon = new ImageIcon(getClass().getResource(str));
		img = icon.getImage();
		return img;
	}
	
	/*
	 * Création d'une méthode walk qui associe :
	 * l'image du pers a l'arret quand le bouton du clavier est relaché
	 * l'image du pers qui va à gauche ou à droite en fonction de la key enfoncé
	 * lorsque les keys de mouvements sont activé, il ya succession d'image du pers en mouvement, et a l'arret pour simuler le mouvement:
	 *  cela est géré grace à un compteur et une fréquence (tous les 25px de mouvement on switch d'image)
	 * */
	
	
	
	
}
