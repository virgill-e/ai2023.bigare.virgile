package treasurequest.domains;

/**
 * Decrit comment creer une partie
 * @author virgi
 *
 */
public interface ITreasureQuestGameFactory {

	/**
	 * Initialise une instance de TreasureQuestGame
	 */
	public void createGame();
	
	/**
	 * initiaise une instance de TreasureQuestGame avec une carte aleatoire
	 */
	public void createGameRandomMap();

	/**
	 * Renvoie une instance de TreasureQuestGame
	 */
	public TreasureQuestGame getGame();
}
