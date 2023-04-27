package treasurequest.supervisors;

import java.util.List;
import treasurequest.supervisors.views.ViewNames;
import treasurequest.domains.TreasureQuestGameFactory;
import treasurequest.supervisors.views.*;


/**
 * Fournit les données qu'une vue représenter le menu principal doit afficher.
 * 
 * Réagit aux événements de haut niveau signalé par sa vue.
 * */
public class MainMenuSupervisor {
	private static final String NEW_GAME = "Nouvelle partie";
	private static final String EXIT = "Quitter";
	private static final int NEW_GAME_ITEM = 0;
	private static final int EXIT_ITEM = 1;
	
	private MainMenuView view;
	private TreasureQuestGameFactory factory;

	
	public MainMenuSupervisor(TreasureQuestGameFactory factory) {
		this.factory=factory;
	}
	
	public void setView(MainMenuView view) {
		if(view == null) {
			return;
		}
		
		this.view = view;
		this.view.setItems(List.of(NEW_GAME,EXIT));
		//TODO : définir à la vue les items.
	}

	/**
	 * Méthode appelée par la vue quand l'utilisateur sélectionne un item.
	 * 
	 * @param itemPos la position de l'item sélectionné. {@code item in [0; items.length[}
	 * */
	public void onItemSelected(int itemPos) {
		if(EXIT_ITEM == itemPos) {
			view.confirmExit();
		}
		if(NEW_GAME_ITEM==itemPos) {
			view.goTo(ViewNames.PLAY_GAME);
		}
		
		//TODO : Démarrer une nouvelle partie (done)
		//TODO : naviguer vers l'écran de jeu (done)
	}

}