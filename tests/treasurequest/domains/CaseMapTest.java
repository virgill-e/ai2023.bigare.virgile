package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;
import treasurequest.supervisors.views.TileType;

class CaseMapTest {
	private static final String PATH="resources/maps/map-sample.txt";
	private static final String PATH2="resources/maps/map-sample-2.txt";
	@Test
	void constructorInstanceOf() {
		char[][] tabMap=CharArrayFileReader.parseFile(PATH);
		CaseMap caseMap=new CaseMap(tabMap);
		assertTrue(caseMap instanceof CaseMap);
	}
	
	@Test
	void getCaseWithCoord() {
		char[][] tabMap=CharArrayFileReader.parseFile(PATH);
		CaseMap caseMap=new CaseMap(tabMap);
		assertEquals(caseMap.getCaseWithCoord(new Coordinate(0, 0)).getType(), TileType.WATER);
		assertEquals(caseMap.getCaseWithCoord(new Coordinate(1, 1)).getType(), TileType.SAND);
		assertNull(caseMap.getCaseWithCoord(null));
	}
	
	@Test
	void getNbTreasure() {
		char[][] tabMap=CharArrayFileReader.parseFile(PATH2);//dans cette carte il doit y avoir 1 trésor
		CaseMap caseMap=new CaseMap(tabMap);
		assertEquals(caseMap.getNbTreasure(), 1);
		
		char[][] tabMap2=CharArrayFileReader.parseFile(PATH);//dans cette carte il doit y avoir 20 trésor
		CaseMap caseMap2=new CaseMap(tabMap2);
		assertEquals(caseMap2.getNbTreasure(), 20);
	}
	
	@Test
	void getCenterMap() {
		char[][] tabMap=CharArrayFileReader.parseFile(PATH2);
		CaseMap caseMap=new CaseMap(tabMap);
		assertEquals(caseMap.getCenter(),new Coordinate(3, 2));
	}
	
	@Test
    void testIterator() {
        char[][] tabMap = { { 'S', 'S', }, { 'S', 'S', } };
        List<Coordinate> expectedCoords = new ArrayList<Coordinate>();
        expectedCoords.add(new Coordinate(0, 0));
        expectedCoords.add(new Coordinate(0, 1));
        expectedCoords.add(new Coordinate(1, 0));
        expectedCoords.add(new Coordinate(1, 1));

        CaseMap caseMap = new CaseMap(tabMap);
        Iterator<Coordinate> it = caseMap.iterator();

        while (it.hasNext()) {
            assertTrue(expectedCoords.contains(it.next()));
        }
    }

}
