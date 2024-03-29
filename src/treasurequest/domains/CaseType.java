package treasurequest.domains;

import java.util.Objects;

/**
 * CaseType permet d'identifier les attributs d'une case en fonction de son type
 * 
 * @author virgi
 *
 */
public class CaseType {
	private static final int SAND_COST = 1;

	private final char type;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur de CaseType recevant le type en parametre
	 * 
	 * @param type
	 */
	public CaseType(char type) {
		this.type = isGoodType(type);
	}

	/**
	 * methode de fabrique, renvoie un CaseType en fonction du char recu en
	 * parametre
	 * 
	 * @param type
	 * @return
	 */
	public static CaseType typeOf(char type) {
		if (type == 'S' || type == 'P' || type == 'F' || type == 'R')
			return new CaseType(type);
		else
			return new CaseType('X');
	}

	/*
	 * PUBLIC METHODS
	 */

	public char getType() {
		return this.type;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaseType other = (CaseType) obj;
		return type == other.type;
	}

	/**
	 * renvoie la cout de creusage d'une case en fonction de son type
	 * 
	 * @return
	 */
	public int getCost() {
		if (type == 'P')
			return SAND_COST * 2;
		else if (type == 'F')
			return SAND_COST * 3;
		else if (type == 'R')
			return SAND_COST * 5;
		else if (type == 'S')
			return SAND_COST;
		return 0;
	}

	/**
	 * renvoie un boolean si une case peut être creuser ou non
	 * 
	 * @return
	 */
	public boolean canBeDug() {
		return this.type != 'X';
	}

	/*
	 * PRIVATE METHODS
	 */

	private char isGoodType(char type) {
		if (type == 'P')
			return type;
		else if (type == 'F')
			return type;
		else if (type == 'R')
			return type;
		else if (type == 'S')
			return type;
		return 'X';
	}
}
