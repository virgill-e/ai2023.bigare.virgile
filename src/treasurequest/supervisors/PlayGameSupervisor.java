package treasurequest.supervisors;

import java.util.Arrays;

import treasurequest.domains.CaseMap;
import treasurequest.domains.Coordinate;
import treasurequest.domains.TreasureQuestGame;
import treasurequest.domains.TreasureQuestGameFactory;
import treasurequest.supervisors.views.PlayGameView;
import treasurequest.supervisors.views.TileType;
import treasurequest.supervisors.views.ViewNames;

/**
 * Réagit aux événements utilisateurs de sa vue en mettant à jour une partie en cours et fournit à sa vue les données à afficher.
 * */
public class PlayGameSupervisor {

	private static final String SAMPLE="resources/maps/map-sample.txt";

	private PlayGameView view;
	private TreasureQuestGameFactory factory;
	private TreasureQuestGame game;

	public PlayGameSupervisor(TreasureQuestGameFactory factory) {
		this.factory=factory;
	}

	/**
	 * Définit la vue de ce superviseur à {@code view}.
	 * */
	public void setView(PlayGameView view) {
		if(view == null) {
			return;
		}

		this.view = view;
	}
	/**
	 * Méthode appelée juste avant que la vue de ce superviseur soit affichée à l'écran.
	 * 
	 * Le superviseur affiche les données de départ du jeu (cout de la case active, nombre de trésors, bourse du joueur, etc.).
	 * Il dessine également les cases et indique quelle case est active.
	 * */
	public void onEnter(String fromView) {
		if (ViewNames.MAIN_MENU.equals(fromView)) {
			// TODO : faire le rendu initial de l'écran de jeu
			factory.createGame();
			game=factory.getGame();
			drawMap();
			
		}
	}
	
	
	private void drawMap() {
		//boucler sur la map pour voir 
		CaseMap caseMap=game.getMap();
		for(Coordinate c:caseMap) {
			view.setTileAt(caseMap.getCaseWithCoord(c).getType(), c.getCoordinateX(), c.getCoordinateY());
		}
	}



	/**
	 * Tente de déplacer la case active de {@code deltaRow} lignes et de {@code deltaRow} colonnes.
	 * 
	 * Cette méthode doit vérifier que les coordonnées calculées correspondent bien à une case du terrain.
	 * */
	public void onMove(int deltaRow, int deltaCol) {
		//TODO : valider et changer de case active. Appelez les méthodes adéquates de la vue.
	}

	/**
	 * Tente de creuser la case active et met à jour l'affichage en conséquence.
	 * 
	 * Ne fais rien si la case active a déjà été creusee ou si elle est de type Eau.
	 * */
	public void onDig() {
		//TODO : creuser si possible
		//TODO : appelez la méthode setSpriteAt(...) de la vue
	}

	/**
	 * Méthode appelée par la vue quand l'utilisateur souhaite interrompre la partie.
	 * 
	 * Ce superviseur demande à sa vue de naviguer vers le menu principal.
	 * */
	public void onStop() {
		//TODO : naviguer vers le menu principal
	}

}
