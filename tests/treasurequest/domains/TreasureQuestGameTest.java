package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;

class TreasureQuestGameTest {
	private static final String SAMPLE="resources/maps/map-sample-2.txt";
	private static final char[][] MAP_TAB=CharArrayFileReader.parseFile(SAMPLE);


	@Test
	void constructorInstanceOf() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertTrue(tqg instanceof TreasureQuestGame);
	}
	
	@Test
	void getMap() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertTrue(tqg.getCoords()!=null);
		assertTrue(tqg.getCoords() instanceof CaseMap);
	}
	
	@Test
	void getActiveRowAndCol() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(3, tqg.getActiveCol());
		assertEquals(2, tqg.getActiveRow());
	}
	
	@Test
	void getTypeActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals('R', tqg.getActiveCaseType());
	}
	
	@Test
	void getCostActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(5, tqg.getActiveCaseCost());
	}
	
	@Test
	void getPlayerCoins() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(2, tqg.getPlayerCoins());
	}
	
	@Test
	void getNbTreasure() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(1, tqg.getNbTreasur());
	}
	
	@Test
	void getCaseTypeWithCoord() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(0, 0)),'X');
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(1, 1)),'P');
	}
	
	@Test
	void getCoords() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertTrue(tqg.getCoords() instanceof Iterable<?>);
	}
	
	@Test
	void getActiveRow() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(2, tqg.getActiveRow());
	}
	
	@Test
	void getActiveCol() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		assertEquals(3, tqg.getActiveCol());
	}
	
	@Test
	void updateActiveCase() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		tqg.updateActiveCase(1, 1);
		assertEquals(3, tqg.getActiveRow());
		assertEquals(4, tqg.getActiveCol());
	}
	
	@Test
	void dig() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		tqg.updateActiveCase(1, 1);
		assertTrue(tqg.dig());
	}
	
	@Test
	void digOnTreasure() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		tqg.updateActiveCase(-1, -2);
		assertTrue(tqg.dig());
	}
	
	@Test
	void digOnWater() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		tqg.updateActiveCase(-2, -3);
		assertFalse(tqg.dig());
	}
	
	@Test
	void getCardianlPoint() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandomCoordinate()));
		tqg.updateActiveCase(-1, -1);
		assertEquals(CardinalPoints.WEST, tqg.getCardinalPoints());
		
		
	}
	
	
	

}
