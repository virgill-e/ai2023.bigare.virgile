package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClueGeneratorTest {

	@Test
	void generate() {
		Clue clue = ClueGenerator.generateClue(new Coordinate(0, 0), new Coordinate(1, 0));
		assertEquals(CardinalPoints.EAST, clue.getCardinalPoint());
		assertEquals(new Coordinate(1, 0), clue.getOriginTreasure());
	}

	@Test
	void coordinate() {
		Clue clue = ClueGenerator.generateClue(new Coordinate(5, 5), new Coordinate(5, 4));
		// NORTH
		assertEquals(CardinalPoints.NORTH, clue.getCardinalPoint());
		// SOUTH
		clue = ClueGenerator.generateClue(new Coordinate(5, 5), new Coordinate(5, 6));
		assertEquals(CardinalPoints.SOUTH, clue.getCardinalPoint());
		// East
		clue = ClueGenerator.generateClue(new Coordinate(5, 5), new Coordinate(6, 5));
		assertEquals(CardinalPoints.EAST, clue.getCardinalPoint());
		// West
		clue = ClueGenerator.generateClue(new Coordinate(5, 5), new Coordinate(4, 5));
		assertEquals(CardinalPoints.WEST, clue.getCardinalPoint());
	}

}
