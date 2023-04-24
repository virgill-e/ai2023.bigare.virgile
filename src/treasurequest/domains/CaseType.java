package treasurequest.domains;

import treasurequest.supervisors.views.TileType;

public class CaseType {
	private TileType type;
	
	public CaseType(TileType type) {
		this.type=type;
	}
	
	public TileType getType() {
		return this.type;
	}
	
	public int getCout() {
		//TODO: cout en fonction du type
		return -1;
	}
}
