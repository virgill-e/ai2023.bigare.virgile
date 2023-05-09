package treasurequest.domains;

/**
 * class d'une partie de Treasure Quest
 * 
 * @author virgi
 *
 */
public class TreasureQuestGame {
	private final CaseMap caseMap;
	private final Player player;
	private Coordinate activeCoordinate;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Constructeur d'une partie de Treasure Quest prenant en parametre le path vers
	 * le sample de la map
	 * 
	 * @param sample
	 */
	public TreasureQuestGame(CaseMap map) {
		this.caseMap = map;
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
	public Iterable<Coordinate> getCoords() {
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

	public void updateActiveCase(int deltaRow, int deltaCol) {
		int Col = activeCoordinate.getCol();
		int Row = activeCoordinate.getRow();
		Coordinate newActiveCase = new Coordinate(Col + deltaCol, Row + deltaRow);
		if (caseMap.caseExist(newActiveCase)) {
			activeCoordinate = newActiveCase;
		}
	}

	/**
	 * Creuse a l'emplacement de la case active et renvoie true si elle a reussi a
	 * creuser ou false si la case ne peut être creuse
	 * 
	 * @return
	 */
	public boolean dig() {
		Case caseDig = caseMap.getCaseWithCoord(activeCoordinate);
		if (canDig(caseDig)) {
			player.substractCoins(caseDig.getCost());
			if (caseDig.hasTreasure()) {
				player.addCoins(caseDig.getTreasureValue());
				caseMap.removeTreasure(activeCoordinate);
				caseDig.removeTreasure();
			}
			caseDig.setDug();
			return true;
		}
		return false;
	}

	/**
	 * renvoie le le point cardinal correspondant à l'indice de la case, null si pas
	 * d'indice
	 * 
	 * @return
	 */
	public CardinalPoints getCardinalPoints() {
		return caseMap.getCaseWithCoord(activeCoordinate).getCardinalPoint();
	}
	
	/**
	 * renvoie si la case active possede un tresor
	 * @return
	 */
	public boolean ActiveHasTreasure() {
		return caseMap.getCaseWithCoord(activeCoordinate).hasTreasure();
	}

	/*
	 * PRIVATE METHODS
	 */
	private boolean canDig(Case caseDig) {

		if (caseDig == null)
			return false;
		if (caseDig.isDug())
			return false;
		if (!caseDig.canBeDug())
			return false;
		return player.getCoins() >= caseDig.getCost();
	}



}
