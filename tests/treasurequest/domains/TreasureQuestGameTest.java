package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreasureQuestGameTest {
	private static final String SAMPLE="resources/maps/map-sample-2.txt";


	@Test
	void constructorInstanceOf() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertTrue(tqg instanceof TreasureQuestGame);
	}
	
	@Test
	void getMap() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertTrue(tqg.getCoord()!=null);
		assertTrue(tqg.getCoord() instanceof CaseMap);
	}
	
	@Test
	void getActiveRowAndCol() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertEquals(2, tqg.getActiveCol());
		assertEquals(3, tqg.getActiveRow());
	}
	
	@Test
	void getTypeActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertEquals('R', tqg.getActiveCaseType());
	}
	
	@Test
	void getCostActive() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertEquals(5, tqg.getActiveCaseCost());
	}
	
	@Test
	void getPlayerCoins() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertEquals(2, tqg.getPlayerCoins());
	}
	
	@Test
	void getNbTreasure() {
		TreasureQuestGame tqg=new TreasureQuestGame(SAMPLE);
		assertEquals(1, tqg.getNbTreasur());
	}
	
	
	

}
