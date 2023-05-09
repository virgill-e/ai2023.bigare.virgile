package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClueTest {

	
	@Test
	void originTreasure() {
		Clue clue=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		assertEquals(new Coordinate(0, 0), clue.getOriginTreasure());
	}
	
	@Test
	void cardianlPoint() {
		Clue clue=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		assertEquals(CardinalPoints.NORTH, clue.getCardinalPoint());
	}
	
	@Test
	void hashCodeTest() {
		Clue clue1=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		Clue clue2=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		assertEquals(clue1.hashCode(), clue2.hashCode());
	}
	
	@Test
	void equalsTest() {
		Clue clue1=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		Clue clue2=new Clue(CardinalPoints.NORTH, new Coordinate(0, 0));
		assertTrue(clue1.equals(clue2));
		assertFalse(clue1.equals(null));
		assertTrue(clue1.equals(clue1));
	}

}
