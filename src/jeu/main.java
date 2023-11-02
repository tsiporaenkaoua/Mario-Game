package jeu;

import javax.swing.JFrame;

public class main {
	public static Scene scene;

	public static void main(String[] args) {
		
		//Création de la fenetre de l'appli
		JFrame window = new JFrame("Jeu style Mario");//crée le fenetre
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//crée la croix rouge pour fermer la fenetre
		window.setSize(700,350);
		window.setLocationRelativeTo(null);//placer le fenetre au centre de la page
		window.setResizable(false);
		window.setAlwaysOnTop(true);//toujours au premier plan
		
		//Instanciation de l'objet scene
		scene = new Scene();//création de tous les espaces memoire necessaires pour utiliser l'objet Scene
		window.setContentPane(scene);
		window.setVisible(true);
	}

}
