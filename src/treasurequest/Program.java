package treasurequest;

import javax.swing.SwingUtilities;

import treasurequest.supervisors.*;
import treasurequest.supervisors.views.ViewNames;
import treasurequest.swing.*;

/**
 * Construit l'application et affiche la fenêtre principale.
 * 
 * @author Nicolas Hendrikx
 *
 */
public class Program {

	/**
	 * Point d'entrée de l'application.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Program::buildAndRun);

	}
	
	private static void buildAndRun() {
		//TODO : définir les dépendances injectées au moment de construire les superviseurs
		var menuSupervisor = new MainMenuSupervisor();
		var playSupervisor = new PlayGameSupervisor();
		var endSupervisor = new GameOverSupervisor();
		
		MainWindow main = new MainWindow("B1UE09 - Treasure Quest", 
				new MainMenuSwingView(menuSupervisor),
				new PlayGameSwingView(playSupervisor),
				new GameOverSwingView(endSupervisor));
		
		main.start(ViewNames.MAIN_MENU);
	}

}
