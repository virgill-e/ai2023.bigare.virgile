package treasurequest.domains;

/**
 * 
 * @author virgi
 * cree des coordonnees x et y 
 */
public class Coordinate {
	private final int coordinateX;
	private final int coordinateY;
	
	public Coordinate(int coordX,int coordY) {
		coordinateX=Math.abs(coordX);
		coordinateY=Math.abs(coordY);
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}
	
}
