package treasurequest.domains;

import treasurequest.io.CharArrayFileReader;
import treasurequest.supervisors.views.TileType;

/**
 * classe d'une partie de Treasure Quest
 * @author virgi
 *
 */
public class TreasureQuestGame {
	private final CaseMap caseMap;
	private final Player player;
	private Coordinate activeCoordinate;
	
	/**
	 * Constructeur d'une parte de Treasure Quest prenant en parametre
	 * le path vers le sample de la map
	 * @param sample
	 */
	public TreasureQuestGame(String sample) {
		this.caseMap=new CaseMap(CharArrayFileReader.parseFile(sample));
		this.player=new Player(caseMap.getNbTreasure()*2);
		this.activeCoordinate=caseMap.getCenter();
	}
	
	/**
	 * renvoie la CaseMap de la partie en cours
	 * @return
	 */
	public CaseMap getMap() {
		return this.caseMap;
	}
	
	public int getActiveRow() {
		return this.caseMap.getCenter().getCoordinateX();
	}
	
	public int getActiveCol() {
		return this.caseMap.getCenter().getCoordinateY();
	}
	
	public int getPlayerCoins() {
		return this.player.getCoins();
	}
	
	public int getNbTreasur() {
		return this.caseMap.getNbTreasure();
	}
	
	public TileType getActiveCaseType() {
		return caseMap.getCaseWithCoord(activeCoordinate).getType();
	}
	
	public int getActiveCaseCost() {
		Case casee=caseMap.getCaseWithCoord(activeCoordinate);
		return casee.getCost();
	}
	
	public void updateActiveCase() {
		//TODO
	}
}
