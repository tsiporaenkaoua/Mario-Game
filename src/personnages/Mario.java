package personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage{
	
	//****VARIABES****//

	private ImageIcon iconMario;
	private Image imageMario;

	
	//****CONSTRUCTEUR****//
	public Mario(int x, int y) {
		super(x, y, 28, 50);//appel du superconstructeur : constructeur de la classe Personnage
		this.iconMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imageMario = this.iconMario.getImage();
	}
	
	
	//****GETTERS****//
	public Image getImageMario() {return imageMario;}

}
