package treasurequest.domains;

import java.util.StringJoiner;

public class ClueGenerator {
	
	public static Clue generateClue(Coordinate source, Coordinate objective) {
		CardinalPoints cardinalpoint=getDirection(source, objective);
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
		if(value.toString().length()==0) {
			System.out.println("aaaaaaa");
		}
		return CardinalPoints.valueOf(value.toString());
	}
}
