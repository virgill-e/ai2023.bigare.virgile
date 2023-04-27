package treasurequest.domains;

import treasurequest.supervisors.views.TileType;

/**
 * CaseType permet d'identifier les attributs d'une case en fonction de son
 * type
 * 
 * @author virgi
 *
 */
public class CaseType {
	private static final int SAND_COST = 1;

	private final TileType type;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur de CaseType recevant le type en parametre
	 * 
	 * @param type
	 */
	public CaseType(TileType type) {
		this.type = type;
	}

	/*
	 * PUBLIC METHODS
	 */

	public TileType getType() {
		return this.type;
	}

	/**
	 * renvoie la cout de creusage d'une case en fonction de son type
	 * @return
	 */
	public int getCost() {
		if (type == TileType.GRASSLAND)
			return SAND_COST * 2;
		else if (type == TileType.FOREST)
			return SAND_COST * 3;
		else if (type == TileType.ROCK)
			return SAND_COST * 5;
		return 1;
	}

	/**
	 * renvoie un boolean si une case peut être creuser ou non
	 * @return
	 */
	public boolean canBeDug() {
		return this.type != TileType.WATER;
	}
	
	/*
	 * PRIVATE METHODS
	 */
}
