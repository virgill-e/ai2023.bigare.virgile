package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	void getClossest() {
		Coordinate coordSrc = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(1, 3);
		Coordinate coord3 = new Coordinate(1, 5);
		
		assertEquals(coord2, coordSrc.getClosest(coord2, coord3));
		assertEquals(coord2, coordSrc.getClosest(coord3, coord2));
	}
	
	@Test
	void getClossestSameDist() {
		Coordinate coordSrc = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(1, 3);
		Coordinate coord3 = new Coordinate(1, 1);
		
		assertNull(coordSrc.getClosest(coord2, coord3));
	}
	
	
	@Test
	void compareTo() {
		Coordinate coordSrc = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(1, 3);
		Coordinate coord3 = new Coordinate(1, 2);
		
		assertTrue(coordSrc.compareTo(coord3)==0);
		assertTrue(coordSrc.compareTo(coord2)<0);
		assertTrue(coord2.compareTo(coordSrc)>0);
	}
	
	@Test
	void getNeighbor() {
		Coordinate coordSrc = new Coordinate(0, 0);
		List<Coordinate> neighboors=coordSrc.getNeighbors(3);
		List<Coordinate> neighboorsExpected=new ArrayList<Coordinate>();
		neighboorsExpected.add(new Coordinate(-1, -1));
		neighboorsExpected.add(new Coordinate(-1, 0));
		neighboorsExpected.add(new Coordinate(-1, 1));
		neighboorsExpected.add(new Coordinate(0, -1));
		neighboorsExpected.add(new Coordinate(0, 1));
		neighboorsExpected.add(new Coordinate(1, -1));
		neighboorsExpected.add(new Coordinate(1, 0));
		neighboorsExpected.add(new Coordinate(1, 1));
		
		for(int i=0;i<neighboors.size();i++) {
			assertTrue(neighboorsExpected.contains(neighboors.get(i)));
		}
	}
	
	@Test
	void getNeighborSize1() {
		Coordinate coordSrc = new Coordinate(0, 0);
		List<Coordinate> neighboors=coordSrc.getNeighbors(1);
		assertEquals(coordSrc, neighboors.get(0));
	}

}
