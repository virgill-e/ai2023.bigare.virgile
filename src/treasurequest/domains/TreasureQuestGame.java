package treasurequest.domains;

import treasurequest.io.CharArrayFileReader;

/**
 * classe d'une partie de Treasure Quest
 * @author virgi
 *
 */
public class TreasureQuestGame {
	private final CaseMap caseMap;
	
	/**
	 * Constructeur d'une parte de Treasure Quest prenant en parametre
	 * le path vers le sample de la map
	 * @param sample
	 */
	public TreasureQuestGame(String sample) {
		this.caseMap=new CaseMap(CharArrayFileReader.parseFile(sample));
	}
	
	/**
	 * renvoie la CaseMap de la partie en cours
	 * @return
	 */
	public CaseMap getMap() {
		return this.caseMap;
	}
}
