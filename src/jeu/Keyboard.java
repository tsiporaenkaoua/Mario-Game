package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//gère les actions de l'utilisateur donc implémente l'interface 
public class Keyboard implements KeyListener{


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			main.scene.setDx(1);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			main.scene.setDx(-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {main.scene.setDx(0);}

	@Override
	public void keyTyped(KeyEvent e) {
		// inutile dans notre cas
	}

}
