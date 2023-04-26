package treasurequest.supervisors;


import treasurequest.domains.CaseMap;
import treasurequest.domains.Coordinate;
import treasurequest.domains.TreasureQuestGame;
import treasurequest.domains.TreasureQuestGameFactory;
import treasurequest.supervisors.views.PlayGameView;
import treasurequest.supervisors.views.ViewNames;

/**
 * Réagit aux événements utilisateurs de sa vue en mettant à jour une partie en cours et fournit à sa vue les données à afficher.
 * */
public class PlayGameSupervisor {

	private static final String BOURSE_PL = "Bourse : %d P";
	private static final String NB_TREASURE="Tresor restant: %d";
	private static final String ACTIVE_COST="Cout de la case active: %d";
	private static final String ACTIVE_TYPE="Type case active: %s";
	
	private PlayGameView view;
	private final TreasureQuestGameFactory factory;
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
			factory.createGame();
			game=factory.getGame();
			drawMap();
			view.setActiveCase(game.getActiveRow(), game.getActiveCol());
			panelDisplay();
		}
	}
	
	private void panelDisplay() {
		view.setPlayerCoins(String.format(BOURSE_PL, game.getPlayerCoins()));
		view.setTreasuresCount(String.format(NB_TREASURE,game.getNbTreasur()));
		view.setActiveCaseCost(String.format(ACTIVE_COST,game.getActiveCaseCost()));
		view.setActiveCaseType(String.format(ACTIVE_TYPE,game.getActiveCaseType()));
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
