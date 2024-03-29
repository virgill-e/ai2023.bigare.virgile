package treasurequest.supervisors;

import java.util.Objects;

import treasurequest.domains.CardinalPoints;
import treasurequest.domains.Coordinate;
import treasurequest.domains.TreasureQuestGame;
import treasurequest.domains.ITreasureQuestGameFactory;
import treasurequest.supervisors.views.PlayGameView;
import treasurequest.supervisors.views.SpriteType;
import treasurequest.supervisors.views.TileType;
import treasurequest.supervisors.views.ViewNames;

/**
 * Réagit aux événements utilisateurs de sa vue en mettant à jour une partie en
 * cours et fournit à sa vue les données à afficher.
 */
public class PlayGameSupervisor {

	private static final String BOURSE_PL = "Bourse : %d P";
	private static final String NB_TREASURE = "Tresor restant: %d";
	private static final String ACTIVE_COST = "Cout de la case active: %d";
	private static final String ACTIVE_TYPE = "Type case active: %s";

	private PlayGameView view;
	private final ITreasureQuestGameFactory factory;
	private TreasureQuestGame game;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur de PlayGameSupervisor reçoit en parametre La factory pour creer
	 * une partie
	 * 
	 * @param factory2
	 */
	public PlayGameSupervisor(ITreasureQuestGameFactory factory) {
		Objects.requireNonNull(factory);
		this.factory = factory;
	}

	/*
	 * PUBLIC METHODS
	 */

	/**
	 * Définit la vue de ce superviseur à {@code view}.
	 */
	public void setView(PlayGameView view) {
		if (view == null) {
			return;
		}
		this.view = view;
	}

	/**
	 * Méthode appelée juste avant que la vue de ce superviseur soit affichée à
	 * l'écran.
	 * 
	 * Le superviseur affiche les données de départ du jeu (cout de la case active,
	 * nombre de trésors, bourse du joueur, etc.). Il dessine également les cases et
	 * indique quelle case est active.
	 * 
	 * 
	 * Post-conditions sur la création d’une partie:
	 * 
	 * Player: Un player player doit être initialise en possedant comme piece 2*le
	 * nombre de tresor et avoir assez de piece que pour pouvoir creuser une case
	 * 
	 * CaseMap: Doit etre initialise en connaisant toute ses cases et avoir pose des
	 * tresor sur 10% de ses cases creusables
	 * 
	 * Case: Chaque cases doivent etre initialise, ne pas etre creuse, savoir si
	 * elle contiennet un tresor et connaitre leur type
	 * 
	 */
	public void onEnter(String fromView) {
		if (ViewNames.MAIN_MENU.equals(fromView)) {
			game = factory.getGame();
			drawMap();
			view.setActiveCase(game.getActiveRow(), game.getActiveCol());
			panelDisplay();
		}
	}

	/**
	 * Tente de déplacer la case active de {@code deltaRow} lignes et de
	 * {@code deltaRow} colonnes.
	 * 
	 * Cette méthode doit vérifier que les coordonnées calculées correspondent bien
	 * à une case du terrain.
	 */
	public void onMove(int deltaRow, int deltaCol) {
		// la vue.
		game.updateActiveCase(deltaRow, deltaCol);
		view.setActiveCase(game.getActiveRow(), game.getActiveCol());
		panelDisplay();
	}

	/**
	 * Tente de creuser la case active et met à jour l'affichage en conséquence.
	 * 
	 * Ne fais rien si la case active a déjà été creusee ou si elle est de type Eau.
	 * 
	 * 
	 * Postconditions vérifiées par le montant ajouté à la bourse du joueur :
	 * 
	 * - La valeur d'un tresor doit être comprise entre 10 et 20
	 * 
	 * - Lors de l'ajout de cette valeur au joueur la methode empêche les nombres
	 * negatifs
	 */
	public void onDig() {
		boolean hasTreasure = game.ActiveHasTreasure();
		if (game.dig()) {
			setSpriteWhenDig(hasTreasure);
		}
		panelDisplay();
		if(game.isLoose()) {
			goToGameOver();
		}
	}
	


	/**
	 * Méthode appelée par la vue quand l'utilisateur souhaite interrompre la
	 * partie.
	 * 
	 * Ce superviseur demande à sa vue de naviguer vers le menu principal.
	 */
	public void onStop() {
		view.clearTiles();
		view.goTo(ViewNames.MAIN_MENU);
	}

	/*
	 * PRIVATE METHODS
	 */

	private void panelDisplay() {
		view.setPlayerCoins(String.format(BOURSE_PL, game.getPlayerCoins()));
		view.setTreasuresCount(String.format(NB_TREASURE, game.getNbTreasur()));
		view.setActiveCaseCost(String.format(ACTIVE_COST, game.getActiveCaseCost()));
		view.setActiveCaseType(String.format(ACTIVE_TYPE, game.getActiveCaseType()));
	}
	

	private void drawMap() {
		for (Coordinate c : game.getCoords()) {
			char actualChar = game.getCaseTypeWithCoord(c);
			view.setTileAt(whatType(actualChar), c.getRow(), c.getCol());
		}
	}

	private void goToGameOver() {
		view.clearTiles();
		view.goTo(ViewNames.GAME_OVER);
	}
	
	/**
	 * @param hasTreasure
	 */
	private void setSpriteWhenDig(boolean hasTreasure) {
		if (hasTreasure) {
			view.setSpriteAt(SpriteType.TREASURE, game.getActiveRow(), game.getActiveCol());
			return;
		}
		CardinalPoints cardinalPoint = game.getCardinalPoints();
		if (cardinalPoint != null) {
			view.setSpriteAt(SpriteType.valueOf(cardinalPoint.toString()), game.getActiveRow(), game.getActiveCol());
			return;
		}
		view.setSpriteAt(SpriteType.DUG, game.getActiveRow(), game.getActiveCol());
	}

	private TileType whatType(char type) {
		if (type == 'S')
			return TileType.SAND;
		else if (type == 'P')
			return TileType.GRASSLAND;
		else if (type == 'F')
			return TileType.FOREST;
		else if (type == 'R')
			return TileType.ROCK;
		else
			return TileType.WATER;
	}

}
