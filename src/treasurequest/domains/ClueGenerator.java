package treasurequest.domains;

import java.util.StringJoiner;

/**
 * class permetant de generer un indice
 * 
 * @author virgi
 *
 */
public class ClueGenerator {

	/**
	 * fonction que renvoie un Clue en recevant la Coordinate source et la
	 * Coordinate cible
	 * 
	 * @param source
	 * @param objective
	 * @return
	 */
	public static Clue generateClue(Coordinate source, Coordinate objective) {
		CardinalPoints cardinalpoint = getDirection(source, objective);
		return new Clue(cardinalpoint, objective);
	}

	private static CardinalPoints getDirection(Coordinate neighbor, Coordinate origin) {
		StringJoiner value = new StringJoiner("_");
		if (neighbor.getRow() < origin.getRow()) {
			value.add("SOUTH");
		} else if (neighbor.getRow() > origin.getRow()) {
			value.add("NORTH");
		}

		if (neighbor.getCol() > origin.getCol()) {
			value.add("WEST");
		} else if (neighbor.getCol() < origin.getCol()) {
			value.add("EAST");
		}
		return CardinalPoints.valueOf(value.toString());
	}
}
