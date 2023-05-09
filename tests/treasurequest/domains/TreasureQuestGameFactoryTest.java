package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TreasureQuestGameFactoryTest {

	private static final String SAMPLE="resources/maps/map-sample-2.txt";

	
	@Test
	void constructorInstanceOf() {
		TreasureQuestGameFactory tqgf=new TreasureQuestGameFactory(SAMPLE);
		assertTrue(tqgf instanceof TreasureQuestGameFactory);
	}
	
	@Test
	void createGame() {
		TreasureQuestGameFactory tqgf=new TreasureQuestGameFactory(SAMPLE);
		tqgf.createGame();
		assertTrue(tqgf.getGame() instanceof TreasureQuestGame);
	}
	
	@Test
	void getGameNull() {
		TreasureQuestGameFactory tqgf=new TreasureQuestGameFactory(SAMPLE);
		assertTrue(tqgf.getGame() instanceof TreasureQuestGame);
	}
	
	
	
	

}
