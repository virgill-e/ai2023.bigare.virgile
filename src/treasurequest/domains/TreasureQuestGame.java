package treasurequest.domains;

import treasurequest.io.CharArrayFileReader;

/**
 * class d'une partie de Treasure Quest
 * 
 * @author virgi
 *
 */
public class TreasureQuestGame {
	private final CaseMap caseMap;
	private final Player player;
	private final Coordinate activeCoordinate;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Constructeur d'une partie de Treasure Quest prenant en parametre le path vers
	 * le sample de la map
	 * 
	 * @param sample
	 */
	public TreasureQuestGame(String sample) {
		this.caseMap = new CaseMap(CharArrayFileReader.parseFile(sample));
		this.player = new Player(caseMap.getNbTreasure() * 2);
		this.activeCoordinate = caseMap.getCenter();
	}

	/*
	 * PUBLIC METHODS
	 */

	/**
	 * Renvoie la CaseMap de la partie en cours
	 * 
	 * @return
	 */
	public Iterable<Coordinate> getCoord() {
		return this.caseMap;
	}

	/**
	 * renvoie la ligne correspondante a la case active
	 * 
	 * @return
	 */
	public int getActiveRow() {
		return this.activeCoordinate.getRow();
	}

	/**
	 * renvoie la colonne correspondante a la case active
	 * 
	 * @return
	 */
	public int getActiveCol() {
		return this.activeCoordinate.getCol();
	}

	/**
	 * renvoie le nombre de piece que possède le joueur
	 * 
	 * @return
	 */
	public int getPlayerCoins() {
		return this.player.getCoins();
	}

	/**
	 * renvoie le nombre de trésor restant dans la map
	 * 
	 * @return
	 */
	public int getNbTreasur() {
		return this.caseMap.getNbTreasure();
	}

	/**
	 * renvoie le type de la case active
	 * 
	 * @return
	 */
	public char getActiveCaseType() {
		return caseMap.getCaseWithCoord(activeCoordinate).getType();
	}

	/**
	 * renvoie le coût pour creuser sur la case active
	 * 
	 * @return
	 */
	public int getActiveCaseCost() {
		Case casee = caseMap.getCaseWithCoord(activeCoordinate);
		return casee.getCost();
	}

	/**
	 * renvoit un char representant la type d'une case En fonction de la coordonnee
	 * recu en parametre
	 * 
	 * @param c
	 * @return
	 */
	public char getCaseTypeWithCoord(Coordinate coord) {
		return this.caseMap.getCaseWithCoord(coord).getType();
	}

	/**
	 * mets a jour la case active
	 */
//	public void updateActiveCase() {
//		//TODO: later
//	}

	/*
	 * PRIVATE METHODS
	 */
}
