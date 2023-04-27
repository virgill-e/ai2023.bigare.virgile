package treasurequest.domains;

import treasurequest.supervisors.views.TileType;

/**
 * Classe qui représente une case par son type
 * 
 * @author virgi
 *
 */
public class Case {
	private final CaseType type;
	private int treasure = 0;
	private boolean dug = false;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Constructeur de Case en fonction du char fournit en paramètre
	 * 
	 * @param type
	 */
	public Case(char type) {
		if (type == 'S')
			this.type = new CaseType(TileType.SAND);
		else if (type == 'P')
			this.type = new CaseType(TileType.GRASSLAND);
		else if (type == 'F')
			this.type = new CaseType(TileType.FOREST);
		else if (type == 'R')
			this.type = new CaseType(TileType.ROCK);
		else
			this.type = new CaseType(TileType.WATER);
	}

	/*
	 * PUBLIC METHODS
	 */

	public TileType getType() {
		return this.type.getType();
	}

	/**
	 * renvoie le prix pour creuser sur la case
	 * 
	 * @return
	 */
	public int getCost() {
		return this.type.getCost();
	}

	/**
	 * set la valeur du trésor sur la case un treesor a une valeur allant de 10 a 20
	 * piece
	 * 
	 * @param value
	 */
	public void setTreasure(int value) {
		this.treasure = Math.max(10, Math.min(value, 20));
	}

	/**
	 * revoie un int qui vaut la valeur du trésor
	 * 
	 * @return
	 */
	public int getTreasureValue() {
		return this.treasure;
	}

	/**
	 * check si la case contient un tresor Une case contient un tresor si son
	 * treasure>0
	 * 
	 * @return
	 */
	public boolean hasTreasure() {
		return (this.treasure > 0) ? true : false;
	}

	public boolean isDug() {
		return this.dug;
	}

	/**
	 * Modifie la case pour la définir comme déja creusé
	 * 
	 * @return
	 */
	public void setDug() {
		this.dug = true;
	}

	/*
	 * PRIVATE METHODS
	 */

}
