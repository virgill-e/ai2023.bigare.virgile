package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;

class TreasureQuestGameTest {
	private static final String PATH="resources/maps/map-sample-2.txt";
	private static final char[][] TAB_MAP=CharArrayFileReader.parseFile(PATH);


	@Test
	void constructorInstanceOf() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertTrue(tqg instanceof TreasureQuestGame);
	}
	
	@Test
	void getMap() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertTrue(tqg.getCoord()!=null);
		assertTrue(tqg.getCoord() instanceof CaseMap);
	}
	
	@Test
	void getActiveRowAndCol() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals(3, tqg.getActiveCol());
		assertEquals(2, tqg.getActiveRow());
	}
	
	@Test
	void getTypeActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals('R', tqg.getActiveCaseType());
	}
	
	@Test
	void getCostActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals(5, tqg.getActiveCaseCost());
	}
	
	@Test
	void getPlayerCoins() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals(2, tqg.getPlayerCoins());
	}
	
	@Test
	void getNbTreasure() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals(1, tqg.getNbTreasur());
	}
	
	@Test
	void getCaseTypeWithCoord() {
		TreasureQuestGame tqg=new TreasureQuestGame(new CaseMap(TAB_MAP, new FakeRandomCoordinate()));
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(0, 0)),'X');
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(1, 1)),'P');
	}
	
	
	

}
