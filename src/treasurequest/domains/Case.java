package treasurequest.domains;

import treasurequest.supervisors.views.TileType;

/**
 * Classe qui représente une case par son type
 * @author virgi
 *
 */
public class Case {
	private final CaseType type;

	/**
	 * Constructeur de Case en fonction du char fournit en paramètre
	 * @param type
	 */
	public Case(char type) {
		if(type=='S')this.type=new CaseType(TileType.SAND);
		else if(type=='P')this.type=new CaseType(TileType.GRASSLAND);
		else if(type=='F')this.type=new CaseType(TileType.FOREST);
		else if(type=='R')this.type=new CaseType(TileType.ROCK);
		else this.type=new CaseType(TileType.WATER);
	}

	public TileType getType() {
		return this.type.getType();
	}
	
	public int getCout() {
		return this.type.getCout();
	}
}
