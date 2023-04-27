package treasurequest.domains;

import java.util.Objects;

/**
 * 
 * @author virgi
 * cree des coordonnees x et y 
 */
public class Coordinate {
	private final int coordinateX;
	private final int coordinateY;
	
	/*
	 * CONSTRUCTORS
	 */
	
	/**
	 * constructeur d'une coordonnée prenant en param la valeur x et y
	 * @param coordX
	 * @param coordY
	 */
	public Coordinate(int coordX,int coordY) {
		coordinateX=Math.abs(coordX);
		coordinateY=Math.abs(coordY);
	}
	
	/*
	 * PUBLIC METHODS
	 */

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
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
        return coordinateX == other.coordinateX && coordinateY == other.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
    
    /*
	 * PRIVATE METHODS
	 */
	
}
