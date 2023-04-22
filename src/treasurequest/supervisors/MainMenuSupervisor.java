package treasurequest.supervisors;

import java.util.List;

import treasurequest.supervisors.views.*;


/**
 * Fournit les données qu'une vue représenter le menu principal doit afficher.
 * 
 * Réagit aux événements de haut niveau signalé par sa vue.
 * */
public class MainMenuSupervisor {

	private static final int EXIT_ITEM = 1;
	
	private MainMenuView view;

	public void setView(MainMenuView view) {
		if(view == null) {
			return;
		}
		
		this.view = view;
		this.view.setItems(List.of());
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
		
		//TODO : Démarrer une nouvelle partie
		//TODO : naviguer vers l'écran de jeu
	}

}
