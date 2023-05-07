package treasurequest.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author virgi cree des coordonnees row et col
 */
public class Coordinate {
	private static final double NEIGHBOR_SIZE = 5;

	private final int col;
	private final int row;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur d'une coordonnée prenant en param la valeur row et col
	 * 
	 * @param coordX
	 * @param coordY
	 */
	public Coordinate(int col, int row) {
		this.col = col;
		this.row = row;
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
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		Coordinate other = (Coordinate) obj;
		return col == other.col && row == other.row;
	}

	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}

	public Coordinate getClosest(Coordinate coord1, Coordinate coord2) {
		double distance1 = this.calculateDistance(coord1);
		double distance2 = this.calculateDistance(coord2);
		if (distance1 < distance2) {
			return coord1;
		}
		if (distance1 > distance2) {
			return coord2;
		}
		return null;
	}

	public List<Coordinate> getNeighbors() {
		List<Coordinate> neighbors = new ArrayList<Coordinate>();
		int end = (int) (NEIGHBOR_SIZE / 2);
		int start = end * -1;
		for (int row = start; row <= end; row++) {
			for (int col = start; col <= end; col++) {
				Coordinate neighbor = new Coordinate(this.getCol() + col, this.getRow() + row);
				if (!this.equals(neighbor))
					neighbors.add(neighbor);
			}
		}
		return neighbors;
	}

	private double calculateDistance(Coordinate that) {
		double distance = Math.pow(this.getRow() - that.getRow(), 2) + Math.pow(this.getCol() - that.getCol(), 2);
		distance = Math.sqrt(distance);
		return distance;
	}

	/*
	 * PRIVATE METHODS
	 */

}
