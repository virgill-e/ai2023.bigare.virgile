package treasurequest.domains;

import treasurequest.supervisors.views.TileType;

public class CaseType {
	private static final int SAND_COST=1;
	
	private TileType type;
	
	public CaseType(TileType type) {
		this.type=type;
	}
	
	public TileType getType() {
		return this.type;
	}
	
	public int getCost() {
		if(type==TileType.GRASSLAND)return SAND_COST*2;
		else if(type==TileType.FOREST)return SAND_COST*3;
		else if(type==TileType.ROCK)return SAND_COST*5;
		return 1;
	}
	
	public boolean canBeDug() {
		return this.type!=TileType.WATER;
	}
}
