package treasurequest.domains;

import treasurequest.io.CharArrayFileReader;

/**
 * factory permet d'initialiser une partie de TreasureQuestGame
 * 
 * @author virgi
 * 
 *         CTT du placement des trésors: Dans la classe CaseMap j'appelle la
 *         methode setAllTreasures(),
 * 
 *         Si c -> equivaut au nombre de case dans la Map, et T vaut le nombre
 *         de tresor que la map peut contenir(10% de nombre de cases total)
 * 
 *         getAllCaseCanBeDug() -> O(c), une boucle for -> O(t), get() sur une
 *         Hashmap -> O(1), get() surArrayList-> O(1), Case.setTreasure() ->
 *         O(1).
 *         
 *         La CTT vaut O(c)+O(t)
 *         La complexite est donc linéaire
 *         
 * 
 */
public class TreasureQuestGameFactory implements ITreasureQuestGameFactory {

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
		game = new TreasureQuestGame(new CaseMap(CharArrayFileReader.parseFile(sample), new RandomCoordinate()));
	}

	/**
	 * Renvoie une instance de TreasureQuestGame
	 */
	public TreasureQuestGame getGame() {
		if (this.game == null) {
			createGame();
		}
		return this.game;
	}
}
