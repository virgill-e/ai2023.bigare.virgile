package treasurequest.domains;

/**
 * Decrit comment creer une partie
 * @author virgi
 *
 */
public interface iTreasureQuestGameFactory {

	/**
	 * Initialise une instance de TreasureQuestGame
	 */
	public void createGame();

	/**
	 * Renvoie une instance de TreasureQuestGame
	 */
	public TreasureQuestGame getGame();
}