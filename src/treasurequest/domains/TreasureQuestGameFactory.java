package treasurequest.domains;

/**
 * factory permet d'initialiser une partie de TreasureQuestGame
 * 
 * @author virgi
 *
 */
public class TreasureQuestGameFactory {

	private TreasureQuestGame game;
	private final String sample;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Initialise TreasureQuestGameFactory une un path vers un fichier txt générant
	 * la map
	 * 
	 * @param sample
	 */
	public TreasureQuestGameFactory(String sample) {
		this.sample = sample;
	}

	/**
	 * Initialise une instance de TreasureQuestGame
	 */
	public void createGame() {
		game = new TreasureQuestGame(this.sample);
	}

	/**
	 * Renvoie une instance de TreasureQuestGame
	 */
	public TreasureQuestGame getGame() {
		if(this.game==null) {
	        createGame();
		}
		return this.game;
	}
}
