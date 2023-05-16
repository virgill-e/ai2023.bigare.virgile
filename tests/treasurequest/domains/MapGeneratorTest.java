package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;

class MapGeneratorTest {
	
	private static final String SAMPLE_RANDOM_MAP="resources/maps/big-map.txt";

	

	@Test
	void create() {
		char[][] map=CharArrayFileReader.parseFile(SAMPLE_RANDOM_MAP);
		MapGenerator mapGen=new MapGenerator();
		assertTrue(mapGen instanceof MapGenerator);
		
		char[][] rndmMap= MapGenerator.ramdomMap(map, new FakeRandom());
		assertNotEquals(map, rndmMap);
	}

}
