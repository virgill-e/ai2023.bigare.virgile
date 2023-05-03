package treasurequest.domains;

import java.util.Objects;

/**
 * 
 * @author virgi
 * cree des coordonnees row et col 
 */
public class Coordinate {
	private final int col;
	private final int row;
	
	/*
	 * CONSTRUCTORS
	 */
	
	/**
	 * constructeur d'une coordonnée prenant en param la valeur row et col
	 * @param coordX
	 * @param coordY
	 */
	public Coordinate(int col,int row) {
		this.col=Math.abs(col);
		this.row=Math.abs(row);
	}
	
	/*
	 * PUBLIC METHODS
	 */

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return col == other.col && row == other.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
    
    /*
	 * PRIVATE METHODS
	 */
	
}
