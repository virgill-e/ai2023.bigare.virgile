package treasurequest.supervisors;

import java.util.Objects;

import treasurequest.domains.ITreasureQuestGameFactory;
import treasurequest.domains.TreasureQuestGame;
import treasurequest.supervisors.views.GameOverView;
import treasurequest.supervisors.views.ResultType;
import treasurequest.supervisors.views.ViewNames;

/**
 * Réagit aux événements de haut-niveau de sa vue et lui fournit des données à
 * afficher.
 * 
 * Conditions de fin de partie: Une partie peut se terminer a 2 moment: de le
 * debut de la partie si aucune case n'est creusable ou que la joueur n'as
 * l'argent pour aucune des cases creusables, donc l'objet Player possede moins
 * coins que le prix des case porpose ou la CaseMap ne contient que des case
 * d'eau.
 * 
 * ou apres avoir creuse une case si il n'y a plus de tresor a creuser ou que le
 * joueur n'as plus de fond, Donc si l'objet CaseMap est constitué unqisuement
 * de Case d'eau ou si l'objet Player possede ne possede plus les fond pour
 * pouvoir creuser des Case
 * 
 * La CTT de du calcul de la plus grande zone de case adjacente se trouve dans
 * la classe TreasureQuestGame dans le commentaire de la methode setProfil
 * {@link TreasureQuestGame#setProfil()}
 * 
 */
public class GameOverSupervisor {
	private GameOverView view;
	private ITreasureQuestGameFactory factory;
	private TreasureQuestGame game;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur du game over supervisor recevant la factory en parametre
	 * 
	 * @param factory
	 */
	public GameOverSupervisor(ITreasureQuestGameFactory factory) {
		Objects.requireNonNull(factory);
		this.factory = factory;
	}

	/**
	 * 
	 * */
	public GameOverSupervisor() {

	}

	/*
	 * PUBLIC METHODS
	 */

	public void setView(GameOverView view) {
		if (view == null) {
			return;
		}

		this.view = view;
	}

	/**
	 * Méthode appelée par la vue quand une navigation vers elle est en cours.
	 * 
	 * @param fromView la vue d'origine. Correspond a priori à une constante définie
	 *                 dans ViewNames.
	 */
	public void onEnter(String fromView) {
		if (ViewNames.PLAY_GAME.equals(fromView)) {
			this.game = factory.getGame();
			game.setProfil();
			drawPannel();
		}
	}

	/**
	 * Méthode appelée par la vue quand l'utilisateur souhaite retourner au menu
	 * principal.
	 */
	public void onGoToMain() {
		view.goTo(ViewNames.MAIN_MENU);
	}

	/*
	 * PRIVATE METHODS
	 */

	private void drawPannel() {
		view.clearPanels();
		view.addPanel(ResultType.LOSS, String.valueOf(game.getPlayerSpend()));
		view.addPanel(ResultType.GAIN, String.valueOf(game.getPlayerGain()));
		view.addPanel(ResultType.DURATION, game.getDuration());
		view.addPanel(ResultType.valueOf(game.getProfil().getTitle()), game.getProfil().getTitle());
	}
}
