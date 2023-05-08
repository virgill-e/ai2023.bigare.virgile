package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void isInstanceof() {
		assertTrue(new Coordinate(0, 0) instanceof Coordinate);
	}
	
	@Test
	void CorrectCoordinate() {
		Coordinate coord = new Coordinate(1, 2);
		assertEquals(1, coord.getCol());
		assertEquals(2, coord.getRow());
		
		Coordinate coord2 = new Coordinate(-1, 2);
		assertEquals(-1, coord2.getCol());
		assertEquals(2, coord2.getRow());
	}
	
	@Test
	void equalsTest() {
		Coordinate coord = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(1, 2);
		Coordinate coord3 = new Coordinate(1, 3);
		assertEquals(coord, coord2);
		assertEquals(coord, coord);
		assertNotEquals(coord, coord3);
		assertNotEquals(coord, null);
	}
	
	@Test
	void hashCodeTest() {
		Coordinate coord = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(1, 2);
		Coordinate coord3 = new Coordinate(1, 3);
		assertEquals(coord.hashCode(), coord2.hashCode());
		assertNotEquals(coord.hashCode(), coord3.hashCode());
	}

}
