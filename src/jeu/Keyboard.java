package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//gère les actions de l'utilisateur donc implémente l'interface 
public class Keyboard implements KeyListener{


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			//met xPos a 0 pour pouvoir mettre en mouvement le fond 
			if(main.scene.getxPos() == -1) {
				main.scene.setxPos(0);
				main.scene.setxBack1(-50);
				main.scene.setxBack2(750);
			}
			main.scene.mario.setWalk(true);
			main.scene.mario.setToRight(true);
			main.scene.setDx(1);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			main.scene.setDx(-1);
			main.scene.mario.setWalk(true);
			main.scene.mario.setToRight(false);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		main.scene.mario.setWalk(false);
		main.scene.setDx(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// inutile dans notre cas
	}

}
