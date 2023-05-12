package treasurequest.supervisors;

import java.util.Objects;

import treasurequest.domains.ITreasureQuestGameFactory;
import treasurequest.domains.TreasureQuestGame;
import treasurequest.supervisors.views.GameOverView;
import treasurequest.supervisors.views.ResultType;
import treasurequest.supervisors.views.ViewNames;

/**
 * Réagit aux événements de haut-niveau de sa vue et lui fournit des données à afficher.
 * 
 * */
public class GameOverSupervisor {
	private GameOverView view;
	private ITreasureQuestGameFactory factory;
	private TreasureQuestGame game;
	
	/*
	 * CONSTRUCTORS
	 */
	
	public GameOverSupervisor(ITreasureQuestGameFactory factory) {
		Objects.requireNonNull(factory);
		this.factory=factory;
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
		if(view == null) {
			return;
		}
		
		this.view = view;
	}
	
	/**
	 * Méthode appelée par la vue quand une navigation vers elle est en cours.
	 * 
	 * @param fromView la vue d'origine. Correspond a priori à une constante définie dans ViewNames.
	 * */
	public void onEnter(String fromView) {
		//TODO : générer les résultats et les afficher.
		if (ViewNames.PLAY_GAME.equals(fromView)) {
			this.game=factory.getGame();
			drawPannel();
		}
	}

	/**
	 * Méthode appelée par la vue quand l'utilisateur souhaite retourner au menu principal.
	 * */
	public void onGoToMain() {
		view.goTo(ViewNames.MAIN_MENU);
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	private void drawPannel() {
		view.addPanel(ResultType.LOSS, String.valueOf(game.getPlayerSpend()));
		view.addPanel(ResultType.GAIN, String.valueOf(game.getPlayerGain()));
		view.addPanel(ResultType.DURATION, game.getDuration());
	}
}
