package jeu;
//Lorsqu'on crée un thread, on implémente toujours l'interface Runnable,qui contient une méthode run() qui définit la tâche que le thread exécutera. 
public class Chrono implements Runnable{

	private final int PAUSE = 3;//pause de 3ms avant de repeindre l'écran
	
	@Override
	public void run() {
		//crée une boucle infinie
		while(true) {
			//on repeint l'écran (painComponant de la classe Scene, mais on l'appelle depuis la classe main puisque la scene a été déclarée et instanciée la bas.
			main.scene.repaint();//appel paintComponent()
			//pause de 3ms a chaque boucle
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		
		}
	}
	

}
